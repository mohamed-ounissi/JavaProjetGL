package projetGLPackage;
import java.util.Scanner;

public class Courriel {
    private String message;
    private String subject;

    public Courriel(String subject, String message) {
        this.subject = subject;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void envoyerEmail() {
        System.out.println("Envoi du courriel...");
        System.out.println("Sujet : " + subject);
        System.out.println("Message : " + message);
        System.out.println("Courriel envoyé avec succès !");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le sujet du courriel : ");
        String sujet = scanner.nextLine();

        System.out.print("Entrez le message du courriel : ");
        String message = scanner.nextLine();

        Courriel courriel = new Courriel(sujet, message);
        courriel.envoyerEmail();

        scanner.close();
    }
}
