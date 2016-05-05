<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resourses/css/index.css" >
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
        <script src="<c:url value="/resourses/js/index.js"></c:url>"></script>
    </head>
    <body>
        <p><a href="<c:url value="/form"/>" target="_blank" class="button">Добавление</a>
        <a id="updateButton" href="<c:url value="/form"/>" target="_blank" class="button">Изменение</a>
        <button onclick="deleteRequest();">Удаление</button></p>
    <table id="tableId" class="brd">
            <tr class="thead">
                 <th rowspan="2">Категория</th>
                 <th rowspan="2">Краткое описание проблемы</th>
                 <th rowspan="2">По гарантии</th>
                 <th rowspan="2">Фирма-производитель</th>
                 <th rowspan="2">Дата заявки</th>
                 <th rowspan="2">Крайний срок</th>
                 <th rowspan="2">Состояние заявки</th>
                 <th rowspan="2">Ответственный за заявку</th>
                 <th colspan="2">Данные клиента</th>
             </tr>
             <tr class="thead">
                 <th>ФИО</th>
                 <th>Телефон</th>
             </tr>
             <div id="foundDiv">
                 <c:forEach items="${requests}" var="req">
                     <tr data-request-id="${req.id}" class="tbody" onclick="setActive(this);">
                     <th>${req.category.category}</th>
                     <th>${req.shortDescription}</th>
                     <th>${req.warranty}</th>
                     <th>${req.company.companyName}</th>
                     <th>${req.filingDate}</th>
                     <th>${req.deadline}</th>
                     <th>${req.status.statusName}</th>
                     <th>${req.staff.fio}</th>
                     <th>${req.clients.fio}</th>
                     <th>${req.clients.telephone}</th>
                 </tr>
             </c:forEach>
             </div>
        </table>        
    </body>
</html>
