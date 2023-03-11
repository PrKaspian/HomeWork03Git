package com.example.lesson03;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private static List<User> users;
    private static int countUser;
    public static List<User> getAll(){
        return users;
    }

    public static void write(){
        users = new ArrayList<>();
        users.add(new User(1, R.drawable.android,"Ivan", "Ivanov", "097-333-33-33", "ivan@gmail.com"));
        users.add(new User(2, R.drawable.android,"Petr", "Petrov", "097-555-55-55", "petrov@gmail.com"));
        users.add(new User(3, R.drawable.android,"Stepan", "Stepanov", "097-777-77-77", "stepanov@gmail.com"));
        countUser = users.size();
    }

    public static void add(User user){
        user.setId(countUser++);
        users.add(user);
    }
    public static void setUser(User selectedUser){
       for (int i = 0; i < users.size(); i++){
           if(selectedUser.getId() == users.get(i).getId()){
               users.set(i, selectedUser);
           }
       }
    }
}
