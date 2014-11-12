package persistence;
import java.io.Serializable;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CarteGrise implements Serializable {
	@Id
	String immatriculation;
	@Basic
	Integer puissance;
	@OneToOne
	Vehicule vehicule;
	@OneToMany (mappedBy ="carteGrise")
	Set <Appartenance> appartenances;
	

	public Integer getPuissance() {
		return puissance;
	}

	public Set<Appartenance> getAppartenances() {
		return appartenances;
	}

	public void setAppartenances(Set<Appartenance> appartenances) {
		this.appartenances = appartenances;
	}

	public void setPuissance(Integer puissance) {
		this.puissance = puissance;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public String getImmatriculation() {
		return immatriculation;
	}
	
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	
}
