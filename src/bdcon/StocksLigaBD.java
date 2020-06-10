package bdcon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import userinterface.Menu_Login;
import modelos.stockregis;
import modelos.stockstru;


public class StocksLigaBD {

	public void adicionaS(stockstru stock) {

		String sql = "INSERT INTO Stocks (codigo, nome, descr, cod_categ, quantidade, prec, cod_fornecedor, moeda, unidade) VALUES(?,?,?,?,?,?,?,?,?)";

		try {

			PreparedStatement stmt = Menu_Login.myCon.prepareStatement(sql);

			stmt.setInt(1, stock.getcods());
			stmt.setString(2, stock.getnome());
			stmt.setString(3, stock.gettexto());
			stmt.setInt(4, stock.getcod_c());
			stmt.setInt(5, stock.getquantidade());
			stmt.setDouble(6, stock.getprec());
			stmt.setString(7, stock.getcod_f());
			stmt.setString(8, stock.getmoeda());
			stmt.setString(9, stock.getunidade());

			stmt.execute();
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public void registo(stockregis stock) {

		String sql = "INSERT INTO registos (cod_reg, cod_produto, dataen, quantidade, prec, tipo) VALUES(?,?,?,?,?,?)";

		try {

			PreparedStatement stmt = Menu_Login.myCon.prepareStatement(sql);

			stmt.setInt(1, stock.getcodr());
			stmt.setString(2, stock.getcodp());
			stmt.setString(3, stock.getdata());
			stmt.setInt(4, stock.getquantidade());
			stmt.setDouble(5, stock.getprec());
			stmt.setString(6, stock.gettipo());

			stmt.execute();
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public void alteradados(stockstru stock) {

		String sql = "UPDATE stocks set nome=?,descr=?,cod_categ=? where cod=?";
		try {

			PreparedStatement stmt = Menu_Login.myCon.prepareStatement(sql);

			stmt.setInt(4, stock.getcods());
			stmt.setString(1, stock.getnome());
			stmt.setString(2, stock.gettexto());
			stmt.setInt(3, stock.getcod_c());

			System.out.println(stmt.toString());

			stmt.execute();
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public void alteravalores(stockstru stock) {

		String sql = "UPDATE stocks set prec=?, quantidade=? where codigo=?";
		try {

			PreparedStatement stmt = Menu_Login.myCon.prepareStatement(sql);

			stmt.setInt(3, stock.getcods());
			stmt.setDouble(1, stock.getprec());
			stmt.setInt(2, stock.getquantidade());

			System.out.println(stmt.toString());

			stmt.execute();
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public void retirastocks(stockstru stock) {

		String sql = "UPDATE stocks set quantidade=? where codigo=?";
		try {

			PreparedStatement stmt = Menu_Login.myCon.prepareStatement(sql);

			stmt.setInt(2, stock.getcods());
			stmt.setInt(1, stock.getquantidade());

			System.out.println(stmt.toString());

			stmt.execute();
			stmt.close();

		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public stockstru redreg(String cod) {

		stockstru registolido = new stockstru();

		try {

			String selectSQL = "SELECT * FROM stocks WHERE codigo='" + cod
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
				registolido.setcods(rs.getInt("codigo"));
				registolido.setnome(rs.getString("nome"));
				registolido.settexto(rs.getString("descr"));
				registolido.setcod_c(rs.getInt("cod_categ"));
				registolido.setquantidade(rs.getInt("quantidade"));
				registolido.setprec(rs.getDouble("prec"));
				registolido.setmoeda(rs.getString("moeda"));
				registolido.setunidade(rs.getString("unidade"));
				registolido.setcod_f(rs.getString("cod_fornecedor"));
			}

			return registolido;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean verificaS(String cod) {

		try {

			String selectSQL = "SELECT * from stocks WHERE codigo='" + cod
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

	public Boolean apaga(String pcod) {
		try {

			String selectSQL = "DELETE from stocks WHERE codigo='" + pcod + "'";
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
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public stockregis redregis() {

		stockregis registolido = new stockregis();

		try {

			String selectSQL = "SELECT * FROM registos WHERE cod_reg=(select max(cod_reg) from registos)";

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
				registolido.setcodr(rs.getInt("cod_reg"));
		/*		registolido.setnome(rs.getString("nome"));
				registolido.settexto(rs.getString("descr"));
				registolido.setcod_c(rs.getInt("cod_categ"));
				registolido.setquantidade(rs.getInt("quantidade"));
				registolido.setprec(rs.getInt("prec"));
				registolido.setmoeda(rs.getString("moeda"));
				registolido.setunidade(rs.getString("unidade"));
				registolido.setcod_f(rs.getString("cod_fornecedor")); */
			}

			return registolido;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public stockstru redmax(String cod) {

		stockstru registolido = new stockstru();

		try {

			String selectSQL = "SELECT * FROM stocks WHERE quantidade=(select max(quantidade) from stocks)";

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
				registolido.setcods(rs.getInt("codigo"));
				registolido.setnome(rs.getString("nome"));
				registolido.settexto(rs.getString("descr"));
				registolido.setcod_c(rs.getInt("cod_categ"));
				registolido.setquantidade(rs.getInt("quantidade"));
				registolido.setprec(rs.getDouble("prec"));
				registolido.setmoeda(rs.getString("moeda"));
				registolido.setunidade(rs.getString("unidade"));
				registolido.setcod_f(rs.getString("cod_fornecedor"));
			}

			return registolido;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
