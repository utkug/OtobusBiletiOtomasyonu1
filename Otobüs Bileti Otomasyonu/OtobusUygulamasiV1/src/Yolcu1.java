import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Yolcu1 extends Yolcular{
	public JLabel lblAdSoyad1;
	public JLabel lblTcKimlikNo1;
	public JTextField txtAdSoyad1;
	public Container txtTcKimlikNo1;

	public void yolcuBilgileri(JPanel contentPaneYolcu, int secilenKoltukSayisi, int secilenKoltuklar)
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
		lblNewLabel.setBounds(34, 145, 150, 13);
		contentPaneYolcu.add(lblNewLabel);
		
		lblAdSoyad1 = new JLabel("AD SOYAD");
		lblAdSoyad1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAdSoyad1.setBounds(34, 171, 76, 13);
		contentPaneYolcu.add(lblAdSoyad1);
			
		lblTcKimlikNo1 = new JLabel("T.C. KİMLİK NO");
		lblTcKimlikNo1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTcKimlikNo1.setBounds(34, 201, 76, 13);
		contentPaneYolcu.add(lblTcKimlikNo1);
	}
	
	public void kaydet(int pnr, ImageIcon icon, String adSoyad, String koltukNo) throws SQLException {//Veritabanına kaydetmek icin
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/otobusdb","root","utku");
			String kaydetSorgu = "UPDATE `biletler` SET `yolcu1`='"+adSoyad+"',`koltuk_no1`='"+""+koltukNo+"' WHERE pnr_no='"+pnr+"'";
			PreparedStatement statement = connection.prepareStatement(kaydetSorgu);
			statement.executeUpdate(kaydetSorgu);
			System.out.println("Yolcu1 updated");
			connection.close();
		}catch (SQLException exception) {
			System.out.println("Error: " + exception.getMessage());
			System.out.println("Error Code: " + exception.getErrorCode());
		}	
	}
}
