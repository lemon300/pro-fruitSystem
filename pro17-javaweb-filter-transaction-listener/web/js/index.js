function delFruit(fid){
    if(confirm("是否确定删除?")){
        window.location.href="fruit.do?fid=" + fid + "&operate=delete";
    }
}
function indexFruit(pageNo){
    window.location.href="fruit.do?pageNo=" + pageNo;
}