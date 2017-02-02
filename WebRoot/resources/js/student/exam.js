//��Ӻ��������������¼���
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
//�ύ��
function submitForm(){
	document.getElementById("mainform").submit();
}

function setLeftTime(finTime){
	//��õ�ǰʱ��
	var nowTime = new Date().getTime();
	//����ʣ��ʱ��
	leftTime = (finTime - nowTime)/1000;
	//ʱ�䵽
	if(leftTime<=0){
		var leftelem = document.getElementById("leftTime");
		document.getElementById("leftTime").innerHTML = "ʱ�䵽!";
		clearInterval(leftelem.sl);
		setTimeout(submitForm,1000);
		return ;
	}
	//����ʣ���,��
	var m = parseInt(leftTime/60%60);
	var s = parseInt(leftTime%60);
	document.getElementById("leftTime").innerHTML = m+"��"+s+"��";
}
window.onload = function(){
	//�������ʱ��
	var finTime = new Date().getTime() + 20*60*1000;
	setLeftTime(finTime);
	var leftelem = document.getElementById("leftTime");
	leftelem.sl = setInterval("setLeftTime("+finTime+")",500);
}
