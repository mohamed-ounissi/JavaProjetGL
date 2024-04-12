package projetGLPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Réunion {
    private static int count = 0;
    private int id;
    private String title;
    private String description;
    private Date date;

    public Réunion(String title, String description, Date date) {
        this.id = ++count;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Réunion{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + sdf.format(date) +
                '}';
    }

    public static void créerRéunion(ArrayList<Réunion> réunions, String title, String description, Date date) {
        Réunion nouvelleRéunion = new Réunion(title, description, date);
        réunions.add(nouvelleRéunion);
        System.out.println("Réunion créée avec succès : " + nouvelleRéunion);
    }

    public static void modifierRéunion(ArrayList<Réunion> réunions, int id, String title, String description, Date date) {
        for (Réunion réunion : réunions) {
            if (réunion.getId() == id) {
                réunion.setTitle(title);
                réunion.setDescription(description);
                réunion.setDate(date);
                System.out.println("Réunion modifiée avec succès : " + réunion);
                return;
            }
        }
        System.out.println("Aucune réunion trouvée avec l'ID : " + id);
    }

    public static void consulterRéunions(ArrayList<Réunion> réunions) {
        if (réunions.isEmpty()) {
            System.out.println("Aucune réunion enregistrée.");
        } else {
            System.out.println("Liste des réunions :");
            for (Réunion réunion : réunions) {
                System.out.println(réunion);
            }
        }
    }

    public static void supprimerRéunionParId(ArrayList<Réunion> réunions, int id) {
        Iterator<Réunion> iterator = réunions.iterator();
        while (iterator.hasNext()) {
            Réunion réunion = iterator.next();
            if (réunion.getId() == id) {
                iterator.remove();
                System.out.println("Réunion avec ID " + id + " supprimée avec succès.");
                return;
            }
        }
        System.out.println("Réunion introuvable avec l'ID : " + id);
    }

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Réunion> réunions = new ArrayList<>();

        boolean continuer = true;
        while (continuer) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine(); // pour consommer la nouvelle ligne après nextInt()

            switch (choix) {
                case 1:
                    créerRéunion(scanner, réunions);
                    break;
                case 2:
                    consulterRéunions(réunions);
                    break;
                case 3:
                    modifierRéunion(scanner, réunions);
                    break;
                case 4:
                    supprimerRéunionParId(scanner, réunions);
                    break;
                case 5:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }

        // Fermer le scanner
        scanner.close();
    }

    public static void afficherMenu() {
        System.out.println("\n--- Menu Réunions ---");
        System.out.println("1. Créer une réunion");
        System.out.println("2. Consulter les réunions");
        System.out.println("3. Modifier une réunion");
        System.out.println("4. Supprimer une réunion par ID");
        System.out.println("5. Quitter");
        System.out.print("Choix : ");
    }

    public static void créerRéunion(Scanner scanner, ArrayList<Réunion> réunions) throws ParseException {
        System.out.println("Création d'une nouvelle réunion :");
        System.out.print("Titre de la réunion : ");
        String title = scanner.nextLine();

        System.out.print("Description de la réunion : ");
        String description = scanner.nextLine();

        System.out.print("Date de la réunion (format yyyy-MM-dd) : ");
        String dateStr = scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateStr);

        créerRéunion(réunions, title, description, date);
    }

    public static void modifierRéunion(Scanner scanner, ArrayList<Réunion> réunions) throws ParseException {
        System.out.print("Entrez l'ID de la réunion à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        for (Réunion réunion : réunions) {
            if (réunion.getId() == id) {
                System.out.print("Nouveau titre (laissez vide pour conserver l'ancien titre) : ");
                String title = scanner.nextLine();
                if (!title.isEmpty()) {
                    réunion.setTitle(title);
                }

                System.out.print("Nouvelle description (laissez vide pour conserver l'ancienne description) : ");
                String description = scanner.nextLine();
                if (!description.isEmpty()) {
                    réunion.setDescription(description);
                }

                System.out.print("Nouvelle date de la réunion (format yyyy-MM-dd, laissez vide pour conserver l'ancienne date) : ");
                String dateStr = scanner.nextLine();
                if (!dateStr.isEmpty()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = sdf.parse(dateStr);
                    réunion.setDate(date);
                }

                System.out.println("Réunion modifiée avec succès : " + réunion);
                return;
            }
        }
        System.out.println("Aucune réunion trouvée avec l'ID : " + id);
    }


    public static void supprimerRéunionParId(Scanner scanner, ArrayList<Réunion> réunions) {
        System.out.print("Entrez l'ID de la réunion à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consommer la nouvelle ligne après nextInt()

        supprimerRéunionParId(réunions, id);
    }
}

