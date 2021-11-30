import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import java.util.Properties;

class Mail1{
	String email;
	void sendEmailTLS(String email) {
		this.email = email;
		
		final String username = "sambit.csmtechnologies@gmail.com";
        final String password = "lcjdjtnkobvtcecv";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("sambit.csmtechnologies@gmail.com"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(email)
                );
                message.setSubject("Greeting From Sambit");
                message.setText("Dear User Welcome To Mail Server.");

                Transport.send(message);

                System.out.println("Mail Done");

        } catch (MessagingException e) {
            //e.printStackTrace();
        	System.out.println(e);
        }
	}
}

/*
 * public class Mail{ public static void main(String args[]) { Mail1 ob = new
 * Mail1(); ob.sendEmaiTLS("universityouat@gmail.com"); } }
 */
