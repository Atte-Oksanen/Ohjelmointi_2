import java.util.ArrayList;
import java.util.List;

class InsInfoContainer {
  private ArrayList<InsuranceInfo> container;


  public InsInfoContainer(){
    container = new ArrayList<InsuranceInfo>();
  }


  public void addInfo(InsuranceInfo info){
    container.add(info);
  }

  public void getInfo(){ //metodi, jolla tulostetaan koko arraylist
    int y = 0;
    while(y < container.size()){
      container.get(y).print();
      System.out.println("");
      y++;
    }
  }

  public void minArvo(double arvo){ //metodi, joka tulostaa vain parametrina saadun arvon ylittävät alkiot
    int y = 0, n = 0;

    while(y < container.size()){
      if(container.get(y).getArvo() > arvo){
        container.get(y).print();
        n++;
      }
      y++;
    }
    if(n == 0){
      System.out.println("Haulla ei loytynyt kohteita");
    }
  }

  public void maxArvo(double arvo){ //metodi, joka tulostaa vain parametrina saadun arvon alittavat alkiot
    int y = 0, n = 0;

    while(y < container.size()){
      if(container.get(y).getArvo() < arvo){
        container.get(y).print();
        n++;
      }
      y++;
    }
    if(n == 0){
      System.out.println("Haulla ei loytynyt kohteita");
    }
  }
}
