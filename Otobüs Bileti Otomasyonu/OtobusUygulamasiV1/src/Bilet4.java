import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bilet4 extends Biletler {
	JLabel lblIsim4 = new JLabel("#İSİM#");
	JLabel lblKoltukNo4 = new JLabel("KOLTUK NO");
	JLabel lblKoltukNoV4 = new JLabel("#KOLTUKNO#");
	JLabel lblTutar4 = new JLabel("TUTAR");
	JLabel lblTutarV4 = new JLabel("#TUTAR#");

	public void biletBilgileri(JPanel contentPane) {
		//Ekran
		lblIsim4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIsim4.setBounds(10, 324, 90, 25);
		contentPane.add(lblIsim4);
		
		lblKoltukNo4.setText("KOLTUK NO");
		lblKoltukNo4.setBounds(190, 324, 80, 13);
		contentPane.add(lblKoltukNo4);
		
		lblKoltukNoV4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKoltukNoV4.setBounds(200, 343, 48, 17);
		contentPane.add(lblKoltukNoV4);
		
		lblTutar4.setText("TUTAR");
		lblTutar4.setBounds(286, 324, 45, 13);
		contentPane.add(lblTutar4);
		
		lblTutarV4.setBounds(286, 344, 45, 13);
		contentPane.add(lblTutarV4);
	}
	public void bul(JTextField txtPnrNo, JPanel panel, int secilenKoltuk) {//Veritabanından biilgi cekmek icin
		int pnr = Integer.parseInt(txtPnrNo.getText());
				
				Connection connection;
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/otobusdb","root","utku");
					String bulSorgu = "SELECT yolcu4, koltuk_no4, fiyat, turizm, kalkis, varis, tarih, saat FROM biletler WHERE pnr_no='"+pnr+"'";
					PreparedStatement statement = connection.prepareStatement(bulSorgu);
					ResultSet result = statement.executeQuery(bulSorgu);
					while (result.next())
					{
						lblIsim4.setText(result.getString("yolcu4"));
						lblKoltukNoV4.setText(result.getString("koltuk_no4"));
						lblTutar4.setText(result.getString("fiyat"));
						System.out.println("Bilet4 gösteriliyor");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	public void reset() {//Ekran reset
		lblIsim4.setText("");
		lblKoltukNo4.setText("");
		lblKoltukNoV4.setText("");
		lblTutar4.setText("");
		lblTutarV4.setText("");

	}
}
