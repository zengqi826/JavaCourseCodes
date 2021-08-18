package io.kimmking.dubbo.demo.provider.service;

import io.kimmking.dubbo.demo.api.entity.Account;
import io.kimmking.dubbo.demo.api.service.TransferService;
import io.kimmking.dubbo.demo.provider.mapper.AccountMapper;
import io.kimmking.dubbo.demo.provider.mapper.FreezeAccountMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@DubboService(version = "1.0.0")
public class TransferServiceImpl implements TransferService {
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private FreezeAccountMapper freezeAccountMapper;

    @Override
    public Account findAccountByUserId(long userId) {
        return accountMapper.findByUserId(userId);
    }

    @Override
    @HmilyTCC(confirmMethod = "sayConfrim", cancelMethod = "sayCancel")
    public Boolean transfer(long userId, Account account) {
        BigDecimal usd = account.getUsd();
        BigDecimal cny = account.getCny();
        boolean result = true;
        if (cny != null) {
            result = result && accountMapper.subCny(userId, cny) > 0 && freezeAccountMapper.addCny(userId, cny) > 0;
        }
        if (usd != null) {
            result = accountMapper.subUsd(userId, usd) > 0 && freezeAccountMapper.addUsd(userId, usd) > 0;
        }
        return result;
    }
    public boolean sayConfrim(long userId, Account account) {
        return addMoney(userId, account) && clearFreeze(userId, account);
    }



    public boolean sayCancel(long userId, Account account) {
        return addMoney(userId, account) && clearFreeze(userId, account);
    }
    private boolean addMoney(long userId, Account account) {
        BigDecimal cny = account.getCny();
        BigDecimal usd = account.getUsd();
        boolean result = true;
        if (cny != null) {
            result = result && accountMapper.addUsd(userId, cny.divide(BigDecimal.valueOf(7))) > 0;
        }
        if (usd != null) {
            result = accountMapper.addCny(userId, usd.multiply(BigDecimal.valueOf(7))) > 0;
        }
        return result;
    }
    private boolean clearFreeze(long userId, Account account) {
        BigDecimal cny = account.getCny();
        BigDecimal usd = account.getUsd();
        boolean result = true;
        if (cny != null) {
            result = result && freezeAccountMapper.subCny(userId, cny) > 0;
        }
        if (usd != null) {
            result = freezeAccountMapper.subUsd(userId, usd) > 0;
        }
        return result;
    }
}
