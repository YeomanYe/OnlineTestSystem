var temp,currentPage;
var flag = 0;//点击了是按钮
var dialogFlag;//对话标志位 ：0删除一个，1批量删除
/**
 * 删除一个试题的dialog
 * 
 * @param tagA
 */
function subjectDialog(tagA,flag,page){
	var dialog = document.createElement("div");
	dialog.setAttribute("id","dialog");
	dialog.innerHTML = "确定删除吗?";
	document.body.appendChild(dialog);
	
	currentPage = page;
	temp = tagA;
	dialogFlag = flag;
	$("#dialog").dialog({
		title:"确认会话框",
		autoOpen:false,
		close:function(){
        	var dialog = document.getElementById("dialog");
        	dialog.parentNode.removeChild(dialog);
        	//判断按下了批量删除还是删除;
        	if(dialogFlag==0 && flag==1){
            	delOne(temp,page);
            }else if(dialogFlag==1 && flag==1){
            	delBat(temp);
            }
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
                flag = 1;
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
	var goPage = document.getElementById("pageNumber").getAttribute("value");
	document.getElementById("currentPage").setAttribute("value", goPage);
	document.getElementById("mainForm").submit();
}
/**
 * 删除一个函数
 * @param tagA
 */
function delOne(tagA,currentPage){
	document.getElementById("currentPage").setAttribute("value", currentPage);
	var basePath = document.getElementById("basePath").value;
	var mainform = document.getElementById("mainForm");
	document.getElementById("subjectId").value = tagA;
	ajaxOption(mainform,basePath+"delSubjectAction_One",function(){
		document.getElementById("mainForm").submit();
	});
	/*mainform.setAttribute("action", basePath+"delSubjectAction_One");
	mainform.submit();
	return false;*/
}
/**
 * 批量删除
 */
function delBat(currentPage){
	document.getElementById("currentPage").setAttribute("value", currentPage);
	var mainform = document.getElementById("mainForm");
	var basePath = document.getElementById("basePath").getAttribute("value");
	ajaxOption(mainform,basePath+"delSubjectAction_Batch",function(){
		document.getElementById("mainForm").submit();
	});
	/*mainform.setAttribute("action",basePath+"delSubjectAction_Batch");
	mainform.submit();*/
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