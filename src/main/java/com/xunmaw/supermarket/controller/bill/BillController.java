package com.xunmaw.supermarket.controller.bill;

import com.alibaba.fastjson.JSONArray;
import com.xunmaw.supermarket.pojo.Bill;
import com.xunmaw.supermarket.pojo.Provider;
import com.xunmaw.supermarket.pojo.User;
import com.xunmaw.supermarket.service.bill.BillServiceImpl;
import com.xunmaw.supermarket.service.provider.ProviderServiceImpl;
import com.xunmaw.supermarket.service.user.UserServiceImpl;
import com.xunmaw.supermarket.tools.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 功能说明
 *
 */
@Controller
public class BillController {
    @Autowired
	BillServiceImpl billService;
    @Autowired
	ProviderServiceImpl providerService;
    @Autowired
	UserServiceImpl userService;

    @RequestMapping(value="/bill.do",method = {RequestMethod.POST,RequestMethod.GET})
    public String doPost(@RequestParam(value = "pn",defaultValue = "1")Integer pn, HttpServletRequest request, HttpServletResponse response, @RequestParam(value="method",required = false) String method)
            throws ServletException, IOException {
        System.out.println("=================== "+method);
        if(method != null && method.equals("query")){
            return this.query(pn,request,response);
        }else if(method != null && method.equals("add")){
            return  this.add(request,response);
        }else if(method != null && method.equals("view")){
            return  this.getBillById(request,response,"billview");
        }else if(method != null && method.equals("modify")){
            return this.getBillById(request,response,"billmodify");
        }else if(method != null && method.equals("modifysave")){
            return this.modify(request,response);
        }else if(method != null && method.equals("delbill")){
            this.delBill(request,response);
        }else if(method != null && method.equals("getproviderlist")){
            this.getProviderlist(request,response);
        }
        return "error";
    }

