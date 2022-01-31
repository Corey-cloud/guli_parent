package com.atguigu.eduservice.controller.admin;

import com.atguigu.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * Created by corey on 2021/7/21
 **/

@RestController
@RequestMapping("/user")
//@CrossOrigin    //解决跨域
public class EduLoginController {

    //login
    @PostMapping("login")
    public R login() {
        return R.ok().data("token","admin");
    }

    //info
    @GetMapping("info")
    public R info() {
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}