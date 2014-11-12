package persistence;
import javax.persistence.Basic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance (strategy=InheritanceType.JOINED)
public abstract class Proprietaire {
	@Id
	@GeneratedValue
	Long id;
	@Basic	
	protected String adresse;
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public Long getId() {
		return id;
	}
	

}
