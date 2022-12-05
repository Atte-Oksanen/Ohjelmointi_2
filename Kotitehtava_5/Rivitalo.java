import java.util.ArrayList;
import java.util.List;

class Rivitalo extends Rakennus{
  private ArrayList<Integer> pintaAla = new ArrayList<Integer>();
  private ArrayList<Integer> huoneet = new ArrayList<Integer>();

  public Rivitalo(int huoneistot){
    super(huoneistot);
  }

  public void setHuoneet(int huoneet){
    this.huoneet.add(huoneet);
  }

  public void setPintaAla(int syote){
    this.pintaAla.add(syote);
  }

  public void printRakennus(){
    int n = 0;
    super.printRakennus();
    while(n < pintaAla.size()){
      System.out.println("Huoneiston tiedot:\nPinta-ala:" + pintaAla.get(n) + "\nHuoneiden lukumaara:" + huoneet.get(n));
      n++;
    }
  }

}
