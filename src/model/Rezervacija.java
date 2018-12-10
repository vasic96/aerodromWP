package model;

import java.util.Date;

public class Rezervacija {
	private int id;
	private Let polazniLet;
	private Let povratniLet;
	private int sedistePolazni;
	private int sedisteDolazni;
	private Date datumRezervacije;
	private Date datumProdajeKarte;
	private Korisnik korisnik;
	private String imePutnika;
	private String prezimePutnika;
	
	public Rezervacija() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Let getPolazniLet() {
		return polazniLet;
	}

	public void setPolazniLet(Let polazniLet) {
		this.polazniLet = polazniLet;
	}

	public Let getPovratniLet() {
		return povratniLet;
	}

	public void setPovratniLet(Let povratniLet) {
		this.povratniLet = povratniLet;
	}

	public int getSedistePolazni() {
		return sedistePolazni;
	}

	public void setSedistePolazni(int sedistePolazni) {
		this.sedistePolazni = sedistePolazni;
	}

	public int getSedisteDolazni() {
		return sedisteDolazni;
	}

	public void setSedisteDolazni(int sedisteDolazni) {
		this.sedisteDolazni = sedisteDolazni;
	}

	public Date getDatumRezervacije() {
		return datumRezervacije;
	}

	public void setDatumRezervacije(Date datumRezervacije) {
		this.datumRezervacije = datumRezervacije;
	}

	public Date getDatumProdajeKarte() {
		return datumProdajeKarte;
	}

	public void setDatumProdajeKarte(Date datumProdajeKarte) {
		this.datumProdajeKarte = datumProdajeKarte;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public String getImePutnika() {
		return imePutnika;
	}

	public void setImePutnika(String imePutnika) {
		this.imePutnika = imePutnika;
	}

	public String getPrezimePutnika() {
		return prezimePutnika;
	}

	public void setPrezimePutnika(String prezimePutnika) {
		this.prezimePutnika = prezimePutnika;
	}
	
	

}
