package com.itwill.annotation.exe;

@Component
@ComponentSingleValue(id = 100)
@ComponentMultiValue(count = 10,names = {"사과","복숭아","바나나"})
public class ComponentUsingClass {
	@AutoWired
	private Object member;
	
	@AutoWired
	public ComponentUsingClass(Object member) {
		
	}

	@AutoWired
	public void method1(Object member) {
		
	}
	

}
