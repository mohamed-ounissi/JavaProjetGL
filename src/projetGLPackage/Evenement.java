package projetGLPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Evenement {

    private static int eventCounter = 0;

    private String id_event;
    private String title;
    private String description;
    private String category;
    private String visibilite;
    private List<Adherent> participatedAdherents;

    public Evenement(String title, String description, String category, String visibilite, List<Evenement> eventList) {
        this.id_event = generateUniqueId(eventList);
        this.title = title;
        this.description = description;
        this.category = category;
        this.visibilite = visibilite;
        this.participatedAdherents = new ArrayList<>();
    }

    public String getId_event() {
        return id_event;
    }

    public void setId_event(String id_event) {
        this.id_event = id_event;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(String visibilite) {
        this.visibilite = visibilite;
    }

    public List<Adherent> getParticipatedAdherents() {
        return participatedAdherents;
    }

    public void creerEvenement(List<Evenement> eventList, String title, String description, String category, String visibilite) {
        Evenement event = new Evenement(title, description, category, visibilite, eventList);
        eventList.add(event);
    }

    public void modifierEvenement(List<Evenement> eventList, String id, String title, String description, String category, String visibilite) {
        Evenement event = findEventById(eventList, id);
        if (event != null) {
            event.setTitle(title);
            event.setDescription(description);
            event.setCategory(category);
            event.setVisibilite(visibilite);
        } else {
            System.out.println("Événement non trouvé.");
        }
    }

    public void consulterEvenement(List<Evenement> eventList, String id) {
        Evenement event = findEventById(eventList, id);
        if (event != null) {
            System.out.println("Détails de l'événement:");
            System.out.println("ID: " + event.getId_event());
            System.out.println("Titre: " + event.getTitle());
            System.out.println("Description: " + event.getDescription());
            System.out.println("Catégorie: " + event.getCategory());
            System.out.println("Visibilité: " + event.getVisibilite());
        } else {
            System.out.println("Événement non trouvé.");
        }
    }

    public void supprimerEvenement(List<Evenement> eventList, String id) {
        Evenement event = findEventById(eventList, id);
        if (event != null) {
            eventList.remove(event);
            System.out.println("Événement supprimé avec succès.");
        } else {
            System.out.println("Événement non trouvé.");
        }
    }

    public void participerEvenement(List<Evenement> eventList, String id) {
        Evenement event = findEventById(eventList, id);
        if (event != null) {
            Scanner scanner = new Scanner(System.in);
            boolean addingAdherents = true;
            System.out.println("Ajout de participants à l'événement (Entrez 'done' pour terminer) :");
            while (addingAdherents) {
                System.out.print("Entrez l'ID de l'adhérent: ");
                String adherentId = scanner.nextLine();
                if (adherentId.equalsIgnoreCase("done")) {
                    addingAdherents = false;
                } else {
                    Adherent adherent = findAdherentById(adherentId);
                    if (adherent != null) {
                        event.getParticipatedAdherents().add(adherent);
                        System.out.println("Adhérent ajouté avec succès.");
                    } else {
                        System.out.println("Adhérent non trouvé.");
                    }
                }
            }
            scanner.close();
        } else {
            System.out.println("Événement non trouvé.");
        }
    }

    public void afficherTousLesEvenements(List<Evenement> eventList) {
        System.out.println("Liste de tous les événements:");
        for (Evenement event : eventList) {
            System.out.println("ID: " + event.getId_event());
            System.out.println("Titre: " + event.getTitle());
            System.out.println("Description: " + event.getDescription());
            System.out.println("Catégorie: " + event.getCategory());
            System.out.println("Visibilité: " + event.getVisibilite());
            System.out.println("Adhérents participants:");
            for (Adherent adherent : event.getParticipatedAdherents()) {
                System.out.println("- " + adherent.getUsername());
            }
            System.out.println();
        }
    }

    private String generateUniqueId(List<Evenement> eventList) {
        return String.valueOf(eventList.size() + 1);
    }

    private Evenement findEventById(List<Evenement> eventList, String id) {
        for (Evenement event : eventList) {
            if (event.getId_event().equals(id)) {
                return event;
            }
        }
        return null;
    }

    private Adherent findAdherentById(String id) {
        // Assuming there's a list of adherents available to search from
        List<Adherent> adherents = new ArrayList<>(); // Assuming there's a list of adherents
        for (Adherent adherent : adherents) {
            if (adherent.getId_user().equals(id)) {
                return adherent;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Evenement> eventList = new ArrayList<>();

        boolean continuer = true;
        while (continuer) {
            System.out.println("=== Menu ===");
            System.out.println("1. Créer un événement");
            System.out.println("2. Modifier un événement");
            System.out.println("3. Consulter un événement");
            System.out.println("4. Supprimer un événement par ID");
            System.out.println("5. Participer à un événement");
            System.out.println("6. Afficher tous les événements");
            System.out.println("7. Quitter");
            System.out.print("Choix: ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            Evenement evenement = new Evenement("", "", "", "", eventList); // Create a new event object

            switch (choix) {
                case 1:
                    System.out.print("Entrez le titre de l'événement: ");
                    String title = scanner.nextLine();
                    System.out.print("Entrez la description de l'événement: ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez la catégorie de l'événement: ");
                    String category = scanner.nextLine();
                    System.out.print("Entrez la visibilité de l'événement: ");
                    String visibility = scanner.nextLine();
                    evenement.creerEvenement(eventList, title, description, category, visibility);
                    System.out.println("Événement créé avec succès.");
                    break;
                case 2:
                    System.out.print("Entrez l'ID de l'événement à modifier: ");
                    String eventId = scanner.nextLine();
                    System.out.print("Entrez le nouveau titre de l'événement: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Entrez la nouvelle description de l'événement: ");
                    String newDescription = scanner.nextLine();
                    System.out.print("Entrez la nouvelle catégorie de l'événement: ");
                    String newCategory = scanner.nextLine();
                    System.out.print("Entrez la nouvelle visibilité de l'événement: ");
                    String newVisibility = scanner.nextLine();
                    evenement.modifierEvenement(eventList, eventId, newTitle, newDescription, newCategory, newVisibility);
                    break;
                case 3:
                    System.out.print("Entrez l'ID de l'événement à consulter: ");
                    String consultEventId = scanner.nextLine();
                    evenement.consulterEvenement(eventList, consultEventId);
                    break;
                case 4:
                    System.out.print("Entrez l'ID de l'événement à supprimer: ");
                    String deleteEventId = scanner.nextLine();
                    evenement.supprimerEvenement(eventList, deleteEventId);
                    break;
                case 5:
                    System.out.print("Entrez l'ID de l'événement auquel vous voulez participer: ");
                    String participateEventId = scanner.nextLine();
                    evenement.participerEvenement(eventList, participateEventId);
                    break;
                case 6:
                    evenement.afficherTousLesEvenements(eventList);
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
}
