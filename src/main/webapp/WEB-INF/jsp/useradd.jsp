<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@include file="head.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户管理页面 >> 用户添加页面</span>
    </div>
    <div class="providerAdd">
        <fm:form method="post" id="billForm" name="billForm" action="${pageContext.request.contextPath }/user.do?method=add"  modelAttribute="user">
            <div>
                <label for="userCode">用户编码：</label>
                <fm:input path="userCode" name="userCode" id="userCode"/>
                <fm:errors path="userCode"/>
                <!-- 放置提示信息 -->
                <font color="red"></font>
            </div>
            <div>
                <label for="userName">用户名称：</label>
                <fm:input path="userName" name="userName" id="userName"/>
                <fm:errors path="userName"/>
                <font color="red"></font>
            </div>
            <div>
                <label for="userPassword">用户密码：</label>
                <fm:password path="userPassword" name="userPassword" id="userPassword"/>
                <fm:errors path="userPassword"/>
                <font color="red"></font>
            </div>
            <%--                &lt;%&ndash;<div>&ndash;%&gt;
            &lt;%&ndash;                    <label for="ruserPassword">确认密码：</label>&ndash;%&gt;
            &lt;%&ndash;                    <input type="password" name="ruserPassword" id="ruserPassword" value="">&ndash;%&gt;
            &lt;%&ndash;                    <fm:errors path="ruserPassword"/>&ndash;%&gt;
            &lt;%&ndash;                    <font color="red"></font>&ndash;%&gt;
            &lt;%&ndash;                </div>&ndash;%&gt;--%>
            <div>
                <label >用户性别：</label>
                <fm:select  path="gender" name="gender" id="gender">
                    <option value="1" selected="selected">男</option>
                    <option value="2">女</option>
                </fm:select>
                <fm:errors path="gender"/>
            </div>
            <div>
                <label for="birthday">出生日期：</label>
                <fm:input path="birthday" type="text" Class="Wdate" id="birthday" name="birthday"
                          readonly="readonly" onclick="WdatePicker();"/>
                <fm:errors path="birthday"/>

                <font color="red"></font>
            </div>
            <div>
                <label for="phone">用户电话：</label>
                <fm:input path="phone" name="phone" id="phone"/>
                <fm:errors path="phone"/>
                <font color="red"></font>
            </div>
            <div>
                <label for="address">用户地址：</label>
                <fm:input path="address" name="address" id="address"/>
                <fm:errors path="address"/>
            </div>
            <div>
                <label >用户角色：</label>
                <!-- 列出所有的角色分类 -->
                <fm:select path="userRole" name="userRole" id="userRole">
                    <fm:option value="1">系统管理员</fm:option>
                    <fm:option value="2">经理</fm:option>
                    <fm:option value="3">普通用户</fm:option>
                </fm:select>
                <fm:errors path="userRole"/>
                <font color="red"></font>
            </div>
            <div class="providerAddBtn">
                <input type="submit" name="add" id="add" value="保存" >
                <input type="button" id="back" name="back" value="返回" >
            </div>
        </fm:form>
    </div>
</div>
</section>
<%@include file="foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/useradd.js"></script>

