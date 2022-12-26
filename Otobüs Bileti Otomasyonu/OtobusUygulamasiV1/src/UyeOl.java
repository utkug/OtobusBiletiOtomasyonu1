import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Checkbox;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.DropMode;
import javax.swing.JCheckBox;

public class UyeOl extends JFrame {

	private JPanel contentPane;
	private JTextField txtAdSoyad;
	private JTextField txtTcKimlikNo;
	private JTextField txtCepTelefonu;
	private JTextField txtEmail;
	private JPasswordField pswSifre;
	static String eMail;
	static String cepTelefonu;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UyeOl uyeOl = new UyeOl();
					uyeOl.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UyeOl() {
		setTitle("Üye Ol");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUyeOl = new JButton("Üye Ol");
		btnUyeOl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnUyeOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bul();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUyeOl.setBounds(102, 205, 103, 29);
		contentPane.add(btnUyeOl);
		
		txtAdSoyad = new JTextField();
		txtAdSoyad.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtAdSoyad.setBounds(127, 37, 136, 19);
		contentPane.add(txtAdSoyad);
		
		txtTcKimlikNo = new JTextField();
		txtTcKimlikNo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtTcKimlikNo.setColumns(10);
		txtTcKimlikNo.setBounds(127, 66, 136, 19);
		contentPane.add(txtTcKimlikNo);
		
		txtCepTelefonu = new JTextField();
		txtCepTelefonu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtCepTelefonu.setColumns(10);
		txtCepTelefonu.setBounds(127, 95, 136, 19);
		contentPane.add(txtCepTelefonu);
	
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtEmail.setColumns(10);
		txtEmail.setBounds(127, 124, 136, 19);
		contentPane.add(txtEmail);
		
		pswSifre = new JPasswordField();
		pswSifre.setFont(new Font("Tahoma", Font.PLAIN, 10));
		pswSifre.setBounds(127, 153, 136, 19);
		contentPane.add(pswSifre);
		
		JLabel lblAdSoyad = new JLabel("AD SOYAD");
		lblAdSoyad.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAdSoyad.setBounds(43, 32, 76, 29);
		contentPane.add(lblAdSoyad);
		
		JLabel lblTcKimlikNo = new JLabel("T.C. KİMLİK NO");
		lblTcKimlikNo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTcKimlikNo.setBounds(43, 69, 76, 13);
		contentPane.add(lblTcKimlikNo);
		
		JLabel lblCepTelefonu = new JLabel("CEP TELEFONU");
		lblCepTelefonu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCepTelefonu.setBounds(43, 98, 76, 13);
		contentPane.add(lblCepTelefonu);
		
		JLabel lblEmail = new JLabel("E-MAİL");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEmail.setBounds(43, 127, 45, 13);
		contentPane.add(lblEmail);
		
		JLabel lblSifre = new JLabel("ŞİFRE");
		lblSifre.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSifre.setBounds(43, 156, 45, 13);
		contentPane.add(lblSifre);
		
		JLabel lblZatenUyeMisiniz = new JLabel("Zaten üye misiniz?");
		lblZatenUyeMisiniz.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblZatenUyeMisiniz.setBounds(43, 255, 89, 13);
		contentPane.add(lblZatenUyeMisiniz);
		
		JButton btnGirisYap = new JButton("GİRİŞ YAP");
		btnGirisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GirisYap giris = new GirisYap();
				giris.setVisible(true);
			}
		});
		btnGirisYap.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGirisYap.setBounds(184, 251, 80, 21);
		contentPane.add(btnGirisYap);
		
		JCheckBox chckbx = new JCheckBox("Şifreyi göster");
		chckbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbx.isSelected() == true)
	            {
					pswSifre.setEchoChar((char)0);
	            }
	            else
	            {
	            	pswSifre.setEchoChar('●');
	            }
			}
		});
		chckbx.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbx.setBounds(127, 178, 93, 21);
		contentPane.add(chckbx);
	}
	public void kaydet() throws SQLException {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/otobusdb","root","utku");
			String kaydetSorgu = "insert into kullanicilar (ad_soyad,tc_kimlik,cep_telefonu,email,sifre) values (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(kaydetSorgu);
			statement.setString(1, txtAdSoyad.getText());
			statement.setString(2, txtTcKimlikNo.getText());
			statement.setString(3, txtCepTelefonu.getText());
			statement.setString(4, txtEmail.getText());
			statement.setString(5, pswSifre.getText());
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Üyeliğiniz Başarıyla Gerçekleşmiştir");
			OtobusBiletiBul otobusBiletiBul = new OtobusBiletiBul();
			otobusBiletiBul.setVisible(true);
		}catch (SQLException exception) {
			System.out.println("Error: " + exception.getMessage());
			System.out.println("Error Code: " + exception.getErrorCode());
		}	
	}
	public void bul() throws SQLException {
		try {
			eMail = txtEmail.getText();
			cepTelefonu = txtCepTelefonu.getText();
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/otobusdb","root","utku");
			String bulSorgu = "select count(id) ,cep_telefonu as uye from kullanicilar where email='" + eMail + "'";
			PreparedStatement statement = connection.prepareStatement(bulSorgu);
			ResultSet result = statement.executeQuery(bulSorgu);
			
			while(result.next()) {
				if(result.getInt("uye") == 1)
				{
					JOptionPane.showMessageDialog(null, "Girmiş olduğunuz e-mail adresi ile üyeliğiniz bulunmaktadır.", "Mesaj", JOptionPane.ERROR_MESSAGE);
				}
				else 
				{
					kaydet();		
				}
			}
		}catch (SQLException exception) {
			System.out.println("Error: " + exception.getMessage());
			System.out.println("Error Code: " + exception.getErrorCode());
		}	
	}
}
