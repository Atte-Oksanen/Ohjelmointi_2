import java.util.Scanner;

class Vt3main  {
  private static String lehdenNimi, nimi, osoite;
  private static int valinta = 0, kesto = 0, menu = 0;
  private static double hinta;
  public static Scanner scan = new Scanner(System.in);

public static void main(String[] args) {
  int n = 0, y = 0;
  Subscription sub[] = new Subscription[100];

  while(menu !=2){
    System.out.println("Tervetuloa automatisoituun tilauspalveluumme \nMinka lehden haluaisitte tilata?");
    setLehdenNimi(); //Määritetään lehden nimi, sisältää syötteentarkistuksen, ei hyväksy erikoismerkkejä.
    setValinta(); //Valitaan tilausmuoto, sisältää syötteentarkistuksen.
    if(valinta == 2){
      setKesto(); //Määritetään tilauksen kesto.
    }
    else{
      kesto = 12;
    }
    setAsiakas(); //Määritetään asiakkaan tiedot.

    if(valinta == 1){ //luodaan oliot käyttäjän syöttämillä tiedoilla.
     sub[n] = new StandingSubscription(lehdenNimi, nimi, osoite, hinta, kesto);
   }
    else{
      sub[n] = new RegularSubscription(lehdenNimi, nimi, osoite, hinta, kesto);
    }
    System.out.println("Haluaisitteko tehda uuden tilauksen?\n1: Kylla\n2: Ei");
    setMenu();
    n++;
  }
  System.out.println("Yhteenveto tehdyista tilauksista:"); //tulostetaan kaikkien tilauksien tiedot

  while(y < n){
    printSubscriptionInvoice(sub[y]);
    y++;
  }
}

static void setLehdenNimi(){
  int tarkistin = 0, n = 0;
  char test;
  do {
    tarkistin = 0;
    lehdenNimi = scan.nextLine();
    while(n < lehdenNimi.length()){
      test = lehdenNimi.charAt(n);
      if((test < '0' || test > '9') && (test < 'A' || test > 'Z') && (test < 'a' || test > 'z') && test != ' '){
        tarkistin = 1;
        System.out.println("Virheellinen syote. \nAnna uusi syote.");
        break;
      }
      n++;
    }
  } while (tarkistin == 1);
  hinta = lehdenNimi.length();


}

static void setValinta(){
  int tarkistin = 0;
  System.out.println("Lehden kuukausitilauksen hinta on " + hinta + " euroa\nHaluatteko jatkuvan 12kk tilauksen vai kuukausitilauksen?\n(12kk:n tilauksessa patee 20% alennus)\n1: 12kk tilaus\n2: Kuukausitilaus\n");

  do{
    tarkistin = 0;
    try {
      valinta = scan.nextInt();
    }
    catch (Exception e){
      tarkistin = 1;
      scan.nextLine();
    }
    if(tarkistin != 1 && (valinta > 2 || valinta < 1)){
      System.out.println("Virheellinen syote.\nAnna uusi syote.");
      tarkistin = 1;
    }
  } while(tarkistin == 1);
  scan.nextLine();

}

static void setKesto(){
  int tarkistin = 0;
  System.out.println("Kuinka monta kuukautta haluaisitte tilata lehtea?");

  do{
    tarkistin = 0;
    try {
      kesto = scan.nextInt();
    }
    catch (Exception e){
      tarkistin = 1;
      scan.nextLine();
    }
    if(tarkistin != 1 && kesto < 1){
      System.out.println("Virheellinen syote.\nAnna uusi syote.");
      tarkistin = 1;
    }
  } while(tarkistin == 1);
  scan.nextLine();


}

static void setAsiakas(){
  int tarkistin = 0, n = 0;
  char test;

  System.out.println("Kiitos tilauksesta! \nTarvitsisimme viela laskutustiedot. \nNimi:");
  do {
    tarkistin = 0;
    nimi = scan.nextLine();
    while(n < nimi.length()){
      test = nimi.charAt(n);
      if((test < 'A' || test > 'Z') && (test < 'a' || test > 'z') && test != ' '){
        tarkistin = 1;
        System.out.println("Virheellinen syote. \nAnna uusi syote.");
        break;
      }
      n++;
    }
  } while (tarkistin == 1);

  System.out.println("Toimitusosoite:");
  do {
    tarkistin = 0;
    osoite = scan.nextLine();
    while(n < osoite.length()){
      test = osoite.charAt(n);
      if((test < '0' || test > '9') && (test < 'A' || test > 'Z') && (test < 'a' || test > 'z') && test != ' '){
        tarkistin = 1;
        System.out.println("Virheellinen syote. \nAnna uusi syote.");
        break;
      }
      n++;
    }
  } while (tarkistin == 1);


}

static void setMenu(){
  int tarkistin = 0;
  do{
    tarkistin = 0;
    try {
      menu = scan.nextInt();
    }
    catch (Exception e){
      tarkistin = 1;
      scan.nextLine();
    }
    if(tarkistin != 1 && (menu > 2 || menu < 1)){
      System.out.println("Virheellinen syote.\nAnna uusi syote.");
      tarkistin = 1;
    }
  } while(tarkistin == 1);
  scan.nextLine();
}

static void printSubscriptionInvoice(Subscription sub){
  System.out.println("\n");
  sub.print();
}




}
