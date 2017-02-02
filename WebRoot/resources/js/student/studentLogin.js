window.onload = function(){
	var leftBar = document.getElementById("leftBar"),
		menuAs = leftBar.getElementsByTagName("a");
	//给菜单超链接设置事件
	for(var i=0;i<menuAs.length;i++){
		menuAs[i].onclick = menuClickEvent;	
	}
};

function menuClickEvent(){
	//将其他超链接样式清空
	var leftBar = document.getElementById("leftBar");
	var menuAs = leftBar.getElementsByTagName("a");
	for(var i=0;i<menuAs.length;i++){
		menuAs[i].className = "";
	}
	//给当前超链接设置样式
	this.className = "current";
	//删除rightBar下的所有div子节点
	var rightBar = document.getElementById("rightBar"),
		divs = rightBar.getElementsByTagName("div");
	for(var i=0;i<divs.length;i++){
		divs[i].parentNode.removeChild(divs[i]);
	}
	//获得地址
	var id = this.id,
		basePath = document.getElementById("basePath").value;
	switch(id){
	case "baseInfoLi":basePath+="query_studentOperateAction_BaseInfo";break;
	case "onlineTestLi":basePath+="query_studentOperateAction_Paper";break;
	case "queryScoreLi":basePath+="query_studentOperateAction_Score";break;
	}
	//发送ajax
	var xhr = new XMLHttpRequest();
	xhr.onload = function(){
		if((xhr.status>=200 && xhr.status<300) || xhr.status == 304){
			document.getElementById("rightBar").innerHTML = xhr.responseText;
		}
	};
	xhr.open("get",basePath);
	xhr.send();
}
/**
 * 更新学生信息
 */
function updateStuInfo(){
	var form = document.getElementById("stuInfoForm"),
		url = form.getAttribute("action");
	ajaxOption(form,url);
}
