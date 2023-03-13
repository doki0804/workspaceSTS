window.jQuery = function(arg){
	if(typeof arg=='string'){
		/******************selector*******************/
		let elementNodeList = document.querySelectorAll(arg);
		if(!elementNodeList) elementNodeList=[];
		let jqueryWrapperObject={
			'elementNodeList':elementNodeList,
			'css':function(propertyName,propertyValue){
				for(element of this.elementNodeList){
					element.style.cssText+=`${propertyName}:${propertyValue};`;
				}
				return this;
			},
			'text':function(textArg){
				if(textArg){
					//set text
					for(element of this.elementNodeList){
						//element.innerHTML=textArg;
						element.firstChild.nodeValue=textArg;
					}
					return this;
				}else if(textArg==undefined){
					//get text
					let returnText='';
					for(element of this.elementNodeList){
						returnText += element.firstChild.nodeValue;
					}
					return returnText;
				}
			}
		}
		return jqueryWrapperObject;
	}else if(typeof arg=='function'){
		/*
		인자로 대입된 함수를 DOM트리생성직후에 호출되도록
		window.onload이벤트 프로퍼티에 등록
		*/
		window.addEventListener('load',arg);
	}else if(typeof arg == 'object'){
		/*
		표준객체(Element,document,window,....)
		*/
		let elementNodeList = [];
		elementNodeList.push(arg);
		if(typeof arg=='string'){
		/******************selector*******************/
		let elementNodeList = document.querySelectorAll(arg);
		if(!elementNodeList) elementNodeList=[];
		let jqueryWrapperObject={
			'elementNodeList':elementNodeList,
			'css':function(propertyName,propertyValue){
				for(element of this.elementNodeList){
					element.style.cssText+=`${propertyName}:${propertyValue};`;
				}
				return this;
			},
			'text':function(textArg){
				if(textArg){
					//set text
					for(element of this.elementNodeList){
						//element.innerHTML=textArg;
						element.firstChild.nodeValue=textArg;
					}
					return this;
				}else if(textArg==undefined){
					//get text
					let returnText='';
					for(element of this.elementNodeList){
						returnText += element.firstChild.nodeValue;
					}
					return returnText;
				}
			}
		}
		return jqueryWrapperObject;
	}
	}
}
/**********jQuery flobal function**********/
window.jQuery.each = function(array,funcArg){
	for(let i=0;i<array.length;i++){
		funcArg(i,array[i]);
	}
}

window.$ = window.jQuery;







