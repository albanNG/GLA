package persistence;
import java.util.Date;


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

/* Cette classe relie la classe proprietaire a la classe carte grise:
 * chaque objet date est identifie par un triplet {carte grise; date; proprietaire}*/
@Entity
public class Appartenance {
	@Basic
	Date dateDebut;
	@Basic
	Date dateFin;
	@Id
	@GeneratedValue
	Long id;
	@ManyToOne
	Proprietaire proprietaire;
	@ManyToOne
	CarteGrise carteGrise;	
	
	
	
	public Date getDateDebut() {
		return dateDebut;
	}  
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Proprietaire getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
	public CarteGrise getCarteGrise() {
		return carteGrise;
	}
	public void setCarteGrise(CarteGrise carteGrise) {
		this.carteGrise = carteGrise;
	}
	
	public Long getId() {
		return id;
	}
	
}
