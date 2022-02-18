package it.film.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.film.dao.FilmDao;
import it.film.dao.FilmDaoImp;
import it.film.entity.Film;

@RestController
@RequestMapping("/film")
@Api(value = "FilmRest", tags = "Gestione film")
public class FilmRest {

	FilmDao fd = new FilmDaoImp();
	Logger log = LoggerFactory.getLogger(getClass());
	
	@PostMapping
	@ApiOperation(value = "inserimento film", notes = "Permette di inserire un film")
	public ResponseEntity<String> inserisciFilm(@RequestBody Film f) {
		try {
			fd.salva(f);
			return new ResponseEntity<String>("Film inserito con successo", HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<String>("Film NON inserito", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "aggiorna film", notes = "Permette di aggiornare")
	public ResponseEntity<String> aggiornaFilm(@RequestBody Film f, @PathVariable int id) {
		f.setId(id);
		try {
			fd.aggiorna(f);
			return new ResponseEntity<String>("Film aggiornato correttamente", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Film NON aggiornato", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "cancellazione cittadino", notes = "Permette di cancellare un film")
	public ResponseEntity<String> cancellaFilm(@PathVariable int id) {
		try {
			fd.cancella(id);
			return new ResponseEntity<String>("Film cancellato con successo", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Film NON cancellato", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	@ApiOperation(value = "lista film", notes = "Permette di visualizzare la lista di tutti i film")
	public ResponseEntity<List<Film>> getAllFilm() {
		try {
			return new ResponseEntity<List<Film>>(fd.trovaTutti(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Film>>(fd.trovaTutti(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{regista}")
	@ApiOperation(value = "trova film regista", notes = "Trova i film di un regista")
	public ResponseEntity<List<Film>> getByRegista(@PathVariable String regista) {
		try {
			return new ResponseEntity<List<Film>>(fd.trovaByRegista(regista), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Film>>((List<Film>) null, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	
	
	
}
