package it.yeplab.referral.datamanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import it.yeplab.referral.domaindata.Categoria;

public class ManagerCategorie {
	
	private Connection connection;
	
	public ManagerCategorie(Connection connection) {
		super();
		this.connection = connection;
	}

	public Categoria getCategoriaById(int idcategoria) {
		Categoria categoria=null;
		Statement statement;
		try {
			statement=connection.createStatement();
			String sql="SELECT * FROM `rp_categoriaprodotto` WHERE `id`="+idcategoria+";";
			ResultSet res=statement.executeQuery(sql);
			while(res.next()) {
				categoria=new Categoria(res.getInt("id"), res.getString("nome"));
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoria;
	}
	
	public int addCategoria(int idcategoria, String nome) {
		Statement statement;
		try {
			statement=connection.createStatement();
			String sql="INSERT INTO `rp_categoriaprodotto`(`id`, `nome`) VALUES ("+idcategoria+",'"+nome+"')";
			statement.executeQuery(sql);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idcategoria;
	}
	
	public int remCategoria(int idcategoria) {
		int result=-1;
		Statement statement;
		try {
			statement=connection.createStatement();
			String sql="DELETE FROM `rp_categoriaprodotto` WHERE `id`="+idcategoria+";";
			result=statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int editCategoria(int oldidcategoria, int newidcategoria, String nome) {
		int result=-1;
		Statement statement;
		try {
			statement=connection.createStatement();
			String sql="UPDATE `rp_categoriaprodotto` SET `id`="+newidcategoria+",`nome`='"+nome+"' WHERE `id`="+oldidcategoria+";";
			result=statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Categoria> getListaCategorie() {
		List<Categoria> categorie=new LinkedList<Categoria>();
		Statement statement;
		try {
			statement=connection.createStatement();
			String sql="SELECT * FROM `rp_categoriaprodotto`";
			ResultSet res=statement.executeQuery(sql);
			while(res.next()) {
				categorie.add(new Categoria(res.getInt("id"), res.getString("nome")));
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categorie;
	}

}
