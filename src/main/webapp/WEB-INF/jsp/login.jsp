<%--
  Created by IntelliJ IDEA.
  User: 宏哥、为你疯
  Date: 2020/5/21
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>登录界面</title>
    <script  src="../../js/jquery-1.11.0.min.%20js"></script>
    <script>
    $(
        function () {
            $("#btn").on("click",function () {
                var error="";
                var flag=true;

                var userName=$("#uname").val();
                var pwd=$("#pwd").val();
                if(userName==""||userName==undefined){
                    error="用户名不能为空！";
                    flag=false;
                }
                if(pwd==""||pwd==undefined){
                    error="密码不能为空！";
                    flag=false;
                }
                if(pwd==""&&userName==""){
                    error="账号和密码都不能为空！";
                    flag=false;
                }
                if(flag==true&&error==""){
                    $("#form1").submit();
                }else{
                    alert(error);
                    return;
                }
            });
        }
    );
    </script>
</head>
<body>
    <h1>登录</h1>
    <p style="color: red">${error}</p>
    <form:form action="/doLogin1" modelAttribute="user"  method="post" id="form1">
    用户名:<form:input path="uName" id="uname"/><br>
    密码:<form:password path="password" id="pwd"/><br>
    <input type="button" value="提交" id="btn"/>
    </form:form>
</body>
</html>
