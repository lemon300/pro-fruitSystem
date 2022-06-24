function $(id) {
    return document.getElementById(id);
}

//检验非空方式一：
function checkFruit() {
    let fname = $("fname");
    let price = $("price");
    let fcount = $("fcount");
    let remark = $("remark");
    let input = $("input")

    if (fname.value == "") {
        alert("名称不可为空！");
        fname.focus();
        return false;
    } else if (price.value == "") {
        alert("价格不可为空！");

        price.focus();
        return false;
    } else if (fcount.value == "") {
        alert("库存不可为空！");

        fcount.focus();
        return false;
    } else if (remark.value == "") {
        alert("备注不可为空！");

        remark.focus();
        return false;
    } else {
        return true;
    }

}

//检验非空方式二：
function myCheck() {
    let fruitTbl = $("tbl_fruit");
    let element = fruitTbl.rows;
    //获取所有input元素的集合
    let inputList = document.getElementsByTagName("input");
    for (let i = 0; i < element.length - 1; i++) {
        let input = element[i].cells[1].firstChild;
        let th = element[i].cells[0].innerText;
        let thText = th.split(":", 1)[0];
        if (input.value.trim() == "" || input.value.length == null) {
            alert(thText + "不可为空");
            //通过属性名id获取input的id属性值
            let id = inputList[i+1].getAttribute("id")
            //alert(id);
            if (id != null) {
                $(id).focus();
            }
            return false;
        }
    }
    return true;
}