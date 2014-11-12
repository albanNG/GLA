package persistence;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;

@Entity
public class Vehicule {
	@Id
	String numeroDeSerie;
	@Basic
	Date dateDeMiseEnCirculation;
	@ManyToOne
	Modele modele;
	
	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}
	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}
	public Date getDateDeMiseEnCirculation() {
		return dateDeMiseEnCirculation;
	}
	public void setDateDeMiseEnCirculation(Date dateDeMiseEnCirculation) {
		this.dateDeMiseEnCirculation = dateDeMiseEnCirculation;
	}


}

