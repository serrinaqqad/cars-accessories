package StepDefinitions;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
	
	public EmailSender() {
	}
	
    public void sendEmail(String email_subject, String email_message) {
        // Retrieve email and password from environment variables
        String senderEmail = System.getenv("SENDER_EMAIL");
        String senderPassword = System.getenv("SENDER_PASSWORD");
        String recipientEmail = "myemail@example.com";
        if (senderEmail == null || senderPassword == null) {
            System.err.println("Sender email or password not provided in environment variables.");
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

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
