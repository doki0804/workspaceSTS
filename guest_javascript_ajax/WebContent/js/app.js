/**
 *
 */
//import * as View from "./view.js";
//import {render as Render} from "./view.js";
import {render} from "./view.js";
import * as Service from "./service.js";
import * as URL from "./request-url.js";

 /*
 메뉴객체이벤트등록
 */
const menuGuestHome = document.querySelector('#menu_guest_home');
const menuGuestList = document.querySelector('#menu_guest_list');
const menuGuestWriteForm = document.querySelector('#menu_guest_write_form');
 
menuGuestHome.addEventListener('click',function(e){
	render("#guest-main-template");
	e.preventDefault();
	
});
menuGuestList.addEventListener('click',function(e){
	let jsonResult = Service.guestService('GET',URL.GUEST_LIST_URL,'');
	render('#guest-list-template',jsonResult);
	
	e.preventDefault();
});
menuGuestWriteForm.addEventListener('click',function(e){
	render('#guest-write-form-template');
	e.preventDefault();
});
 
menuGuestHome.click();

document.addEventListener('click',function(e){
	console.log(e.target.id);
	/******************guest_detail*******************/
	if(e.target.classList.contains('guest_item_a')){
		let params ='guest_no='+e.target.getAttribute('guest_no');
		let jsonResult = Service.guestService('GET',URL.GUEST_DETAIL_URL,params);
		render('#guest-detail-template',jsonResult);
		e.preventDefault();
	}
	/******************guest_delete_action*******************/
	if(e.target.id=='btn_guest_remove_action'){
		let params ='guest_no='+e.target.getAttribute('guest_no');
		let jsonResult = Service.guestService('POST',URL.GUEST_REMOVE_ACTION_URL,params);
		if(jsonResult.code==1){
			menuGuestList.click();
		}else{
			alert(jsonResult.msg);
		}
		e.preventDefault();
	}
	/******************guest_write_action*******************/
	if(e.target.id=='btn_guest_write_action'){
		console.log(document.getElementById('guest_write_form'));
		let params = ['guest_name='+document.getElementById('guest_write_form')];
		console.log(params);
		/*let jsonResult = Service.guestService('POST',URL.GUEST_WRITE_ACTION_URL,params);
		if(jsonResult.code==1){
			menuGuestList.click();
		}else{
			alert(jsonResult.msg);
		}*/
		e.preventDefault(); 
	}
});