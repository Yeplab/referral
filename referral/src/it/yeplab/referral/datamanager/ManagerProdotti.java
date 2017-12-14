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

	public Prodotto getProdottoById(int idprodotto) {
		Prodotto prodotto = null;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM `rp_prodotti` WHERE `id`=" + idprodotto + ";";
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				prodotto = new Prodotto(res.getInt("id"), res.getString("nome"), res.getString("descrizione"),
						res.getInt("idcategoria"), res.getString("prezzo"), res.getString("provvigione"),
						res.getString("schedatecnica"), res.getString("note"));
			}
			sql = "SELECT `nome` FROM `rp_categoriaprodotto` WHERE `id`=" + prodotto.getIdcategoria() + ";";
			res = statement.executeQuery(sql);
			while (res.next()) {
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
			String sql = "INSERT INTO `rp_prodotti`(`nome`, `descrizione`, `idcategoria`, `prezzo`, `provvigione`,"
					+ " `schedatecnica`, `note`) VALUES ('" + nome + "','" + descrizione + "'," + idcategoria + ",'"
					+ prezzo + "','" + provvigione + "','" + schedatecnica + "','" + note + "')";
			statement.executeUpdate(sql);
			sql = "SELECT MAX(`id`) FROM `rp_prodotti`";
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				id = res.getInt("id");
			}
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
			String sql = "DELETE FROM `rp_prodotti` WHERE `id`=" + idprodotto + ";";
			result = statement.executeUpdate(sql);
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
			String sql = "UPDATE `rp_prodotti` SET `nome`='" + nome + "',`descrizione`='" + descrizione
					+ "',`idcategoria`=" + idcategoria + ",`prezzo`='" + prezzo + "',`provvigione`='" + provvigione
					+ "',`schedatecnica`='" + schedatecnica + "',`note`='" + note + "' WHERE `id`=" + idprodotto + ";";
			result = statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Prodotto> getListaProdottiCategoria(int idcategoria) {
		List<Prodotto> prodotti = new LinkedList<Prodotto>();
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql="SELECT `id` FROM `rp_prodotti` WHERE `idcategoria`="+idcategoria+";";
			ResultSet res=statement.executeQuery(sql);
			statement.close();
			while(res.next()) {
				prodotti.add(getProdottoById(res.getInt("id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prodotti;
	}

}
