package persistence;
import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class Societe extends Proprietaire{
	@Basic
	String numeroSiret;
	@Basic
	String raisonSociale;
	
	public String getNumeroSiret() {
		return numeroSiret;
	}
	public void setNumeroSiret(String numeroSiret) {
		this.numeroSiret = numeroSiret;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
}
