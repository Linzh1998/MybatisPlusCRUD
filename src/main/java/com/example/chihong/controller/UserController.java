package com.example.chihong.controller;



import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.chihong.entity.User;
import com.example.chihong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
     private UserService userService;

//    @Autowired
//    private UserMapper userMapper;

    // 查询所有用户
    @GetMapping("/getlist")
    public List<User> getlist() {
        return userService.list();

    }

    @GetMapping("/getTwo")
    public List<User> getTwo(){
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.orderBy(true,true,"RAND()"); // 在 MySQL 中使用 RAND() 函数进行随机排序
        queryWrapper.last("LIMIT 2"); // 限制结果集为两条数据
        return userService.list(queryWrapper);
    }



    // 添加用户信息
    @PostMapping("/adduser")
    public String adduser(@RequestBody User user) {
        userService.save(user);
//        userMapper.insert(user);
        return "add succeed";
    }

    // 删除用户信息
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> dellete(@PathVariable long id){

        boolean remove = userService.removeById(id);
        if(remove){
            return  ResponseEntity.ok("del succeed");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User NOT FIUND");
        }

    }

    //get post delete put（http请求方式）

    // 修改用户信息
    @PostMapping("/update")
    public String update(@RequestBody User user){

        boolean updated = userService.updateById(user);
        if(updated){
            return "ok";
        } else{
            return "err";
        }

    }

}

////控制器和业务逻辑分开写
//@RestController
//@RequestMapping("/user/")
//public class UserController {
//
//    @Autowired
//    private UserServiceImpl userService;
//
//
//
//    // 查询所有用户
//    @GetMapping("/getlist")
//    public List<User> getlist() {
//        return userService.getlist();
//
//    }
//
//    // 添加用户信息
//    @PostMapping("/adduser")
//    public String adduser(@RequestBody User user) {
//        userService.adduser(user);
//        return "add succeed";
//    }
//
//    // 删除用户信息
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> dellete(@PathVariable long id){
//        return userService.dellete(id);
//    }
//
//    // 更新用户信息
//    @PutMapping("/updata")
//    public String updata(@RequestBody User user){
//        return userService.updata(user);
//    }
//
//}
