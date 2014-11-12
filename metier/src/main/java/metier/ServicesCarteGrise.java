package metier;

import java.util.Date; 
import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Component;

import dao.DAOCarteGrise;

//import DAO.DAOCarteGrise;

//import dao.*;
import persistence.*;


@Component
public class ServicesCarteGrise {

	@Autowired
	private DAOCarteGrise carteGriseDAO;

	public CarteGrise creerCarteGrise(String immatriculation, Integer puissance,
			String numSerie, Long idProprietaire)	{
		final CarteGrise cgExistante = carteGriseDAO.lireCarteGrise(immatriculation);
		if (cgExistante == null) {
			final Vehicule v = carteGriseDAO.lireVehicule(numSerie);
			if (v == null) {
				System.err.println("Le véhicule n'existe pas.");
				return null;
			} else {
				final Proprietaire p = carteGriseDAO.lireProprietaire(idProprietaire);
				if (p == null) {
					System.err.println("Le propriétaire n'existe pas.");
					return null;
				} else {
					final CarteGrise nouvelleCarteGrise = new CarteGrise();
					nouvelleCarteGrise.setImmatriculation(immatriculation);
					nouvelleCarteGrise.setPuissance(puissance);
					nouvelleCarteGrise.setVehicule(v);
					final Appartenance app = new Appartenance();
					app.setCarteGrise(nouvelleCarteGrise);
					app.setProprietaire(p);
					app.setDateDebut(new Date());
					app.setDateFin(null);
					nouvelleCarteGrise.getAppartenances().add(app);
					carteGriseDAO.enregistrerCarteGrise(nouvelleCarteGrise);
					return nouvelleCarteGrise;
				}
			}

		} else {
			System.err.println("La carte grise existe déjà...");
				return null;
			}

		}
	
	
	public CarteGrise chercherCarteGrise (String immatriculation){
	
		final CarteGrise cg = carteGriseDAO.lireCarteGrise(immatriculation);
		if (cg == null ) System.err.println("Le vehicule n'est pas dans la base... ");
		return cg;
	}
	
	public Set <CarteGrise> chercherCarteGrise (Proprietaire p){
		// TODO Test 		
		return carteGriseDAO.findCartesGrises(p);	
	}
	
	public CarteGrise updateCarteGrise (CarteGrise cg){
		
		return null; 
	}
}

	

