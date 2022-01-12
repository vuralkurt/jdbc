package techproed.jdbcOrnekler;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc2Query02_Sorgu {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection kon =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1879");
		
		Statement st= kon.createStatement();	
		
		/*=======================================================================
//		 ORNEK1: Bolumler tablosundaki tum kayitlari listeleyen bir sorgu yaziniz.
//		========================================================================*/ 
		
	    ResultSet tablo1=	st.executeQuery("select*from bolumler");
		
		while (tablo1.next()) {
			
			System.out.println(tablo1.getInt(1)+" "+tablo1.getString(2)+" "+tablo1.getString("konum"));
			
		}
		
		System.out.println("============================");
		
		
//		/*=======================================================================
//		 ORNEK2: SATIS ve MUHASEBE bolumlerinde calisan personelin isimlerini ve 
//		 maaslarini, maas ters sirali olarak listeleyiniz
//		========================================================================*/ 
		
	   ResultSet tablo2=st.executeQuery("select isim,maas from personel where bolum_id in(10,30)  order by maas desc");
		
		
		while (tablo2.next()) {
			
			System.out.println(tablo2.getString(1)+" "+tablo2.getString(2));
			
		}
		
		
		
		System.out.println("=====================================");
		
		
//		/*=======================================================================
//		  ORNEK3: Tüm bolumlerde calisan personelin isimlerini, bolum isimlerini 
//		  ve maaslarini, bolum ve maas sirali listeleyiniz. NOT: calisani olmasa 
//		  bile bolum ismi gosterilmelidir.
//		========================================================================*/ 
//	
       
		ResultSet tablo3=  st.executeQuery("select b.bolum_isim, p.isim, p.maas from bolumler b left join personel p "
				  + " on p.bolum_id=b.bolum_id "
				  + " ORDER BY b.bolum_isim, p.maas");
				
				
				 while(tablo3.next()) {
				System.out.println(tablo3.getString(1) + "\t" + tablo3.getString(2)+"\t"+ tablo3.getInt(3));	 
					 
					 
			 }
				 
				 
				 
				 
				 
			System.out.println("==================================================================");	
			
			
				 
				 /*=======================================================================
//				  ORNEK4: Maasi en yuksek 10 kisinin bolumunu,adini ve maasini listeyiniz
//				========================================================================*/ 
				 
				 
			ResultSet tablo4= st.executeQuery("select b.bolum_isim ,p.isim, p.maas from personel p left join bolumler b"
					 + " on p.bolum_id=b.bolum_id"
					 + " ORDER BY maas DESC"
					 + " limit 10");
					 
					 while(tablo4.next()) {
						 System.out.println(tablo4.getString(1)+" "+tablo4.getString(2)+" "+ tablo4.getInt(3));
						 
					 }
				 
				 
			        kon.close();
					st.close();
					tablo1.close();
					tablo2.close();
					tablo3.close();
					tablo4.close();	
				 
		
		
		
	}

}
