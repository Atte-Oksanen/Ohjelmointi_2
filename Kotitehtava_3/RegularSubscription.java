class RegularSubscription extends Subscription { //luokassa ei asetusmetodeja, sillä tietoja ei tarvitse muokata

  private int kesto;

  RegularSubscription(String lehdenNimi, String nimi, String osoite, double hinta, int kesto){
    super(lehdenNimi, nimi, osoite, hinta);
    this.kesto = kesto;
  }

    public void print(){
      System.out.println("Tilauksen tyyppi: Kuukausitilaus\nLehden nimi: "+ lehden_nimi + "\nTilaajan nimi: " + tilaajan_nimi);
      System.out.println("Toimitusosoite: " + toimitusosoite + "\nLaskutettavat kuukaudet: " + kesto);
      System.out.printf("Kokonaishinta: %.2f", hinta * kesto);
  }
}
