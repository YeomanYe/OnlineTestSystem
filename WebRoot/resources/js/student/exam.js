//添加函数到窗口载入事件；
function addLoadEvent(func){
	var oldonload = window.onload;
	if(typeof oldonload != 'function'){
		window.onload = func;
	}else{
		window.onload = function(){
			oldonload();
			func();
		};
	}
}
//提交表单
function submitForm(){
	document.getElementById("mainform").submit();
}

function setLeftTime(finTime){
	//获得当前时间
	var nowTime = new Date().getTime();
	//计算剩余时间
	leftTime = (finTime - nowTime)/1000;
	//时间到
	if(leftTime<=0){
		var leftelem = document.getElementById("leftTime");
		document.getElementById("leftTime").innerHTML = "时间到!";
		clearInterval(leftelem.sl);
		setTimeout(submitForm,1000);
		return ;
	}
	//计算剩余分,秒
	var m = parseInt(leftTime/60%60);
	var s = parseInt(leftTime%60);
	document.getElementById("leftTime").innerHTML = m+"分"+s+"秒";
}
window.onload = function(){
	//获得最终时间
	var finTime = new Date().getTime() + 20*60*1000;
	setLeftTime(finTime);
	var leftelem = document.getElementById("leftTime");
	leftelem.sl = setInterval("setLeftTime("+finTime+")",500);
}
