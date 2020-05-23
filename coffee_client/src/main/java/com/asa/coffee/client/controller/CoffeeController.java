package com.asa.coffee.client.controller;

import com.asa.coffee.client.domain.Coffee;
import com.asa.coffee.client.feign.CoffeeFeignClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class CoffeeController {

    private final DiscoveryClient discoveryClient;
    private final CoffeeFeignClient coffeeFeignClient;

    public CoffeeController(DiscoveryClient discoveryClient, CoffeeFeignClient coffeeFeignClient) {
        this.discoveryClient = discoveryClient;
        this.coffeeFeignClient = coffeeFeignClient;
    }

    @GetMapping("/")
    public String handleRequest(Model model) {
        List<ServiceInstance> instances = discoveryClient.getInstances("Coffee-Service");
        if (instances != null && !instances.isEmpty()) {
            ServiceInstance serviceInstance = instances.get(0);
            String url = serviceInstance.getUri().toString();
            url = url + "/list";
            RestTemplate restTemplate = new RestTemplate();
            List<Coffee> result = restTemplate.getForObject(url, List.class);
            model.addAttribute("result", result);
        }
        return "coffee";
    }

    @GetMapping("/feign")
    public String handleRequestFeign(Model model) {
        List<Coffee> result = coffeeFeignClient.getCoffeeList();
        model.addAttribute("result", result);
        List<ServiceInstance> instances = discoveryClient.getInstances("Coffee-Service");
        return "feign";
    }
}
