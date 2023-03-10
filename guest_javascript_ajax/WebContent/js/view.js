/**
 * view.js
*/
export function render(templateId='#guest-main-template',jsonResult={},contentId='#content') {
	let templateHtml = document.querySelector(templateId);
	let bindTemplate = Handlebars.compile(templateHtml.innerHTML);
	let resultTemplate = bindTemplate(jsonResult);
	document.querySelector(contentId).innerHTML = resultTemplate;
}