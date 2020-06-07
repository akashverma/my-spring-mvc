package com.practice.myspringmvc.services;

public class UserService {
    private final UserManager userManager;

    public UserService(UserManager userManager) {
        this.userManager = userManager;
    }

    public int getUserCount() {
        try {
            return userManager.getUserCount();
        }
        catch (Exception e) {
            return -1;
        }
    }
}
