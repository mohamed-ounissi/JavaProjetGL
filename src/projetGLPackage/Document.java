package projetGLPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Document {
    private static int count = 0;
    private int id;
    private String title;
    private String description;
    private String privacy;
    private String coverPicture;

    public Document(String title, String description, String privacy, String coverPicture) {
        this.id = ++count;
        this.title = title;
        this.description = description;
        this.privacy = privacy;
        this.coverPicture = coverPicture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Document> documents = new ArrayList<>();

        boolean continuer = true;
        while (continuer) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    creerDocument(scanner, documents);
                    break;
                case 2:
                	consulterDocument(documents);
                    break;
                case 3:
                    modifierDocument(scanner, documents);
                    break;
                case 4:
                    supprimerDocument(scanner, documents);
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
        System.out.println("\n--- Menu Documents ---");
        System.out.println("1. Créer un document");
        System.out.println("2. Consulter un document");
        System.out.println("3. Modifier un document");
        System.out.println("4. Supprimer un document");
        System.out.println("5. Quitter");
        System.out.print("Choix : ");
    }

    public static void creerDocument(Scanner scanner, ArrayList<Document> documents) {
        System.out.println("Création d'un nouveau document :");
        System.out.print("Titre : ");
        String title = scanner.nextLine();

        System.out.print("Description : ");
        String description = scanner.nextLine();

        System.out.print("Confidentialité : ");
        String privacy = scanner.nextLine();

        System.out.print("Image de couverture : ");
        String coverPicture = scanner.nextLine();

        Document nouveauDocument = new Document(title, description, privacy, coverPicture);
        documents.add(nouveauDocument);
        System.out.println("Document créé avec succès : " + nouveauDocument);
    }

    public static void consulterDocument(ArrayList<Document> documents) {
        if (documents.isEmpty()) {
            System.out.println("Aucun document enregistré.");
        } else {
            System.out.println("Liste des documents :");
            for (Document doc : documents) {
                System.out.println(doc);
            }
        }
    }


    public static void modifierDocument(Scanner scanner, ArrayList<Document> documents) {
        System.out.println("Liste des documents :");
        for (Document doc : documents) {
            System.out.println(doc);
        }

        System.out.print("Entrez l'ID du document à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        for (Document doc : documents) {
            if (doc.getId() == id) {
                System.out.println("Modification du document : " + doc);
                System.out.print("Nouveau titre (laissez vide pour conserver l'ancien titre) : ");
                String newTitle = scanner.nextLine();
                if (!newTitle.isEmpty()) {
                    doc.setTitle(newTitle);
                }

                System.out.print("Nouvelle description : ");
                String newDescription = scanner.nextLine();
                if (!newDescription.isEmpty()) {
                    doc.setDescription(newDescription);
                }

                System.out.print("Nouvelle confidentialité : ");
                String newPrivacy = scanner.nextLine();
                if (!newPrivacy.isEmpty()) {
                    doc.setPrivacy(newPrivacy);
                }

                System.out.print("Nouvelle image de couverture : ");
                String newCoverPicture = scanner.nextLine();
                if (!newCoverPicture.isEmpty()) {
                    doc.setCoverPicture(newCoverPicture);
                }

                System.out.println("Document modifié avec succès : " + doc);
                return;
            }
        }
        System.out.println("Aucun document trouvé avec l'ID : " + id);
    }


    public static void supprimerDocument(Scanner scanner, ArrayList<Document> documents) {
        System.out.print("Entrez l'ID du document à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consommer la nouvelle ligne après nextInt()

        for (int i = 0; i < documents.size(); i++) {
            Document doc = documents.get(i);
            if (doc.getId() == id) {
                documents.remove(i);
                System.out.println("Document avec ID " + id + " supprimé avec succès.");
                return;
            }
        }
        System.out.println("Aucun document trouvé avec l'ID : " + id);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", privacy='" + privacy + '\'' +
                ", coverPicture='" + coverPicture + '\'' +
                '}';
    }
}
