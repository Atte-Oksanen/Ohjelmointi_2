class Omakotitalo extends Rakennus{
  private int pintaAla;
  private int huoneet;

  public Omakotitalo(int huoneistot){
    super(huoneistot);
  }

  public void setHuoneet(int huoneet){
    this.huoneet = huoneet;
  }

  public void setPintaAla(int pintaAla){
    this.pintaAla = pintaAla;
  }
  public void printRakennus(){
    System.out.println("Omakotitalon tiedot:\nPinta-ala:" + pintaAla + "\nHuoneiden lukumaara:" + huoneet);
  }

}
