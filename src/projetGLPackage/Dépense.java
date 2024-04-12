package projetGLPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Dépense {
    private static int count = 0; 
    private int id; 
    private String label;
    private String amount;
    private String category;
    private String paymentMode;
    private Date operationDate;

    public Dépense(String label, String amount, String category, String paymentMode, Date operationDate) {
        this.id = ++count; 
        this.label = label;
        this.amount = amount;
        this.category = category;
        this.paymentMode = paymentMode;
        this.operationDate = operationDate;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Dépense{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", amount='" + amount + '\'' +
                ", category='" + category + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                ", operationDate=" + sdf.format(operationDate) +
                '}';
    }

    //créer une dépense
    public static void creerDépense(ArrayList<Dépense> dépenses, String label, String amount, String category,
            String paymentMode, Date operationDate) {
        Dépense nouvelleDépense = new Dépense(label, amount, category, paymentMode, operationDate);
        dépenses.add(nouvelleDépense);
        System.out.println("Dépense créée avec succès : " + nouvelleDépense);
    }

    // consulter les dépenses
    public static void consulterDépenses(ArrayList<Dépense> dépenses) {
        if (dépenses.isEmpty()) {
            System.out.println("Aucune dépense enregistrée.");
        } else {
            System.out.println("Liste des dépenses :");
            for (Dépense dépense : dépenses) {
                System.out.println(dépense);
            }
        }
    }


    //  supprimer une dépense par son id
    public static void supprimerDépenseParId(ArrayList<Dépense> dépenses, int id) {
        Iterator<Dépense> iterator = dépenses.iterator();
        while (iterator.hasNext()) {
            Dépense dépense = iterator.next();
            if (dépense.getId() == id) {
                iterator.remove();
                System.out.println("Dépense avec ID " + id + " supprimée avec succès.");
                return;
            }
        }
        System.out.println("Dépense introuvable avec l'ID : " + id);
    }

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Dépense> dépenses = new ArrayList<>();

        boolean continuer = true;
        while (continuer) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine(); // pour consommer la nouvelle ligne après nextInt()

            switch (choix) {
                case 1:
                    creerDépense(scanner, dépenses);
                    break;
                case 2:
                    consulterDépenses(dépenses);
                    break;
                case 3:
                    supprimerDépenseParId(scanner, dépenses);
                    break;
                case 4:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }

        // Fermer
        scanner.close();
    }

    public static void afficherMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Créer une dépense");
        System.out.println("2. Consulter les dépenses");
        System.out.println("3. Supprimer une dépense par ID");
        System.out.println("4. Quitter");
        System.out.print("Choix : ");
    }

    public static void creerDépense(Scanner scanner, ArrayList<Dépense> dépenses) throws ParseException {
        System.out.println("Création d'une nouvelle dépense :");
        System.out.print("Libellé de la dépense : ");
        String label = scanner.nextLine();

        System.out.print("Montant de la dépense : ");
        String amount = scanner.nextLine();

        System.out.print("Catégorie de la dépense : ");
        String category = scanner.nextLine();

        System.out.print("Mode de paiement : ");
        String paymentMode = scanner.nextLine();

        System.out.print("Date de l'opération (format yyyy-MM-dd) : ");
        String operationDateStr = scanner.nextLine();


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date operationDate = sdf.parse(operationDateStr);


        creerDépense(dépenses, label, amount, category, paymentMode, operationDate);
    }

    public static void supprimerDépenseParId(Scanner scanner, ArrayList<Dépense> dépenses) {
        System.out.print("Entrez l'ID de la dépense à supprimer : ");
        int idASupprimer = scanner.nextInt();
        scanner.nextLine();
        supprimerDépenseParId(dépenses, idASupprimer);
    }
}
