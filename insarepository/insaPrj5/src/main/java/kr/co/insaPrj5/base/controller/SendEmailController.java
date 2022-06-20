package kr.co.insaPrj5.base.controller;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SendEmailController {
    private Multipart multipart;
    
    @RequestMapping("/base/sendEmail.do")
	public ModelAndView sendEmail(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String empCode, @RequestParam String usage,  @RequestParam String eMail) {
       
       String host = "smtp.naver.com";
       final String user = "seoulittest1"; 
       final String password = "testtest1";
       int port = 465;
       
		/*
		 * String recipient = eMail; //받는 사람의 메일주소를 입력해주세요 String subject = "메일테스트";
		 * //메일 제목 입력해주세요. String body = user+"님으로 부터 메일을 받았습니다."; //메일 내용 입력해주세요.
		 */
       
       String toAddress = eMail;

       try {

          // Get the session object
          Properties props = new Properties();
          props.put("mail.smtp.host", host);
          props.put("mail.smtp.port", port);
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.ssl.enable", "true");
          props.put("mail.smtp.ssl.trust", host);


          Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
             protected PasswordAuthentication getPasswordAuthentication() {      
                return new javax.mail.PasswordAuthentication(user, password);
             }
          });
           MimeMessage message = new MimeMessage(session);
             message.setFrom(new InternetAddress("seoulittest1@naver.com"));  
             message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
           System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@toAddress:   "+toAddress);
             // Subject
             message.setSubject("제목: 메일 전송(아이리포트)");
             multipart = new MimeMultipart();
                   
             // Text
             MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setText("본문내용 : 메일 전송(아이리포트)");
                multipart.addBodyPart(mbp1);

             // send the message
             //if(fileName != null){
                   DataSource source = new FileDataSource(request.getServletContext().getRealPath("/report/"+empCode+"_"+usage+".pdf"));
                   BodyPart messageBodyPart = new MimeBodyPart();
                   messageBodyPart.setDataHandler(new DataHandler(source));
                   messageBodyPart.setFileName(empCode+"_"+MimeUtility.encodeText(usage, "UTF-8", "B")+".pdf");
                                                                     //B 는 Base64 로 Q 는 quoted-printable
                   multipart.addBodyPart(messageBodyPart);
             //  }
             message.setContent(multipart);
                Transport.send(message);
             System.out.println("메일 발송 성공!");
             File sentFile = new File(request.getServletContext().getRealPath("/report/"+empCode+"_"+usage+".pdf"));
             sentFile.delete();

       } catch (Exception e) {
          e.printStackTrace();
          System.out.println("메일에러" + e);
       }
       return null;
    }
}