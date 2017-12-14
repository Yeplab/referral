package it.yeplab.referral.domaindata;

public class Categoria {
	
	private int id;
	private String nome;
	
	public Categoria(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
