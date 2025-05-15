package com.example.web.service;

import com.example.web.client.UserClient;
import com.example.web.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WebService {
    private final UserClient userClient;

    public WebService(UserClient userClient) {
        this.userClient = userClient;
    }

//    public [type de data à retourner] [nom fonction](){
//        FONCTION
//        return [data à retourner];
//    }

//    public void test() {
//        User toto = new User();
//        toto.setText("text");
//        toto.setStatus(true);
//        toto.setDate(LocalDateTime.now());
//    }
}
