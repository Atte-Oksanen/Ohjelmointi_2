class StandingSubscription extends Subscription{ //luokassa ei asetusmetodeja, sillä tietoja ei tarvitse muokata.

  private int alennus = 20;


  StandingSubscription(String lehdenNimi, String nimi, String osoite, double hinta, int kesto){
    super(lehdenNimi, nimi, osoite, hinta - (hinta / 5));
  }

    public void print(){
      System.out.println("Tilauksen tyyppi: 12kk Kestotilaus\nLehden nimi: "+ lehden_nimi + "\nTilaajan nimi: " + tilaajan_nimi);
      System.out.println("Toimitusosoite: " + toimitusosoite + "\nLaskutettavat kuukaudet: 12");
      System.out.printf("Kokonaishinta: %.2f", hinta * 12);
    }


}
