package com.softserveinc.task03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UserManager {
    private final Set<User> users;

    public UserManager() {
        users = new HashSet<>();
    }

    public void register(String login, String password) {
        User user = new User(login, password);
        users.add(user);
    }

    public void delete(String login) {
        for(User user: users) {
            if(user.getLogin().equals(login)) {
                users.remove(user);
                break;
            }
        }
    }

    public boolean exists(String login, String password){
        for(User user: users) {
            if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
//        User user = new User(login, password);
//        Iterator<User> iterator = users.iterator();
//        while(iterator.hasNext()){
//            if(iterator.equals(user)){
//                return true;
//            }
//        }
        return false;
    }

    public boolean changePassword(String login, String oldPassword, String newPassword) {
        User user = new User(login, oldPassword);
        if (exists(login, oldPassword)) {
            user.setPassword(newPassword);
            return true;
        }
        return false;
    }
}
