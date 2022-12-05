import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class Hirsipuu {
  private Random rand = new Random();
  private String sana;
  private int arvausMaara, indeksi, oikein;
  private List<Character> arvatut = new ArrayList<Character>();
  private StringBuilder peitetty;


  public Hirsipuu(List<String> lista, int arvaukset) {
    arvausMaara = arvaukset;
    indeksi = rand.nextInt(lista.size()); //valitaan satunnaisesti arvattava sana
    sana = lista.get(indeksi);
    peitetty = new StringBuilder(sana);
    this.primePeitetty();
  }

  private void primePeitetty(){ //Alustetaan peitelty sana
    int n = 0;
    while(n < sana.length()){
      peitetty.setCharAt(n, '_');
      n++;
    }
  }

  private void muokkaaPeitetty(char merkki){ //Muokataan peiteltyä sanaa sitä mukaan, kun pelaaja arvaa kirjaimia oikein
    int n = 0;

    while(n < sana.length()){
      if(merkki == sana.charAt(n) || merkki == sana.charAt(n) + 32 || merkki == sana.charAt(n) - 32){
        peitetty.setCharAt(n, sana.charAt(n));
      }
      n++;
    }

  }

  public boolean arvaa(char merkki){ //Metodi tarkastaa löytyykö arvattua kirjainta sanasta, jos arvaus on väärin, vähennetään yksi arvaus pelaajalta
    int n = 0, x = 0, oikeintemp = 0, tarkistin = 0;

    while(x < arvatut.size()){
      if(arvatut.get(x) == merkki || arvatut.get(x) == merkki + 32 || arvatut.get(x) == merkki - 32){
        System.out.println("Tama merkki on jo arvattu!");
        tarkistin = 1;
        break;
      }
      x++;
    }

    arvatut.add(merkki);

    while(n < sana.length() && tarkistin == 0){
      if(sana.charAt(n) == merkki || sana.charAt(n) == merkki + 32 || sana.charAt(n) == merkki - 32){
        oikeintemp++;
        oikein++;
        this.muokkaaPeitetty(merkki);
      }
      n++;
    }

    if(oikeintemp == 0 && tarkistin == 0) {
      arvausMaara--;
      return(false);
    }
    else{
      return(true);
    }
  }

  public String getPeitetty(){
    return(peitetty.toString());
  }

  public List<Character> arvaukset(){
    return(arvatut);
  }

  public int arvauksiaOnJaljella(){
    return(arvausMaara);
  }

  public String sana(){
    return(sana);
  }

  public String getSana(){
    return(sana);
  }

  public boolean onLoppu(){
    if(oikein == sana.length() || arvausMaara == 0){
      return(true);
    }
    else{
      return(false);
    }
  }




}
