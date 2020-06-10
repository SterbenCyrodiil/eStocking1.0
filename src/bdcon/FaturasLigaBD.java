package bdcon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelos.faturastru;
import modelos.stockstru;
import userinterface.Menu_Login;

public class FaturasLigaBD {
	
	public void adicionaF(faturastru fatura) {

		String sql = "INSERT INTO faturas (codigo, nome, cod_categ, ref, cod_ent, valor, moeda, data) VALUES(?,?,?,?,?,?,?,?)";

		try {

			PreparedStatement stmt = Menu_Login.myCon.prepareStatement(sql);

			stmt.setInt(1, fatura.getcod_fa());
			stmt.setString(2, fatura.getnome());
			stmt.setInt(3, fatura.getcod_c());
			stmt.setString(4, fatura.getref());
			stmt.setString(5, fatura.getcod_e());
			stmt.setInt(6, fatura.getvalor());
			// 8 Data;
			stmt.setString(7, fatura.getmoeda());
			stmt.setString(8, fatura.getdata());
			stmt.execute();
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

	}
	
	public faturastru redreg(String cod) {

		faturastru registolido = new faturastru();

		try {

			String selectSQL = "SELECT * FROM faturas WHERE codigo='" + cod
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
				registolido.setcod_fa(rs.getInt("codigo"));
				registolido.setnome(rs.getString("nome"));
				registolido.setcod_e(rs.getString("cod_ent"));
				registolido.setcod_c(rs.getInt("cod_categ"));
				registolido.setref(rs.getString("ref"));
				registolido.setvalor(rs.getInt("valor"));
				registolido.setmoeda(rs.getString("moeda"));
				
			}

			return registolido;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean verificaS(String cod) {

		try {

			String selectSQL = "SELECT * from faturas WHERE codigo='" + cod
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
	
}
