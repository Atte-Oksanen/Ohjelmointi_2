class Subscription {

  protected String lehden_nimi, tilaajan_nimi, toimitusosoite;
  protected double hinta;


  Subscription(String lehden_nimi, String tilaajan_nimi, String toimitusosoite, double hinta){
    this.lehden_nimi = lehden_nimi;
    this.tilaajan_nimi = tilaajan_nimi;
    this.toimitusosoite = toimitusosoite;
    this.hinta = hinta;
  }

  public void print(){
  }
}
