package com.example.FP.service;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;
    private static int number;

    private static String senderEmail = System.getenv("email");

    //임의의 6자리 양수를 반환합니다.
    public void makeRandomNumber() {
        Random r = new Random();
        String randomNumber = "";
        for(int i = 0; i < 6; i++) {
            randomNumber += Integer.toString(r.nextInt(10));
        }

        number = Integer.parseInt(randomNumber);
    }

    //mail을 어디서 보내는지, 어디로 보내는지 , 인증 번호를 html 형식으로 어떻게 보내는지 작성합니다.
    public MimeMessage CreateMail(String mail) {
        makeRandomNumber();
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom(senderEmail);
            message.setRecipients(MimeMessage.RecipientType.TO, mail);
            message.setSubject("U's Recipe 인증 이메일 입니다.");
            String body = "";

            body += "<div style=\"margin:auto;max-width:600px;padding-top:50px\" class=\"m_8369295054549316484email-container\">\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "                <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" align=\"center\" id=\"m_8369295054549316484logoContainer\" style=\"background:#252f3d;border-radius:3px 3px 0 0;max-width:600px\">\n" +
                    "                    <tbody><tr>\n" +
                    "                        <td style=\"background:#D65454;border-radius:3px 3px 0 0;padding:20px 0 10px 0;text-align:center\">\n" +
                    "                        </td>\n" +
                    "                    </tr>\n" +
                    "                    </tbody></table>\n" +
                    "\n" +
                    "\n" +
                    "                <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" align=\"center\" id=\"m_8369295054549316484emailBodyContainer\" style=\"border:0px;border-bottom:1px solid #d6d6d6;max-width:600px\">\n" +
                    "                    <tbody><tr>\n" +
                    "                        <td style=\"background-color:#fff;color:#444;font-family:'Amazon Ember','Helvetica Neue',Roboto,Arial,sans-serif;font-size:14px;line-height:140%;padding:25px 35px\">\n" +
                    "                            <h1 style=\"font-size:20px;font-weight:bold;line-height:1.3;margin:0 0 15px 0\">이메일 주소 확인</h1>\n" +
                    "                            <p style=\"margin:0;padding:0\">새로운 U's Recipe 계정 생성 프로세스를 시작해 주셔서 감사합니다. 사용자가 본인임을 확인하려고 합니다. 메시지가 표시되면 다음 확인 코드를 입력하세요. 계정을 생성하지 않는 경우에는 이 메시지를 무시해도 됩니다.</p>\n" +
                    "                            <p style=\"margin:0;padding:0\"></p>\n" +
                    "                        </td>\n" +
                    "                    </tr>\n" +
                    "                    <tr>\n" +
                    "                        <td style=\"background-color:#fff;color:#444;font-family:'Amazon Ember','Helvetica Neue',Roboto,Arial,sans-serif;font-size:14px;line-height:140%;padding:25px 35px;padding-top:0;text-align:center\">\n" +
                    "                            <div style=\"font-weight:bold;padding-bottom:15px\">확인 코드</div>\n" +
                    "                            <div style=\"color:#000;font-size:36px;font-weight:bold;padding-bottom:15px\">"+number+"</div>\n" +
                    "                            <div>(이 코드는 10분 동안 유효합니다.)</div>\n" +
                    "                        </td>\n" +
                    "                    </tr>\n" +
                    "                    <tr>\n" +
                    "                        <td style=\"background-color:#fff;border-top:1px solid #e0e0e0;color:#777;font-family:'Amazon Ember','Helvetica Neue',Roboto,Arial,sans-serif;font-size:14px;line-height:140%;padding:25px 35px\">\n" +
                    "                        </td>\n" +
                    "                    </tr>\n" +
                    "                    </tbody></table>\n" +
                    "\n" +
                    "\n" +
                    "                <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" align=\"center\" id=\"m_8369295054549316484footer\" style=\"max-width:600px\">\n" +
                    "                    <tbody><tr>\n" +
                    "                        <td style=\"color:#777;font-family:'Amazon Ember','Helvetica Neue',Roboto,Arial,sans-serif;font-size:12px;line-height:16px;padding:20px 30px;text-align:center\">\n" +
                    "                        </td>\n" +
                    "                    </tr>\n" +
                    "                    </tbody></table>\n" +
                    "\n" +
                    "\n" +
                    "            </div>";
            message.setText(body,"UTF-8", "html");
        } catch (jakarta.mail.MessagingException e) {
            e.printStackTrace();
        }
        return message;
    }

    //이메일을 전송합니다.
    public int sendMail(String mail) {
        MimeMessage message = CreateMail(mail);
        javaMailSender.send(message);

        return number;
    }
}
