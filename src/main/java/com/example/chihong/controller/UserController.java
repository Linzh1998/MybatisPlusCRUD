package com.example.chihong.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.chihong.entity.User;
import com.example.chihong.mapper.UserMapper;
import com.example.chihong.service.UserService;
import com.example.chihong.service.impl.UserServiceImpl;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author terry
 * @since 2023-11-16
 */

//控制器和业务逻辑一起写
//@RestController
//@RequestMapping("/user/")
//public class UserController {
//
//    @Autowired
//     private UserService userService;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    // 查询所有用户
//    @GetMapping("/getlist")
//    public List<User> getlist() {
//        return userService.list();
//
//    }
//
//    // 添加用户信息
//    @PostMapping("/adduser")
//    public String adduser(@RequestBody User user) {
//        userMapper.insert(user);
//        return "add succeed";
//    }
//
//    // 删除用户信息
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> dellete(@PathVariable long id){
//        boolean result = userMapper.deleteById(id) > 0;
//        if(result){
//            return  ResponseEntity.ok("del succeed");
//        } else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User NOT FIUND");
//        }
//    }
//
//    // 删除用户信息
//    @PutMapping("/updata")
//    public String updata(@RequestBody User user){
//        int result = userMapper.updateById(user);
//        if(result > 0){
//            return "ok";
//        } else {
//            return "err";
//        }
//    }
//
//}

//控制器和业务逻辑分开写
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;



    // 查询所有用户
    @GetMapping("/getlist")
    public List<User> getlist() {
        return userService.getlist();

    }

    // 添加用户信息
    @PostMapping("/adduser")
    public String adduser(@RequestBody User user) {
        userService.adduser(user);
        return "add succeed";
    }

    // 删除用户信息
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> dellete(@PathVariable long id){
        return userService.dellete(id);
    }

    // 更新用户信息
    @PutMapping("/updata")
    public String updata(@RequestBody User user){
        return userService.updata(user);
    }

}
