import java.util.Scanner;

class Main {
  public static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    int n = 0, tarkistin = 0, y = 0;
    String nimi, ika, leveysAste, pituusAste, tontinNimi, pintaAla, pintaAlarakennus, huoneistot;

    System.out.println("Syota tontin tiedot\n"); //pyydetään käyttäjältä tontin tiedot. Sisältää syötteentarkistuksen
    tontinNimi = TontinNimiSetter();
    pintaAla = pintaAlaSetter();
    leveysAste = leveysAsteSetter();
    pituusAste = pituusAsteSetter();
    Tontti tontti = new Tontti(tontinNimi, pintaAla, leveysAste, pituusAste);

    System.out.println("Syota rakennuksen tiedot\n"); //pyydetään käyttäjältä rakennuksen tiedot. Sisältää syötteentarkistuksen
    pintaAlarakennus = pintaAlarakennusSetter();
    huoneistot = huoneistotSetter();
    tontti.setRakennus(huoneistot, pintaAlarakennus);

    System.out.println("\nSyota asukkaan tiedot (Max 100 asukasta) \nSyota 0 siirtyaksesi eteenpain\n"); //pyydetään käyttäjältä asukkaan tiedot. Sisältää syötteentarkistuksen
    while(true){
      nimi = nimiSetter();
      if(nimi.compareTo("0") == 0){
        break;
      }
      ika = ikaSetter();
      tontti.setAsukas(nimi, ika);
      n++;
    }

    tontti.printTontti(); //tulostetaan kaikkien olioiden sisältö
    tontti.printRakennus();
    tontti.printAsukas();
  }

  static String TontinNimiSetter(){
    Tontti tontti = new Tontti();
    int tarkistin = 0;
    String tontinNimi;
    do {
      System.out.println("Nimi:");
      tontinNimi = scan.nextLine();
      tarkistin = tontti.nimitarkistin(tontinNimi);
      if(tarkistin == 1){
        System.out.println("Virheellinen syote!");
      }
    } while (tarkistin != 0);

    return(tontinNimi);
  }

  static String pintaAlaSetter(){
    Tontti tontti = new Tontti();
    int tarkistin = 0;
    String pintaAla;
    do {
      System.out.println("Pinta-ala:");
      pintaAla = scan.nextLine();
      tarkistin = tontti.pintaAlaTarkistin(pintaAla);
      if(tarkistin == 1){
        System.out.println("Virheellinen syote!");
      }
    } while (tarkistin != 0);
    return(pintaAla);
  }

  static String leveysAsteSetter(){
    Tontti tontti = new Tontti();
    int tarkistin = 0;
    String leveysAste;

    do {
      System.out.println("Leveysasteet:(Muodossa 123.3456N)");
      leveysAste = scan.nextLine();
        tarkistin = tontti.koordinaattitarkistin(leveysAste);
        if(tarkistin != 1){
          System.out.println("Virheellinen syote!");
        }
    } while (tarkistin != 1);
    return(leveysAste);
  }

  static String pituusAsteSetter(){
    Tontti tontti = new Tontti();
    int tarkistin = 0;
    String pituusAste;
    do {
      System.out.println("Pituusasteet:(Muodossa 123.3456E)");
      pituusAste = scan.nextLine();
        tarkistin = tontti.koordinaattitarkistin(pituusAste);
        if(tarkistin != 2){
          System.out.println("Virheellinen syote!");
        }
    } while (tarkistin != 2);
    return(pituusAste);
  }

  static String pintaAlarakennusSetter(){
    Tontti tontti = new Tontti();
    int tarkistin = 0;
    String pintaAlarakennus;
    do {
      System.out.println("Pinta-ala:");
      pintaAlarakennus = scan.nextLine();
      tarkistin = tontti.pintaAlaTarkistin(pintaAlarakennus);
      if (tarkistin == 1){
        System.out.println("Virheellinen syote!");
      }
    } while(tarkistin != 0);
    return(pintaAlarakennus);
  }

  static String huoneistotSetter(){
    Tontti tontti = new Tontti();
    int tarkistin = 0;
    String huoneistot;
    do {
      System.out.println("Huoneiden lukumaara:");
      huoneistot = scan.nextLine();
      tarkistin = tontti.pintaAlaTarkistin(huoneistot);
      if (tarkistin == 1){
        System.out.println("Virheellinen syote!");
      }
    } while(tarkistin != 0);
    return(huoneistot);
  }

  static String nimiSetter(){
    Tontti tontti = new Tontti();
    int tarkistin = 0;
    String nimi;
      do {
        System.out.print("Nimi:");
        nimi = scan.nextLine();
        if (nimi.charAt(0) == '0'){
          return(nimi);
        }
        tarkistin = tontti.nimitarkistin(nimi);
      }while (tarkistin !=0);
      return (nimi);
    }

  static String ikaSetter(){
    Tontti tontti = new Tontti();
    int tarkistin = 0;
    String ika;
    do {
      System.out.print("Syntyma-aika:");
      ika = scan.nextLine();
      tarkistin = tontti.pintaAlaTarkistin(ika);
      if(tarkistin == 1){
        System.out.println("Virheellinen syote!");
      }
    }while(tarkistin != 0);
    System.out.println("");
    return(ika);
  }

}
