package com.asa.coffee.client.feign;

import com.asa.coffee.client.domain.Coffee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "Coffee-Service" )
public interface CoffeeFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    List<Coffee> getCoffeeList();
}