window.jQuery = function(arg){
	if(typeof arg=='string'){
		let elementNodeList = document.querySelectorAll(arg);
		let jqueryWrapperObject={
			'elementNodeList':elementNodeList,
			'css':function(propertyName,propertyValue){
				for(element of this.elementNodeList){
					element.style.cssText+=`${propertyName}:${propertyValue};`;
				}
				return this;
			},
			'text':function(textArg){
				for(element of this.elementNodeList){
					//element.innerHTML=textArg;
					element.firstChild.nodeValue=textArg;
				}
				return this;
			}
		}
		return jqueryWrapperObject;
	}else if(typeof arg=='function'){
		
	}
}
window.$ = window.jQuery;







