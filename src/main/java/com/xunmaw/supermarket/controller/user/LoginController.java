package com.xunmaw.supermarket.controller.user;

import com.xunmaw.supermarket.pojo.User;
import com.xunmaw.supermarket.service.bill.BillServiceImpl;
import com.xunmaw.supermarket.service.provider.ProviderServiceImpl;
import com.xunmaw.supermarket.service.role.RoleServiceImpl;
import com.xunmaw.supermarket.service.user.UserServiceImpl;
import com.xunmaw.supermarket.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能说明
 *
 */
@Controller
public class LoginController {
    @Autowired
	UserServiceImpl userService;
    @Autowired
	RoleServiceImpl roleService;
    @Autowired
	ProviderServiceImpl providerService;
    @Autowired
	BillServiceImpl billService;

    @RequestMapping(value="/login.do",method = {RequestMethod.POST,RequestMethod.GET})
    public String doPost(HttpServletRequest request, HttpServletResponse response, Model model){
        //获取用户名和密码
        String userCode = request.getParameter("userCode");
        String userPassword = request.getParameter("userPassword");
        //调用service方法，进行用户匹配
        User user = userService.login(userCode,userPassword);
        if(null != user){//登录成功
            //放入session
            request.getSession().setAttribute(Constants.USER_SESSION, user);
            //页面跳转（frame.jsp）
            return "frame";
        }else{
            //页面跳转（login.jsp）带出提示信息--转发
            model.addAttribute("error", "用户名或密码不正确");
            return "login";
            //.forward(request, response);
        }
    }

}
