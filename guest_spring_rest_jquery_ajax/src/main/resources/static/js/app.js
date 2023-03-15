import * as View from "./view.js";
import * as Request from "./request.js";

/*
메뉴객체이벤트등록
	#menu_guest_home
	#menu_guest_list
	#btn_guest_list
	#menu_guest_write_form
	#btn_guest_write_action
	#btn_guest_modify_form
	#btn_guest_modify_action
	#btn_guest_remove_action
	#btn_guest_write_form
	.guest_item_a
	
	
	
	
	
*/ 

/*******guest_home*******/
$('#menu_guest_home').click(function(e){
	View.render("#guest-main-template");
	e.preventDefault();
	
});

/*******guest_list*******/
$(document).on('click','#menu_guest_list,#btn_guest_list',function(e){
	let url='guest';
	let sendData={};
	let method = 'GET';
	let async = true;
	let contentType = "aplication/json";
	Request.ajaxRequest(url,method,sendData,contentType,function(jsonResult){
		View.render("#guest-list-template",jsonResult);
	},async);
	e.preventDefault();
	
});

/*******guest_write_form*******/
$(document).on('click','#menu_guest_write_form,#btn_guest_write_form',function(e){
	View.render('#guest-write-form-template',{})
	e.preventDefault();
	
});

/*******guest_write_action*******/
$(document).on('click','#btn_guest_write_action',function(e){
	let sendData = $('#guest_write-form').serializeArray();
	Request.ajaxRequest('guest','POST',sendData,'appliction/json;charset=UTF-8',function(){
		View.render("#guest-list-template",jsonResult);
	},true);
	e.preventDefault();
});

/*******guest_modify_form*******/
$(document).on('click','#btn_guest_modify_form',function(e){
	View.render('#guest-modify-form-template',{})
	e.preventDefault();
});

/*******guest_modify_action*******/
$(document).on('click','#btn_guest_modify_action',function(e){
	e.preventDefault();
});

/*******guest_remove_action*******/
$(document).on('click','#btn_guest_remove_action',function(e){
	e.preventDefault();
});

/*******guest_detail*******/
$(document).on('click','.guest_item_a',function(e){
	View.render('#guest-detail-template',{})
	e.preventDefault();
});

$(function(){
	View.render('#guest-main-template',{})
});

