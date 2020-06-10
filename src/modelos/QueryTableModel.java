package modelos;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import userinterface.Menu_Login;

public class QueryTableModel extends AbstractTableModel {
    Vector cache;
    int colCount;
    String[] headers;

    String db;
    String dbHost;
    String dbLogin;
    String dbPassw;     
    Statement statement;

    public QueryTableModel() {
      cache = new Vector();
    }

    public String getColumnName(int i) {
      return headers[i];
    }

    public int getColumnCount() {
      return colCount;
    }

    public int getRowCount() {
      return cache.size();
    }

    public Object getValueAt(int row, int col) {
      return ((String[]) cache.elementAt(row))[col];
    }

   

    public void setQuery(String query) {
      cache = new Vector();
      try {
        // Execute the query and store the result set and its metadata
   //     Connection con = getConnection();
        
        Statement statement = Menu_Login.myCon.createStatement();
        
        ResultSet rs = statement.executeQuery(query);
        ResultSetMetaData meta = rs.getMetaData();
        colCount = meta.getColumnCount();

        // Rebuild the headers array with the new column names
        headers = new String[colCount];
        for (int h = 1; h <= colCount; h++) {
          headers[h - 1] = meta.getColumnName(h);
          
  //        System.out.print(meta.getColumnName(h));
        }

        while (rs.next()) {
          String[] record = new String[colCount];
          for (int i = 0; i < colCount; i++) {
            record[i] = rs.getString(i + 1);
//            System.out.println(rs.getString(i + 1));
            
          }
          cache.addElement(record);
        }
        fireTableChanged(null);

        

      } catch (Exception e) {
        cache = new Vector(); // blank it out and keep going.
        e.printStackTrace();
      }
    }

    
  }
