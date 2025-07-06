package com.johar.test.openfeigntest.config;

import com.johar.test.openfeigntest.client.UserClient;
import org.springframework.stereotype.Component;

/**
 * @ClassName: FeignFallback
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/22 22:28
 * @Since: 1.0.0
 */
@Component
public class FeignFallback implements UserClient {
    @Override
    public String getName() {
        return "FeignFallback";
    }

    @Override
    public String createErr() {
        return "FeignFallback";
    }

}