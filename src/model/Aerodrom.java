package model;

public class Aerodrom {
	private Integer id;
	private String naziv;
	
	
	public Aerodrom() {
		
	}
	
	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}




	@Override
	public String toString() {
		return "Aerodrom [id=" + id + ", naziv=" + naziv + "]";
	}
	
	
	
	
	
}


