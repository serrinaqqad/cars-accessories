package fall2023project;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Logger;
public class EmailSender {
	Logger logger = Logger.getLogger(getClass().getName());
	String reciepentEmail;
	public EmailSender(String reciepent) {
		reciepentEmail = reciepent;
	}
	public void setReciepent(String r) {
		reciepentEmail = r;
	}
	
    public void sendEmail(String email_subject, String email_message) {
        // Retrieve email and password from environment variables
        String senderEmail = System.getenv("SENDER_EMAIL");
        String senderPassword = System.getenv("SENDER_PASSWORD");
        String recipientEmail = "recipient@example.com";
        if (senderEmail == null || senderPassword == null) {
        	logger.info("Sender email or password not provided in environment variables.");
            return;
        }

        // Setup properties for the SMTP server
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Create a session with the sender's email and password
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);

            // Set the sender's email address
            message.setFrom(new InternetAddress(senderEmail));

            // Set the recipient's email address
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));

            // Set the email subject and content
            message.setSubject(email_subject);
            message.setText(email_message);
            Transport.send(message);

            logger.info("Email sent successfully!");

        } catch (MessagingException e) {
        	logger.info("********* Failed to send Email **********");
        }
    }
}
