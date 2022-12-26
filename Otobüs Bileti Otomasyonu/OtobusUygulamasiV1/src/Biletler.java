import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.JTextField;

abstract class Biletler {//Biletlerin ana abstract sınıfı
     public void biletBilgileri(JPanel panel) {

     }
     public void bul(JTextField txtPnrNo, JPanel panel, int secilenKoltukSayisi) throws SQLException {
    	 
     }
     public void reset() {}
}