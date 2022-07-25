package cn.ut.gradle.service.impl;

import cn.ut.gradle.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author PuTongjiao
 * @date 2022/7/25 22:23
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String test() {
        return "test";
    }
}
