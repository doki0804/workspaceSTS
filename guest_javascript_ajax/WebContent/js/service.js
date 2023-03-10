/**
 * 
 */
import {ajaxRequest} from './request.js';
function guestService(method,url,params){
	let returnJsonResult={};
	
	//ajax요청
	ajaxRequest(method,url,params,function(jsonResult){
		returnJsonResult = jsonResult;
	},false);
		
	return returnJsonResult;
}
export{guestService}