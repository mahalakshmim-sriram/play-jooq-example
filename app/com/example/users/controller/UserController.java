package com.example.users.controller;

import com.example.models.tables.pojos.Users;
import com.example.users.models.UserVo;
import com.example.users.service.IUserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.util.List;

public class UserController extends Controller {

    @Inject
    private IUserService userService;

    @Inject
    ObjectMapper mapper;


    public Result createOrUpdateUser(Http.Request request) {
        JsonNode jsonNode = request.body().asJson();
        UserVo user = mapper.convertValue(jsonNode, UserVo.class);
        Users updatedUser = userService.createOrUpdateUser(user);
        if (updatedUser == null){
            return badRequest(Json.toJson("User Creation/Updation unsuccessful."));
        }
        UserVo updatedUserVo = mapper.convertValue(user, UserVo.class);
        return ok(Json.toJson(updatedUserVo));
}

    public Result deleteUser(String userName) {
        boolean success = userService.deleteUser(userName);
        if (success) {
            return ok(Json.toJson("User Deleted successfully"));
        }
        return badRequest(Json.toJson("User Deletion unsuccussful"));
    }

    public Result users() {
        List<Users> users = userService.fetchUsers();
        return ok(Json.toJson(users));
    }

    public Result user(String userName) {
        Users user = userService.fetchUser(userName);
        if (user != null) {
            return ok(Json.toJson(user));
        } else {
            return badRequest(Json.toJson("User not found"));
        }
    }

}
