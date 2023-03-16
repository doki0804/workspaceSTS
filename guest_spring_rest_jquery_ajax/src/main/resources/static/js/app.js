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
/************validator 국제화*************/
$.getScript(`js/localization/messages_${navigator.language}.js`);
/************validator 기본설정*************/
console.log(navigator.language);
let validator = null;

$.validator.setDefaults({
	rules:{
				guest_name:{
					required:true,
					minlength:2	
				},
				guest_email:{
					required:true,
					email:true	
				},
				guest_homepage:{
					required:true,
					url:true	
				},
				guest_title:{
					required:true,
					rangelength:[3,6]	
				}
			},
			messages:{
				guest_name:{
					required:"이름을 입력하세요",
					minlength:"이름은 {0}자 이상입니다"	
				},
				guest_title:{
					required:"타이틀을 입력하세요",
					rangelength:"타이틀은 {0} ~ {1}자 입력가능합니다"	
				}
			},
	errorClass:'error',
	validClass:'valid'
});

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
	/*###############################[form validator plugin]##########################
    form validator
	 - HOMEPAGE :   https://jqueryvalidation.org/
	 - API      :   https://jqueryvalidation.org/validate/
		1. $(form).validate() function은 form loading시에 미리 호출되어있어야한다.
		2. var validator=$(form).validate(); 실행후 반환되는 validator 객체를 사용한다.
	#################################################################################*/
	validator = $('#guest_write_form').validate(
		{
			rules:{
				guest_content:{
					required:true,
					equalTo:'#guest_title'	
				}
			},
			messages:{
				guest_content:{
					required:"내용을 입력하세요",
					equalTo:"내용은 타이틀과 일치해야합니다"
				}
			}

		}
	);
	e.preventDefault();
	
});

/*******guest_write_action*******/
$(document).on('click','#btn_guest_write_action',function(e){
	
	if(validator.form()){
		let sendData={
			guest_name:document.f.guest_name.value,
			guest_email:document.f.guest_email.value,
			guest_homepage:document.f.guest_homepage.value,
			guest_title:document.f.guest_title.value,
			guest_content:document.f.guest_content.value
		};
		Request.ajaxRequest('guest','POST',JSON.stringify(sendData),'application/json;charset=UTF-8',function(jsonResult){
			if(jsonResult.code==1){
				let new_guest_no = jsonResult.data[0].guest_no;
				Request.ajaxRequest(`guest/${new_guest_no}`,'GET',{},'application/json;charset=UTF-8',function(resultJson){
					View.render('#guest-detail-template',resultJson)
				},true);
			}else{
				alert("쓰기실패");
			}
		},true);
		e.preventDefault();
	}else{
		alert('validation false');
	}
});

/*******guest_modify_form*******/
$(document).on('click','#btn_guest_modify_form',function(e){
	let guest_no = e.target.getAttribute('guest_no');
	Request.ajaxRequest(`guest/${guest_no}`,'GET',{},'application/json;charset=UTF-8',function(jsonResult){
		View.render('#guest-modify-form-template',jsonResult);
	},true);
	e.preventDefault();
});

/*******guest_modify_action*******/
$(document).on('click','#btn_guest_modify_action',function(e){
	let guest_no = document.f.guest_no.value;
	let sendData = {
		guest_no:document.f.guest_no.value,
		guest_name:document.f.guest_name.value,
		guest_email:document.f.guest_email.value,
		guest_homepage:document.f.guest_homepage.value,
		guest_title:document.f.guest_title.value,
		guest_content:document.f.guest_content.value
	}
	Request.ajaxRequest(`guest/${guest_no}`,'PUT',JSON.stringify(sendData),'application/json;charset=UTF-8',function(jsonResult){
		View.render('#guest-detail-template',jsonResult);
	},true)
	e.preventDefault();
});

/*******guest_remove_action*******/
$(document).on('click','#btn_guest_remove_action',function(e){
	let guest_no = $('#guest_view_form input[name=guest_no]').val();
	Request.ajaxRequest(`guest/${guest_no}`,'DELETE',{},'application/json;charset=UTF-8',function(jsonResult){
		if(jsonResult.code==1){
			Request.ajaxRequest('guest','GET',{},'application/json;charset=UTF-8',function(jsonResult){
			View.render("#guest-list-template",jsonResult);
			},true);
		}else {
			alert(jsonResult.msg);
		}
	},true);
	e.preventDefault();
});

/*******guest_detail*******/
$(document).on('click','.guest_item_a',function(e){
	let guest_no = e.target.getAttribute('guest_no');
	Request.ajaxRequest(`guest/${guest_no}`,'GET',{},'application/json;charset=UTF-8',function(resultJson){
		View.render('#guest-detail-template',resultJson);
	},true);
	e.preventDefault();
});

$(function(){
	View.render('#guest-main-template',{})
});

