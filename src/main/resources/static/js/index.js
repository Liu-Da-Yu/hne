var layer , loading ,loadingDetail;
layui.use('layer', function() {
    layer = layui.layer;
    $(".aboutLink").click();

});

//点击查看详情
function clickDetail( id ){

    loadingDetail = layer.load(0, {shade:  [0.4,'#000']});

    //根据id获取产品详情
    $.ajax({
        url : "/getProductById",
        type : "post",
        data:{
            id : id
        },
        success : function( res ) {
            res = JSON.parse(res);
            if( res.code === 0 && res.data ){
                var data = res.data[0];
                if(data){
                    var imgs = getUrl(data.imgUrl,false);
                    var infos = getUrl(data.infoImgUrl,true);
                    var dom =
                        "<div style='height: 800px;padding: 15px'>"+
                          "<div class='layui-carousel' id='lunbo'>" +
                            "<div carousel-item>" +
                               imgs+
                            "</div>" +
                          "</div>"+
                        "<div style='padding-left: 35px;padding-top: 15px'>"+data.infoText+"</div>" +  infos
                        +"</div>";

                    layer.open({
                        type: 1
                        ,title: 'View details'
                        ,closeBtn: 1
                        ,area: '700px'
                        ,shade: 0.8
                        ,id: 'LAY_layuipro'
                        ,moveType: 0
                        ,content: dom

                    });

                    layui.use('carousel', function(){
                        var carousel = layui.carousel;
                        //建造实例
                        carousel.render({
                            elem: '#lunbo'
                            ,width: '100%' //设置容器宽度
                            ,arrow: 'always' //始终显示箭头
                            //,anim: 'updown' //切换动画方式
                        });
                    });
                }
                layer.close(loadingDetail);
            }
        },
        error : function () {
            alert("Failed to add. Please contact the administrator . ");
            layer.close(loadingDetail);
        }

    });

}

//根据地址拼接img标签 是否拼接图片风格
function getUrl( str , f ){

    var dom = "";
    if(str){
        var style = "" ;
        if(f){
            style = "style = 'width:580px;margin-left:45px'" ;
        }

        var strs = str.split(";");
        for(var i = 0 ; i < strs.length ; i++ ){
            if( strs[i] && strs[i].length > 2 ){
                dom += "<img " + style + "src='/productImg/"+strs[i]+"'>";
            }
        }
    }
    return dom ;
}

function getProducts ( where ){

    loading = layer.load(0, {shade:  [0.4,'#000']});

    $.ajax({
        url : "/getProducts",
        type : "post",
        data:{
            where : where
        },
        success : function( res ) {
            res = JSON.parse(res);
            if( res.code === 0 && res.data ){

                var dom = "";
                $.each( res.data , function ( index , ele ) {
                    dom += "<tr class='productTr' style='height: 170px'>" +
                                "<td class='productTd0'>"+ele.id+"</td>" +
                                "<td class='productTd1'>" +
                                    "<img class='productTdImg' src='/productImg/"+ele.imgUrl+"'>" +
                                "</td>" +
                                "<td class='productTd2'>"+ele.name+"</td>" +
                                "<td class='productTd3'>"+ele.size+"</td>" +
                                "<td class='productTd4'>"+ele.voltage+"</td>" +
                                "<td class='productTd5'>"+ele.energy+"</td>" +
                                "<td class='productTd6'>" +
                                    "<button onclick='clickDetail("+"\""+ele.id+"\""+")' class='productBtn layui-btn layui-btn-normal'>DETAIL</button>" +
                                "</td>" +
                            "</tr>";
                });

                $(".productTable tr").eq(0).nextAll().remove();
                $(".productTable").append(dom);
                layer.close(loading);
            }
        },
        error : function () {
            alert("Failed to add. Please contact the administrator . ");
            layer.close(loading);
        }
    });



}


function changeLink( type , th ) {

    //更改链接样式
    $(".links div").each(function (i,ele) {
        $(ele).removeClass("selectLinkSpan");
    });
    $(th).removeClass("noSelectLinkSpan");
    $(th).addClass("selectLinkSpan");

    //切换显示
    $(".product").css("display","none");
    $(".contact").css("display","none");
    $(".about").css("display","none");
    $(".lithium").css("display","none");
    //lithium
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

//根据条件获取数据
function getProductByType(){
    getProducts( $(".productType option:selected").val() );
}