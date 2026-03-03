package com.mercadopreso.cart.gateways.clients;

@org.springframework.cloud.openfeign.FeignClient(name = "feignClient", url = "http://localhost:8080/")
public interface FeignClient {

}
