var pathName = document.location.pathname;
var index = pathName.substr(1).indexOf("/");
var result = pathName.substr(0,index+1);

function page_nav(frm,inputNum){
    frm.pageIndex.value = inputNum;
    frm.submit();
}
function jump_to(totalPage,inputNum,resourse){

    //alert(num);
    //验证用户的输入
    var regexp=/^[1-9]\d*$/;
    //alert(totalPageCount);
    console.log("inputNum: "+inputNum);
    console.log("totalPage: "+totalPage);
    if(!regexp.test(inputNum)){
        alert("请输入大于0的正整数！");
        return false;
    }else if((parseInt(inputNum)-parseInt(totalPage)) > 0){
        alert("请输入小于总页数的页码, inputNum:"+inputNum+" totalPage:"+totalPage);
        return false;
    }else{
        window.location.href = result+resourse+"&pn="+parseInt(inputNum);
    }
}