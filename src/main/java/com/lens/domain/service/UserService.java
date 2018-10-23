package com.lens.domain.service;

import com.lens.domain.bean.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserService {

    static HashMap<Integer, User> userIdMap=getUserIdMap();

    public UserService(){
        if(userIdMap == null){
            userIdMap = new HashMap<Integer, User>();

            User userA= new User(1, "Ashen", 22);
            User userB= new User(2, "John", 27);
            User userC= new User(3, "Jack", 25);
            User userD= new User(4, "Shane", 23);

            userIdMap.put(1,userA);
            userIdMap.put(4,userB);
            userIdMap.put(3,userC);
            userIdMap.put(2,userD);
        }

    }

    public List<User> getAllUserList() {
        List<User> userList = new ArrayList<User>(userIdMap.values());
        return userList;
    }

    public User getUser(int id) throws Exception{
        User user = userIdMap.get(id);
        if(user == null){
            throw new Exception("user with id " +id+" not found");
        }
        return user;
    }

    public User addUser(User user) {
        user.setId(getMaxId() + 1);
        userIdMap.put(user.getId(),user);
        return user;
    }

    public User updateUser(User user) {
        if(user.getId() <= 0){
            return null;
        }
        userIdMap.put(user.getId(),user);
        return user;
    }

    public void deleteUser(int id) {
        userIdMap.remove(id);
    }

    public static HashMap<Integer,User> getUserIdMap(){
        return userIdMap;
    }

    public static int getMaxId(){
        int max = 0;
        for(int id:userIdMap.keySet()){
            if(max<=id){
                max = id;
            }
        }
        return max;
    }
}
