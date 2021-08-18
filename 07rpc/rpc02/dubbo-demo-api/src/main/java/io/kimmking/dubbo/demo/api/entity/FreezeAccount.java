package io.kimmking.dubbo.demo.api.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Account
 *
 * @author zengqi
 * @date 2021/8/17 16:57
 */


@Data
@ToString
public class FreezeAccount implements Serializable {
    private long userId;
    private BigDecimal cny;
    private BigDecimal usd;
}
