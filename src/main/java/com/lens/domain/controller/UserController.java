package com.lens.domain.controller;

import com.lens.domain.bean.User;
import com.lens.domain.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/userlist")
public class UserController {

    UserService userService = new UserService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUserList(){
        List<User> listOfUserList=userService.getAllUserList();
        return listOfUserList;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getuserById(@PathParam("id") int id) throws Exception {
        return userService.getUser(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public User adduser(User user) {
        return userService.addUser(user);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(User user){
        return userService.updateUser(user);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deteteUser(@PathParam("id") int id){
        userService.deleteUser(id);
    }
}
