package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc3DML_SQL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1879");
			
		 Statement st= con.createStatement();	
		 
		 
		 /*=======================================================================
		  ORNEK1: Bolumler tablosuna yeni bir kayit (80, 'ARGE', 'ISTANBUL') 
		  ekleyelim 
		========================================================================*/
		 
//		 int s1=st.executeUpdate("INSERT INTO bolumler VALUES(91, 'ARGE2','CORLU')");
//		 
//		 System.out.println(s1);
//		 
		
		
		 /*=======================================================================
	      ORNEK2: Bolumler tablosuna birden fazla yeni kayıt ekleyelim.
	     ========================================================================*/ 
	    
	    // 1.YONTEM
	 	// -----------------------------------------------
	 	// Ayri ayri sorgular ile veritabanina tekrar tekrar ulasmak islemlerin 
	 	// yavas yapilmasina yol acar. 10000 tane veri kaydi yapildigi dusunuldugunde
	    // bu kotu bir yaklasimdir.
		 
		 
//		 String sorgular []= { "INSERT INTO bolumler VALUES(95, 'YEMEKHANE', 'ISTANBUL')",
//				 
//    	  "INSERT INTO bolumler VALUES(85, 'OFIS','ANKARA')",
//    	  
//    	  "INSERT INTO bolumler VALUES(75, 'OFIS2', 'VAN')"};
//		 
//		 int count=0;
//		 for (String each : sorgular) {
//			 
//			 st.executeUpdate(each);
//			 count++;
//			
//		}
//		 System.out.println("Waooowww"+"\n"+count+"satir eklendi");
//		 
//		 
		 
		// 2.YONTEM (addBath ve excuteBatch() metotlari ile)
		 	// ----------------------------------------------------
		 	// addBatch metodu ile SQL ifadeleri gruplandirilabilir ve exucuteBatch()
		 	// metodu ile veritabanina bir kere gonderilebilir.
		 	// excuteBatch() metodu bir int [] dizi dondurur. Bu dizi her bir ifade sonucunda 
		 	// etkilenen satir sayisini gosterir. 
			
//		 	String [] sorgular1 = {"INSERT INTO bolumler VALUES(81, 'YEMEKHANE2', 'MUS')",
//		 		            	  "INSERT INTO bolumler VALUES(82, 'OFIS3','ORDU')",
//		 		            	  "INSERT INTO bolumler VALUES(83, 'OFIS4', 'MUGLA')"};
//		 
//		 
//		 for (String w : sorgular1) {
//			 
//			 st.addBatch(w);  // verileri toplar.(bir arada tutar)
//		}
//		 
//		st.executeBatch();   //verileri bir seferde yollar
//		System.out.println("Cappiccino");
//		
		
		// 3. YONTEM
	 	//-----------------------------------------------------
	 	// batch metoduyla birlikte PreparedStatement kullanmak en efektif yontemdir.
	 	// bir sonraki ornekte bunu gerceklestirecegiz.
		
		
		
		 
		 
		 
		 
		 
		
		
		
	}

}
