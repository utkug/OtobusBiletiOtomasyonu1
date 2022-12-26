import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bilet2 extends Biletler{
	JLabel lblIsim2 = new JLabel("#İSİM#");
	JLabel lblKoltukNo2 = new JLabel("KOLTUK NO");
	JLabel lblKoltukNoV2 = new JLabel("#KOLTUKNO#");
	JLabel lblTutar2 = new JLabel("TUTAR");
	JLabel lblTutarV2 = new JLabel("#TUTAR#");
	public void biletBilgileri(JPanel contentPane) {
		//Ekran
		lblIsim2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIsim2.setBounds(10, 179, 90, 25);
		contentPane.add(lblIsim2);
		
		lblKoltukNo2.setText("KOLTUK NO");
		lblKoltukNo2.setBounds(190, 179, 80, 13);
		contentPane.add(lblKoltukNo2);
		
		
		lblKoltukNoV2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKoltukNoV2.setBounds(200, 198, 48, 17);
		contentPane.add(lblKoltukNoV2);
		
		lblTutar2.setText("TUTAR");
		lblTutar2.setBounds(286, 179, 45, 13);
		contentPane.add(lblTutar2);
		
		
		lblTutarV2.setBounds(286, 199, 45, 13);
		contentPane.add(lblTutarV2);
	}
	public void bul(JTextField txtPnrNo, JPanel panel, int secilenKoltuk) {////Veritabanından biilgi cekmek icin
		int pnr = Integer.parseInt(txtPnrNo.getText());
		
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/otobusdb","root","utku");
			String bulSorgu = "SELECT yolcu2, koltuk_no2, fiyat, turizm, kalkis, varis, tarih, saat FROM biletler WHERE pnr_no='"+pnr+"'";
			PreparedStatement statement = connection.prepareStatement(bulSorgu);
			ResultSet result = statement.executeQuery(bulSorgu);
			while (result.next())
			{
				lblIsim2.setText(result.getString("yolcu2"));
				lblKoltukNoV2.setText(result.getString("koltuk_no2"));
				lblTutarV2.setText(result.getString("fiyat"));
				System.out.println("Bilet2 gösteriliyor");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void reset() {//Ekran reset
		lblIsim2.setText("");
		lblKoltukNo2.setText("");
		lblKoltukNoV2.setText("");
		lblTutar2.setText("");
		lblTutarV2.setText("");
	}
}
