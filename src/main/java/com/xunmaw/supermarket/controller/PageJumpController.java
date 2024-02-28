package com.xunmaw.supermarket.controller;

import com.xunmaw.supermarket.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 功能说明
 *
 */
@Controller
public class PageJumpController {
    
    //表示方法与请求URL的映射，这里映射/index请求
    @RequestMapping(value="/billadd",method = {RequestMethod.POST,RequestMethod.GET})
    public String billadd(){
        return "billadd";
    }
    @RequestMapping(value="/pwdmodify",method = {RequestMethod.POST,RequestMethod.GET})
    public String pwdmodify(){
        return "pwdmodify";
    }
    @RequestMapping(value="/provideradd",method = {RequestMethod.POST,RequestMethod.GET})
    public String provideradd(){
        return "provideradd";
    }
    @RequestMapping(value="/useradd",method = {RequestMethod.POST,RequestMethod.GET})
    public String useradd(Model model){
        model.addAttribute("user", new User());//这里给视图层提供了数据的对象，用来数据绑定
        return "useradd";
    }
    /*@RequestMapping(value="/pwdmodify.do",method = {RequestMethod.POST,RequestMethod.GET})
    public String index(){
        return "pwdmodify";
    }
    @RequestMapping(value="/pwdmodify.do",method = {RequestMethod.POST,RequestMethod.GET})
    public String index(){
        return "pwdmodify";
    }
    @RequestMapping(value="/pwdmodify.do",method = {RequestMethod.POST,RequestMethod.GET})
    public String index(){
        return "pwdmodify";
    }
    @RequestMapping(value="/pwdmodify.do",method = {RequestMethod.POST,RequestMethod.GET})
    public String index(){
        return "pwdmodify";
    }
    @RequestMapping(value="/pwdmodify.do",method = {RequestMethod.POST,RequestMethod.GET})
    public String index(){
        return "pwdmodify";
    }*/
    //@RequestMapping(value="/test2",method = {RequestMethod.POST,RequestMethod.GET})
/*    @RequestMapping(value="/index1")
    public ModelAndView index1(@RequestParam(value="username",required = false) String username){
        ModelAndView mav= new ModelAndView();
        mav.addObject("username",username);
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value="/index2")
    public String index2(@RequestParam(value="username",required = false) String username, Model model){
        model.addAttribute("username",username);
        return "index2";
    }

    @RequestMapping(value="/index3")
    public String index3(@RequestParam(value="username",required = false) String username, Map<String,Object> model){
        model.put("username",username);
        return "index2";
    }*/
}
