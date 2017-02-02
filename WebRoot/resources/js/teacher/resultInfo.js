var flag = 0;//�ж��Ƿ���ȷ��
/**
 * ����updateResult�Ựʹ�õ�div
 * @param resultId
 * @returns
 */
function createResultDiv(basePath){
	var resultDiv = document.createElement("div");
	var studentID = document.getElementById("studentID").value;
	var temp = '<form id="mainForm" action="'+basePath+'update_resultAction" method="post">';
	temp += '<input type="hidden" name="studentID" value="'+studentID+'"/>';
	temp += '<input type="hidden" name="resultID" id="resultID"/>';
	temp += '<label for="resultScore">����ɼ�</label><br/>';
	temp += '<input id="resultScore" type="text" name="resultScore"/><br/>';
	temp += '<label for="stuPass">ѧ������</label><br/>';
	temp += '<input type="password" id="stuPass" name="stuPass"/><br/>';
	temp += '</form>';
	resultDiv.innerHTML = temp;
	resultDiv.setAttribute("id","dialog");
	document.body.appendChild(resultDiv);
}
/**
 * ���ڸ��³ɼ��ĶԻ���
 * @param resultId
 */
function updateResultDialog(resultId,basePath){
	createResultDiv(basePath);
	document.getElementById("resultID").setAttribute("value", resultId);
	
	$("#dialog").dialog({
		title:"ѧ���ɼ��޸�",
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
            "ȷ��": function() {
                $( this ).dialog( "close" );
                flag = 1;
            },
        	"ȡ��":function(){
        		$(this).dialog("close");
        	}
        },
        closeOnEscape:true
	});
	$("#dialog").dialog("open");
}
/**
 * ���³ɼ�
 */
function updateResult(){
	var form = document.getElementById("mainForm");
	basePath = form.getAttribute("action");
	ajaxOption(form,basePath,function(){
		document.getElementById("form2").submit();
	});
}