package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Jdbc1Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
	//1)ilgili driveri yükle(MySQL)
	
	Class.forName("com.mysql.cj.jdbc.Driver");
		
		
	//2)Baglanti olusturmaliyiz(username ve password gir)	
	
		
	Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1879");
		
	
	//3)SQL komutlari icin bir statement nesnesi olustur.
		
	Statement st= con.createStatement();	
	
	
		
	// 4) SQL ifadeleri yazabilir ve calistirabiliriz.
	
	 ResultSet veri=st.executeQuery("SELECT isim,maas,sirket from personel where id=123456789");
	
	
	// 5) Artik tamam.
	
	while (veri.next()) {
		
		System.out.println(veri.getString("isim")+" "+veri.getInt("maas")+" "+veri.getString("sirket"));
		
		System.out.println();
		
		System.out.println(veri.getString(1));
		System.out.println(veri.getInt(2));
		System.out.println(veri.getString(3));
	}
	 
	 
	// 6)Oluturulan nesneler bellekten kaldirilsin.
	con.close();
	st.close();
	veri.close();
	
	

	}

}
