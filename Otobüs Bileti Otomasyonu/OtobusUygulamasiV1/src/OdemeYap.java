import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;

public class OdemeYap extends JFrame {
	public JPanel contentPaneYolcu;
	private JTextField txtCepTelefonu;
	private JTextField txtEmail;
	private JTextField txtIletisimBilgileri;
	private JTextField txtYolcuBilgileri;
	public JTextField adSoyad[]= new JTextField[4];
	public JTextField tc[] = new JTextField[4];
	public JLabel labeladSoyad[] = new JLabel[4];
	public JLabel labelTC[] = new JLabel[4];
	public JLabel labelBaslik[] = new JLabel[4];
	int y=168;//konum icin

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {				
					OdemeYap frame = new OdemeYap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void bilgiCek(JTextField textField,JTextField textField2 ) throws SQLException {//İletişim bilgileri icin
			if(!(UyeOl.eMail==null && UyeOl.cepTelefonu==null)) {
				textField.setText(UyeOl.eMail);
				textField2.setText(UyeOl.cepTelefonu);
				
			}
			if(!(GirisYap.eMail==null && GirisYap.cepTelefonu==null)) {
				textField.setText(GirisYap.eMail);
				textField2.setText(GirisYap.cepTelefonu);
			
			}
	}

	public OdemeYap(Otobus bus,int secilenKoltukSayisi, ArrayList<Integer> secilenKoltuklar) throws SQLException {
		setTitle("Ödeme Ekranı");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPaneYolcu = new JPanel();
		contentPaneYolcu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 361, 388);
		setContentPane(contentPaneYolcu);
		contentPaneYolcu.setLayout(null);
		OtobusDBKaydet otobusDBKaydet = new OtobusDBKaydet();
		int y2=198;
		for (int i=0;i<4;i++) {
			adSoyad[i] = new JTextField();
			adSoyad[i].setFont(new Font("Tahoma", Font.PLAIN, 10));
			adSoyad[i].setBounds(118, y, 136, 19);
			y+=85;
			tc[i] = new JTextField();
			tc[i].setFont(new Font("Tahoma", Font.PLAIN, 10));
			tc[i].setBounds(118, y2, 136, 19);
			y2+=85;	
		}
		
		for(int i=0;i<4;i++) {
		}
		txtIletisimBilgileri = new JTextField();
		txtIletisimBilgileri.setHorizontalAlignment(SwingConstants.CENTER);
		txtIletisimBilgileri.setText("İLETİŞİM BİLGİLERİ");
		txtIletisimBilgileri.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtIletisimBilgileri.setColumns(10);
		txtIletisimBilgileri.setBounds(87, 10, 114, 19);
		txtIletisimBilgileri.setBackground(Color.RED);
		txtIletisimBilgileri.setForeground(Color.WHITE);
		contentPaneYolcu.add(txtIletisimBilgileri);
		
		JLabel lblCepTelefonu = new JLabel("CEP TELEFONU");
		lblCepTelefonu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCepTelefonu.setBounds(34, 50, 76, 13);
		contentPaneYolcu.add(lblCepTelefonu);
		
		JLabel lblEmail = new JLabel("E-MAİL");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEmail.setBounds(34, 80, 45, 13);
		contentPaneYolcu.add(lblEmail);
		
		txtCepTelefonu = new JTextField();
		txtCepTelefonu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtCepTelefonu.setColumns(10);
		txtCepTelefonu.setBounds(118, 47, 136, 19);
		contentPaneYolcu.add(txtCepTelefonu);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtEmail.setColumns(10);
		txtEmail.setBounds(118, 77, 136, 19);
		contentPaneYolcu.add(txtEmail);
		
		bilgiCek(txtEmail, txtCepTelefonu);
		
		txtYolcuBilgileri = new JTextField();
		txtYolcuBilgileri.setText("YOLCU BİLGİLERİ");
		txtYolcuBilgileri.setHorizontalAlignment(SwingConstants.CENTER);
		txtYolcuBilgileri.setForeground(Color.WHITE);
		txtYolcuBilgileri.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtYolcuBilgileri.setColumns(10);
		txtYolcuBilgileri.setBackground(Color.RED);
		txtYolcuBilgileri.setBounds(87, 115, 114, 19);
		contentPaneYolcu.add(txtYolcuBilgileri);
		
		Yolcular[] yolcular = new Yolcular[] {new Yolcu1(), new Yolcu2(), new Yolcu3(), new Yolcu4()};
		//PNR no üretimi
		ImageIcon icon = new ImageIcon("onay.png");
		Random random = new Random();
		int min = 100000, max = 999999;
		int pnr = random.nextInt(max - min ) + min;
		otobusDBKaydet.kaydetDB(pnr, bus.turizm, bus.kalkis, bus.varis, bus.kalkisTarih, bus.saat, ""+bus.fiyat);//Otobus bilgilerini veri tabanına kaydedilmesi
		//if'ler ile yolcu sayısına göre ekrana bastırma
		if(secilenKoltukSayisi == 1)//1 icin Yolcu
		{
			yolcular[0].yolcuBilgileri(contentPaneYolcu,secilenKoltukSayisi,secilenKoltuklar.get(0));//Ekrena 1.yolcunun bilgilerini bastırmak icin
			for (int i=0;i<secilenKoltukSayisi;i++) {
				contentPaneYolcu.add(adSoyad[i]);
				contentPaneYolcu.add(tc[i]);
			}
			contentPaneYolcu.validate();
			contentPaneYolcu.repaint();
			JButton btnOdemeYap = new JButton(bus.fiyat*1+" TL");
			btnOdemeYap.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {		
					try {	
						String isim0 = adSoyad[0].getText();
						yolcular[0].kaydet(pnr, icon,isim0,""+secilenKoltuklar.get(0));
						JOptionPane.showMessageDialog(null, "      Ödemeniz başarıyla gerçekleşti!\nBiletinizi " + pnr + " PNR no. ile sorgulatabilirsiniz.", "Onay", JOptionPane.PLAIN_MESSAGE, icon);
						OtobusBiletiBul otobusBiletiBul = new OtobusBiletiBul();
						otobusBiletiBul.setVisible(true);
						hide();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnOdemeYap.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnOdemeYap.setBounds(87, 235, 108, 29);
			contentPaneYolcu.add(btnOdemeYap);
			setBounds(100, 100, 297, 324);
		}
		else if(secilenKoltukSayisi == 2)//2 Yolcu icin
		{
			yolcular[0].yolcuBilgileri(contentPaneYolcu,secilenKoltukSayisi-1,secilenKoltuklar.get(0));//Ekrena 1.yolcunun bilgilerini bastırmak icin
			yolcular[1].yolcuBilgileri(contentPaneYolcu,secilenKoltukSayisi,secilenKoltuklar.get(1));//Ekrena 2.yolcunun bilgilerini bastırmak icin
			for (int i=0;i<secilenKoltukSayisi;i++) {
				contentPaneYolcu.add(adSoyad[i]);
				contentPaneYolcu.add(tc[i]);
			}
			contentPaneYolcu.validate();
			contentPaneYolcu.repaint();
			JButton btnOdemeYap = new JButton(bus.fiyat*2+" TL");
			btnOdemeYap.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {	
						String isim0 = adSoyad[0].getText();
						String isim=adSoyad[1].getText();
						yolcular[0].kaydet(pnr, icon,isim0,""+secilenKoltuklar.get(0));
						yolcular[1].kaydet(pnr, icon,isim,""+secilenKoltuklar.get(1));
						JOptionPane.showMessageDialog(null, "      Ödemeniz başarıyla gerçekleşti!\nBiletinizi " + pnr + " PNR no. ile sorgulatabilirsiniz.", "Onay", JOptionPane.PLAIN_MESSAGE, icon);
						OtobusBiletiBul otobusBiletiBul = new OtobusBiletiBul();
						otobusBiletiBul.setVisible(true);
						hide();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnOdemeYap.setFont(new Font("Tahoma", Font.PLAIN, 10));
			btnOdemeYap.setBounds(87, 320, 108, 29);
			contentPaneYolcu.add(btnOdemeYap);
			setBounds(100, 100, 297, 409);
		}
		else if(secilenKoltukSayisi == 3)//3 Yolcu icin
		{
			yolcular[0].yolcuBilgileri(contentPaneYolcu,secilenKoltukSayisi-2,secilenKoltuklar.get(0));//Ekrena 1.yolcunun bilgilerini bastırmak icin
			yolcular[1].yolcuBilgileri(contentPaneYolcu,secilenKoltukSayisi-1,secilenKoltuklar.get(1));//Ekrena 2.yolcunun bilgilerini bastırmak icin
			yolcular[2].yolcuBilgileri(contentPaneYolcu,secilenKoltukSayisi,secilenKoltuklar.get(2));//Ekrena 3.yolcunun bilgilerini bastırmak icin
			for (int i=0;i<secilenKoltukSayisi;i++) {
				contentPaneYolcu.add(adSoyad[i]);
				contentPaneYolcu.add(tc[i]);
			}
			contentPaneYolcu.validate();
			contentPaneYolcu.repaint();
			JButton btnOdemeYap = new JButton(bus.fiyat*3+" TL");
			btnOdemeYap.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						String isim0 = adSoyad[0].getText();
						String isim=adSoyad[1].getText();
						String isim2 = adSoyad[2].getText();
						yolcular[0].kaydet(pnr, icon,isim0,""+secilenKoltuklar.get(0));
						yolcular[1].kaydet(pnr, icon,isim,""+secilenKoltuklar.get(1));
						yolcular[2].kaydet(pnr, icon,isim2,""+secilenKoltuklar.get(2));
						JOptionPane.showMessageDialog(null, "      Ödemeniz başarıyla gerçekleşti!\nBiletinizi " + pnr + " PNR no. ile sorgulatabilirsiniz.", "Onay", JOptionPane.PLAIN_MESSAGE, icon);
						OtobusBiletiBul otobusBiletiBul = new OtobusBiletiBul();
						otobusBiletiBul.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			btnOdemeYap.setFont(new Font("Tahoma", Font.PLAIN, 10));
			btnOdemeYap.setBounds(87, 405, 108, 29);
			contentPaneYolcu.add(btnOdemeYap);
			setBounds(100, 100, 297, 494);
		}
		else if(secilenKoltukSayisi == 4)//4 Yolcu icin
		{
			yolcular[0].yolcuBilgileri(contentPaneYolcu,secilenKoltukSayisi-3,secilenKoltuklar.get(0));//Ekrena 1.yolcunun bilgilerini bastırmak icin
			yolcular[1].yolcuBilgileri(contentPaneYolcu,secilenKoltukSayisi-2,secilenKoltuklar.get(1));//Ekrena 2.yolcunun bilgilerini bastırmak icin
			yolcular[2].yolcuBilgileri(contentPaneYolcu,secilenKoltukSayisi-1,secilenKoltuklar.get(2));//Ekrena 3.yolcunun bilgilerini bastırmak icin
			yolcular[3].yolcuBilgileri(contentPaneYolcu,secilenKoltukSayisi,secilenKoltuklar.get(3));//Ekrena 4.yolcunun bilgilerini bastırmak icin
			for (int i=0;i<secilenKoltukSayisi;i++) {
				contentPaneYolcu.add(adSoyad[i]);
				contentPaneYolcu.add(tc[i]);
			}
			contentPaneYolcu.validate();
			contentPaneYolcu.repaint();
			JButton btnOdemeYap = new JButton(bus.fiyat*4+" TL");
			btnOdemeYap.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String isim0 = adSoyad[0].getText();
						String isim=adSoyad[1].getText();
						String isim2 = adSoyad[2].getText();
						String isim3 = adSoyad[3].getText();
						yolcular[0].kaydet(pnr, icon,isim0,""+secilenKoltuklar.get(0));
						yolcular[1].kaydet(pnr, icon,isim,""+secilenKoltuklar.get(1));
						yolcular[2].kaydet(pnr, icon,isim2,""+secilenKoltuklar.get(2));
						yolcular[3].kaydet(pnr, icon, isim3,""+secilenKoltuklar.get(3));
						JOptionPane.showMessageDialog(null, "      Ödemeniz başarıyla gerçekleşti!\nBiletinizi " + pnr + " PNR no. ile sorgulatabilirsiniz.", "Onay", JOptionPane.PLAIN_MESSAGE, icon);
						OtobusBiletiBul otobusBiletiBul = new OtobusBiletiBul();
						otobusBiletiBul.setVisible(true);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnOdemeYap.setFont(new Font("Tahoma", Font.PLAIN, 10));
			btnOdemeYap.setBounds(87, 490, 108, 29);
			contentPaneYolcu.add(btnOdemeYap);
			setBounds(100, 100, 297, 579);
		}
	}
}
