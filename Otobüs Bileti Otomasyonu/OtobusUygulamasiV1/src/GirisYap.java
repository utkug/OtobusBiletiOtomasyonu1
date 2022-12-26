import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.CommentClientInfoProvider;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.xdevapi.Result;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.JCheckBox;

public class GirisYap extends JFrame {

	private JPanel contentPane;	
	private JTextField txtEmail;
	private JPasswordField pswSifre;
	static String eMail;
	static String sifre;
	static String cepTelefonu;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GirisYap girisYap = new GirisYap();
					girisYap.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	

	public GirisYap() {
		setTitle("Giriş Yap");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGirisYap = new JButton("Giriş Yap");
		btnGirisYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bul();
					//hide();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGirisYap.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGirisYap.setBounds(101, 127, 103, 29);
		contentPane.add(btnGirisYap);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtEmail.setColumns(10);
		txtEmail.setBounds(117, 40, 136, 19);
		contentPane.add(txtEmail);
		
		pswSifre = new JPasswordField();
		pswSifre.setFont(new Font("Tahoma", Font.PLAIN, 10));
		pswSifre.setBounds(117, 69, 136, 19);
		contentPane.add(pswSifre);
		
		JLabel lblEmail = new JLabel("E-MAİL");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEmail.setBounds(58, 43, 45, 13);
		contentPane.add(lblEmail);
		
		JLabel lblSifre = new JLabel("ŞİFRE");
		lblSifre.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSifre.setBounds(58, 72, 45, 13);
		contentPane.add(lblSifre);
		
		JLabel lblUyeDegilMisiniz = new JLabel("Üye değil misiniz?");
		lblUyeDegilMisiniz.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblUyeDegilMisiniz.setBounds(58, 176, 89, 13);
		contentPane.add(lblUyeDegilMisiniz);
		
		JButton btnHemenUyeOl = new JButton("HEMEN ÜYE OL");
		btnHemenUyeOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UyeOl uyeOl = new UyeOl();
				uyeOl.setVisible(true);
				hide();
			}
		});
		btnHemenUyeOl.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnHemenUyeOl.setBounds(161, 172, 92, 21);
		contentPane.add(btnHemenUyeOl);
		
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
		chckbx.setBounds(117, 94, 93, 21);
		contentPane.add(chckbx);
	}
	public void bul() throws SQLException {
		try {
			eMail = txtEmail.getText();
			sifre = pswSifre.getText();
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/otobusdb","root","utku");
			String bulSorgu = "select cep_telefonu, count(id) as giris from kullanicilar where email='" + eMail + "' and sifre='" + sifre + "'";
			PreparedStatement statement = connection.prepareStatement(bulSorgu);
			ResultSet result = statement.executeQuery(bulSorgu);
			
			while(result.next()) {
				if(result.getInt("giris") == 1)
				{
					OtobusBiletiBul otobusBiletiBul = new OtobusBiletiBul();
					otobusBiletiBul.setVisible(true);
					cepTelefonu=result.getString("cep_telefonu");
					hide();
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"E-mail adresi ve şifrenizi kontrol ederek tekrar deneyiniz.", "Mesaj", JOptionPane.ERROR_MESSAGE);
				}
			}
		}catch (SQLException exception) {
			System.out.println("Error: " + exception.getMessage());
			System.out.println("Error Code: " + exception.getErrorCode());
		}	
	}
}