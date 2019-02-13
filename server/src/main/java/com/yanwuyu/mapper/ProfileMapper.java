package com.yanwuyu.mapper;

import com.yanwuyu.model.Profile;
import com.yanwuyu.model.ProfileExample;
import com.yanwuyu.model.ProfileKey;
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

public interface ProfileMapper {
    @SelectProvider(type=ProfileSqlProvider.class, method="countByExample")
    long countByExample(ProfileExample example);

    @DeleteProvider(type=ProfileSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProfileExample example);

    @Delete({
        "delete from profile",
        "where userid = #{userid,jdbcType=INTEGER}",
          "and catid = #{catid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(ProfileKey key);

    @Insert({
        "insert into profile (userid, catid, ",
        "lang)",
        "values (#{userid,jdbcType=INTEGER}, #{catid,jdbcType=INTEGER}, ",
        "#{lang,jdbcType=VARCHAR})"
    })
    int insert(Profile record);

    @InsertProvider(type=ProfileSqlProvider.class, method="insertSelective")
    int insertSelective(Profile record);

    @SelectProvider(type=ProfileSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="catid", property="catid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="lang", property="lang", jdbcType=JdbcType.VARCHAR)
    })
    List<Profile> selectByExample(ProfileExample example);

    @Select({
        "select",
        "userid, catid, lang",
        "from profile",
        "where userid = #{userid,jdbcType=INTEGER}",
          "and catid = #{catid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="catid", property="catid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="lang", property="lang", jdbcType=JdbcType.VARCHAR)
    })
    Profile selectByPrimaryKey(ProfileKey key);

    @UpdateProvider(type=ProfileSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Profile record, @Param("example") ProfileExample example);

    @UpdateProvider(type=ProfileSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Profile record, @Param("example") ProfileExample example);

    @UpdateProvider(type=ProfileSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Profile record);

    @Update({
        "update profile",
        "set lang = #{lang,jdbcType=VARCHAR}",
        "where userid = #{userid,jdbcType=INTEGER}",
          "and catid = #{catid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Profile record);
}