import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Yolcu3 extends Yolcular{
	private JLabel lblAdSoyad3;
	private JLabel lblTcKimlikNo3;
	private JTextField txtAdSoyad3;
	private Container txtTcKimlikNo3;

	public void yolcuBilgileri(JPanel contentPaneYolcu, int secilenKoltukSayisi, int secilenKoltuklar)
	{
		String cinsiyet="";//Cinsiyet bilgisi icin
		for(int i=0;i<4;i++) {
			if(!(KoltukSecim.cinsiyet[i]==null)) {
				cinsiyet=KoltukSecim.cinsiyet[i];
				KoltukSecim.cinsiyet[i]=null;
				break;
			}
		}//Ekran
		JLabel lblNewLabel = new JLabel(secilenKoltukSayisi + ". Yolcu - "+cinsiyet+" (Koltuk No : " + secilenKoltuklar + ")");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(34, 315, 150, 13);
		contentPaneYolcu.add(lblNewLabel);
		
		lblAdSoyad3 = new JLabel("AD SOYAD");
		lblAdSoyad3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAdSoyad3.setBounds(34, 341, 76, 13);
		contentPaneYolcu.add(lblAdSoyad3);
			
		lblTcKimlikNo3 = new JLabel("T.C. KİMLİK NO");
		lblTcKimlikNo3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTcKimlikNo3.setBounds(34, 371, 76, 13);
		contentPaneYolcu.add(lblTcKimlikNo3);
	}
	public void kaydet(int pnr, ImageIcon icon, String adSoyad, String koltukNo) throws SQLException {//Veritabanına kaydetmek icin
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/otobusdb","root","utku");
			String kaydetSorgu = "UPDATE `biletler` SET `yolcu3`='"+adSoyad+"',`koltuk_no3`='"+""+koltukNo+"' WHERE pnr_no='"+pnr+"'";
			PreparedStatement statement = connection.prepareStatement(kaydetSorgu);
			statement.executeUpdate();
			System.out.println("Yolcu3 updated");
			connection.close();

		}catch (SQLException exception) {
			System.out.println("Error: " + exception.getMessage());
			System.out.println("Error Code: " + exception.getErrorCode());
		}	
	}
}
