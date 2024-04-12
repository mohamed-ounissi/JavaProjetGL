package projetGLPackage;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SousBudget {
    private static int nextId = 1;
    private int id;
    private String subject;
    private double planned;
    private Date date;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public SousBudget(String subject, double planned, Date date) {
        this.id = nextId++;
        this.subject = subject;
        this.planned = planned;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getPlanned() {
        return planned;
    }

    public void setPlanned(double planned) {
        this.planned = planned;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SousBudget{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", planned=" + planned +
                ", date='" + dateFormat.format(date) + '\'' +
                '}';
    }

    public static SousBudget creerSousBudget(Scanner scanner) {
        System.out.print("Entrez le sujet du sous-budget : ");
        String subject = scanner.nextLine();

        System.out.print("Entrez le montant prévu : ");
        double planned = scanner.nextDouble();
        scanner.nextLine();  

        System.out.print("Entrez la date (format yyyy-MM-dd) : ");
        Date date = parseDate(scanner.nextLine());

        return new SousBudget(subject, planned, date);
    }

    public static void consulterSousBudget(ArrayList<SousBudget> sousBudgets) {
        if (sousBudgets.isEmpty()) {
            System.out.println("Aucun sous-budget enregistré.");
        } else {
            System.out.println("Liste des sous-budgets :");
            for (SousBudget budget : sousBudgets) {
                System.out.println(budget);
            }
        }
    }

    public static void supprimerSousBudget(ArrayList<SousBudget> sousBudgets, int id) {
        boolean removed = false;
        for (SousBudget budget : sousBudgets) {
            if (budget.getId() == id) {
                sousBudgets.remove(budget);
                System.out.println("Sous-budget avec ID " + id + " supprimé avec succès.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Aucun sous-budget trouvé avec l'ID : " + id);
        }
    }

    public static void afficherMenu() {
        System.out.println("\n--- Menu Sous-Budget ---");
        System.out.println("1. Créer un sous-budget");
        System.out.println("2. Consulter les sous-budgets");
        System.out.println("3. Supprimer un sous-budget");
        System.out.println("4. Quitter");
        System.out.print("Choix : ");
    }

    private static Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        } catch (Exception e) {
            System.out.println("Format de date invalide. Utilisation du format par défaut.");
            return new Date(); 
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<SousBudget> sousBudgets = new ArrayList<>();

        boolean continuer = true;
        while (continuer) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine();  

            switch (choix) {
                case 1:
                    sousBudgets.add(creerSousBudget(scanner));
                    break;
                case 2:
                    consulterSousBudget(sousBudgets);
                    break;
                case 3:
                    System.out.print("Entrez l'ID du sous-budget à supprimer : ");
                    int idASupprimer = scanner.nextInt();
                    scanner.nextLine();  // Consommer la nouvelle ligne
                    supprimerSousBudget(sousBudgets, idASupprimer);
                    break;
                case 4:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }

        scanner.close();
    }
}
