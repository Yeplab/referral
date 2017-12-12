package it.yeplab.referral.datamanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import it.yeplab.referral.dbconnection.DBConnectionFactory;
import it.yeplab.referral.domaindata.Agente;

public class ManagerAgenti {

	private Connection connection;

	public ManagerAgenti(Connection connection) {
		this.connection = connection;
	}
	
	public int logIn(String email, String password) {
		int result=-1;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql="SELECT `id` FROM `rp_agenti` WHERE `email`='"+email+"' AND `password`='"+password+"'";
			ResultSet res=statement.executeQuery(sql);
			while(res.next()) {
				result=res.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Agente getAgenteById(int idagente) {
		Agente agente = null;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM `rp_agenti` WHERE `id`=" + idagente + ";";
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				agente = new Agente(res.getInt("id"), res.getString("denominazione"), res.getString("referente"),
						res.getString("dataiscrizione"), res.getString("indirizzo"), res.getString("telefono"),
						res.getString("email"), res.getString("cf"), res.getString("piva"),
						res.getString("mezzopagamento"), res.getString("coordinatepagaento"));
				statement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return agente;
	}

	public int addAgente(String denominazione, String referente, String indirizzo, String telefono, String email,
			String cf, String piva, String mezzopagamento, String coordinatepagamento) {
		int id = -1;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "INSERT INTO `rp_agenti`(`denominazione`, `referente`, `dataiscrizione`, `indirizzo`, `telefono`, `email`, "
					+ "`cf`, `piva`, `mezzopagamento`, `coordinatepagamento`) VALUES ('" + denominazione + "','"
					+ referente + "', NOW() + INTERVAL + " + DBConnectionFactory.TIME_ZONE + " + HOUR ,'" + indirizzo
					+ "','" + telefono + "','" + email + "','" + cf + "','" + piva + "','" + mezzopagamento + "','"
					+ coordinatepagamento + "')";
			statement.executeUpdate(sql);
			sql = "SELECT MAX(`id`) FROM  `rp_agenti`";
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				id = res.getInt("id");
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		return id;
	}

	public int remAgente(int idagente) {
		int result = 0;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "DELETE FROM `rp_agenti` WHERE `id`=" + idagente + ";";
			result = statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		return result;
	}

	public int editAgente(int idagente, String denominazione, String referente, String indirizzo, String telefono,
			String email, String cf, String piva, String mezzopagamento, String coordinatepagamento) {
		int result = 0;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "UPDATE `rp_agenti` SET `denominazione`='" + denominazione + "',`referente`='" + referente
					+ "',`indirizzo`='" + indirizzo + "',`telefono`='" + telefono + "',`email`='" + email + "',`cf`='"
					+ cf + "',`piva`='" + piva + "',`mezzopagamento`='" + mezzopagamento + "',`coordinatepagamento`='"
					+ coordinatepagamento + "' WHERE `id`=" + idagente + ";";
			result = statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Agente> getListaAgenti() {
		List<Agente> lista = new LinkedList<Agente>();
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM `rp_agenti`";
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				lista.add(new Agente(res.getInt("id"), res.getString("denominazione"), res.getString("referente"),
						res.getString("dataiscrizione"), res.getString("indirizzo"), res.getString("telefono"),
						res.getString("email"), res.getString("cf"), res.getString("piva"),
						res.getString("mezzopagamento"), res.getString("coordinatepagaento")));
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public int cambioPassword(int idagente, String vecchiapassword, String nuovapassword) {
		int res=-1;
		Statement statement;
		try {
			statement=connection.createStatement();
			String sql="";
			res=statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}