$(function () {

    $(".productsLink").click();

});


function changeLink( type , th ) {

    //更改链接样式
    $(".links div").each(function (i,ele) {
        $(ele).removeClass("selectLinkSpan");
    });
    $(th).removeClass("noSelectLinkSpan");
    $(th).addClass("selectLinkSpan");

    //切换显示
    $(".home").css("display","none");
    $(".product").css("display","none");
    $(".contact").css("display","none");
    $(".about").css("display","none");
    $("."+type).css("display","inline-block");
    //$(".language").css("display","none");

}

function submitBtn(){

    var nameInput = $(".nameInput").val();
    var companyInput = $(".companyInput").val();
    var contactInput = $(".contactInput").val();
    var emailInput = $(".emailInput").val();
    var messageInput = $(".messageInput").val();

    if( !nameInput ){
        alert("Please tell us your name ");
        return;
    }

    $.ajax({
        url : "/commitInfo",
        type : "post",
        data:{
            nameInput:nameInput,
            companyInput:companyInput,
            contactInput:contactInput,
            emailInput:emailInput,
            messageInput:messageInput
        },
        success : function(data) {
           if(data){
               alert("If the submission is successful, we will keep in touch with you in time.");
           }
        },
        error : function () {
            alert("Failed to add. Please contact the administrator . ");
        }
    });
}