package com.example.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "back", url = "http://localhost:8090")
public interface UserClient {
//    @RequestMapping(method = RequestMethod.POST, value = "[url]", consumes = "application/json")
//    [type de data à récupérer] [nom fonction](@RequestBody [type de data à envoyer] [nom]);
}
