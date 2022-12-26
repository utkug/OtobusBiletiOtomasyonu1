import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JProgressBar;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JPasswordField;

public class OtobusBiletiSecim extends JFrame {
	
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtobusBiletiSecim frame = new OtobusBiletiSecim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param string2 
	 * @param string 
	 * @param otobusList 
	 */
	public OtobusBiletiSecim(List<Otobus> otobusList, String ka, String va,String ta) {
		setTitle("Sonuçlar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seferler: "+ka+" - "+va);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(190, 10, 300, 23);
		contentPane.add(lblNewLabel);
		JLabel sonuclarEkran = new JLabel();
	
		
		int i=0,y=-25;//Aranmak istenen sonucların listelendiği yer
		JLabel[] label = new JLabel[10];
		JButton[] button=new JButton[10];
		for (Otobus bus: otobusList) {
			if(!(bus.listele(bus, ka, va,ta)==null)) {
				y+=35;
			    label[i] = new JLabel();
			    label[i].setText(bus.listele(bus, ka, va,ta));
			   label[i].setFont(new Font("Tahoma", Font.PLAIN, 13));
			    label[i].setBounds(12, y, 500, 120);
				contentPane.add(label[i]);
				button[i] = new JButton("İncele");
				button[i].setBackground(new Color(192, 192, 192));
				button[i].setFont(new Font("Tahoma", Font.PLAIN, 9));
				button[i].setBounds(500, y+50, 85, 18);
				contentPane.add(button[i]);
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						KoltukSecim KoltukSecim=new KoltukSecim(bus);
						KoltukSecim.setVisible(true);
					}
				});
				i+=1;
			}
			
		}
	}
}
