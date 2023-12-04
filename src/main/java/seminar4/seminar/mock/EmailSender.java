package seminar4.seminar.mock;

public interface EmailSender {
    void sendEmail(String to, String subject, String body);
}