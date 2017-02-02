var temp;
/**
 * 删除paper会话
 * @param id
 */
function delPaperDialog(id){
	temp = id;
	$("#dialog").dialog({
		autoOpen:false,
        show: {
            effect: "fadeIn",
            duration: 500
        },
        hide: {
            effect: "fadeOut",
            duration: 500
        },
	    resizable: false,
        height: "auto",
        width: 300,
        modal: true,
        buttons: {
            "是": function() {
                $( this ).dialog( "close" );
                if(temp===undefined){
                	delBatch();
                }else delOne(temp); 
            },
        	"否":function(){
        		$(this).dialog("close");
        	}
        },
        closeOnEscape:true
	});
	$("#dialog").dialog("open");
}
/**
 * 点击换页
 * */
function pageClick(currentPage){
	document.getElementById("currentPage").setAttribute("value", currentPage);
	document.getElementById("mainForm").submit();
}

/**
 * GO点击事件
 * */
function goClick(){
	var goPage = document.getElementById("pageNumber").value;
	document.getElementById("currentPage").setAttribute("value", goPage);
	document.getElementById("mainForm").submit();
}
/**
 * 全选复选框
 * @param checkbox
 */
function check(checkbox){
	if(checkbox.checked){
		var boxs = document.getElementsByName("paperIds");
		for(var i=0;i<boxs.length;i++){
			boxs[i].checked=true;
		}
	}else{
		var boxs = document.getElementsByName("paperIds");
		for(var i=0;i<boxs.length;i++){
			boxs[i].checked=false;
		}
	}
}
/**
 * 批量删除
 */
function delBatch(){
	var form = document.getElementById("mainForm");
	var basePath = document.getElementById("basePath").value;
	form.setAttribute("action", basePath+"delPaperAction_Batch");
	form.submit();
}
/**
 * 通过ID,删除一个paper
 * @param id
 */
function delOne(id){
	var basePath = document.getElementById("basePath").value;
	var form = document.getElementById("mainForm");
	var inputElem = document.createElement("input");
	inputElem.setAttribute("type", "hidden");
	inputElem.setAttribute("name","paperId");
	inputElem.setAttribute("value", id);
	//插入input节点到form节点内
	var arr = form.childNodes;
	for(var i=0;i<arr.length;i++){
		if(arr[i].nodeType==1){
			form.insertBefore(inputElem,arr[i]);
			break;
		}
	}
	form.setAttribute("action", basePath+"delPaperAction_One");
	form.submit();
}