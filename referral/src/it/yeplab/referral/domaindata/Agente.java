package it.yeplab.referral.domaindata;

public class Agente {
	
	private int id;
	private String denominazione;
	private String referente;
	private String dataiscrizione;
	private String indirizzo;
	private String telefono;
	private String email;
	private String cf;
	private String piva;
	private String mezzopagamento;
	private String coordinatepagamento;
	
	public Agente(int id, String denominazione, String referente, String dataiscrizione, String indirizzo, String telefono, String email,
			String cf, String piva, String mezzopagamento, String coordinatepagamento) {
		super();
		this.id = id;
		this.denominazione = denominazione;
		this.referente = referente;
		this.dataiscrizione=dataiscrizione;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.email = email;
		this.cf = cf;
		this.piva = piva;
		this.mezzopagamento = mezzopagamento;
		this.coordinatepagamento = coordinatepagamento;
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
	
	public String getDataiscrizione() {
		return dataiscrizione;
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

	public String getMezzopagamento() {
		return mezzopagamento;
	}

	public String getCoordinatepagamento() {
		return coordinatepagamento;
	}

	@Override
	public String toString() {
		return "Agente [id=" + id + ", denominazione=" + denominazione + ", referente=" + referente
				+ ", dataiscrizione=" + dataiscrizione + ", indirizzo=" + indirizzo + ", telefono=" + telefono
				+ ", email=" + email + ", cf=" + cf + ", piva=" + piva + ", mezzopagamento=" + mezzopagamento
				+ ", coordinatepagamento=" + coordinatepagamento + "]";
	}

}
