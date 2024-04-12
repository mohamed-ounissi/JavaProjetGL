package projetGLPackage;

import java.util.ArrayList;
import java.util.List;

public class Gallery {

    private List<Image> images;

    public Gallery() {
        this.images = new ArrayList<Image>(); 
    }

    public void addImage(Image image) {
        this.images.add(image);  
    }

    public List<Image> getImages() {
        return images;  
    }

   
}