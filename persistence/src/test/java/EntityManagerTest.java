import java.util.Date;


import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import persistence.Appartenance;
import persistence.CarteGrise;
import persistence.Marque;
import persistence.Modele;
import persistence.Particulier;
import persistence.Societe;
import persistence.Type;
import persistence.Vehicule;

@ContextConfiguration ("/fr/istic/cg/applicationContext-persistence.xml")
@RunWith(SpringJUnit4ClassRunner.class)

public class EntityManagerTest {
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Transactional
	public void testEm() {
	    assertTrue(em.isOpen());
	}

	
	@Test 
	@Transactional
	public void TestMarque(){
		final Marque m = new Marque();
		m.setCode("Renault");
		m.setNom("Renault Constructeur");
		em.persist(m);
		em.flush();
		
		final Marque m2 = em.find(Marque.class, "Renault");
		assertNotNull(m2);
		assertEquals(m.getNom(),m2.getNom());
		assertTrue(m2.equals(m));
	}
	
	@Test 
	@Transactional
	public void TestModel(){
		final Modele m = new Modele();
		m.setCode("Clio");
		m.setNom("Renault Clio");
		em.persist(m);
		em.flush();
		
		final Modele m2 = em.find(Modele.class, "Clio");
		assertNotNull(m2);
		assertEquals(m.getNom(),m2.getNom());
		assertTrue(m2.equals(m));
	}
	
	
	@Test 
	@Transactional
	public void TestType(){
		final Type m = new Type();
		m.setCode("HDI");
		m.setNom("Renault Clio HDI");
		em.persist(m);
		em.flush();
		
		final Type m2 = em.find(Type.class, "HDI");
		assertNotNull(m2);
		assertEquals(m.getNom(),m2.getNom());
		assertTrue(m2.equals(m));
	}
	
	@Test 
	@Transactional
	public void TestVehicule(){
		final Vehicule v = new Vehicule();
		v.setNumeroDeSerie("124");
		v.setDateDeMiseEnCirculation(new Date(2010,10,14));
		em.persist(v);
		em.flush();
		
		final Vehicule v2 = em.find(Vehicule.class, "124");
		assertNotNull(v2);
		assertEquals(v.getDateDeMiseEnCirculation(),v2.getDateDeMiseEnCirculation());
		assertTrue(v2.equals(v));
	}

	@Test 
	@Transactional
	public void TestCarteGrise(){
		final CarteGrise cg = new CarteGrise();
		cg.setImmatriculation("124 E 1542 35");
		cg.setPuissance(300);
		em.persist(cg);
		em.flush();
		
		final CarteGrise cg2 = em.find(CarteGrise.class, "124 E 1542 35");
		assertNotNull(cg2);
		assertEquals(cg.getPuissance(),cg2.getPuissance());
		assertTrue(cg2.equals(cg));
	}
	
	@Test
	@Transactional
	public void TestAppartenance(){
		final Appartenance app = new Appartenance();
		//app.setProprietaire(proprietaire);
		app.setDateDebut(new Date(2014, 06, 14));
		app.setDateFin(new Date (2014,10,24));
		em.persist(app);
		em.flush();		
		Long test = app.getId();
		
		final Appartenance app2 = em.find(Appartenance.class,test );
		assertNotNull(app2);
		assertEquals(app.getDateFin(),app2.getDateFin());
		assertTrue(app2.equals(app));
	}
	
	
	
	@Test 
	@Transactional
	public void TestParticulier(){
		final Particulier par = new Particulier();
		par.setAdresse("14 Boulevard du General Leclerc");
		par.setNom("Jean-Philippe");
		par.setPrenom("LESAGE");
		em.persist(par);
		em.flush();
		Long test = par.getId();
		
		final Particulier par2 = em.find(Particulier.class, test );
		assertNotNull(par2);
		assertEquals(par.getAdresse(),par2.getAdresse());
		assertEquals(par.getNom(),par2.getNom());
		assertEquals(par.getPrenom(),par2.getPrenom());
		assertTrue(par2.equals(par));
	}
	
	

	
	
	@Test 
	@Transactional
	public void TestSociete(){
		final Societe soc = new Societe();
		soc.setAdresse("14 Boulevard du General Leclerc");
		soc.setNumeroSiret("123456789");
		soc.setRaisonSociale("Blabla");
		em.persist(soc);
		em.flush();
		
		Long test = soc.getId();
		
		final Societe soc2 = em.find(Societe.class, test);
		assertNotNull(soc2);
		assertEquals(soc.getNumeroSiret(),soc2.getNumeroSiret());
		assertEquals(soc.getRaisonSociale(),soc2.getRaisonSociale());
		assertEquals(soc.getRaisonSociale(),soc2.getRaisonSociale());
		assertTrue(soc2.equals(soc));
	}
	
}
