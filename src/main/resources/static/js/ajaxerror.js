var baseurl = window.document.location.origin+'/imooc';
console.log(baseurl)
$.ajax({
    url:baseurl+ "/err/getAjaxerror",
    type:"POST",
    async:false,
    success:function(data){
        //debugger;
        if(data.status == 200 && data.msg == "OK"){
            alert("SUCCESS");
        }else{
            alert("发生异常："+ data.msg);
        }
    },
    error:function (response, ajaxOptions, thrownError) {
        alert("error")
    }
})