<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 超市订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body class="login_bg">
<fm:form method="post" id="billForm" name="billForm"  modelAttribute="user">
    private Integer id;   //id
    private String billCode; //账单编码
    private String productName; //商品名称
    private String productDesc; //商品描述
    private String productUnit; //商品单位
    private BigDecimal productCount; //商品数量
    private BigDecimal totalPrice; //总金额
    private Integer isPayment; //是否支付
    private Integer providerId; //供应商ID
    private Integer createdBy; //创建者
    private Date creationDate; //创建时间
    private Integer modifyBy; //更新者
    private Date modifyDate;//更新时间
    <div class="">
        <label for="billCode">订单编码：</label>
        <fm:input path="billCode"/>
        <input type="text" name="billCode" class="text" id="billCode" value="">
        <!-- 放置提示信息 -->
        <font color="red"></font>
    </div>
    <div>
        <label for="productName">商品名称：</label>
        <fm:input path="productName"/>
        <input type="text" name="productName" id="productName" value="">
        <font color="red"></font>
    </div>
    <div>
        <label for="productUnit">商品单位：</label>
        <fm:input path="productUnit"/>
        <input type="text" name="productUnit" id="productUnit" value="">
        <font color="red"></font>
    </div>
    <div>
        <label for="productCount">商品数量：</label>
        <fm:input path="productCount"/>
        <input type="text" name="productCount" id="productCount" value="">
        <font color="red"></font>
    </div>
    <div>
        <label for="totalPrice">总金额：</label>
        <fm:input path="totalPrice"/>
        <input type="text" name="totalPrice" id="totalPrice" value="">
        <font color="red"></font>
    </div>
    <div>
        <label >供应商：</label>
        <  />
        <select name="providerId" id="providerId">
        </select>
        <font color="red"></font>
    </div>
    <div>
        <label >是否付款：</label>
        <input type="radio" name="isPayment" value="1" checked="checked">未付款
        <input type="radio" name="isPayment" value="2" >已付款
    </div>
    <div class="providerAddBtn">
        <input type="button" name="add" id="add" value="保存">
        <input type="button" id="back" name="back" value="返回" >
    </div>
    </form>


</fm:form>
</body>
</html>

