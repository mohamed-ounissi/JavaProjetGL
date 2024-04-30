package projetGLPackage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gallery {

    private List<Image> imageGallery;
    private int nextId; // Next available ID for the image

    public Gallery() {
        this.imageGallery = new ArrayList<>();
        this.nextId = 1; // Start with ID 1
    }

    public void addImage(String description, String imagePath) {
        String id = Integer.toString(nextId++);
        Image image = new Image(id, description, imagePath);
        this.imageGallery.add(image);
    }

    public void removeImage(Image image) {
        this.imageGallery.remove(image);
        
    }

    public int getImageCount() {
        return this.imageGallery.size();
    }

    public List<Image> getImages() {
        return this.imageGallery;
    }

    public Image getImageById(String id) {
        for (Image image : this.imageGallery) {
            if (image.getId_image().equals(id)) {
                return image;
            }
        }
        return null; // Return null if image with given id is not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gallery gallery = new Gallery();

        boolean continuer = true;
        while (continuer) {
            System.out.println("=== Menu ===");
            System.out.println("1. Ajouter une image");
            System.out.println("2. Afficher les images");
            System.out.println("3. Supprimer une image par ID");
            System.out.println("4. Afficher toutes les images et obtenir le nombre total");
            System.out.println("5. Rechercher une image par ID");
            System.out.println("6. Quitter");
            System.out.print("Choix: ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // pour consommer la nouvelle ligne après nextInt()

            switch (choix) {
                case 1:
                    System.out.print("Entrez la description de l'image: ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez le chemin de l'image: ");
                    String imagePath = scanner.nextLine();
                    gallery.addImage(description, imagePath);
                    System.out.println("Image ajoutée avec succès.");
                    break;
                case 2:
                    List<Image> images = gallery.getImages();
                    if (images.isEmpty()) {
                        System.out.println("Aucune image dans la galerie.");
                    } else {
                        System.out.println("Liste des images dans la galerie:");
                        for (Image image : images) {
                            System.out.println(image);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Entrez l'ID de l'image à supprimer: ");
                    String id = scanner.nextLine();
                    Image image = gallery.getImageById(id);
                    if (image != null) {
                        gallery.removeImage(image);
                        System.out.println("Image supprimée avec succès.");
                    } else {
                        System.out.println("Aucune image trouvée avec cet ID.");
                    }
                    break;
                case 4:
                    List<Image> images1 = gallery.getImages();
                    if (images1.isEmpty()) {
                        System.out.println("Aucune image dans la galerie.");
                    } else {
                        System.out.println("Liste des images dans la galerie:");
                        for (Image image1 : images1) {
                            System.out.println(image1);
                        }
                        System.out.println("Nombre total d'images dans la galerie: " + gallery.getImageCount());
                    }
                    break;

                case 5:
                    System.out.print("Entrez l'ID de l'image à rechercher: ");
                    String searchId = scanner.nextLine();
                    Image foundImage = gallery.getImageById(searchId);
                    if (foundImage != null) {
                        System.out.println("Image trouvée: " + foundImage);
                    } else {
                        System.out.println("Aucune image trouvée avec cet ID.");
                    }
                    break;
                case 6:
                    continuer = false;
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }

        // Fermer le scanner
        scanner.close();}
}
