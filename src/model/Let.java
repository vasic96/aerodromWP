package model;

import java.util.Date;

public class Let {
	private int id;
	private String broj;
	private Date datumPolaska;
	private Date datumDolaska;
	private Aerodrom polazniAerodrom;
	private Aerodrom dolazniAerodrom;
	private int brojSedista;
	private float cena;
	
	public Let() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public Date getDatumPolaska() {
		return datumPolaska;
	}

	public void setDatumPolaska(Date datumPolaska) {
		this.datumPolaska = datumPolaska;
	}

	public Date getDatumDolaska() {
		return datumDolaska;
	}

	public void setDatumDolaska(Date datumDolaska) {
		this.datumDolaska = datumDolaska;
	}

	public Aerodrom getPolazniAerodrom() {
		return polazniAerodrom;
	}

	public void setPolazniAerodrom(Aerodrom polazniAerodrom) {
		this.polazniAerodrom = polazniAerodrom;
	}

	public Aerodrom getDolazniAerodrom() {
		return dolazniAerodrom;
	}

	public void setDolazniAerodrom(Aerodrom dolazniAerodrom) {
		this.dolazniAerodrom = dolazniAerodrom;
	}

	public int getBrojSedista() {
		return brojSedista;
	}

	public void setBrojSedista(int brojSedista) {
		this.brojSedista = brojSedista;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	@Override
	public String toString() {
		return "Let [id=" + id + ", broj=" + broj + ", datumPolaska=" + datumPolaska + ", datumDolaska=" + datumDolaska
				+ ", polazniAerodrom=" + polazniAerodrom + ", dolazniAerodrom=" + dolazniAerodrom + ", brojSedista="
				+ brojSedista + ", cena=" + cena + "]";
	}
	
	
	
	
	

}
