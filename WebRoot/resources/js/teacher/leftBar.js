window.onload = function(){
	var as = document.getElementsByTagName("a");
	for(var i=0;i<as.length;i++){
		as[i].onclick = changeAStyle;
	}
}
/**
*�ı䵱ǰ��������ʽ
*/
function changeAStyle(){
	var as = document.getElementsByTagName("a");
	for(var i=0;i<as.length;i++){
		as[i].removeAttribute("class");
	}
	this.setAttribute("class","cur");
}
/**
 * dt�������
 * @param dt
 */
function dtClick(dt){
	var dl = dt.parentNode;
	var dds = dl.childNodes;
	var allDD = document.getElementsByTagName("dd");
	for(var i=0;i<allDD.length;i++){
		if(allDD[i].tagName == "DD"){
			allDD[i].style.display = "none";
			}
		}
	for(var i=0;i<dds.length;i++){
		if(dds[i].tagName != null && dds[i].tagName == "DD"){
			dds[i].style.display = "block";
		}
	}
}