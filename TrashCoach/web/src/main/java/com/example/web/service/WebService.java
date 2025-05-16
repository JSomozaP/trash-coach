package com.example.web.service;

import com.example.web.client.UserClient;
import com.example.web.model.User;
import com.example.web.service.form.UserForm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

// Récupérer tous les déchets
public List<User> getAllTrash() {
    return userClient.getAllTrash();
}

// Ajouter un nouveau déchet
public User addTrash(UserForm userForm) {
    User trash = new User();
    trash.setText(userForm.getText());
    trash.setStatus(userForm.isStatus());
    trash.setDate(LocalDateTime.now());
    return userClient.createTrash(trash);
}

// Supprimer un déchet
public void deleteTrash(Long id) {
    userClient.deleteTrash(id);
}

// Pour tester la création d'un déchet
public void test() {
    User trash = new User();
    trash.setText("Test Trash");
    trash.setStatus(true);
    trash.setDate(LocalDateTime.now());
    userClient.createTrash(trash);
}

// Récupérer les messages du coach
    public List<String> getCoachMessages() {
        return userClient.getCoachTrash();
    }


}
