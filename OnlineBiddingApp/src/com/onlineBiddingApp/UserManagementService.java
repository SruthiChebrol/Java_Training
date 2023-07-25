package com.onlineBiddingApp;

import java.util.ArrayList;
import java.util.List;

public class UserManagementService {
    private List<User> users;

 

    public UserManagementService() {
        this.users = new ArrayList<>();
    }

 

    public void createUser(String username, String password) {
        User user = new User(username, password);
        users.add(user);
    }

    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
    
    public boolean updatePassword(String username, String newPassword) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.setPassword(newPassword);
                return true;
            }
        }
        return false;
    }

 

   
}
