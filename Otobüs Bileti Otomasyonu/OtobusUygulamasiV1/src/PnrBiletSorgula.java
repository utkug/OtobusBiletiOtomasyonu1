import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class PnrBiletSorgula extends JFrame {
	JLabel toplamFiyat = new JLabel();
	private JPanel contentPane;
	private JTextField textFieldPNR;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PnrBiletSorgula frame = new PnrBiletSorgula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PnrBiletSorgula() {
		setTitle("PNR ile Bilet Sorgula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("PNR ile Bilet Sorgula");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(180, 0, 145, 25);
		contentPane.add(lblNewLabel);
		
		textFieldPNR = new JTextField();
		textFieldPNR.setBounds(180, 35, 96, 19);
		contentPane.add(textFieldPNR);
		textFieldPNR.setColumns(10);
		
		JLabel lblPNRYazi = new JLabel("PNR");
		lblPNRYazi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPNRYazi.setBounds(117, 37, 53, 13);
		contentPane.add(lblPNRYazi);
		Biletler[] biletler = new Biletler[] {new Bilet1(), new Bilet2(), new Bilet3(), new Bilet4()};//BAK
		
		JButton btnNewButton = new JButton("BUL");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int pnr= Integer.parseInt(textFieldPNR.getText());
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/otobusdb","root","utku");
					String bulSorgu = "SELECT yolcu1, yolcu2, yolcu3, yolcu4, fiyat, varis, tarih, saat, count(id) as pnr FROM biletler WHERE pnr_no='"+pnr+"'";
					PreparedStatement statement = connection.prepareStatement(bulSorgu);
					ResultSet result = statement.executeQuery(bulSorgu);
					int secilenKoltukSayisi=0;
			
					
					for(Biletler yol: biletler) {
						yol.reset();
						toplamFiyat.setText("");
					}
					while (result.next())//Veritabanından çektiğimiz bilgileri sınıfların içine gönderek bilgileri ekrana bastırdıgımız yer
					{	
						if(result.getInt("pnr") == 1)
						{
							String yolcu1 = result.getString("yolcu1");
							if(!(yolcu1==null)) {
								secilenKoltukSayisi=+1;
								 biletler[0].biletBilgileri(contentPane);
								 biletler[0].bul(textFieldPNR, contentPane, secilenKoltukSayisi);
								 
							}
							String yolcu2 = result.getString("yolcu2");
							if(!(yolcu2==null)) {
								 secilenKoltukSayisi=+2;
								 biletler[1].biletBilgileri(contentPane);
								 biletler[1].bul(textFieldPNR, contentPane, secilenKoltukSayisi);
								
							} 
							String yolcu3 = result.getString("yolcu3");
							if(!(yolcu3==null)) {
								secilenKoltukSayisi=+3;
								 biletler[2].biletBilgileri(contentPane);
								 biletler[2].bul(textFieldPNR, contentPane, secilenKoltukSayisi);
								 
							}
							String yolcu4 = result.getString("yolcu4");
							if(!(yolcu4==null)) {
								secilenKoltukSayisi=+4;
								 biletler[3].biletBilgileri(contentPane);
								 biletler[3].bul(textFieldPNR, contentPane, secilenKoltukSayisi);
								 
							}
							toplamFiyat.setText(""+Integer.parseInt(result.getString("fiyat")) * secilenKoltukSayisi+" TL");//Toplam tutar hesaplama
							toplamFiyat.setBounds(490, 350, 45, 13);
							System.out.print(secilenKoltukSayisi);
							contentPane.add(toplamFiyat);
							contentPane.revalidate();
							contentPane.repaint();
						}
						else 
						{
							JOptionPane.showMessageDialog(null,"Geçersiz PNR no.", "Mesaj", JOptionPane.ERROR_MESSAGE);
						}
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		btnNewButton.setBounds(286, 34, 75, 19);
		
		JButton btnNewButton_1 = new JButton("Ana Menüye Dön");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OtobusBiletiBul obb = new OtobusBiletiBul();
				obb.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 4, 130, 21);
		contentPane.add(btnNewButton_1);

	}
}
