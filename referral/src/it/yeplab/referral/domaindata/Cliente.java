package it.yeplab.referral.domaindata;

public class Cliente {
	
	private int id;
	private String denominazione;
	private String referente;
	private String indirizzo;
	private String telefono;
	private String email;
	private String cf;
	private String piva;
	private int idagente;
	private String denominazioneagente;
	private String note;
	
	public Cliente(int id, String denominazione, String referente, String indirizzo, String telefono, String email,
			String cf, String piva, int idagente, String note) {
		super();
		this.id = id;
		this.denominazione = denominazione;
		this.referente = referente;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.email = email;
		this.cf = cf;
		this.piva = piva;
		this.idagente = idagente;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public String getReferente() {
		return referente;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public String getCf() {
		return cf;
	}

	public String getPiva() {
		return piva;
	}

	public int getIdagente() {
		return idagente;
	}

	public String getDenominazioneagente() {
		return denominazioneagente;
	}

	public void setDenominazioneagente(String denominazioneagente) {
		this.denominazioneagente = denominazioneagente;
	}

	public String getNote() {
		return note;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", denominazione=" + denominazione + ", referente=" + referente + ", indirizzo="
				+ indirizzo + ", telefono=" + telefono + ", email=" + email + ", cf=" + cf + ", piva=" + piva
				+ ", idagente=" + idagente + ", denominazioneagente=" + denominazioneagente + ", note=" + note + "]";
	}

}
