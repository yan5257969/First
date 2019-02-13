package com.yanwuyu.mapper;

import com.yanwuyu.model.Account;
import com.yanwuyu.model.AccountExample;
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

public interface AccountMapper {
    @SelectProvider(type=AccountSqlProvider.class, method="countByExample")
    long countByExample(AccountExample example);

    @DeleteProvider(type=AccountSqlProvider.class, method="deleteByExample")
    int deleteByExample(AccountExample example);

    @Delete({
        "delete from account",
        "where userid = #{userid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userid);

    @Insert({
        "insert into account (userid, username, ",
        "password, email, ",
        "xm, address)",
        "values (#{userid,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{xm,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR})"
    })
    int insert(Account record);

    @InsertProvider(type=AccountSqlProvider.class, method="insertSelective")
    int insertSelective(Account record);

    @SelectProvider(type=AccountSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="xm", property="xm", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR)
    })
    List<Account> selectByExample(AccountExample example);

    @Select({
        "select",
        "userid, username, password, email, xm, address",
        "from account",
        "where userid = #{userid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="xm", property="xm", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR)
    })
    Account selectByPrimaryKey(Integer userid);

    @UpdateProvider(type=AccountSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    @UpdateProvider(type=AccountSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    @UpdateProvider(type=AccountSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Account record);

    @Update({
        "update account",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "xm = #{xm,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR}",
        "where userid = #{userid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Account record);
}