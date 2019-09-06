package com.jnshu.crq.action;

import com.jnshu.crq.common.nickName.NickName;
import com.jnshu.crq.common.response.ResponseBo;
import com.jnshu.crq.model.User;
import com.jnshu.crq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseBo register(@RequestBody User user) throws Exception {
        Random random = new Random();
        int len = random.nextBoolean()? 2 : 3;
        user.setName(NickName.getNickName(random.nextBoolean(),len));
        user.setSynopsis(user.getName()+"的简介");
        user.setCreateAt(System.currentTimeMillis());
        userService.addUser(user);
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("data",user);
        return responseBo;
    }

    @PostMapping("/login")
    public ResponseBo login(HttpSession session, @RequestBody HashMap<String,String> req) throws Exception {
        List<User> list = userService.getUserByName(req.get("name"));
        if(list.size()>0){
            User user = userService.getUserLogin(req.get("name"),req.get("password"));
            if(user==null){
                return ResponseBo.error("密码错误");
            }else {
                session.setAttribute("user",user);
                return ResponseBo.ok("登录成功");
            }
        }else{
            return ResponseBo.error("用户名错误");
        }
    }

    @PostMapping("/logout")
    public ResponseBo logout(HttpSession session){
        session.removeAttribute("user");
        ResponseBo responseBo = ResponseBo.ok("注销成功");
        return responseBo;
    }


    @GetMapping("/profile")
    public ResponseBo profile(HttpSession session){
        ResponseBo responseBo = ResponseBo.ok("获取个人信息成功");
        User user = (User) session.getAttribute("user");
        responseBo.put("user",user);
        return responseBo;
    }
}
