class Tontti {
  private String pituusAste;
  private String leveysAste;
  private String nimi;
  private String pintaAla;
  private Rakennus rakennus;

  public Tontti(){
    //konstruktori, joka aktivoituu tarkastin-olion kutsun yhteydessä
  }

  public Tontti(String nimi, String pintaAla, String leveysAste, String pituusAste){
    this.rakennus = new Rakennus();
    this.nimi = nimi;
    this.pintaAla = pintaAla;
    this.leveysAste = leveysAste;
    this.pituusAste = pituusAste;
  }

  public void pituusAsteSetter(String syote){
    pituusAste = syote;
  }

  public void leveyAsteSetter(String syote){
    leveysAste = syote;
  }

  public String pituusAsteGetter(){
    return pituusAste;
  }

  public void nimiSetter(String syote){
    nimi = syote;
  }

  public void pintaAlaSetter(String syote){
    pintaAla = syote;
  }

  public void setRakennus(String huoneistot, String pintaAla){
    rakennus.pintaAlaSetter(pintaAla);
    rakennus.huoneetSetter(huoneistot);
  }

  public void printRakennus(){
    rakennus.printRakennus();
  }

  public void setAsukas(String nimi, String ika){
    rakennus.setAsukas(nimi, ika);
  }

  public void printAsukas(){
    rakennus.printAsukas();
  }

  public void printTontti(){ //Print funktio kaikelle olion sisältämälle tiedolle
    String tontinnimi = "Tontin Nimi: ";
    String info = tontinnimi + nimi + "\nPinta-ala: " + pintaAla + "\nLeveysasteet: " + leveysAste + "\nPituusasteet: " + pituusAste;
    System.out.println(info);
  }

  public int koordinaattitarkistin(String syote){ //syötetarkistin tontin koordinaateille

    int n = 0,
    tarkistin = 0;

    switch(syote.charAt(syote.length() - 1)){
      case 'N':
        tarkistin = 1;
        break;
      case 'E':
        tarkistin = 2;
        break;
      case 'S':
        tarkistin = 1;
        break;
      case 'W':
        tarkistin = 2;
        break;
      default:
        tarkistin = 0;
    }

    while(n < syote.length() - 1){
      if((syote.charAt(n) < '0' || syote.charAt(n) > '9') && syote.charAt(n) != '.'){
        tarkistin = 0;
        break;
      }
      n++;
    }
    return (tarkistin);
  }

  public int nimitarkistin(String syote){ //syötetarkistin tontin sekä asukkaiden nimille
    int n = 0,
    tarkistin = 0;

    while(n < syote.length()){
      if((syote.charAt(n) < '0' || syote.charAt(n) > '9') && (syote.charAt(n) < 'a' || syote.charAt(n) > 'z') && (syote.charAt(n) < 'A' || syote.charAt(n) > 'Z') && syote.charAt(n) != ' '){
        tarkistin = 1;
        break;
      }
      n++;
    }
    return tarkistin;
  }

  public int pintaAlaTarkistin(String syote){ //syötetarkistin tontin sekä rakennuksen pinta-alalle. Käytetään myös muiden desimaalilukujen tarkistamiseen
    int n = 0,
    tarkistin = 0;

    while(n < syote.length()){
      if((syote.charAt(n) < '0' || syote.charAt(n) > '9') && syote.charAt(n) != '.'){
        tarkistin = 1;
        break;
      }
      n++;
    }
    return (tarkistin);
  }



}
