package io.kimmking.dubbo.demo.api.service;

import io.kimmking.dubbo.demo.api.entity.Account;
import org.dromara.hmily.annotation.Hmily;
/**
 * TransferService
 *
 * @author zengqi
 * @date 2021/8/17 17:01
 */

public interface TransferService {
    Account findAccountByUserId(long userId);
    @Hmily
    Boolean transfer(long userId, Account account);

}
