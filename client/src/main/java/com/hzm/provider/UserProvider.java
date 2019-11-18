package com.hzm.provider;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "user")
public interface UserProvider {

}
