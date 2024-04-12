package projetGLPackage;

public class Image {

    private String id_image;
    private String description;

    public Image(String id_image, String description) {
        this.id_image = id_image;
        this.description = description;
    }

    public String getId_image() {
        return id_image;
    }

    public void setId_image(String id_image) {
        this.id_image = id_image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}