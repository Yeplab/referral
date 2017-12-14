package it.yeplab.referral.datamanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import it.yeplab.referral.domaindata.Stato;

public class ManagerStati {

	private Connection connection;

	public static String LAVORAZIONE = "`rp_statolavorazione`";
	public static String PREVENTIVO = "`rp_statopreventivo`";
	public static String PROVVIGIONE = "`rp_statoprovvigione`";

	public Stato getStatoById(int idstato, String tipo) {
		Stato stato = null;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM " + tipo + " WHERE `id`=" + idstato + ";";
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				stato = new Stato(idstato, res.getString("nome"), tipo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stato;
	}

	public int addStato(int idstato, String nome, String tipo) {
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "INSERT INTO " + tipo + "(`id`, `nome`) VALUES (" + idstato + ",'" + nome + "')";
			statement.executeQuery(sql);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idstato;
	}

	public int remStato(int idstato, String tipo) {
		int result = -1;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "DELETE FROM " + tipo + " WHERE `id`=" + idstato + ";";
			result = statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int editStato(int oldidstato, int newidstato, String nome, String tipo) {
		int result = -1;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "UPDATE " + tipo + " SET `id`=" + newidstato + ",`nome`='" + nome + "' WHERE `id`="
					+ oldidstato + ";";
			result = statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Stato> getListaStati(String tipo){
		List<Stato> stati=new LinkedList<Stato>();
		Statement statement;
		try {
			statement=connection.createStatement();
			String sql="SELECT * FROM "+tipo+";";
			ResultSet res=statement.executeQuery(sql);
			while(res.next()) {
				stati.add(new Stato(res.getInt("id"), res.getString("nome"), tipo));
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return stati;
	}

}
