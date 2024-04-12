package projetGLPackage;

public class Evenement {

    private String id_event;
    private String title;
    private String description;
    private String category;
    private String visibilite ;

    public Evenement(String id_event, String title, String description, String category, String visibilite) {
        this.id_event = id_event;
        this.title = title;
        this.description = description;
        this.category = category;
        this.visibilite = visibilite;
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

    public void setCategory(String visibilite) {
        this.visibilite = visibilite;
    }

    public String getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(String visibilite) {
        this.visibilite = visibilite;
    }
    
    public void creer_evenement() {
        
    }

    public void modifier_evenement() {
       
    }

    public void consulter_evenement() {
        
    }

    public void supprimer_evenement() {
        
    }
    public void participer_evenement() {
        
    }
}
