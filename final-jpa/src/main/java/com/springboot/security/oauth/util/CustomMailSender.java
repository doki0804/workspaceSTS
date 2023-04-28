package com.springboot.security.oauth.util;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.springboot.security.oauth.user.dto.UserDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
@RequiredArgsConstructor
public class CustomMailSender {
	@Autowired
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String form;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Mail {
        private String address;
        private String title;
        private String message;
    }

    private void mimeMailSend(Mail mailDTO){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            message.setFrom(new InternetAddress(form));  //naver, daum, nate일 경우 넣어주어야함
            message.setSubject(mailDTO.getTitle());
            message.setText(mailDTO.getMessage(), "UTF-8", "html");
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailDTO.getAddress()));
            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendFindPasswordMail(UserDto.findPassword userDto, String tempPassword) {
        String htmlMessage =
        "<div>" +
        		userDto.getNickname()+"님의 임시 비밀번호는 <span style='font-weight:bold; color:blue;'>"+tempPassword+"</span> 입니다." +
        "</div>";

        Mail mail = new Mail();
        mail.setAddress(userDto.getUserEmail());
        mail.setTitle("[used book] 임시 비밀번호 안내 메일입니다.");
        mail.setMessage(htmlMessage);

        this.mimeMailSend(mail);
    }
}