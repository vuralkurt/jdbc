package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class Jdbc4CRUD_sql {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1879");
			
			Statement st= con.createStatement();	
		
		
			
			/*=======================================================================
			  ORNEK1: urunler adinda bir tablo olusturalim id int, 
			  isim VARCHAR(10) fiyat int 
			========================================================================*/ 
	
//		st.execute("CREATE TABLE urunler("
//			       + " id int,"
//			       + " isim VARCHAR(10),"
//			       + " fiyat double)");	
//		System.out.println("Oleyyyy");
//		
			
			
			
			
		/*=======================================================================
		 ORNEK2: urunler tablosuna asagidaki kayitlari toplu bir sekilde ekleyelim
		========================================================================*/ 
			
			
			
		// Cok miktarda kayit eklemek icin PreparedStatement metodu kullanilabilir. 
		// PreparedStatement hem hizli hem de daha guvenli (SQL injection saldirilari icin) bir yontemdir. 
		// Bunun icin; 
		// 	1) Veri girisine uygun bir POJO(Plain Old Java Object) sinifi olusturulur.
		// 	2) POJO Class nesnelerini saklayacak bir collection olusturulur
		// 	3) bir dongu ile kayitlar eklenir. 	
			
//		List<Urun> kayitlar=new ArrayList<Urun>();
//		
//		kayitlar.add(new Urun(101,"laptop", 6500));
//		kayitlar.add(new Urun(102,"PC", 4500));
//		kayitlar.add(new Urun(103,"Telefon", 4500));
//		kayitlar.add(new Urun(104,"Anakart", 1500));
//		kayitlar.add(new Urun(105,"Klavye", 200));
//		kayitlar.add(new Urun(106,"Fare", 100));
//			
//		
//		con.prepareStatement("insert into urunler values(?,?,?)");	// gizli alan actirip 3 sutunluk veri icn 3 tane
//																	// ? acar.Varrags gibi davranabilir.
//		
//		PreparedStatement  veri =	con.prepareStatement("INSERT INTO urunler VALUES(?,?,?)");
//		
//		for (Urun each : kayitlar) {
//			veri.setInt(1, each.getId());
//			veri.setString(2, each.getIsim());
//			veri.setDouble(3, each.getFiyat());
//			veri.addBatch();
//		}
//		veri.executeBatch();
//		System.out.println("Tulay nolur evine dönnnn");
//		
//		
//		
//		
//		/*=======================================================================
//		  ORNEK3: urunler tablosundaki PC'nin fiyatini %10 zam yapiniz
//		========================================================================*/
//		
//		
//		System.out.println(st.executeUpdate("update urunler set fiyat=fiyat*1.1 where id=102 ")==0?"Kayıt Güncellendi":"Kayıt Güncellenmedi");
//		System.out.println("Waoowww");
//		
//		
//		
//		/*=======================================================================
//		  ORNEK6: urunler tablosuna Marka adinda ve Default degeri ASUS olan yeni 
//		  bir sutun ekleyiniz.
//		========================================================================*/
//		
//			st.executeUpdate("alter table urunler add marka varchar(10) default 'Asus'");
//			
//			System.out.println("Göz Göz Göztepe");
//			
			
			
			/*=======================================================================
			  ORNEK7: urunler tablosunu siliniz.
			========================================================================*/ 
			
			
			st.executeUpdate("drop table urunler ");
			System.out.println("Kapatin dükkani");
			
			
			st.close();
			con.close();
			
			

	}

}
