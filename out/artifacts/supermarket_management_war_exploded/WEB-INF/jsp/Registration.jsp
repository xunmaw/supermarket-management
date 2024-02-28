<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<!--头部-->
<header class="publicHeader">
    <h1>超市订单管理系统</h1>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${userSession.userName }</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath }/jsp/logout.do">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2022年12月16日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li>注册</li>
                <li><a href="${pageContext.request.contextPath }/logout.do">退出注册</a></li>
            </ul>
        </nav>
    </div>
    <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
    <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>

    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>注册页面</span>
        </div>
        <div class="providerAdd">
            <fm:form method="post" id="billForm" name="billForm" action="${pageContext.request.contextPath }/user.do?method=add"  modelAttribute="user">
                用户编码:<fm:input path="userCode"/></br>
                用户名称:<fm:input path="userName"/></br>
                用户密码:<fm:password path="userPassword"/></br>
                性别：<form:radiobutton path="gender" value="男" label="男"/>
                <form:radiobutton path="gender" value="女" label="女"/><br/>
                出生日期:<fm:input path="birthday" type="date" value="1999-01-01"/>
                电话:<fm:input path="phone"/></br>
                地址:<fm:input path="address"/></br>
                用户角色:<form:select path="userRole" items="userRole">
                <option value="Regular employees">普通员工</option>
                <option value="Regular employees">经理</option>
            </form:select>
                创建者:<fm:input path="createdBy"/></br>
                创建时间:<fm:input path="creationDate"/></br>
                更新者:<fm:input path="modifyBy"/></br>
                更新时间:<fm:input path="modifyDate"/></br>

                <%--            private String userCode; //用户编码--%>
                <%--            private String userName; //用户名称--%>
                <%--            private String userPassword; //用户密码--%>
                <%--            private Integer gender;  //性别--%>
                <%--            private Date birthday;  //出生日期--%>
                <%--            private String phone;   //电话--%>
                <%--            private String address; //地址--%>
                <%--            private Integer userRole;    //用户角色--%>
                <%--            private Integer createdBy;   //创建者--%>
                <%--            private Date creationDate; //创建时间--%>
                <%--            private Integer modifyBy;     //更新者--%>
                <%--            private Date modifyDate;   //更新时间--%>

                <%--            private Integer age;//年龄--%>

                <%--            private String userRoleName;    //用户角色名称--%>






            </fm:form>
        </div>
    </div>
</section>
<%@include file="foot.jsp" %>
