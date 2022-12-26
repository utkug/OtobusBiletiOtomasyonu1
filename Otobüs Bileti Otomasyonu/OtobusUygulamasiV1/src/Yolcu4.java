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

public class Yolcu4 extends Yolcular{
	private JLabel lblAdSoyad4;
	private JLabel lblTcKimlikNo4;
	private JTextField txtAdSoyad4;
	private Container txtTcKimlikNo4;

	public void yolcuBilgileri(JPanel contentPaneYolcu, int secilenKoltukSayisi,  int secilenKoltuklar)
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
		lblNewLabel.setBounds(34, 400, 150, 13);
		contentPaneYolcu.add(lblNewLabel);
		
		lblAdSoyad4 = new JLabel("AD SOYAD");
		lblAdSoyad4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAdSoyad4.setBounds(34, 426, 76, 13);
		contentPaneYolcu.add(lblAdSoyad4);
			
		lblTcKimlikNo4 = new JLabel("T.C. KİMLİK NO");
		lblTcKimlikNo4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTcKimlikNo4.setBounds(34, 456, 76, 13);
		contentPaneYolcu.add(lblTcKimlikNo4);
	}
	public void kaydet(int pnr, ImageIcon icon, String adSoyad, String koltukNo) throws SQLException {//Veritabanına kaydetmek icin
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/otobusdb","root","utku");
			String kaydetSorgu = "UPDATE `biletler` SET `yolcu4`='"+adSoyad+"',`koltuk_no4`='"+""+koltukNo+"' WHERE pnr_no='"+pnr+"'";
			PreparedStatement statement = connection.prepareStatement(kaydetSorgu);
			statement.executeUpdate();
			System.out.println("Yolcu4 updated");
			connection.close();
			
		}catch (SQLException exception) {
			System.out.println("Error: " + exception.getMessage());
			System.out.println("Error Code: " + exception.getErrorCode());
		}	
	}
}
