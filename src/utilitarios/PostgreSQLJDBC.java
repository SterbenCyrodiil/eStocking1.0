package utilitarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreSQLJDBC {
   
	public static Connection liga_pgs(String usr,String pwd) throws FileNotFoundException {
      Connection con = null;
      
   //   System.out.println("["+usr+"]");
   //   System.out.println("["+pwd+"]");
      
      
      
      try {
         
    	  DriverManager.registerDriver(new org.postgresql.Driver());   
    	  Class.forName("org.postgresql.Driver");
         con = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/eStockingTeste1",
            usr, pwd);
         
         System.out.println(con);
         System.out.println("Ligou!");
         return con;
                       
      } catch (Exception e) {
         e.printStackTrace();
         
         File file = new File("c:\\x\\test.txt");  
         FileOutputStream fis = new FileOutputStream(file);  
         PrintStream out = new PrintStream(fis);  
         System.setOut(out);  
         System.out.println(e.getClass().getName()+": "+e.getMessage());  
         
         ClassLoader loader = PostgreSQLJDBC.class.getClassLoader();
         //System.out.println("x:"+loader.getResource("PostgreSQLJDBC.class"));
         System.out.println(loader.getResource("src/PostgreSQLJDBC.class"));
         
         System.out.println(""+System.getProperty("java.class.path"));
         
         System.err.println(e.getClass().getName()+": "+e.getMessage());
      
 //   	  EcraLogin.txtNewLabel=e.getClass().getName()+": "+e.getMessage();
    	      	  
         return null;
         
      }
      
   }
}