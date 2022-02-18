package it.film.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.security.crypto.bcrypt.BCrypt;

import it.film.entity.Film;

public class FilmDaoImp implements FilmDao {

	private EntityManager em = null;
	
	public EntityManager getEm() {
		if(em == null) {
			em = EntityManagerHelper.getEntityManager();
		}
		return em;
	}
	
	
	/**
	 *  Salva un un film
	 * 
	 *  @author  Simone Guidi
	 *  @param  f Film da salvare
	 *  @return  
	 */
	public void salva(Film f) {
		String incassoCriptato = BCrypt.hashpw(f.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCriptato);
		getEm().getTransaction().begin();	// inizia la transazione
		getEm().persist(f);	// inserimento
		getEm().getTransaction().commit();	// termina la transazione
		
	}

	/**
	 * 	Aggiorna un film
	 * 
	 *  @author  Simone Guidi
	 *  @param  f Film da aggiornare
	 *  @return  
	 * @throws Exception 
	 */
	public void aggiorna(Film f) throws Exception {
		String incassoCriptato = BCrypt.hashpw(f.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCriptato);
		Film fi = getEm().find(Film.class, f.getId());
		if(fi == null) {
			throw new Exception("Film non trovato");
		}
		getEm().getTransaction().begin();
		getEm().merge(f);
		getEm().getTransaction().commit();
		
	}

	/**
	 *  Cancella un film
	 * 
	 *  @author  Simone Guidi
	 *  @param  id chiave primaria del film da cancellare
	 *  @return  
	 */
	public void cancella(int id) {
		
		Film fi = trovaById(id);
		getEm().getTransaction().begin();
		getEm().remove(fi);
		getEm().getTransaction().commit();
		
	}
	
	
	/**
	 *  Trova un film tramite id
	 * 
	 *  @author  Simone Guidi
	 *  @param  id chiave primaria del film da trovare
	 *  @return Film ritorna un film
	 */
	public Film trovaById(int id) {
		
		return getEm().find(Film.class, id);
	}

	
	/**
	 *  Mostra la lista di film del regista ricercato
	 * 
	 *  @author  Simone Guidi
	 *  @param  regista Film assegnati al regista cercato
	 *  @return List<Film> Ritorna una lista di film assegnati al regista cercato
	 */
	@SuppressWarnings("unchecked")
	public List<Film> trovaByRegista(String regista) {
		return getEm().createNamedQuery("film.regista").setParameter(1, regista).getResultList();
	
	}

	/**
	 *  Mostra tutti i film presenti
	 * 
	 *  @author  Simone Guidi
	 *  @param  f Film presenti
	 *  @return List<Film> Ritorna una lista di tutti i film presenti
	 */
	@SuppressWarnings("unchecked")
	public List<Film> trovaTutti() {
		
		return getEm().createNamedQuery("film.trovatutti").getResultList();
	}


	

}
