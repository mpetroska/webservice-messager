package lt.bt.messager.messanger.controller;

import lt.bt.messager.messanger.dto.User;
import lt.bt.messager.messanger.entity.UserEntity;
import lt.bt.messager.messanger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public User createUser(@RequestBody User user) {

            userService.createUser(user);


        return user;
    }

    @GetMapping()
    public List<UserEntity> getAll() {

        return userService.getAll();
    }




}
