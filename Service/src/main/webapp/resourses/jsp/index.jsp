<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!0990</h1>
        <c:forEach items="${category}" var="test">
            <h3>${test.idcategory}   ${test.category}</h3>
        </c:forEach>
    </body>
</html>
