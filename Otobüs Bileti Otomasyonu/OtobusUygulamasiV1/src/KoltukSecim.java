import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Font;
import java.awt.JobAttributes;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class KoltukSecim extends JFrame {
	
	int secilenKoltukSayisi=0;
	String secKoltuk=null;
	private JPanel contentPane;
	JTextField[] gosterge= new JTextField[4];
	Boolean kontrol;//KOltuk secimi icin kullanılan bir true false
	JTextField temp[]=new JTextField[40];//Koltuk secimi kaldırma icin kullanılan gecici bir değişken
	JLabel lblNewLabel_1 = new JLabel();
	JFrame frame = new JFrame();
	ArrayList<Integer> secilenKoltuklar = new ArrayList<Integer>();//Secilen koltukların numaraları icin bir ArrayList
	static String[] cinsiyet= new String[4];//Cinsiyeti tutmak icin
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KoltukSecim frame = new KoltukSecim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public int getNo(JButton buton) {
		String strNo = buton.getText();
		int intNo = Integer.parseInt(strNo);
		return intNo;
	}
	public void genelIslem(JButton buton,String index) {
		buton.addActionListener(new ActionListener() {//8
			public void actionPerformed(ActionEvent e) {
				int no = getNo(buton);
				int secim = JOptionPane.showConfirmDialog(null,"Cinsiyet Seciniz","Secim Ekrani",JOptionPane.YES_NO_CANCEL_OPTION);
				if(secim==JOptionPane.YES_OPTION) {islemErkek(buton,""+no);}
				if(secim==JOptionPane.NO_OPTION) {islemKadin(buton,""+no);}
				if(secim==JOptionPane.CANCEL_OPTION) {islemKaldir(buton, ""+no);}
			}
		});
	}
	
	public void islemErkek(JButton buton,String index) {//Erkek secilmek istenirse
		if(secilenKoltukSayisi==4) {JOptionPane.showMessageDialog(new JFrame(), "Aynı anda maksimum 4 adet koltuk satın alabilirsiniz.", "Hata Ekranı",JOptionPane.ERROR_MESSAGE); return;}
		buton.setBackground(new Color(0, 128, 255))	;
		   for(int i=0;i<4;i++) {
			   if( gosterge[i].getText().equals(index)) { kontrol=false; gosterge[i].setBackground(Color.BLUE);break;}
		   else {kontrol=true;}}
			   for(int i=0;i<4;i++) {  
			    if( gosterge[i].getBackground()==Color.GRAY &&  gosterge[i].getText().equals("")&&kontrol) {
				   gosterge[i].setFont(new Font("Tahoma", Font.PLAIN, 12));
				   gosterge[i].setBackground(new Color(0, 128, 255));
				   gosterge[i].setBackground(Color.BLUE);
				   gosterge[i].setForeground(Color.WHITE);
				   gosterge[i].setText(index);
				   secilenKoltukSayisi+=1;
				   int intIndex = Integer.parseInt(index);
				   secilenKoltuklar.add(intIndex);
				   temp[intIndex-1]= gosterge[i];
				   break;
  		  }
		  }}
	
	public void islemKadin(JButton buton, String index) {//Kadin secilmek istenirse
		if(secilenKoltukSayisi==4) {JOptionPane.showMessageDialog(new JFrame(), "Aynı anda maksimum 4 adet koltuk satın alabilirsiniz.", "Hata Ekranı",JOptionPane.ERROR_MESSAGE); return;}
		buton.setBackground(new Color(255, 128, 192));

		   for(int i=0;i<4;i++) {
			   if( gosterge[i].getText().equals(index)) { kontrol=false; gosterge[i].setBackground(Color.PINK);break;}
		   else {kontrol=true;}}
			   for(int i=0;i<4;i++) {  
			    if( gosterge[i].getBackground()==Color.GRAY &&  gosterge[i].getText().equals("")&&kontrol) {
				   gosterge[i].setFont(new Font("Tahoma", Font.PLAIN, 12));
				   gosterge[i].setBackground(new Color(0, 128, 255));
				   gosterge[i].setBackground(Color.PINK);
				   gosterge[i].setForeground(Color.WHITE);
				   gosterge[i].setText(index);
				   secilenKoltukSayisi+=1;
				   int intIndex = Integer.parseInt(index);
				   secilenKoltuklar.add(intIndex);
		  		   temp[intIndex-1]= gosterge[i];
				   break;
 		  }
		  }
	}
	
	public void islemKaldir(JButton buton, String index) {//Secilen koltuk iptal edinmek istenirse
		int tempNo= Integer.parseInt(buton.getText());
		if(temp[tempNo-1]==null) {return;}
		buton.setSelected(false);
		buton.setBackground(new Color(240, 240, 240));
		secilenKoltukSayisi-=1;
		 int intIndex = Integer.parseInt(index);
		 temp[intIndex-1].setBackground(Color.GRAY);
		 temp[intIndex-1].setText("");
		 secilenKoltuklar.removeAll(Arrays.asList(intIndex));
		contentPane.revalidate();
		contentPane.repaint();}
	public KoltukSecim(Otobus bus) {//Ana metod
		setTitle("Koltuk Secme Ekranı");
		UIManager.put("OptionPane.cancelButtonText", "Secimi Kaldir");
        UIManager.put("OptionPane.yesButtonText", "Erkek");
        UIManager.put("OptionPane.noButtonText", "Kadin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		int x=380;
		for(int i=0;i<4;i++) {	//Alt taraftaki gostergeler
			gosterge[i]=new JTextField();
			gosterge[i].setBounds(x,194,20,20);
			gosterge[i].setBackground(Color.GRAY);
			gosterge[i].setText("");
			contentPane.add(gosterge[i]);
			x+=20;
		}

		JButton butonlar[]=new JButton[40];
		for(int i=0;i<40;i++) {
			butonlar[i]= new JButton(""+(i+1));
			butonlar[i].setBackground(new Color(240, 240, 240));
			contentPane.add(butonlar[i]);
			
		}
		
	//Dolmuş koltukları boyamak icin Erkek
	for(String koltuk: bus.erkekKoltuk) {
		for(JButton buton: butonlar) {
			if(buton.getText().equals(koltuk)) {
				buton.setBackground(new Color(0, 128, 255));
				buton.setEnabled(false);
			}
		}
	}
	//Dolmuş koltukları boyamak icin Kadin
	for(String koltuk1: bus.kadinKoltuk) {
		for(JButton buton: butonlar) {
		if(buton.getText().equals(koltuk1)) {
				buton.setBackground(new Color(255, 128, 192));
				buton.setEnabled(false);
			}
			}
	}
		contentPane.setLayout(null);
		for(int i=0;i<40;i++) {//Koltuk islemleri
			genelIslem(butonlar[i],""+(i+1));
		}
		//Koltuk konumlari
		butonlar[0].setBounds(60, 23, 53, 31);
		butonlar[9].setBounds(245, 23, 53, 31);
		butonlar[12].setBounds(308, 23, 53, 31);
		butonlar[15].setBounds(371, 23, 53, 31);
		butonlar[18].setBounds(434, 23, 53, 31);
		butonlar[4].setBounds(123, 64, 53, 31);
		butonlar[7].setBounds(182, 64, 53, 31);
		butonlar[10].setBounds(245, 64, 53, 31);
		butonlar[1].setBounds(60, 64, 53, 31);
		butonlar[2].setBounds(123, 23, 53, 31);
		butonlar[3].setBounds(123, 23, 53, 31);
		butonlar[6].setBounds(182, 23, 53, 31);
		butonlar[13].setBounds(308, 64, 53, 31);
		butonlar[16].setBounds(371, 64, 53, 31);
		butonlar[19].setBounds(434, 64, 53, 31);
		butonlar[2].setBounds(60, 126, 53, 31);
		butonlar[5].setBounds(123, 126, 53, 31);
		butonlar[8].setBounds(182, 126, 53, 31);
		butonlar[11].setBounds(245, 126, 53, 31);
		butonlar[14].setBounds(308, 126, 53, 31);
		butonlar[17].setBounds(371, 126, 53, 31);
		butonlar[20].setBounds(434, 126, 53, 31);
		butonlar[21].setBounds(497, 126, 53, 31);
		butonlar[24].setBounds(560, 126, 53, 31);
		butonlar[22].setBounds(560, 23, 53, 31);
		butonlar[23].setBounds(560, 64, 53, 31);
		butonlar[25].setBounds(623, 23, 53, 31);
		butonlar[26].setBounds(623, 64, 53, 31);
		butonlar[27].setBounds(623, 126, 53, 31);
		butonlar[28].setBounds(686, 23, 53, 31);
		butonlar[29].setBounds(686, 64, 53, 31);
		butonlar[30].setBounds(686, 126, 53, 31);
		butonlar[31].setBounds(749, 23, 53, 31);
		butonlar[32].setBounds(749, 64, 53, 31);
		butonlar[33].setBounds(749, 126, 53, 31);
		butonlar[34].setBounds(812, 23, 53, 31);
		butonlar[35].setBounds(812, 64, 53, 31);
		butonlar[36].setBounds(812, 126, 53, 31);
		butonlar[37].setBounds(875, 23, 53, 31);
		butonlar[38].setBounds(875, 64, 53, 31);
		butonlar[39].setBounds(875, 126, 53, 31);
		
		JLabel lblNewLabel = new JLabel("Şoför");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 126, 40, 42);
		contentPane.add(lblNewLabel);
		
		JButton onaylaVeDevam = new JButton("Onayla ve Devam et");
		onaylaVeDevam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		onaylaVeDevam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText("Seçilen Koltuklar: "+secilenKoltuklar.size());
				OdemeYap odemeYap;
				try {
					secilenKoltuklar.removeAll(secilenKoltuklar);
					for(JTextField gos: gosterge) {
						if(gos.getBackground()==Color.BLUE) {
							secilenKoltuklar.add(Integer.parseInt(gos.getText()));
						}
						else if(gos.getBackground()==Color.PINK) {
							
							secilenKoltuklar.add(Integer.parseInt(gos.getText()));
						}
					}
					
					for(int i=0;i<4;i++) {
						if(gosterge[i].getBackground()==Color.BLUE) {
							cinsiyet[i]="Erkek";
						}
						else if(gosterge[i].getBackground()==Color.PINK) {
							cinsiyet[i]="Kadın";
						}
					}
					odemeYap = new OdemeYap(bus,secilenKoltukSayisi, secilenKoltuklar);
					odemeYap.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		onaylaVeDevam.setBounds(60, 191, 144, 31);
		contentPane.add(onaylaVeDevam);
		
		JLabel secilenKoltukarLabel = new JLabel("Secilen Koltuklar:");
		secilenKoltukarLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		secilenKoltukarLabel.setBounds(279, 194, 98, 22);
		contentPane.add(secilenKoltukarLabel);
		
		lblNewLabel_1.setBounds(623, 191, 134, 31);
		contentPane.add(lblNewLabel_1);
		
	}
}
