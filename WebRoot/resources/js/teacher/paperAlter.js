/**
 * 试题对话框div设置
 * @param score
 * @param title
 * @param optionA
 * @param optionB
 * @param optionC
 * @param optionD
 * @param answer
 * @param parse
 */
function viewFormatSubject(score,title,optionA,optionB,optionC,optionD,answer,parse){
	var dialog = document.createElement("div");
	dialog.setAttribute("id","dialog");
	var temp = "";
	temp += "<div align='center'>("+score+"分)"+title+"</div>";
	temp += "<b>A.</b> "+optionA+"</br>";
	temp += "<b>B.</b> "+optionB+"</br>";
	temp += "<b>C.</b> "+optionC+"</br>";
	temp += "<b>D.</b> "+optionD+"</br>";
	temp += "答案:<i>"+answer+"</i></br>";
	temp += "解析:"+parse+"";
	dialog.innerHTML = temp;
	document.body.appendChild(dialog);
}
/**
 * 浏览视图对话框
 * @param score
 * @param title
 * @param optionA
 * @param optionB
 * @param optionC
 * @param optionD
 * @param answer
 * @param parse
 */
function viewSubjectDialog(score,title,optionA,optionB,optionC,optionD,answer,parse){
	viewFormatSubject(score,title,optionA,optionB,optionC,optionD,answer,parse);
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
        title:"试题查看",
	    resizable: false,
        height: "auto",
        width: 500,
        modal: true,
        close:function(){
        	var dialog = document.getElementById("dialog");
        	dialog.parentNode.removeChild(dialog);
        },
        buttons: {
            "OK": function() {
                $( this ).dialog( "close" );
            }
        },
        closeOnEscape:true
	});
	$("#dialog").dialog("open");
}
/**
 * 重置试卷对话框
 */
function resetPaperDialog(){
	var dialog = document.createElement("div");
	dialog.setAttribute("id","dialog");
	dialog.innerHTML = "确定重置吗?";
	document.body.appendChild(dialog);
	$("#dialog").dialog({
		title:"确认对话框",
		autoOpen:false,
		close:function(){
        	var dialog = document.getElementById("dialog");
        	dialog.parentNode.removeChild(dialog);
        },
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
                resetPaper();
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
	var basePath = document.getElementById("basePath").value ;
	document.getElementById("currentPage").setAttribute("value", currentPage);
	var form = document.getElementById("mainForm");
	form.setAttribute("action", basePath+"query_savePaperAction_Subject");
}

/**
 * GO点击事件
 * */
function goClick(){
	var basePath = document.getElementById("basePath").value ;
	var goPage = document.getElementById("pageNumber").value;
	document.getElementById("currentPage").setAttribute("value", goPage);
	var form = document.getElementById("mainForm");
	form.setAttribute("action", basePath+"query_savePaperAction_Subject");
	form.submit();
}
/**
 * 全选复选框
 * @param checkbox
 */
function check(checkbox){
	if(checkbox.checked){
		var boxs = document.getElementsByName("subjectIds");
		for(var i=0;i<boxs.length;i++){
			boxs[i].checked=true;
		}
	}else{
		var boxs = document.getElementsByName("subjectIds");
		for(var i=0;i<boxs.length;i++){
			boxs[i].checked=false;
		}
	}
}
/**
 * 批量添加试题
 */
function addBatchSubjects(){
	var form = document.getElementById("mainForm");
	var bastPath = document.getElementById("basePath").value;
	form.action = bastPath +"add_savePaperAction_BatchSubjects";
	form.submit();
}
/**
 * 添加试题
 */
function addSubject(id){
	var form = document.getElementById("mainForm");
	//设置input的元素用于传输subjectId
	var inputElem = document.createElement("input");
	inputElem.setAttribute("type", "hidden");
	inputElem.setAttribute("name", "subjectId");
	inputElem.setAttribute("value", id);
	//插入input节点到form节点内
	var arr = form.childNodes;
	for(var i=0;i<arr.length;i++){
		if(arr[i].nodeType==1){
			form.insertBefore(inputElem,arr[i]);
			break;
		}
	}
	var basePath = document.getElementById("basePath").value;
	//设置表单属性，发送表单
	form.action = basePath+"add_savePaperAction_Subject";
	form.submit();
}
/**
 * 检查试卷
 */
function checkPaper(){
	var form = document.getElementById("mainForm");
	var basePath = document.getElementById("basePath").value;
	form.action = basePath+"check_savePaperAction_Paper";
	form.submit();
}
/**
 * 试题查询
 */
function querySubject(){
	var form = document.getElementById("mainForm");
	var basePath = document.getElementById("basePath").value;
	form.setAttribute("action", basePath+"query_savePaperAction_Subject");
	form.submit();
}
/**
 * 试卷重置
 */
function resetPaper(){
	var form = document.getElementById("mainForm");
	var basePath = document.getElementById("basePath").value;
	form.setAttribute("action", basePath+"reset_savePaperAction_Paper");
	form.submit();
}
/**
 * 试卷提交
 */
function submitPaper(){
	var form = document.getElementById("mainForm");
	var path = form.getAttribute("action");
	ajaxOption(form,path);
}