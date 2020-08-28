package com.swagger.swaggerdemoapi.rest;

import com.swagger.swaggerdemoapi.entities.User;
import com.swagger.swaggerdemoapi.model.ApiError;
import com.swagger.swaggerdemoapi.model.UserBean;
import com.swagger.swaggerdemoapi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.HttpURLConnection;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/users")
@Api()
public class UserController {
    @Autowired
    private UserService userService;

    final String JSON = "application/json";
    final String XML = "application/xml";

    @GetMapping("")
    @ApiOperation(value = "Get the list of users", notes = "Return a list of all the users",
            produces = JSON+","+XML, consumes = JSON+","+XML)
    List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("")
    @ApiOperation(value = "Creates an user", notes = "Returns the user",
            produces = JSON+","+XML, consumes = JSON+","+XML)
    @ApiResponses({
            @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Errors in the input data", response=ApiError.class)
    })
    User postUser(@Valid @RequestBody UserBean newUser) {
        return userService.postUser(newUser);
    }

    @GetMapping("/{userId}")
    @ApiResponses({
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "User not found", response=ApiError.class)
    })
    @ApiOperation(value = "Find an user by id", notes = "Returns the user",
            produces = JSON+","+XML, consumes = JSON+","+XML)
    User getUser(@PathVariable Integer userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    @ApiOperation(value = "E-dits an user", notes = "Returns the user",
            produces = JSON+","+XML, consumes = JSON+","+XML)
    @ApiResponses({
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "User not found", response=ApiError.class),
            @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Errors in the input data", response=ApiError.class)
    })
    User putUser(@RequestBody UserBean newUser, @PathVariable Integer userId) {
        return userService.editUser(newUser, userId);
    }

    @DeleteMapping("/{userId}")
    @ApiOperation(value = "Deletes an user")
    @ApiResponses({
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "User not found", response=ApiError.class)
    })
    void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }
}
