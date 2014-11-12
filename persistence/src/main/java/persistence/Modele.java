package persistence;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.OneToMany;


@Entity
public class Modele {
	@Id
	String code;
	@Basic
	String nom;
	@ManyToOne
	Type type;
	@ManyToOne
	Marque marque;
	 
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
