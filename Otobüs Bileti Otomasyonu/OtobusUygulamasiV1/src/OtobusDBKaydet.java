import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OtobusDBKaydet {
	public void kaydetDB(int pnr,String turizm, String kalkis, String varis,String tarih,String saat, String fiyat) throws SQLException {
	try {
		System.out.println("Otobus bilgileri Kaydedildi");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otobusdb","root","utku");
		String kaydetDB = "insert into biletler (pnr_no,turizm,kalkis,varis,tarih,saat,fiyat) values (?,?,?,?,?,?,?)";
		PreparedStatement statement = con.prepareStatement(kaydetDB);
		statement.setLong(1,pnr);
		statement.setString(2, turizm);
		statement.setString(3, kalkis);
		statement.setString(4, varis);
		statement.setString(5, tarih);
		statement.setString(6, saat);
		statement.setString(7, fiyat);
		statement.executeUpdate();
	}
	catch(SQLException exception){
		System.out.println("Error: " + exception.getMessage());
		System.out.println("Error Code: " + exception.getErrorCode());
	}
	}

}
