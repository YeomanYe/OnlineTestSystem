var temp,currentPage;
var flag = 0;//������ǰ�ť
var dialogFlag;//�Ի���־λ ��0ɾ��һ����1����ɾ��
/**
 * ɾ��һ�������dialog
 * 
 * @param tagA
 */
function subjectDialog(tagA,flag,page){
	var dialog = document.createElement("div");
	dialog.setAttribute("id","dialog");
	dialog.innerHTML = "ȷ��ɾ����?";
	document.body.appendChild(dialog);
	
	currentPage = page;
	temp = tagA;
	dialogFlag = flag;
	$("#dialog").dialog({
		title:"ȷ�ϻỰ��",
		autoOpen:false,
		close:function(){
        	var dialog = document.getElementById("dialog");
        	dialog.parentNode.removeChild(dialog);
        	//�жϰ���������ɾ������ɾ��;
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
            "��": function() {
                $( this ).dialog( "close" );
                flag = 1;
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
	document.getElementById("currentPage").setAttribute("value", currentPage);
	document.getElementById("mainForm").submit();
}

/**
 * GO����¼�
 * */
function goClick(){
	var goPage = document.getElementById("pageNumber").getAttribute("value");
	document.getElementById("currentPage").setAttribute("value", goPage);
	document.getElementById("mainForm").submit();
}
/**
 * ɾ��һ������
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
 * ����ɾ��
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