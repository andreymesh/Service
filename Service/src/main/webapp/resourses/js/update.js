function updateRequest()
{
    var data={}
    data.categoryId=$("#categorys option:selected").val();
    data.shortDescription=$("#shortdesc").val();
    data.description=$("#desc").val();
    data.warranty=$("#warranty").prop("checked");
    data.companyId=$("#company").val();
    data.statusId=$("#status option:selected").val();
    data.staffId=$("#staff option:selected").val();
    data.clients=$("#client").val();
    data.telephone=$("#telephone").val();
    var requestId=$("table").data("requestId");
    $.ajax({
        url:"http://localhost:8084/Service/requests"+(requestId==""?"":("/"+requestId)),
        method:(requestId==""?"POST":"PUT"),
        datatype:"json",
        contentType:"application/json",
        data:JSON.stringify(data),
        success: function (data){
            alert(data.massage)            
        },
        error: function (jqXHR, textStatus, errorThrown) {
                alert("Ошибка при обновлении");
            }})
}