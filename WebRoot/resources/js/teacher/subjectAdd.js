var temp;

function resetSubjectDialog(basePath){
	//����dialogԪ��
	var dialogElem = document.createElement("div");
	dialogElem.setAttribute("title","ȷ�ϻỰ��");
	dialogElem.setAttribute("id", "dialog");
	dialogElem.innerHTML = "<p>ȷ��������?</p>";
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
            "��": function() {
                $( this ).dialog( "close" );
                resetSubject(temp);
            },
        	"��":function(){
        		$(this).dialog("close");
        	}
        },
        closeOnEscape:true
	});
	$("#dialog").dialog("open");
	return false;
}
/**
 * ͨ��ajax��������
 */
function saveSubjectByAjax(){
	var form = document.getElementById("mainForm");
	var path = form.getAttribute("action");
	ajaxOption(form,path);
}
/**
 * ��������
 */
function resetSubject(basePath){
	var form = document.getElementById("mainForm");
	form.setAttribute("action", basePath+"reset_saveSubjectAction");
	form.submit();
}