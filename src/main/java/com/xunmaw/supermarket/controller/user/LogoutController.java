package com.xunmaw.supermarket.controller.user;

import com.xunmaw.supermarket.service.bill.BillServiceImpl;
import com.xunmaw.supermarket.service.provider.ProviderServiceImpl;
import com.xunmaw.supermarket.service.role.RoleServiceImpl;
import com.xunmaw.supermarket.service.user.UserServiceImpl;
import com.xunmaw.supermarket.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能说明
 *
 */
@Controller
public class LogoutController {
    @Autowired
	UserServiceImpl userService;
    @Autowired
	RoleServiceImpl roleService;
    @Autowired
	ProviderServiceImpl providerService;
    @Autowired
	BillServiceImpl billService;
    @RequestMapping(value="/logout.do",method = {RequestMethod.POST,RequestMethod.GET})
    public String  doPost(HttpServletRequest request, HttpServletResponse response)
    {
        //清除session
        request.getSession().removeAttribute(Constants.USER_SESSION);
        return "/login";
    }
}
