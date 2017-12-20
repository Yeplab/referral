package it.yeplab.referral.datamanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import it.yeplab.referral.domaindata.Prodotto;

public class ManagerProdotti {

	private Connection connection;
	
	public static String LAVORAZIONE = "`rp_prodottolavorazione`";
	public static String PREVENTIVO = "`rp_prodottopreventivo`";
	public static String AGENTE = "`rp_prodottoagente`";
	public static String ADMIN = "`rp_prodotto`";

	public ManagerProdotti(Connection connection) {
		super();
		this.connection = connection;
	}

	public Prodotto getProdottoById(int idprodotto, String tipo, int idtipo) {
		Prodotto prodotto = null;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM `rp_prodotti` WHERE `id`="+idprodotto+";";
			ResultSet res=statement.executeQuery(sql);
			while(res.next()) {
				prodotto=new Prodotto(res.getInt("id"), res.getString("nome"), res.getString("descrizione"), res.getInt("idcategoria"), res.getString("prezzo"), res.getString("provvigione"), res.getString("schedatecnica"), res.getString("note"));
			}
			if(tipo.equals(AGENTE)) {
				sql = "SELECT `prezzo`, `provvigione` FROM `rp_prodottoagente` WHERE `idprodotto`="+idprodotto+" AND `idagente`="+idtipo+";";
				res=statement.executeQuery(sql);
				while(res.next()) {
					prodotto.setPrezzo(res.getString("prezzo"));
					prodotto.setProvvigione(res.getString("provvigione"));
				}
			}
			if(tipo.equals(PREVENTIVO)) {
				sql = "SELECT `prezzo`, `provvigione` FROM `rp_prodottopreventivo` WHERE `idprodotto`="+idprodotto+" AND `idpreventivo`="+idtipo+";";
				res=statement.executeQuery(sql);
				while(res.next()) {
					prodotto.setPrezzo(res.getString("prezzo"));
					prodotto.setProvvigione(res.getString("provvigione"));
				}
			}
			if(tipo.equals(LAVORAZIONE)) {
				sql = "SELECT `prezzo`, `provvigione` FROM `rp_prodottolavorazione` WHERE `idprodotto`="+idprodotto+" AND `idlavorazione`="+idtipo+";";
				res=statement.executeQuery(sql);
				while(res.next()) {
					prodotto.setPrezzo(res.getString("prezzo"));
					prodotto.setProvvigione(res.getString("provvigione"));
				}
			}
			sql="SELECT `nome` FROM `rp_categoriaprodotto` WHERE `id`="+prodotto.getIdcategoria()+";";
			res=statement.executeQuery(sql);
			while(res.next()) {
				prodotto.setNomecategoria(res.getString("nome"));
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prodotto;
	}

	public int addProdotto(String nome, String descrizione, int idcategoria, String prezzo, String provvigione,
			String schedatecnica, String note) {
		int id = -1;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "";
			//TODO nuovo prodotto
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public int addProdottoSpecifico(int idprodotto, String tipo, int idtipo) {
		int id = -1;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "";
			//TODO aggiunge prodotto specifico per agente, preventivo, lavorazione
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public int remProdotto(int idprodotto) {
		int result = -1;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "";
			//TODO cancella prodotto
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int editProdotto(int idprodotto, String nome, String descrizione, int idcategoria, String prezzo,
			String provvigione, String schedatecnica, String note) {
		int result = -1;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "";
			//TODO modifica prodotto
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Prodotto> getListaProdottiCategoria(int idcategoria, String tipo, int idtipo) {
		List<Prodotto> prodotti = new LinkedList<Prodotto>();
		String nomecategoria="";
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql="SELECT `nome` FROM `rp_categoriaprodotto` WHERE `id`="+idcategoria+";";
			ResultSet res=statement.executeQuery(sql);
			while(res.next()) {
				nomecategoria=res.getString("nome");
			}
			sql="SELECT * FROM `rp_prodotti` WHERE `idcategoria`="+idcategoria+";";
			res=statement.executeQuery(sql);
			while(res.next()) {
				Prodotto p=new Prodotto(res.getInt("id"), res.getString("nome"), res.getString("descrizione"), res.getInt("idcategoria"), res.getString("prezzo"), res.getString("provvigione"), res.getString("schedatecnica"), res.getString("note"));
				if(tipo.equals(AGENTE)) {
					sql="SELECT `prezzo`, `provvigione` FROM `rp_prodottoagente` WHERE `idprodotto`="+p.getId()+" AND `idagente`="+idtipo+";";
					ResultSet r=statement.executeQuery(sql);
					while(r.next()) {
						p.setPrezzo(res.getString("prezzo"));
						p.setProvvigione(res.getString("provvigione"));
					}
				}
				p.setNomecategoria(nomecategoria);
				prodotti.add(p);
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prodotti;
	}

}
