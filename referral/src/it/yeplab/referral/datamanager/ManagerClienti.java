package it.yeplab.referral.datamanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.State;

import it.yeplab.referral.domaindata.Cliente;

public class ManagerClienti {

	private Connection connection;

	public Cliente getClienteById(int idcliente) {
		Cliente cliente = null;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "SELECT * FROM `rp_clienti` WHERE `id`=" + idcliente + ";";
			ResultSet res = statement.executeQuery(sql);
			while (res.next()) {
				cliente = new Cliente(res.getInt("id"), res.getString("denominazione"), res.getString("referente"),
						res.getString("indirizzo"), res.getString("telefono"), res.getString("email"),
						res.getString("cf"), res.getString("piva"), res.getInt("idagente"), res.getString("note"));
			}
			sql = "SELECT `denominazione` FROM `rp_agenti` WHERE `id`=" + cliente.getIdagente() + ";";
			res = statement.executeQuery(sql);
			while (res.next()) {
				cliente.setDenominazioneagente(res.getString("denominazione"));
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}

	public int addCliente(String denominazione, String referente, String indirizzo, String telefono, String email,
			String cf, String piva, int idagente, String note) {
		int id = -1;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "INSERT INTO `rp_clienti`(`denominazione`, `referente`, `indirizzo`, `telefono`, `email`, `cf`, `piva`, `idagente`, `note`) VALUES ('"
					+ denominazione + "','" + referente + "','" + indirizzo + "','" + telefono + "','" + email + "','"
					+ cf + "','" + piva + "'," + idagente + ",'" + note + "')";
			statement.executeUpdate(sql);
			sql = "SELECT MAX(`id`) FROM `rp_clienti`";
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

	public int remCliente(int idcliente) {
		int result = -1;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "DELETE FROM `rp_clienti` WHERE `id`=" + idcliente + ";";
			result = statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int editCliente(int idcliente, String denominazione, String referente, String indirizzo, String telefono,
			String email, String cf, String piva, int idagente, String note) {
		int result = -1;
		Statement statement;
		try {
			statement = connection.createStatement();
			String sql = "UPDATE `rp_clienti` SET `denominazione`='" + denominazione + "',`referente`='" + referente
					+ "',`indirizzo`='" + indirizzo + "',`telefono`='" + telefono + "',`email`='" + email + "',`cf`='"
					+ cf + "',`piva`='" + piva + "',`idagente`=" + idagente + ",`note`='" + note + "' WHERE `id`="
					+ idcliente + ";";
			result = statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Cliente> getListaClientiAgente(int idagente){
		List<Cliente> clienti=new LinkedList<Cliente>();
		Statement statement;
		try {
			statement=connection.createStatement();
			String sql="SELECT `id` FROM `rp_clienti` WHERE `idagente`="+idagente+";";
			ResultSet res=statement.executeQuery(sql);
			statement.close();
			while(res.next()) {
				clienti.add(getClienteById(res.getInt("id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clienti;
	}

}
