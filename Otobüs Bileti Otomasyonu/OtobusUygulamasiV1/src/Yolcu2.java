import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Yolcu2 extends Yolcular{
	public JLabel lblAdSoyad2;
	public JLabel lblTcKimlikNo2;
	public  JTextField txtAdSoyad2;
	public Container txtTcKimlikNo2;


	public void yolcuBilgileri(JPanel contentPaneYolcu, int secilenKoltukSayisi,int secilenKoltuklar)
	{
		String cinsiyet="";//Cinsiyet bilgisi icin
		for(int i=0;i<4;i++) {
			if(!(KoltukSecim.cinsiyet[i]==null)) {
				cinsiyet=KoltukSecim.cinsiyet[i];
				KoltukSecim.cinsiyet[i]=null;
				break;
			}
		}//Ekran icin
		JLabel lblNewLabel = new JLabel(secilenKoltukSayisi + ". Yolcu - "+cinsiyet+" (Koltuk No : " + secilenKoltuklar + ")");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(34, 230, 150, 13);
		contentPaneYolcu.add(lblNewLabel);
		
		lblAdSoyad2 = new JLabel("AD SOYAD");
		lblAdSoyad2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAdSoyad2.setBounds(34, 256, 76, 13);
		contentPaneYolcu.add(lblAdSoyad2);
			
		lblTcKimlikNo2 = new JLabel("T.C. KİMLİK NO");
		lblTcKimlikNo2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTcKimlikNo2.setBounds(34, 286, 76, 13);
		contentPaneYolcu.add(lblTcKimlikNo2);
	}
	
	public void kaydet(int pnr, ImageIcon icon,String adSoyad,String koltukNo) throws SQLException {//Veritabanına kaydetmek icin
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/otobusdb","root","utku");
			String kaydetSorgu = "UPDATE `biletler` SET `yolcu2`='"+adSoyad+"',`koltuk_no2`='"+""+koltukNo+"' WHERE pnr_no='"+pnr+"'";
			PreparedStatement statement = connection.prepareStatement(kaydetSorgu);
			statement.executeUpdate(kaydetSorgu);
			System.out.println("Yolcu2 updated");
			connection.close();

		}catch (SQLException exception) {
			System.out.println("Error: " + exception.getMessage());
			System.out.println("Error Code: " + exception.getErrorCode());
		}	
		
	}
	public Yolcu2() {}
}
