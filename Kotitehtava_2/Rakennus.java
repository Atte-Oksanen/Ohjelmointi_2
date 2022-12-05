class Rakennus {
  private String pintaAla;
  private String huoneet;
  private Asukkaat asukkaat;


  public Rakennus(){
    this.asukkaat = new Asukkaat();
  }
  public void pintaAlaSetter(String syote){
    pintaAla = syote;
  }

  public void huoneetSetter(String syote){
    huoneet = syote;
  }


  public void setAsukas(String nimi, String ika){
    asukkaat.SetAsukas(nimi, ika);
  }
  public void printAsukas(){
    asukkaat.printAsukas();
  }

  public void printRakennus(){ //Print funktio kaikelle olion sisältämälle tiedolle
    String ala = "Rakennuksen pinta-ala: ";
    String info = ala + pintaAla + "\nHuoneiden lukumaara: " + huoneet;
    System.out.println(info);
  }
}
