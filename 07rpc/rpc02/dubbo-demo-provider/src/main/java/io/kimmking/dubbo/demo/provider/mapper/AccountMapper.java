package io.kimmking.dubbo.demo.provider.mapper;

import io.kimmking.dubbo.demo.api.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * AccountMapper
 *
 * @author zengqi
 * @date 2021/8/17 18:20
 */

@Repository
public interface AccountMapper {
    @Select("select * from account where user_id = #{userId}")
    Account findByUserId(long userId);

    @Update("update account set cny = cny - #{money} where user_id = #{userId}")
    int subCny(@Param("userId") long userId, @Param("money") BigDecimal money);

    @Update("update account set cny = cny + #{money} where user_id = #{userId}")
    int addCny(@Param("userId") long userId, @Param("money") BigDecimal money);

    @Update("update account set usd = usd - #{money} where user_id = #{userId}")
    int subUsd(@Param("userId") long userId, @Param("money") BigDecimal money);

    @Update("update account set usd = usd + #{money} where user_id = #{userId}")
    int addUsd(@Param("userId") long userId, @Param("money") BigDecimal money);
}
