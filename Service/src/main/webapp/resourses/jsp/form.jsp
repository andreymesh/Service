<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <td>Категория</td>
                <td>
                    <select>
                        <c:forEach items="${categorys}" var="categ">
                            <option <c:if test="${req!=null && req.category.idcategory==categ.idcategory}"> 
                                    selected="selected" </c:if> value="${categ.idcategory}">
                                ${categ.category}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Краткое описание проблемы</td>
                <td>
                    <textarea rows="2" cols="20" name="text"><c:if test="${req!=null}">${req.shortDescription}</c:if>
                    </textarea>
                </td>
            </tr>
            <tr>
                <td>Детальное описание проблемы</td>
                <td>
                    <textarea rows="5" cols="20" name="text"><c:if test="${req!=null}">${req.description}</c:if>
                    </textarea>
                </td>
            </tr>
            <tr>
                <td>По гарантии</td>
                <td><input type="checkbox" <c:if test="${req!=null && req.warranty}">
                       checked</c:if>></td>
            </tr>
            <tr>
                <td>Фирма-производитель</td>
                <td>
                    <input type="text"
                        <c:if test="${req!=null}"> value="${req.company.companyName}"</c:if>
                        >
                </td>
            </tr>
            <tr>
                <td>Состояние заявки</td>
                <td>
                    <select>
                        <c:forEach items="${status}" var="stat">
                            <option <c:if test="${req!=null && 
                                                  req.status.idStatus==stat.idStatus}"> 
                                      selected="selected" </c:if> value="${stat.idStatus}"
                                >${stat.statusName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Ответственный за заявку</td>
                <td>
                    <select>
                        <c:forEach items="${staff}" var="personal">
                            <option <c:if test="${req!=null && 
                                                  req.staff.idstaff==personal.idstaff}">
                                      selected="selected" </c:if> value="${personal.idstaff}" >${personal.fio}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td rowspan="2">Данные клиента</td>
                <td>
                    ФИО: <input type="text" 
                    <c:if test="${req!=null}"> value="${req.clients.fio}" </c:if>>
                </td>
            </tr>
            <tr>
                <td>
                    Телефон:<input type="text" 
                    <c:if test="${req!=null}"> value="${req.clients.telephone}" </c:if>>
                </td>
            </tr>
        </table>
        <button type="button">
            <a href="<c:url value="/index"/>" target="_blank">Сохранить</a></button>
    </body>
</html>
