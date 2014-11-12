package persistence;
import javax.persistence.Basic;
import javax.persistence.Entity;


@Entity
public class Particulier extends Proprietaire{
	@Basic
	String nom;
	@Basic
	String prenom;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
