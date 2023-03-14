package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.UserMapper;
import cn.tedu.coolshark.pojo.dto.UserLoginDTO;
import cn.tedu.coolshark.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;
    @RequestMapping("/login")
    public int login(@RequestBody UserLoginDTO userLoginDTO){
        UserVO userVO = mapper.selectByUsername(userLoginDTO.getUsername());
        if (userVO!=null){
            if (userVO.getPassword().equals(userLoginDTO.getPassword())){
                return 1;
            }
            return 2;
        }
        return 3;
    }
}
