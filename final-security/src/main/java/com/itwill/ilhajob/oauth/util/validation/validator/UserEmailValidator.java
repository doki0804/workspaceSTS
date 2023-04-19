package com.itwill.ilhajob.oauth.util.validation.validator;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.itwill.ilhajob.oauth.util.validation.annotation.Email;


@Component
public class UserEmailValidator implements ConstraintValidator<Email, String> {

    String regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";

    @Override
    public void initialize(Email constraintAnnotation) {
        //어노테이션 입력 시 파라미터로 들어온 값 초기화
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //기본메시지 비활성화
        context.disableDefaultConstraintViolation();
        try {
			value = URLDecoder.decode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //url로 넘어오는 특수문자 처리

        if(!value.matches(regexp)){
            context.buildConstraintViolationWithTemplate("이메일 형식과 맞지 않습니다.").addConstraintViolation();
            return false;
        }

        return true;
    }
}
