/**
 * 
 */
export function ajaxRequest(url,method,sendData,contentType,callbackFunction,async){
	$.ajax({
		url:url,
		method:method,
		data:sendData,
		contentType:contentType,
		success:function(jsonResult){
			callbackFunction(jsonResult);
		},
		async:async
	});
}