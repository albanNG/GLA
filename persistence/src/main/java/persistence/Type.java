package persistence;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Type {
	
	@Id
	String code;
	@Basic
	String nom;
	
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