    private void getProviderlist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("getproviderlist ========================= ");
        List<Provider> providerList = new ArrayList<Provider>();
        providerList = providerService.getProviderList("","");
        System.out.println("getProName--------------"+providerList.get(0).getProName());
        //把providerList转换成json对象输出
        response.setContentType("application/json");
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(providerList));
        outPrintWriter.flush();
        outPrintWriter.close();
    }
    private String getBillById(HttpServletRequest request, HttpServletResponse response,String url)
            throws ServletException, IOException {
        String id = request.getParameter("billid");
        if(!StringUtils.isNullOrEmpty(id)){

            Bill bill = null;
            bill = billService.getBillById(id);
            System.out.println("bill================>  "+bill);
            request.setAttribute("bill", bill);
            return url;
//			request.getRequestDispatcher(url).forward(request, response);
        }
        return "error";
    }

    private String modify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("modify===============");
        String id = request.getParameter("id");
        String productName = request.getParameter("productName");
        String productDesc = request.getParameter("productDesc");
        String productUnit = request.getParameter("productUnit");
        String productCount = request.getParameter("productCount");
        String totalPrice = request.getParameter("totalPrice");
        String providerId = request.getParameter("providerId");
        String isPayment = request.getParameter("isPayment");

        Bill bill = new Bill();
        bill.setId(Integer.valueOf(id));
        bill.setProductName(productName);
        bill.setProductDesc(productDesc);
        bill.setProductUnit(productUnit);
        bill.setProductCount(new BigDecimal(productCount).setScale(2,BigDecimal.ROUND_DOWN));
        bill.setIsPayment(Integer.parseInt(isPayment));
        bill.setTotalPrice(new BigDecimal(totalPrice).setScale(2,BigDecimal.ROUND_DOWN));
        bill.setProviderId(Integer.parseInt(providerId));

        bill.setModifyBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());
        bill.setModifyDate(new Date());
        boolean flag = false;

        flag = billService.modify(bill);
        if(flag){
            return "redirect:/bill.do?method=query";
//			response.sendRedirect(request.getContextPath()+"/jsp/bill.do?method=query");
        }else{
            return "billmodify";
//			request.getRequestDispatcher("billmodify.jsp").forward(request, response);
        }
    }
    private void delBill(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("billid");
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(!StringUtils.isNullOrEmpty(id)){

            boolean flag = billService.deleteBillById(id);
            if(flag){//删除成功
                resultMap.put("delResult", "true");
            }else{//删除失败
                resultMap.put("delResult", "false");
            }
        }else{
            resultMap.put("delResult", "notexit");
        }
        //把resultMap转换成json对象输出
        response.setContentType("application/json");
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(resultMap));
        outPrintWriter.flush();
        outPrintWriter.close();
    }
    private String add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String billCode = request.getParameter("billCode");
        String productName = request.getParameter("productName");
        String productDesc = request.getParameter("productDesc");
        String productUnit = request.getParameter("productUnit");

        String productCount = request.getParameter("productCount");
        String totalPrice = request.getParameter("totalPrice");
        String providerId = request.getParameter("providerId");
        String isPayment = request.getParameter("isPayment");

        Bill bill = new Bill();
        bill.setBillCode(billCode);
        bill.setProductName(productName);
        bill.setProductDesc(productDesc);
        bill.setProductUnit(productUnit);
        bill.setProductCount(new BigDecimal(productCount).setScale(2,BigDecimal.ROUND_DOWN));
        bill.setIsPayment(Integer.parseInt(isPayment));
        bill.setTotalPrice(new BigDecimal(totalPrice).setScale(2,BigDecimal.ROUND_DOWN));
        bill.setProviderId(Integer.parseInt(providerId));
        bill.setCreatedBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());
        bill.setCreationDate(new Date());
        boolean flag = false;

        flag = billService.add(bill);
        if(flag){
            return "redirect:/bill.do?method=query";
//			response.sendRedirect(request.getContextPath()+"/jsp/bill.do?method=query");
        }else{
            return "billadd";
//			request.getRequestDispatcher("billadd.jsp").forward(request, response);
        }

    }
    private String query(Integer pn,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Provider> providerList = new ArrayList<Provider>();

        providerList = providerService.getProviderList("","");
        String queryProductName = request.getParameter("queryProductName");
        String queryProviderId = request.getParameter("queryProviderId");
        String queryIsPayment = request.getParameter("queryIsPayment");
        if(StringUtils.isNullOrEmpty(queryProductName)){
            queryProductName = "";
        }

        List<Bill> billList = new ArrayList<Bill>();
        Bill bill = new Bill();
        if(StringUtils.isNullOrEmpty(queryIsPayment)){
            bill.setIsPayment(0);
        }else{
            bill.setIsPayment(Integer.parseInt(queryIsPayment));
        }

        if(StringUtils.isNullOrEmpty(queryProviderId)){
            bill.setProviderId(0);
        }else{
            bill.setProviderId(Integer.parseInt(queryProviderId));
        }
        bill.setProductName(queryProductName);
        //开启分页
        PageHelper.startPage(pn,10);
        billList = billService.getBillList(bill);
        PageInfo pageinfo = new PageInfo(billList);
        if(providerList == null){
            pageinfo.setPageNum(0);
        }
        //设置分页信息
        request.setAttribute("pageinfo",pageinfo);

        System.out.println("=------------------"+billList);
        request.setAttribute("billList", billList);
        request.setAttribute("queryProductName", queryProductName);
        request.setAttribute("queryProviderId", queryProviderId);
        request.setAttribute("queryIsPayment", queryIsPayment);
        request.setAttribute("providerList",providerList);
        return "billlist";
//		request.getRequestDispatcher("billlist.jsp").forward(request, response);

    }

    public static void main(String[] args) {
        System.out.println(new BigDecimal("23.235").setScale(2,BigDecimal.ROUND_HALF_DOWN));
    }
}
