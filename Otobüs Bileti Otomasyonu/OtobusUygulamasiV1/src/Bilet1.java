import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bilet1 extends Biletler {
	JLabel lblIsim = new JLabel("#İSİM#");
	JLabel lblKoltukNo = new JLabel("KOLTUK NO");
	JLabel lblKoltukNoV = new JLabel("#KOLTUKNO#");
	JLabel lblTutar = new JLabel("TUTAR");
	JLabel lblTutarV = new JLabel("#TUTAR#");
	JLabel lblNewLabel_2_4 = new JLabel("#FİYAT#");
	JLabel lblKalkisVaris = new JLabel("#Kalkis-varis#");
	JLabel lblTarihSaat = new JLabel("#tarih-saat#");
	JLabel lblTurizm = new JLabel("#TURİZM#");
	JLabel lblPNRNO = new JLabel("PNR NO:");
	JLabel lblToplamTL = new JLabel("Toplam Tutar:");
	JLabel lblPNRNOv = new JLabel("#PNR#");
	public void biletBilgileri(JPanel contentPane) {
		//Ekran
		lblPNRNO.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPNRNO.setBounds(378, 60, 75, 25);
		contentPane.add(lblPNRNO);
		lblPNRNO.setText("PNR NO:");
		lblToplamTL.setText("Toplam Tutar:");
		lblPNRNOv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPNRNOv.setBounds(463, 68, 98, 13);
		contentPane.add(lblPNRNOv);
		
		lblIsim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIsim.setBounds(10, 111, 90, 25);
		contentPane.add(lblIsim);
		lblKoltukNo.setText("KOLTUK NO");
		lblKoltukNo.setBounds(190, 111, 80, 13);
		contentPane.add(lblKoltukNo);
		
		lblKoltukNoV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKoltukNoV.setBounds(200, 130, 48, 17);
		contentPane.add(lblKoltukNoV);
		
		lblTutar.setText("TUTAR");
		lblTutar.setBounds(286, 111, 45, 13);
		contentPane.add(lblTutar);
		
		
		lblTutarV.setBounds(286, 131, 45, 13);
		contentPane.add(lblTutarV);
		
		lblKalkisVaris.setBounds(190, 74, 95, 13);
		contentPane.add(lblKalkisVaris);
		
		lblTurizm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTurizm.setBounds(10, 74, 150, 25);
		contentPane.add(lblTurizm);
		
		lblTarihSaat.setBounds(190, 88, 86, 13);
		contentPane.add(lblTarihSaat);
		
		lblToplamTL.setBounds(406, 350, 100, 13);
		contentPane.add(lblToplamTL);
		
	}
	public void bul(JTextField txtPnrNo, JPanel panel, int secilenKoltuk) {//Veritabanından biilgi cekmek icin
		int pnr = Integer.parseInt(txtPnrNo.getText());
		
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/otobusdb","root","utku");
			String bulSorgu = "SELECT yolcu1, koltuk_no1, fiyat, turizm, kalkis, varis, tarih, saat FROM biletler WHERE pnr_no='"+pnr+"'";
			PreparedStatement statement = connection.prepareStatement(bulSorgu);
			ResultSet result = statement.executeQuery(bulSorgu);
			while (result.next())
			{
				lblPNRNOv.setText(""+pnr);
				lblIsim.setText(result.getString("yolcu1"));
				lblKoltukNoV.setText(result.getString("koltuk_no1"));
				lblTutarV.setText(result.getString("fiyat"));
				lblTurizm.setText(result.getString("turizm")+" Turizm");
				lblKalkisVaris.setText(result.getString("kalkis")+"-"+result.getString("varis"));
				lblTarihSaat.setText(result.getString("tarih")+result.getString("saat"));
				System.out.println("Bilet1 gösteriliyor");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void reset() {//Ekrandakileri resetlemek icin
		lblIsim.setText("");
		lblKoltukNo.setText("");
		lblKoltukNoV.setText("");
		lblTutar.setText("");
		lblTutarV.setText("");
		lblNewLabel_2_4.setText("");
		lblKalkisVaris.setText("");;
		lblTarihSaat.setText("");;
		lblTurizm.setText("");;
		lblPNRNO.setText("");;
		lblToplamTL.setText("");;
		lblPNRNOv.setText("");;
	}
}
