import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.util.List;
import javax.swing.Icon;
import javax.swing.InputMap;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OtobusBiletiBul extends JFrame {
	
	private JComboBox kalkis;
	private JComboBox varis;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtobusBiletiBul frame = new OtobusBiletiBul();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OtobusBiletiBul() {
		setTitle("Otobus Uygulamasi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		setContentPane(contentPane);
		
		//Otobus ekleme yeri
		Otobus otobus26 = new Otobus("Ankara", "İstanbul", "23.00", "Yarın", 350, 8, 40, "Kamilkoç", new String[] {"1","2","8","15","16","23","26","31","33","38","39"}, new String[] {"4","10","18","25","27","32","37"});
		Otobus otobus25 = new Otobus("İzmir", "İstanbul", "21.30", "Yarın", 240, 4, 40, "İnan", new String[] {"3","19","20","25","34","38"}, new String[] {"10","17","24","30","31","36"});
		Otobus otobus24 = new Otobus("İzmir", "Ankara", "23.59", "Yarın", 360, 8, 40, "Varan", new String[] {"11","16","20","27","35","38","39"}, new String[] {"18","19","21","26","32","36"});
		Otobus otobus23 = new Otobus("İzmir", "Ankara", "11.35", "Yarın", 315, 7, 40, "Başkent", new String[] {"6","16","17","29","34","40"}, new String[] {"2","15","20","25","26","33","37","38"});
		Otobus otobus22 = new Otobus("İzmir", "Ankara", "16.20", "Bugün", 340, 8, 40, "Metro", new String[] {"8","16","18","21","26","34","38"}, new String[] {"6","12","13","20","29","31","37","40"});
		Otobus otobus21 = new Otobus("İzmir", "İstanbul", "15.00", "Yarın", 260, 5, 40, "Pamukkale", new String[] {"1","9","16","22","32","35"}, new String[] {"2","7","19","27","36","40"});
		Otobus otobus20 = new Otobus("İzmir", "İstanbul", "21.30", "Bugün", 245, 4, 40, "İnan", new String[] {"6","15","17","22","25","34","35"}, new String[] {"8","20","23","29","32","38"});
		Otobus otobus19 = new Otobus("İzmir", "İstanbul", "13.50", "Bugün", 225, 5, 40, "SES", new String[] {"4","6","17","24","32","37"}, new String[] {"7","9","19","29","35","39"});
		Otobus otobus18 = new Otobus("Ankara", "İzmir", "12.00", "Yarın", 300, 8, 40, "Ege", new String[] {"3","9","16","17","27","32","39"}, new String[] {"4","7","18","20","26","28","34","36","37"});
		Otobus otobus17 = new Otobus("Ankara", "İzmir", "22.30", "Bugün", 350, 7, 40, "Varan", new String[] {"1","5","12","18","22","26","35","38","30"}, new String[] {"4","9","15","16","24","28","34","40"});
		Otobus otobus16 = new Otobus("Ankara", "İzmir", "16.50", "Bugün", 310, 8, 40, "Metro", new String[] {"3","6","12","19","25","33","37"}, new String[] {"2","7","15","20","22","28","34","38"});
		Otobus otobus15 = new Otobus("İstanbul", "İzmir", "17.45", "Yarın", 200, 5, 40, "Marmara", new String[] {"1","2","8","16","18","26","33","36","40"}, new String[] {"4","10","14","17","27","31","34"});
		Otobus otobus14 = new Otobus("İstanbul", "İzmir", "13.20", "Yarın", 240, 6, 40, "Ege", new String[] {"7","23","16","40","17","36","11","19"}, new String[] {"2","13","14","20","24","30","37","38","3"});
		Otobus otobus13 = new Otobus("İstanbul", "İzmir", "20.30", "Bugün", 210, 5, 40, "Kamilkoç", new String[] {"8","12","37","35","10","13","17","3"}, new String[] {"7","32","30","22","23","25","9","11"});
		Otobus otobus12 = new Otobus("Ankara", "İstanbul", "05.30", "Bugün", 205, 8, 40, "Başkent", new String[] {"4","35","12","21","32","40","1"}, new String[] {"2","31","30","17","38","29","19"});
		Otobus otobus11 = new Otobus("Ankara", "İstanbul", "19.45", "Yarın", 199, 7, 40, "Marmara", new String[] {"26","12","37","40","16","6","19"}, new String[] {"5","36","30","14","33","22","28"});	
		Otobus otobus10 = new Otobus("Ankara", "İstanbul", "21.00", "Bugün", 199, 7, 40, "SES", new String[] {"37","8","16","30"}, new String[] {"35","1","17","23"});
		Otobus otobus9 = new Otobus("İstanbul", "İzmir", "16.30", "Bugün", 200, 6, 40, "Ege", new String[] {"21","1","32","40"}, new String[] {"2","4","25","23"});
		Otobus otobus8 = new Otobus("İstanbul", "Ankara", "15.30", "Yarın", 249, 8, 40, "İnan", new String[] {"5","17","3","5","14","21","26"}, new String[] {"31","39","25","16","18","22","37"});
		Otobus otobus7 = new Otobus("İstanbul", "Ankara", "12.00", "Yarın", 285, 7, 40, "Ünal", new String[] {"5","17","39","12","14","21","26"}, new String[] {"11","13","15","16","25","22","37"});
		Otobus otobus6 = new Otobus("İstanbul", "Ankara", "08.00", "Yarın", 365, 8, 40, "Kamilkoç", new String[] {"1","2","3","4","5","6","13","16","34"}, new String[] {"21","22","23","24","25","26"});
		Otobus otobus5 = new Otobus("İstanbul", "Ankara", "16.00", "Bugün", 200, 7, 40, "Varan", new String[] {"21","1","3","40"}, new String[] {"2","4","25"});	
		Otobus otobus4 = new Otobus("İstanbul", "Ankara", "16.00", "Bugün", 200, 7, 40, "Marmara", new String[] {"26","12","37","40","16","6","19"}, new String[] {"5","36","30","14","33","22","28"});	
		Otobus otobus3 = new Otobus("Ankara", "İstanbul", "13.00","Yarın" , 310, 8, 40, "Pamukkale", new String[] {"31","29","5"}, new String[] {"32","19","15"});
		Otobus otobus2 = new Otobus("İstanbul", "Ankara", "21.00", "Yarın", 350, 6, 40, "SES", new String[] {"37","8","16","30"}, new String[] {"35","1","17","23"});
		Otobus otobus1 = new Otobus("Ankara", "İstanbul","03.00", "Bugün", 180, 65, 40, "Başkent", new String[] {"33","9","31","25","7"},new String[] {"12","4","2","35","26"});
		
		ArrayList<Otobus> otobusList = new ArrayList<>();
		otobusList.add(otobus1);
	    otobusList.add(otobus2);
	    otobusList.add(otobus3);
	    otobusList.add(otobus4);
	    otobusList.add(otobus5);
	    otobusList.add(otobus6);
	    otobusList.add(otobus7);
	    otobusList.add(otobus8);
	    otobusList.add(otobus9);
		otobusList.add(otobus10);
		otobusList.add(otobus11);
		otobusList.add(otobus12);
		otobusList.add(otobus13);
		otobusList.add(otobus14);
		otobusList.add(otobus15);
		otobusList.add(otobus16);
		otobusList.add(otobus17);
		otobusList.add(otobus18);
		otobusList.add(otobus19);
		otobusList.add(otobus20);
		otobusList.add(otobus21);
		otobusList.add(otobus22);
		otobusList.add(otobus23);
		otobusList.add(otobus24);
		otobusList.add(otobus25);
		otobusList.add(otobus26);

		contentPane.setLayout(null);
		//Jformun component'leri
		JCheckBox bugun = new JCheckBox("Bugün");
		bugun.setBounds(133, 133, 63, 21);
		buttonGroup.add(bugun);
		bugun.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(bugun);
		
		JCheckBox yarin = new JCheckBox("Yarın");
		yarin.setBounds(198, 133, 63, 21);
		buttonGroup.add(yarin);
		yarin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(yarin);
		
		kalkis = new JComboBox();
		kalkis.setBounds(133, 63, 127, 21);
		kalkis.setFont(new Font("Tahoma", Font.PLAIN, 13));
		kalkis.setModel(new DefaultComboBoxModel(new String[] {"Seçiniz", "İstanbul", "Ankara", "İzmir"}));
		kalkis.setToolTipText("Kalkilacak Sehir");
		contentPane.add(kalkis);
		
		varis = new JComboBox();
		varis.setBounds(133, 99, 127, 21);
		varis.setFont(new Font("Tahoma", Font.PLAIN, 13));
		varis.setModel(new DefaultComboBoxModel(new String[] {"Seçiniz", "İstanbul", "Ankara", "İzmir"}));
		contentPane.add(varis);
		
		JButton btnNewButton = new JButton("Otobüs Bileti Bul");
		btnNewButton.setBounds(55, 172, 206, 35);
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));

		btnNewButton.addActionListener(new ActionListener() {//BUL BUTONU
			public void actionPerformed(ActionEvent e) {
				String tarih=null;
				if(bugun.isSelected()) 
				{
					tarih=(String)bugun.getText();
				}
				else if(yarin.isSelected()) {tarih=(String)yarin.getText();}
				String va = (String)varis.getSelectedItem();
				String ka= (String)kalkis.getSelectedItem();
				String ta= tarih;
				
				if(kalkis.getSelectedItem() == varis.getSelectedItem())
				{
					if(kalkis.getSelectedItem().equals("Seçiniz"))
					{
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "Lütfen lokasyon seçiniz", "                         Geçersiz Arama", JOptionPane.ERROR_MESSAGE);
					}
					else if(!kalkis.getSelectedItem().equals("Seçiniz"))
					{
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "Gidiş ve dönüş için aynı lokasyonu seçtiniz. \n         Lütfen farklı bir lokasyon seçiniz.", "                                   Geçersiz Arama", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(kalkis.getSelectedItem() != varis.getSelectedItem())
				{
					if(kalkis.getSelectedItem().equals("Seçiniz") && !varis.getSelectedItem().equals("Seçiniz"))
					{
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "Lütfen lokasyon seçiniz", "                         Geçersiz Arama", JOptionPane.ERROR_MESSAGE);
					}
					else if(varis.getSelectedItem().equals("Seçiniz") && !kalkis.getSelectedItem().equals("Seçiniz"))
					{
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "Lütfen lokasyon seçiniz", "                         Geçersiz Arama", JOptionPane.ERROR_MESSAGE);
					}
					else if(kalkis.getSelectedItem() != varis.getSelectedItem())
					{
						if(bugun.isSelected() == true || yarin.isSelected() == true)
						{
							OtobusBiletiSecim biletsecim=new OtobusBiletiSecim(otobusList,ka,va,ta);
							biletsecim.setVisible(true);
						}
						else if(bugun.isSelected() == false && yarin.isSelected() == false)
						{
							JFrame frame = new JFrame();
							JOptionPane.showMessageDialog(frame, "Lütfen gidiş tarihi seçiniz", "                         Geçersiz Arama", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel text1 = new JLabel("Nereden");
		text1.setBounds(55, 65, 56, 16);
		text1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(text1);
		
		JLabel text2 = new JLabel("Nereye");
		text2.setBounds(55, 95, 56, 28);
		text2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(text2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 42);
		contentPane.add(panel);

		JMenuBar menu = new JMenuBar();
		menu.setBackground(Color.white);
		menu.setBounds(0, 0, 330, 26);
		
		JMenu hesabım = new JMenu("Hesabım");
		hesabım.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JMenuItem cikis = new JMenuItem("Çıkış       ");
		cikis.setHorizontalAlignment(SwingConstants.CENTER);
		cikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GirisYap girisYap = new GirisYap();
				girisYap.setVisible(true);
				hide();
			}
		});
		panel.setLayout(null);
		cikis.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		hesabım.add(cikis);
		
		JMenu biletSorgula = new JMenu("PNR ile Bilet Sorgula");
		biletSorgula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PnrBiletSorgula biletCheck = new PnrBiletSorgula();
				biletCheck.setVisible(true);
			}
		});
		biletSorgula.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JMenu uygulamaCik = new JMenu("Uygulamadan Çık");
		uygulamaCik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		uygulamaCik.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menu.add(hesabım);
		menu.add(biletSorgula);	
		menu.add(uygulamaCik);
		panel.add(menu);
		
		JLabel lblGidiTarihi = new JLabel("Gidiş Tarihi");
		lblGidiTarihi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGidiTarihi.setBounds(55, 129, 72, 28);
		contentPane.add(lblGidiTarihi);
	}
}
