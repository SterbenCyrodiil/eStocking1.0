package bdcon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelos.entistru;
import modelos.faturastru;
import modelos.fornstru;
import userinterface.Menu_Login;

public class EntLigaBD {

	public void adicionaE(entistru ent) {
	
	String sql = "INSERT INTO entidade (cod_entidade, nome, morada, telefone, email, descr) VALUES(?,?,?,?,?,?)";
	
	try {

		PreparedStatement stmt = Menu_Login.myCon.prepareStatement(sql);

		stmt.setString(1, ent.getcod_e());
		stmt.setString(2, ent.getnome());
		stmt.setString(3, ent.getmorada());
		stmt.setString(4, ent.gettelefone());
		stmt.setString(5, ent.getemail());
		stmt.setString(6, ent.getdescr());
		
		stmt.execute();
		stmt.close();

	} catch (SQLException u) {
		throw new RuntimeException(u);
	}


}
	
	public entistru redreg(String cod) {

		entistru registolido = new entistru();

		try {

			String selectSQL = "SELECT * FROM entidade WHERE cod_entidade='" + cod
					+ "'";

			Statement stmt = Menu_Login.myCon.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(selectSQL);

			rs.last();
			int count = rs.getRow();
			if (count == 0) {

			} else {
				rs.beforeFirst();
				rs.next();
				registolido.setcod_e(rs.getString("cod_entidade"));
				registolido.setnome(rs.getString("nome"));
				registolido.setmorada(rs.getString("morada"));
				registolido.settelefone(rs.getString("telefone")); 
				registolido.setemail(rs.getString("email"));
				registolido.setdescr(rs.getString("descr"));
				
				
			}

			return registolido;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean verificaF(String cod) {

		try {

			String selectSQL = "SELECT * from entidade WHERE cod_entidade='" + cod
					+ "'";
			Statement stmt = Menu_Login.myCon.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(selectSQL);

			rs.last();
			int count = rs.getRow();

			// System.out.println("Q:"+selectSQL+" devolve "+count);

			if (count == 0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void alteradados(entistru ent) {

		String sql = "UPDATE entidade set telefone=?,email=?,morada=?, descr=? where cod_entidade=?";
		try {

			PreparedStatement stmt = Menu_Login.myCon.prepareStatement(sql);

			stmt.setString(5, ent.getcod_e());
			stmt.setString(1, ent.gettelefone());
			stmt.setString(2, ent.getemail());
			stmt.setString(3, ent.getmorada());
			stmt.setString(4, ent.getdescr());
			

			System.out.println(stmt.toString());

			stmt.execute();
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}
	
}
