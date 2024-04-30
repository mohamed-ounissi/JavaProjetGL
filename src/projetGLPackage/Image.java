package projetGLPackage;
public class Image {

    private String id_image;
    private String description;
    private String imagePath; // Path to the image file

   


	public Image(String id, String description2, String imagePath2) {
		this.id_image = id;
        this.description = description2;
        this.imagePath = imagePath2;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    // Additional methods for Image class

    public void updateDescription(String newDescription) {
        this.description = newDescription;
    }

    @Override
    public String toString() {
    	 return "Image ID: " + id_image + ", Description: " + description + ", Path: " + imagePath;
    }
}
