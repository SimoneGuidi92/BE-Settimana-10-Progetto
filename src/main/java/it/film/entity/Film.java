package it.film.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(name = "film.trovatutti", query = "SELECT f FROM Film f")
@NamedQuery(name = "film.regista", query = "SELECT f FROM Film f WHERE f.regista = ?1")
public class Film {
	
	private int id;
	private String titolo;
	private int anno;
	private String regista;
	private String tipo;
	private String incasso;
	
	
	
	// getters e setters
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "titolo")
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	@Column(name = "anno")
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	@Column(name = "regista")
	public String getRegista() {
		return regista;
	}
	public void setRegista(String regista) {
		this.regista = regista;
	}
	@Column(name = "tipo")
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Column(name = "incasso")
	public String getIncasso() {
		return incasso;
	}
	public void setIncasso(String incasso) {
		this.incasso = incasso;
	}
	
	
	
}
