import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Otobus {
    public Otobus(String kalkis, String varis,String saat,String kalkisTarih,int fiyat, int tahminiSure,int koltukSayi,String turizm, String[] erkekKoltuk,String[] kadinKoltuk){
        this.kalkis=kalkis;
        this.varis=varis;
        this.kalkisTarih=kalkisTarih;
        this.fiyat=fiyat;
        this.tahminiSure=tahminiSure;
        this.koltukSayi=koltukSayi;
        this.turizm=turizm;
        this.saat=saat;
        this.erkekKoltuk=erkekKoltuk;
        this.kadinKoltuk=kadinKoltuk;
    }
    public String getKalkis() {
		return kalkis;
	}

	public String getVaris() {
		return varis;
	}

	public String getSaat() {
		return saat;
	}

	public String getKalkisTarih() {
		return kalkisTarih;
	}

	public int getFiyat() {
		return fiyat;
	}

	public int getTahminiSure() {
		return tahminiSure;
	}

	public int getKoltukSayi() {
		return koltukSayi;
	}

	public String getTurizm() {
		return turizm;
	}

	public String kalkis;
    public String varis;
    public String saat;
    public String kalkisTarih;
    public int fiyat;
    public int tahminiSure;
    public int koltukSayi;
    public String turizm;
    public String[] erkekKoltuk ;
    public String[] kadinKoltuk;   
   
    public String bilgiYazdir(){
       return "Turizm: "+turizm
        +kalkis+"->"+varis+"\n"
        +"Tahmini Varis Suresi: "+tahminiSure+" Saat\n"
        +"Tarih: "+kalkisTarih+"\n"
        +"Fiyat: "+fiyat+"TL";
    }

    public static String listele(Otobus bus,String kalkis,String varis,String tarih){
    	if(!(bus.kalkis.equals(kalkis) && bus.varis.equals(varis)&& bus.kalkisTarih.equals(tarih))) {
    		return null;
    	}
    	return bus.getTurizm()+" Turizm  "+bus.getKalkis()+"-->"+bus.getVaris()+"     "+"Saat: "+bus.getSaat()+"  Tahmini süre "+bus.tahminiSure+" saat"+"     "+ bus.getFiyat()+" TL";
    }
}
