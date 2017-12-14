package it.yeplab.referral.domaindata;

public class Prodotto {
	
	private int id;
	private String nome;
	private String descrizione;
	private int idcategoria;
	private String nomecategoria;
	private String prezzo;
	private String provvigione;
	private String schedatecnica;
	private String note;
	
	public Prodotto(int id, String nome, String descrizione, int idcategoria, String prezzo,
			String provvigione, String schedatecnica, String note) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.idcategoria = idcategoria;
		this.prezzo = prezzo;
		this.provvigione = provvigione;
		this.schedatecnica = schedatecnica;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public String getNomecategoria() {
		return nomecategoria;
	}

	public void setNomecategoria(String nomecategoria) {
		this.nomecategoria = nomecategoria;
	}

	public String getPrezzo() {
		return prezzo;
	}

	public String getProvvigione() {
		return provvigione;
	}

	public String getSchedatecnica() {
		return schedatecnica;
	}

	public String getNote() {
		return note;
	}

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", idcategoria=" + idcategoria
				+ ", nomecategoria=" + nomecategoria + ", prezzo=" + prezzo + ", provvigione=" + provvigione
				+ ", schedatecnica=" + schedatecnica + ", note=" + note + "]";
	}

}
