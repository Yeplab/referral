package it.yeplab.referral.domaindata;

public class Stato {
	
	private int id;
	private String nome;
	private String tipo;
	
	public Stato(int id, String nome, String tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo=tipo;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public String getTipo() {
		return tipo;
	}

}
