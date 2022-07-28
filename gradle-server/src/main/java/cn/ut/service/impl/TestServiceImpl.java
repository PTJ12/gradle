package cn.ut.service.impl;

import cn.ut.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author PuTongjiao
 * @date 2022/7/28 8:47
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String test() {
        return "adsfasdfasd";
    }
}
