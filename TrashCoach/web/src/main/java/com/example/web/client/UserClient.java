package com.example.web.client;

import com.example.web.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@FeignClient(name = "back", url = "http://localhost:8090")
public interface UserClient {
    //    @RequestMapping(method = RequestMethod.POST, value = "[url]", consumes = "application/json")
    //    [type de data à récupérer] [nom fonction](@RequestBody [type de data à envoyer] [nom]);
    @RequestMapping(method = RequestMethod.POST, value = "/add", consumes = "application/json")
    User createTrash(@RequestBody User trash);

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = "application/json")
    List<User> getAllTrash();

    @RequestMapping(method = RequestMethod.POST, value = "/delete", consumes = "application/json")
    void deleteTrash(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.POST, value = "/coach", consumes = "application/json")
    List<User> getCoachTrash(@RequestBody User trash);
}

