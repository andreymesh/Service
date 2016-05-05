function setActive(element)
{
    var elem=$(element);
    var e=elem.parent().find("tr");
    for (var i=0; i<e.length; i++)
    {
        $(e[i]).removeClass("active");
    }
    elem.addClass("active");
    var id=elem.data("requestId");
    var temp=$("#updateButton");
    var tmp=temp.attr("href");
    var lastIndex=tmp.lastIndexOf("?");
    if (lastIndex!=-1)
    {
        tmp=tmp.substring(0,lastIndex);
    }
    tmp=tmp+"?requestId="+id;
    temp.attr("href",tmp);
}

function deleteRequest()
{
    var id=$("#tableId");
    var activeTr=id.find("tr.active");
    if (activeTr[0]==undefined)
    {
        alert("Выберите необходимую строку");
    }
    else
    {
        $.ajax({
            url:"http://localhost:8084/Service/requests?requestId="+activeTr.data("requestId"),
            method:"DELETE",
            success: function (data, textStatus, jqXHR) {
                alert("Удаление завершено");
                $(activeTr).remove();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Ошибка при удалении");
            }})
    }
}