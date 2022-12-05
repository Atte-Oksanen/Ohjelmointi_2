import java.util.Scanner;

class Main {
  public static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    int n = 0, tyyppi = 0, huoneet = 0, huoneistot = 0;
    String nimi, ika, osoite, tontinNimi, pintaAla, pintaAlarakennus;

    System.out.println("Syota tontin tiedot\n"); //pyydetään käyttäjältä tontin tiedot. Sisältää syötteentarkistuksen
    tontinNimi = TontinNimiSetter();
    pintaAla = pintaAlaSetter();
    osoite = osoiteSetter();
    Tontti tontti = new Tontti(tontinNimi, pintaAla, osoite);

    System.out.println("Syota rakennuksen tiedot\n"); //pyydetään käyttäjältä rakennuksen tiedot. Sisältää syötteentarkistuksen
    tyyppi = tyyppiSetter();
    if (tyyppi != 1) {
      huoneistot = huoneistoSetter();
    }
    else {
      huoneistot = 1;
    }
    tontti.setRakennus(huoneistot, tyyppi); //Luodaan kerrostalo, omakotitalo tai rivitalo

    while(n < huoneistot){ //Asetetaan huoneiston pinta-ala sekä huoneiden lukumäärä. Sisältää syötteentarkistuksen
        tontti.setHuoneet(huoneetSetter(n, tyyppi), tyyppi);
        tontti.setHuonePintaAla(pintaAlarakennusSetter(), tyyppi);
        n++;
    }

    System.out.println("\nSyota asukkaan tiedot \nSyota 0 siirtyaksesi eteenpain\n"); //pyydetään käyttäjältä asukkaan tiedot. Sisältää syötteentarkistuksen
    while(true){
      nimi = nimiSetter();
      if(nimi.compareTo("0") == 0){
        break;
      }
      tontti.setAsukas(nimi, tyyppi);
      n++;
    }

    tontti.printTontti(); //tulostetaan kaikkien olioiden sisältö
    printTyyppi(tyyppi);
    tontti.printRakennus(tyyppi);
    tontti.printAsukas(tyyppi);
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

  static String osoiteSetter(){
    Tontti tontti = new Tontti();
    int tarkistin = 0;
    String osoite;
    do {
      System.out.println("Osoite:");
      osoite = scan.nextLine();
      tarkistin = tontti.nimitarkistin(osoite);
      if(tarkistin == 1){
        System.out.println("Virheellinen syote!");
      }
    } while (tarkistin != 0);

    return(osoite);
  }

  static int tyyppiSetter(){
    int tarkistin = 0, tyyppi = 0;
    System.out.println("Rakennuksen tyyppi: \n1. Omakotitalo, 2. Rivitalo, 3. Kerrostalo");
    do{
      tarkistin = 0;
      try{
        tyyppi = scan.nextInt();
      }
      catch (Exception e){
        scan.nextLine();
        tarkistin = 1;
        System.out.println("Virheellinen syote!\nAnna uusi syote.");
      }
      if(tyyppi < 1 || tyyppi > 3){
        System.out.println("Virheellinen syote!\nAnna uusi syote.");
        tarkistin = 1;
      }
      scan.nextLine();
    } while(tarkistin == 1);
    return(tyyppi);
  }

  static int pintaAlarakennusSetter(){
    int tarkistin = 0, pintaAla = 0;
    System.out.println("Huoneiston pinta-ala:");
    do{
      tarkistin = 0;
      try{
        pintaAla = scan.nextInt();
      }
      catch (Exception e){
        scan.nextLine();
        tarkistin = 1;
        System.out.println("Virheellinen syote!\nAnna uusi syote.");
      }
      if(pintaAla < 1){
        tarkistin = 1;
        System.out.println("Virheellinen syote!\nAnna uusi syote.");
      }

      scan.nextLine();
    } while(tarkistin == 1);

    return(pintaAla);
  }

  static int huoneetSetter(int n, int tyyppi){
    int tarkistin = 0, huoneet = 0;
    n++;
    if(tyyppi == 1){
      System.out.println("Huoneiden lukumaara:");
    }
    else{
      System.out.println("Huoneiden lukumaara huoneistossa numero "+ n +":");
    }
    do{
      tarkistin = 0;
      try{
        huoneet = scan.nextInt();
      }
      catch (Exception e){
        scan.nextLine();
        tarkistin = 1;
        System.out.println("Virheellinen syote!\nAnna uusi syote.");
      }
      if(huoneet < 1){
        tarkistin = 1;
        System.out.println("Virheellinen syote!\nAnna uusi syote.");
      }
      scan.nextLine();
    } while(tarkistin == 1);

    return(huoneet);
  }

  static int huoneistoSetter(){
    int tarkistin = 0, huoneistot = 0;
    System.out.println("Huoneistojen lukumaara:");
    do{
      tarkistin = 0;
      try{
        huoneistot = scan.nextInt();
      }
      catch (Exception e){
        scan.nextLine();
        tarkistin = 1;
        System.out.println("Virheellinen syote!\nAnna uusi syote.");
      }
      if(huoneistot < 1){
        tarkistin = 1;
        System.out.println("Virheellinen syote!\nAnna uusi syote.");
      }

      scan.nextLine();
    } while(tarkistin == 1);

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

    static void printTyyppi(int tyyppi){
      switch(tyyppi){
        case 1:
          System.out.println("Rakennuksen tyyppi: Omakotitalo");
          break;

        case 2:
          System.out.println("Rakennuksen tyyppi: Rivitalo");
          break;

        case 3:
          System.out.println("Rakennuksen tyyppi: Kerrostalo");
          break;
      }
    }

}
