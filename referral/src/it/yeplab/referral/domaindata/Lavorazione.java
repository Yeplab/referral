package it.yeplab.referral.domaindata;

import java.util.List;

public class Lavorazione {
	
	private int id;
	private int idagente;
	private String denominazioneagente;
	private int idcliente;
	private String denominazionecliente;
	private String data;
	private String totaleprezzo;
	private String totaleprovvigione;
	private int idstatolavorazione;
	private String nomestatolavorazione;
	private String datamodificalavorazione;
	private int idstatoprovvigione;
	private String nomestatoprovvigione;
	private String datamodificaprovvigione;
	private String fatturaLavorazione;
	private String fatturaProvvigione;
	private List<Prodotto> prodotti;
	
	public Lavorazione(int id, int idagente, String denominazioneagente, int idcliente, String denominazionecliente,
			String data, String totaleprezzo, String totaleprovvigione, int idstatolavorazione,
			String nomestatolavorazione, String datamodificalavorazione, int idstatoprovvigione,
			String nomestatoprovvigione, String datamodificaprovvigione, String fatturaLavorazione,
			String fatturaProvvigione, List<Prodotto> prodotti) {
		super();
		this.id = id;
		this.idagente = idagente;
		this.denominazioneagente = denominazioneagente;
		this.idcliente = idcliente;
		this.denominazionecliente = denominazionecliente;
		this.data = data;
		this.totaleprezzo = totaleprezzo;
		this.totaleprovvigione = totaleprovvigione;
		this.idstatolavorazione = idstatolavorazione;
		this.nomestatolavorazione = nomestatolavorazione;
		this.datamodificalavorazione = datamodificalavorazione;
		this.idstatoprovvigione = idstatoprovvigione;
		this.nomestatoprovvigione = nomestatoprovvigione;
		this.datamodificaprovvigione = datamodificaprovvigione;
		this.fatturaLavorazione = fatturaLavorazione;
		this.fatturaProvvigione = fatturaProvvigione;
		this.prodotti = prodotti;
	}

	public int getId() {
		return id;
	}

	public int getIdagente() {
		return idagente;
	}

	public String getDenominazioneagente() {
		return denominazioneagente;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public String getDenominazionecliente() {
		return denominazionecliente;
	}

	public String getData() {
		return data;
	}

	public String getTotaleprezzo() {
		return totaleprezzo;
	}

	public String getTotaleprovvigione() {
		return totaleprovvigione;
	}

	public int getIdstatolavorazione() {
		return idstatolavorazione;
	}

	public String getNomestatolavorazione() {
		return nomestatolavorazione;
	}

	public String getDatamodificalavorazione() {
		return datamodificalavorazione;
	}

	public int getIdstatoprovvigione() {
		return idstatoprovvigione;
	}

	public String getNomestatoprovvigione() {
		return nomestatoprovvigione;
	}

	public String getDatamodificaprovvigione() {
		return datamodificaprovvigione;
	}

	public String getFatturaLavorazione() {
		return fatturaLavorazione;
	}

	public String getFatturaProvvigione() {
		return fatturaProvvigione;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	@Override
	public String toString() {
		return "Lavorazione [id=" + id + ", idagente=" + idagente + ", denominazioneagente=" + denominazioneagente
				+ ", idcliente=" + idcliente + ", denominazionecliente=" + denominazionecliente + ", data=" + data
				+ ", totaleprezzo=" + totaleprezzo + ", totaleprovvigione=" + totaleprovvigione
				+ ", idstatolavorazione=" + idstatolavorazione + ", nomestatolavorazione=" + nomestatolavorazione
				+ ", datamodificalavorazione=" + datamodificalavorazione + ", idstatoprovvigione=" + idstatoprovvigione
				+ ", nomestatoprovvigione=" + nomestatoprovvigione + ", datamodificaprovvigione="
				+ datamodificaprovvigione + ", fatturaLavorazione=" + fatturaLavorazione + ", fatturaProvvigione="
				+ fatturaProvvigione + ", prodotti=" + prodotti + "]";
	}

}
