<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: wwwya
  Date: 2021/6/5
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    是顶顶顶顶顶顶顶顶顶顶顶顶顶
    <form action="${pageContext.request.contextPath}/user/quick22" method="post" enctype="multipart/form-data">
        名称 ：<input type="text" name="name"> <br>
        文件1<input type="file" name="uploadFile1"><br/>
        文件2<input type="file" name="uploadFile2"><br/>
        <input type="submit" name="提交文件">
    </form>

    <form action="${pageContext.request.contextPath}/user/quick23" method="post" enctype="multipart/form-data">
        名称<input type="text" name="username"><br/>
        文件1<input type="file" name="uploadFile"><br/>
        文件2<input type="file" name="uploadFile"><br/>
        <input type="submit" value="提交">
    </form>


</head>
<body>

</body>
</html>
