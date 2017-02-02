var flag = 0;
/**
 * 创建注册用的div
 */
function createRegDiv(basePath){
	var regDiv = document.createElement("div");
	regDiv.setAttribute("id", "dialog");
	//构建注册用的表单
	temp = '<form id="regForm" action="'+basePath+'registerAction_submit" method="post">';
	temp += '<label for="regUser">用户名</label><span id="spUser"></span><br/>';
	temp += '<input name="regUser" id="regUser" type="text"/><br/>';
	temp += '<label for="regPass">密码</label><span id="spPass"></span><br/>';
	temp += '<input name="regPass" id="regPass" type="password"/><br/>';
	temp += '<label for="againPass">确认密码</label><span id="spAgainPass"></span><br/>';
	temp += '<input name="againPass" id="againPass" type="password"/><br/>';
	temp += '<label for="captcha">验证码</label><span id="spCaptcha"></span><br/>';
	temp += '<input id="captcha" name="captcha" type="text"/> ';
	temp += '<a ><img id="capImg" src="'+basePath+'captchaAction" alt="验证码"/></a>&nbsp;&nbsp;';
	temp += '<select name="sclass" id="sclass">';
	temp += '<option>1班</option><option>2班</option>';
	temp += '</select>';
	temp += '</form>';
	
	regDiv.innerHTML = temp;
	document.body.appendChild(regDiv);
	//设置所有表单元素样式,事件
	var form = document.getElementById("regForm");
	var inputs = form.getElementsByTagName("input");
	
	
	checkForm.basePath = basePath;
	for(var i=0;i<inputs.length;i++){
		inputs[i].style.width = "210px";
		//鼠标移出表单时判断表单信息
		inputs[i].onblur = checkForm;
	}
	//设置验证码图片样式
	var capImg = document.getElementById("capImg");
	capImg.setAttribute("style","cursor:pointer;margin-bottom:-8px;height:28px;");
	//将原始连接作为属性保存
	capImg.orgSrc = capImg.getAttribute("src");
	capImg.onclick = changeCaptcha;
	//设置验证码填写表单样式
	var capInp = document.getElementById("captcha");
	capInp.style.width = "80px";
}
/**
 * 验证码改变
 */
function changeCaptcha(){
	var path = this.orgSrc,newImg = this.cloneNode(true);
	path +="?random="+Math.random();
	newImg.setAttribute("src",path);
	newImg.orgSrc = this.orgSrc;
	this.parentNode.insertBefore(newImg,this);
	//删除this节点
	this.parentNode.removeChild(this);
	newImg.onclick = changeCaptcha;
}
/**
 * 检查表单
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
					//规定返回0为成功操作
					switch(xhr.responseText){
						case '-1':spUser.innerHTML="(用户名不能为空)";break;
						case '-2':spUser.innerHTML="(用户名已存在)";break;
						case '-3':spPass.innerHTML="(密码不能为空)";break;
						case '-4':spCaptcha.innerHTML="(验证码错误)";break;
						case '-5':spAgainPass.innerHTML="(两次输入的密码不一致)";break;
					}
				}
			};
			xhr.open("post",checkForm.basePath+"registerAction_check");
			xhr.send(new FormData(form));
		}
/**
 * 用户注册对话框
 * @param basePath
 */
function registerDialog(basePath){
	createRegDiv(basePath);
	
	$("#dialog").dialog({
		title:"用户注册",
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
 * 通过ajax进行注册
 */
function register(){
	var form = document.getElementById("regForm");
	path = form.action;
	ajaxOption(form,path);
}