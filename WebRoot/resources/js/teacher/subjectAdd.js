var temp;

function resetSubjectDialog(basePath){
	//构造dialog元素
	var dialogElem = document.createElement("div");
	dialogElem.setAttribute("title","确认会话框");
	dialogElem.setAttribute("id", "dialog");
	dialogElem.innerHTML = "<p>确定重置吗?</p>";
	document.body.appendChild(dialogElem);
	
	temp = basePath;
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
        close:function(){
        	var dialog = document.getElementById("dialog");
        	dialog.parentNode.removeChild(dialog);
        },
        buttons: {
            "是": function() {
                $( this ).dialog( "close" );
                resetSubject(temp);
            },
        	"否":function(){
        		$(this).dialog("close");
        	}
        },
        closeOnEscape:true
	});
	$("#dialog").dialog("open");
	return false;
}
/**
 * 通过ajax保存试题
 */
function saveSubjectByAjax(){
	var form = document.getElementById("mainForm");
	var path = form.getAttribute("action");
	ajaxOption(form,path);
}
/**
 * 重置试题
 */
function resetSubject(basePath){
	var form = document.getElementById("mainForm");
	form.setAttribute("action", basePath+"reset_saveSubjectAction");
	form.submit();
}