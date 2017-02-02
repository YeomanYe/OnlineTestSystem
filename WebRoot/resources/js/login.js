var flag = 0;
/**
 * ����ע���õ�div
 */
function createRegDiv(basePath){
	var regDiv = document.createElement("div");
	regDiv.setAttribute("id", "dialog");
	//����ע���õı�
	temp = '<form id="regForm" action="'+basePath+'registerAction_submit" method="post">';
	temp += '<label for="regUser">�û���</label><span id="spUser"></span><br/>';
	temp += '<input name="regUser" id="regUser" type="text"/><br/>';
	temp += '<label for="regPass">����</label><span id="spPass"></span><br/>';
	temp += '<input name="regPass" id="regPass" type="password"/><br/>';
	temp += '<label for="againPass">ȷ������</label><span id="spAgainPass"></span><br/>';
	temp += '<input name="againPass" id="againPass" type="password"/><br/>';
	temp += '<label for="captcha">��֤��</label><span id="spCaptcha"></span><br/>';
	temp += '<input id="captcha" name="captcha" type="text"/> ';
	temp += '<a ><img id="capImg" src="'+basePath+'captchaAction" alt="��֤��"/></a>&nbsp;&nbsp;';
	temp += '<select name="sclass" id="sclass">';
	temp += '<option>1��</option><option>2��</option>';
	temp += '</select>';
	temp += '</form>';
	
	regDiv.innerHTML = temp;
	document.body.appendChild(regDiv);
	//�������б�Ԫ����ʽ,�¼�
	var form = document.getElementById("regForm");
	var inputs = form.getElementsByTagName("input");
	
	
	checkForm.basePath = basePath;
	for(var i=0;i<inputs.length;i++){
		inputs[i].style.width = "210px";
		//����Ƴ���ʱ�жϱ���Ϣ
		inputs[i].onblur = checkForm;
	}
	//������֤��ͼƬ��ʽ
	var capImg = document.getElementById("capImg");
	capImg.setAttribute("style","cursor:pointer;margin-bottom:-8px;height:28px;");
	//��ԭʼ������Ϊ���Ա���
	capImg.orgSrc = capImg.getAttribute("src");
	capImg.onclick = changeCaptcha;
	//������֤����д����ʽ
	var capInp = document.getElementById("captcha");
	capInp.style.width = "80px";
}
/**
 * ��֤��ı�
 */
function changeCaptcha(){
	var path = this.orgSrc,newImg = this.cloneNode(true);
	path +="?random="+Math.random();
	newImg.setAttribute("src",path);
	newImg.orgSrc = this.orgSrc;
	this.parentNode.insertBefore(newImg,this);
	//ɾ��this�ڵ�
	this.parentNode.removeChild(this);
	newImg.onclick = changeCaptcha;
}
/**
 * ����
 */
function checkForm(){
			var form = document.getElementById("regForm");
			var spans = form.getElementsByTagName("span");
			for(var i=0;i<spans.length;i++){
				spans[i].innerHTML = "";
				spans[i].style.color = "red";
				spans[i].style.fontSize = "15px";
			}
			
			var xhr = new XMLHttpRequest();
			var spUser = document.getElementById("spUser");
			var spPass = document.getElementById("spPass");
			var spCaptcha = document.getElementById("spCaptcha");
			var spAgainPass = document.getElementById("spAgainPass");
			xhr.onload = function(){
				if((xhr.status>=200 && xhr.status<300) || xhr.status == 304){
					//�涨����0Ϊ�ɹ�����
					switch(xhr.responseText){
						case '-1':spUser.innerHTML="(�û�������Ϊ��)";break;
						case '-2':spUser.innerHTML="(�û����Ѵ���)";break;
						case '-3':spPass.innerHTML="(���벻��Ϊ��)";break;
						case '-4':spCaptcha.innerHTML="(��֤�����)";break;
						case '-5':spAgainPass.innerHTML="(������������벻һ��)";break;
					}
				}
			};
			xhr.open("post",checkForm.basePath+"registerAction_check");
			xhr.send(new FormData(form));
		}
/**
 * �û�ע��Ի���
 * @param basePath
 */
function registerDialog(basePath){
	createRegDiv(basePath);
	
	$("#dialog").dialog({
		title:"�û�ע��",
		autoOpen:false,
		close:function(){
			if(flag==1){
				register();
				flag=0;
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
        width: 250,
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
 * ͨ��ajax����ע��
 */
function register(){
	var form = document.getElementById("regForm");
	path = form.action;
	ajaxOption(form,path);
}