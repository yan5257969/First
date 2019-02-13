package com.yanwuyu.mapper;

import com.yanwuyu.model.Category;
import com.yanwuyu.model.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CategoryMapper {
    @SelectProvider(type=CategorySqlProvider.class, method="countByExample")
    long countByExample(CategoryExample example);

    @DeleteProvider(type=CategorySqlProvider.class, method="deleteByExample")
    int deleteByExample(CategoryExample example);

    @Delete({
        "delete from category",
        "where catid = #{catid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer catid);

    @Insert({
        "insert into category (catid, catno, ",
        "name, descn)",
        "values (#{catid,jdbcType=INTEGER}, #{catno,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{descn,jdbcType=VARCHAR})"
    })
    int insert(Category record);

    @InsertProvider(type=CategorySqlProvider.class, method="insertSelective")
    int insertSelective(Category record);

    @SelectProvider(type=CategorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="catid", property="catid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="catno", property="catno", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="descn", property="descn", jdbcType=JdbcType.VARCHAR)
    })
    List<Category> selectByExample(CategoryExample example);

    @Select({
        "select",
        "catid, catno, name, descn",
        "from category",
        "where catid = #{catid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="catid", property="catid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="catno", property="catno", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="descn", property="descn", jdbcType=JdbcType.VARCHAR)
    })
    Category selectByPrimaryKey(Integer catid);

    @UpdateProvider(type=CategorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    @UpdateProvider(type=CategorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    @UpdateProvider(type=CategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Category record);

    @Update({
        "update category",
        "set catno = #{catno,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "descn = #{descn,jdbcType=VARCHAR}",
        "where catid = #{catid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Category record);
}