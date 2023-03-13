/**
 * 
 */
import {ajaxRequest} from './request.js';
function guestService(method,url,params){
	let returnJsonResult={};
	
	//ajax요청
	new Promise();
	ajaxRequest(method,url,params,function(jsonResult){
		returnJsonResult = jsonResult;
	},false);
		
	return returnJsonResult;
}
export{guestService}