/// byte 체크와 길이 넘어가면 자동으로 지우는거
function getTextLength(str) {
	var len = 0;
	for (var i = 0; i < str.length; i++) {
	if (escape(str.charAt(i)).length == 6) {
	len++;
	}
	len++;
	}
	return len;
}
			 	
function cut_300(obj){
	var text = $(obj).val();
	var leng = text.length;
	 while(getTextLength(text) > 300){
	leng--;
	text = text.substring(0, leng);
	}
	 $(obj).val(text);
	$('.bytes').text(getTextLength(text));
}