/**
 * ajax�ύ��
 * @param formElem
 * @param path
 * @param closeFunc�رջỰʱִ�еĺ���
 */
function ajaxOption(formElem,path,closeFunc){
	var xhr = new XMLHttpRequest();
	xhr.onload = function(){
		if((xhr.status>=200 && xhr.status<300) || xhr.status == 304){
			//�涨����0Ϊ�ɹ�����
			if(xhr.responseText==0){
				optionDialog("success.jpg",closeFunc);
			}else optionDialog("failure.jpg",closeFunc);
		}else{
			optionDialog("failure.jpg");
		}
	};
	xhr.open("post",path);
	xhr.send(new FormData(formElem));
}
	
/**
 * 
 *�����ɹ��Ự
 */
function optionDialog(imageName,closeFunc){
	var dialogElem = document.createElement("div");
	dialogElem.setAttribute("id", "dialog");
	var imgElem = document.createElement("img");
	imgElem.setAttribute("src", "http://localhost:8080/OnlineTestSystem/resources/images/"+imageName);
	dialogElem.appendChild(imgElem);
	document.body.appendChild(dialogElem);
	$("#dialog").dialog({
		autoOpen:false,
        show: {
            effect: "fadeIn"
        },
        hide: {
            effect: "fadeOut"
        },
	    resizable: false,
        height: "auto",
        width: 280,
        modal: true,
        close:function(){
        	var dialog = document.getElementById("dialog")
        	dialog.parentNode.removeChild(dialog);
        	if(typeof closeFunc == 'function'){
        		closeFunc();
        	}
        },
        buttons: {
            "ȷ��": function() {
                $( this ).dialog( "close" );
            }
        },
        closeOnEscape:true
	});
	$("#dialog").dialog("open");
}