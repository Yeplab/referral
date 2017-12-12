package it.yeplab.referral.domaindata;

import java.util.List;

public class Preventivo {
	
	private int id;
	private int idagente;
	private String denominazioneagente;
	private int idcliente;
	private String denominazionecliente;
	private String data;
	private String totaleprezzo;
	private String totaleprovvigione;
	private int idstatopreventivo;
	private String nomestatopreventivo;
	private String datamodifica;
	private String file;
	private List<Prodotto> prodotti;
	
	public Preventivo(int id, int idagente, String denominazioneagente, int idcliente, String denominazionecliente,
			String data, String totaleprezzo, String totaleprovvigione, int idstatopreventivo,
			String nomestatopreventivo, String datamodifica, String file, List<Prodotto> prodotti) {
		super();
		this.id = id;
		this.idagente = idagente;
		this.denominazioneagente = denominazioneagente;
		this.idcliente = idcliente;
		this.denominazionecliente = denominazionecliente;
		this.data = data;
		this.totaleprezzo = totaleprezzo;
		this.totaleprovvigione = totaleprovvigione;
		this.idstatopreventivo = idstatopreventivo;
		this.nomestatopreventivo = nomestatopreventivo;
		this.datamodifica = datamodifica;
		this.file = file;
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

	public int getIdstatopreventivo() {
		return idstatopreventivo;
	}

	public String getNomestatopreventivo() {
		return nomestatopreventivo;
	}

	public String getDatamodifica() {
		return datamodifica;
	}

	public String getFile() {
		return file;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	@Override
	public String toString() {
		return "Preventivo [id=" + id + ", idagente=" + idagente + ", denominazioneagente=" + denominazioneagente
				+ ", idcliente=" + idcliente + ", denominazionecliente=" + denominazionecliente + ", data=" + data
				+ ", totaleprezzo=" + totaleprezzo + ", totaleprovvigione=" + totaleprovvigione + ", idstatopreventivo="
				+ idstatopreventivo + ", nomestatopreventivo=" + nomestatopreventivo + ", datamodifica=" + datamodifica
				+ ", file=" + file + ", prodotti=" + prodotti + "]";
	}
	
}
