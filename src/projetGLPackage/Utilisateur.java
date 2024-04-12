package projetGLPackage;
public class Utilisateur {
	
	private String id_user;
	private String username;
	private String lastname;
	private String adresse;
	private String email;
	private String password;
	private String profilePic;
	
	

	
	
	public Utilisateur(String id_user, String username, String lastname, String adresse, String email, String password,
			String profilePic) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.lastname = lastname;
		this.adresse = adresse;
		this.email = email;
		this.password = password;
		this.profilePic = profilePic;
	}
	
	
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	
	
	public void register() {
		
	}
	
	
	public void login() {
		
	}
	
	
	public void creeUtilisateur() {
		
	}
	
	
	public void modifier() {
		
	}
	
	
	public void consulter() {
		
	}
	
	
	public void supprimer() {
		
	}
}
