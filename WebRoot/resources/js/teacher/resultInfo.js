var flag = 0;//判断是否按下确定
/**
 * 构建updateResult会话使用的div
 * @param resultId
 * @returns
 */
function createResultDiv(basePath){
	var resultDiv = document.createElement("div");
	var studentID = document.getElementById("studentID").value;
	var temp = '<form id="mainForm" action="'+basePath+'update_resultAction" method="post">';
	temp += '<input type="hidden" name="studentID" value="'+studentID+'"/>';
	temp += '<input type="hidden" name="resultID" id="resultID"/>';
	temp += '<label for="resultScore">输入成绩</label><br/>';
	temp += '<input id="resultScore" type="text" name="resultScore"/><br/>';
	temp += '<label for="stuPass">学生密码</label><br/>';
	temp += '<input type="password" id="stuPass" name="stuPass"/><br/>';
	temp += '</form>';
	resultDiv.innerHTML = temp;
	resultDiv.setAttribute("id","dialog");
	document.body.appendChild(resultDiv);
}
/**
 * 用于更新成绩的对话框
 * @param resultId
 */
function updateResultDialog(resultId,basePath){
	createResultDiv(basePath);
	document.getElementById("resultID").setAttribute("value", resultId);
	
	$("#dialog").dialog({
		title:"学生成绩修改",
		autoOpen:false,
		close:function(){
			if(flag==1){
        		updateResult();
        	}
        	var dialog = document.getElementById("dialog");
        	dialog.parentNode.removeChild(dialog);
        },
        show: {
            effect: "fadeIn",
            duration: 500
        },
        hide: {
            effect: "fadeOut",
            duration:500
        },
	    resizable: false,
        height: "auto",
        width: 300,
        modal: true,
        buttons: {
            "确定": function() {
                $( this ).dialog( "close" );
                flag = 1;
            },
        	"取消":function(){
        		$(this).dialog("close");
        	}
        },
        closeOnEscape:true
	});
	$("#dialog").dialog("open");
}
/**
 * 更新成绩
 */
function updateResult(){
	var form = document.getElementById("mainForm");
	basePath = form.getAttribute("action");
	ajaxOption(form,basePath,function(){
		document.getElementById("form2").submit();
	});
}