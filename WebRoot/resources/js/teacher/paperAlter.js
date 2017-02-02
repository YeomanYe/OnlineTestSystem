/**
 * ����Ի���div����
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
	temp += "<div align='center'>("+score+"��)"+title+"</div>";
	temp += "<b>A.</b> "+optionA+"</br>";
	temp += "<b>B.</b> "+optionB+"</br>";
	temp += "<b>C.</b> "+optionC+"</br>";
	temp += "<b>D.</b> "+optionD+"</br>";
	temp += "��:<i>"+answer+"</i></br>";
	temp += "����:"+parse+"";
	dialog.innerHTML = temp;
	document.body.appendChild(dialog);
}
/**
 * �����ͼ�Ի���
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
        title:"����鿴",
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
 * �����Ծ�Ի���
 */
function resetPaperDialog(){
	var dialog = document.createElement("div");
	dialog.setAttribute("id","dialog");
	dialog.innerHTML = "ȷ��������?";
	document.body.appendChild(dialog);
	$("#dialog").dialog({
		title:"ȷ�϶Ի���",
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
            "��": function() {
                $( this ).dialog( "close" );
                resetPaper();
            },
        	"��":function(){
        		$(this).dialog("close");
        	}
        },
        closeOnEscape:true
	});
	$("#dialog").dialog("open");
}
/**
 * �����ҳ
 * */
function pageClick(currentPage){
	var basePath = document.getElementById("basePath").value ;
	document.getElementById("currentPage").setAttribute("value", currentPage);
	var form = document.getElementById("mainForm");
	form.setAttribute("action", basePath+"query_savePaperAction_Subject");
}

/**
 * GO����¼�
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
 * ȫѡ��ѡ��
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
 * �����������
 */
function addBatchSubjects(){
	var form = document.getElementById("mainForm");
	var bastPath = document.getElementById("basePath").value;
	form.action = bastPath +"add_savePaperAction_BatchSubjects";
	form.submit();
}
/**
 * �������
 */
function addSubject(id){
	var form = document.getElementById("mainForm");
	//����input��Ԫ�����ڴ���subjectId
	var inputElem = document.createElement("input");
	inputElem.setAttribute("type", "hidden");
	inputElem.setAttribute("name", "subjectId");
	inputElem.setAttribute("value", id);
	//����input�ڵ㵽form�ڵ���
	var arr = form.childNodes;
	for(var i=0;i<arr.length;i++){
		if(arr[i].nodeType==1){
			form.insertBefore(inputElem,arr[i]);
			break;
		}
	}
	var basePath = document.getElementById("basePath").value;
	//���ñ����ԣ����ͱ�
	form.action = basePath+"add_savePaperAction_Subject";
	form.submit();
}
/**
 * ����Ծ�
 */
function checkPaper(){
	var form = document.getElementById("mainForm");
	var basePath = document.getElementById("basePath").value;
	form.action = basePath+"check_savePaperAction_Paper";
	form.submit();
}
/**
 * �����ѯ
 */
function querySubject(){
	var form = document.getElementById("mainForm");
	var basePath = document.getElementById("basePath").value;
	form.setAttribute("action", basePath+"query_savePaperAction_Subject");
	form.submit();
}
/**
 * �Ծ�����
 */
function resetPaper(){
	var form = document.getElementById("mainForm");
	var basePath = document.getElementById("basePath").value;
	form.setAttribute("action", basePath+"reset_savePaperAction_Paper");
	form.submit();
}
/**
 * �Ծ��ύ
 */
function submitPaper(){
	var form = document.getElementById("mainForm");
	var path = form.getAttribute("action");
	ajaxOption(form,path);
}