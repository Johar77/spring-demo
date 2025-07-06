package com.johar.test.openfeigntest.client;

import com.johar.test.openfeigntest.config.FeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName: UserClient
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/1/2 23:29
 * @Since: 1.0.0
 */
//@FeignClient(name = "eureka-client-provider", url = "http://localhost:9998", path = "/user")
@FeignClient(name = "eureka-client-provider", path = "/user", fallback = FeignFallback.class)
public interface UserClient {

    @PostMapping("/getName")
    String getName();

    @PostMapping(path = "/error")
    String createErr();
}
