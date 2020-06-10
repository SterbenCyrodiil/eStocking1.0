package bdcon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelos.fornstru;
import modelos.fornstru;
import modelos.stockstru;
import userinterface.Menu_Login;

public class FornecedoresLigaBD {
	
	public void adicionaFo(fornstru forn) {

		String sql = "INSERT INTO fornecedor (cod_fornecedor, nome, morada, telefone, email, descr) VALUES(?,?,?,?,?,?)";
		
		try {

			PreparedStatement stmt = Menu_Login.myCon.prepareStatement(sql);

			stmt.setString(1, forn.getcod_f());
			stmt.setString(2, forn.getnome());
			stmt.setString(3, forn.getmorada());
			stmt.setString(4, forn.gettelefone());
			stmt.setString(5, forn.getemail());
			stmt.setString(6, forn.getdescr());
			
			stmt.execute();
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	

	}
	
	public fornstru redreg(String cod) {

		fornstru registolido = new fornstru();

		try {

			String selectSQL = "SELECT * FROM fornecedor WHERE cod_fornecedor='" + cod
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
				registolido.setcod_f(rs.getString("cod_fornecedor"));
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

			String selectSQL = "SELECT * from fornecedor WHERE cod_fornecedor='" + cod
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
	
	public void alteradados(fornstru forn) {

		String sql = "UPDATE fornecedor set telefone=?,email=?,morada=?, descr=? where cod_fornecedor=?";
		try {

			PreparedStatement stmt = Menu_Login.myCon.prepareStatement(sql);

			stmt.setString(5, forn.getcod_f());
			stmt.setString(1, forn.gettelefone());
			stmt.setString(2, forn.getemail());
			stmt.setString(3, forn.getmorada());
			stmt.setString(4, forn.getdescr());
			

			System.out.println(stmt.toString());

			stmt.execute();
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}
	
}
