package projetGLPackage;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class BudgetTotal {
    private int year;
    private double amount;
    private ArrayList<SousBudget> sousBudgets;
    private static AtomicInteger nextId = new AtomicInteger(1);
    private int id;

    public BudgetTotal(int year, double amount) {
        this.year = year;
        this.amount = amount;
        this.sousBudgets = new ArrayList<>();
        this.id = nextId.getAndIncrement();
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ArrayList<SousBudget> getSousBudgets() {
        return sousBudgets;
    }

    public void setSousBudgets(ArrayList<SousBudget> sousBudgets) {
        this.sousBudgets = sousBudgets;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BudgetTotal> budgets = new ArrayList<>();

        boolean continuer = true;
        while (continuer) {
            afficherMenuPrincipal();
            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    creerBudget(scanner, budgets);
                    break;
                case 2:
                    consulterBudgets(budgets);
                    break;
                case 3:
                    creerSousBudgetAssocie(scanner, budgets);
                    break;
                case 4:
                    supprimerBudget(scanner, budgets);
                    break;
                case 5:
                    System.out.print("Entrez l'ID du budget dont vous voulez afficher les sous-budgets : ");
                    int idBudgetAfficher = scanner.nextInt();
                    scanner.nextLine(); 
                    BudgetTotal budgetAfficher = trouverBudgetParId(budgets, idBudgetAfficher);
                    if (budgetAfficher != null) {
                        afficherSousBudgets(budgetAfficher);
                    } else {
                        System.out.println("Aucun budget trouvé avec l'ID : " + idBudgetAfficher);
                    }
                    break;
                case 6:
                    System.out.print("Entrez l'ID du budget dont vous voulez supprimer un sous-budget : ");
                    int idBudgetSupprimerSousBudget = scanner.nextInt();
                    scanner.nextLine(); 
                    BudgetTotal budgetSupprimerSousBudget = trouverBudgetParId(budgets, idBudgetSupprimerSousBudget);
                    if (budgetSupprimerSousBudget != null) {
                        supprimerSousBudget(scanner, budgetSupprimerSousBudget);
                    } else {
                        System.out.println("Aucun budget trouvé avec l'ID : " + idBudgetSupprimerSousBudget);
                    }
                    break;
                case 7:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }

        // Fermer le scanner
        scanner.close();
    }

    public static void afficherMenuPrincipal() {
        System.out.println("\n--- Menu Budget Total ---");
        System.out.println("1. Créer un budget");
        System.out.println("2. Consulter les budgets");
        System.out.println("3. Créer un sous-budget associé à un budget");
        System.out.println("4. Supprimer un budget");
        System.out.println("5. Afficher sous budgets de budget");
        System.out.println("6. Supprimer sous budgets de budget ");
        System.out.println("7. Quitter");
        System.out.print("Choix : ");
    }

    public static void creerBudget(Scanner scanner, ArrayList<BudgetTotal> budgets) {
        System.out.print("Entrez l'année du budget : ");
        int year = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Entrez le montant du budget : ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        BudgetTotal budget = new BudgetTotal(year, amount);
        budgets.add(budget);
        System.out.println("Budget principal créé avec succès : " + budget);

        
        System.out.print("Voulez-vous ajouter un ou plusieurs sous-budgets (O/N) ? ");
        String choix = scanner.nextLine().toUpperCase();
        if (choix.equals("O")) {
            creerSousBudgets(scanner, budget);
        }
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
    public static void creerSousBudgets(Scanner scanner, BudgetTotal budget) {
        ArrayList<SousBudget> sousBudgets = new ArrayList<>();
        boolean continuer = true;
        while (continuer) {
            System.out.print("Entrez le sujet du sous-budget : ");
            String subject = scanner.nextLine();

            System.out.print("Entrez le montant prévu : ");
            double planned = scanner.nextDouble();
            scanner.nextLine(); 
            System.out.print("Entrez la date (format yyyy-MM-dd) : ");
            Date date = parseDate(scanner.nextLine());
            

            SousBudget sousBudget = new SousBudget(subject, planned, date);  
            sousBudgets.add(sousBudget);
            System.out.println("Sous-budget créé avec succès : " + sousBudget);

            System.out.print("Voulez-vous ajouter un autre sous-budget (O/N) ? ");
            String autreSousBudget = scanner.nextLine().toUpperCase();
            continuer = autreSousBudget.equals("O");
        }
        budget.setSousBudgets(sousBudgets);  
    }
    public static void supprimerSousBudget(Scanner scanner, BudgetTotal budget) {
        ArrayList<SousBudget> sousBudgets = budget.getSousBudgets();
        if (sousBudgets.isEmpty()) {
            System.out.println("Aucun sous-budget associé à ce budget.");
        } else {
            System.out.print("Entrez l'ID du sous-budget à supprimer : ");
            int idASupprimer = scanner.nextInt();
            scanner.nextLine(); 

            boolean removed = sousBudgets.removeIf(sousBudget -> sousBudget.getId() == idASupprimer);
            if (removed) {
                System.out.println("Sous-budget avec ID " + idASupprimer + " supprimé avec succès.");
            } else {
                System.out.println("Aucun sous-budget trouvé avec l'ID : " + idASupprimer);
            }
        }
    }

    public static void creerSousBudgetAssocie(Scanner scanner, ArrayList<BudgetTotal> budgets) {
        System.out.print("Entrez l'ID du budget auquel associer le sous-budget : ");
        int idBudget = scanner.nextInt();
        scanner.nextLine(); 

        BudgetTotal budgetAssocie = trouverBudgetParId(budgets, idBudget);
        if (budgetAssocie != null) {
            creerSousBudgets(scanner, budgetAssocie);
        } else {
            System.out.println("Aucun budget trouvé avec l'ID : " + idBudget);
        }
    }
    public static void afficherSousBudgets(BudgetTotal budget) {
        ArrayList<SousBudget> sousBudgets = budget.getSousBudgets();
        if (sousBudgets.isEmpty()) {
            System.out.println("Aucun sous-budget associé à ce budget.");
        } else {
            System.out.println("Sous-budgets associés au budget avec l'ID " + budget.getId() + ":");
            for (SousBudget sousBudget : sousBudgets) {
                System.out.println(sousBudget);
            }
        }
    }

    public static BudgetTotal trouverBudgetParId(ArrayList<BudgetTotal> budgets, int id) {
        for (BudgetTotal budget : budgets) {
            if (budget.getId() == id) {
                return budget;
            }
        }
        return null; 
    }

    public static void consulterBudgets(ArrayList<BudgetTotal> budgets) {
        if (budgets.isEmpty()) {
            System.out.println("Aucun budget enregistré.");
        } else {
            System.out.println("Liste des budgets :");
            for (BudgetTotal budget : budgets) {
                System.out.println(budget);
            }
        }
    }

    public static void supprimerBudget(Scanner scanner, ArrayList<BudgetTotal> budgets) {
        System.out.print("Entrez l'ID du budget à supprimer : ");
        int idASupprimer = scanner.nextInt();
        scanner.nextLine();  
        boolean removed = budgets.removeIf(budget -> budget.getId() == idASupprimer);
        if (removed) {
            System.out.println("Budget avec ID " + idASupprimer + " supprimé avec succès.");
        } else {
            System.out.println("Aucun budget trouvé avec l'ID : " + idASupprimer);
        }
    }

    @Override
    public String toString() {
        return "BudgetTotal{" +
                "id=" + id +
                ", year=" + year +
                ", amount=" + amount +
                '}';
    }
}