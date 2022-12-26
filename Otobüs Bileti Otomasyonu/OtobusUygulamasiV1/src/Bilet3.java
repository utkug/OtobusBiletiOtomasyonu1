import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bilet3 extends Biletler{
	JLabel lblIsim3 = new JLabel("#İSİM#");
	JLabel lblKoltukNo3 = new JLabel("KOLTUK NO");
	JLabel lblKoltukNoV3 = new JLabel("#KOLTUKNO#");
	JLabel lblTutar3 = new JLabel("TUTAR");
	JLabel lblTutarV3 = new JLabel("#TUTAR#");
	public void biletBilgileri(JPanel contentPane) {
		//Ekran
		lblIsim3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIsim3.setBounds(10, 259, 90, 25);
		contentPane.add(lblIsim3);
		
		lblKoltukNo3.setText("KOLTUK NO");
		lblKoltukNo3.setBounds(190, 259, 80, 13);
		contentPane.add(lblKoltukNo3);
		
		
		lblKoltukNoV3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKoltukNoV3.setBounds(200, 278, 48, 17);
		contentPane.add(lblKoltukNoV3);
		
		lblTutar3.setText("TUTAR");
		lblTutar3.setBounds(286, 259, 45, 13);
		contentPane.add(lblTutar3);
		
		
		lblTutarV3.setBounds(286, 279, 45, 13);
		contentPane.add(lblTutarV3);
		
	}
	public void bul(JTextField txtPnrNo, JPanel panel, int secilenKoltuk) {//Veritabanından biilgi cekmek icin
		int pnr = Integer.parseInt(txtPnrNo.getText());
		
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/otobusdb","root","utku");
			String bulSorgu = "SELECT yolcu3, koltuk_no3, fiyat, turizm, kalkis, varis, tarih, saat FROM biletler WHERE pnr_no='"+pnr+"'";
			PreparedStatement statement = connection.prepareStatement(bulSorgu);
			ResultSet result = statement.executeQuery(bulSorgu);
			while (result.next())
			{

				lblIsim3.setText(result.getString("yolcu3"));
				lblKoltukNoV3.setText(result.getString("koltuk_no3"));
				lblTutarV3.setText(result.getString("fiyat"));
				System.out.println("Bilet3 gösteriliyor");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void reset() {//Ekran reset
		lblIsim3.setText("");
		lblKoltukNo3.setText("");
		lblKoltukNoV3.setText("");
		lblTutar3.setText("");
		lblTutarV3.setText("");
	}
}
