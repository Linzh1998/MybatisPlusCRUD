package com.example.chihong.service.impl;

import com.example.chihong.entity.User;
import com.example.chihong.mapper.UserMapper;
import com.example.chihong.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author terry
 * @since 2023-11-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getlist() {
        return userMapper.selectList(null);

    }

    public String adduser(@RequestBody User user) {
        userMapper.insert(user);
        return null;
    }

    public ResponseEntity<?> dellete(long id){
        boolean result = userMapper.deleteById(id) > 0;
        if(result){
            return  ResponseEntity.ok("del succeed");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User NOT FIUND");
        }
    }

    public String updata(User user){
        int result = userMapper.updateById(user);
        if(result > 0){
            return "ok";
        } else {
            return "err";
        }
    }

}
