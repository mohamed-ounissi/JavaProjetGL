package projetGLPackage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Dépense> dépenses = new ArrayList<>();
        ArrayList<Document> documents = new ArrayList<>();

        boolean continuer = true;
        while (continuer) {
            afficherMenuPrincipal();
            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    Dépense.main(args); 
                    
                case 2:
                   
                	Document.main(args); 
                	
                case 3:
                    
                    Courriel.main(args);
                case 4:
                    
                    Réunion.main(args);
                    
                case 5:
                    
                	Gallery.main(args);
                case 6:
                    
                	Evenement.main(args);;    
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
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Gérer les Dépenses");
        System.out.println("2. Gérer les Documents");
        System.out.println("3. Envoyer Email");
        System.out.println("4. Gérer Réunion");
        System.out.println("5. Gérer gallerie");
        System.out.println("6. Gérer Evenement");
        System.out.println("7. Quitter");
        System.out.print("Choix : ");
    }
}
