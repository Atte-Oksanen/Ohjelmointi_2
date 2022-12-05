import java.util.ArrayList;
import java.util.List;

class Rakennus {
  private int huoneistot;
  private ArrayList<Asukkaat> asukkaat = new ArrayList<Asukkaat>();


  public Rakennus(int huoneistot){
    this.huoneistot = huoneistot;
  }


  public void setAsukas(String nimi){
    asukkaat.add(new Asukkaat(nimi));
  }

  public void printAsukas(){
    int n = 0;
    while(n < asukkaat.size()){
      asukkaat.get(n).printAsukas();
      n++;
    }
  }

  public void printRakennus(){
    System.out.println("Huoneistojen lukumaara: " + huoneistot);
  }
}
