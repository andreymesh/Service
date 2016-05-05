<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
        <script src="<c:url value="/resourses/js/update.js"></c:url>"></script>
    </head>
    <body>
        <table data-request-id="${req==null ? "":req.id}">
            <tr>
                <td>Категория</td>
                <td>
                    <select id="categorys">
                        <c:forEach items="${categorys}" var="categ">
                            <option <c:if test="${req!=null && req.category.id==categ.id}"> 
                                    selected="selected" </c:if> value="${categ.id}">
                                ${categ.category}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Краткое описание проблемы</td>
                <td>
                    <textarea id="shortdesc" rows="2" cols="20" name="text"><c:if test="${req!=null}">${req.shortDescription}</c:if>
                    </textarea>
                </td>
            </tr>
            <tr>
                <td>Детальное описание проблемы</td>
                <td>
                    <textarea id="desc" rows="5" cols="20" name="text"><c:if test="${req!=null}">${req.description}</c:if>
                    </textarea>
                </td>
            </tr>
            <tr>
                <td>По гарантии</td>
                <td><input id="warranty" type="checkbox" <c:if test="${req!=null && req.warranty}">
                       checked</c:if>></td>
            </tr>
            <tr>
                <td>Фирма-производитель</td>
                <td>
                    <input id="company" type="text"
                        <c:if test="${req!=null}"> value="${req.company.companyName}"</c:if>
                        >
                </td>
            </tr>
            <tr>
                <td>Состояние заявки</td>
                <td>
                    <select id="status">
                        <c:forEach items="${status}" var="stat">
                            <option <c:if test="${req!=null && 
                                                  req.status.id==stat.id}"> 
                                      selected="selected" </c:if> value="${stat.id}"
                                >${stat.statusName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Ответственный за заявку</td>
                <td>
                    <select id="staff">
                        <c:forEach items="${staff}" var="personal">
                            <option <c:if test="${req!=null && 
                                                  req.staff.id==personal.id}">
                                      selected="selected" </c:if> value="${personal.id}" >${personal.fio}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td rowspan="2">Данные клиента</td>
                <td>
                    ФИО: <input id="client" type="text" 
                    <c:if test="${req!=null}"> value="${req.clients.fio}" </c:if>>
                </td>
            </tr>
            <tr>
                <td>
                    Телефон:<input id="telephone" type="text" 
                    <c:if test="${req!=null}"> value="${req.clients.telephone}" </c:if>>
                </td>
            </tr>
        </table>
                <button type="button" onclick="updateRequest();">Сохранить</button>
    </body>
</html>
