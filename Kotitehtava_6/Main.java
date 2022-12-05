import java.util.Scanner;

class Main {
  static Sanalista sanat;
  static Hirsipuu status;
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    int arvaukset = 8, menu = 0;
    String tiedosto;
    boolean tarkistin;

    System.out.println("Tervetuloa pelaamaan Hirsipuuta!\nSyota tiedoston nimi, josta sanalista loytyy.");
    do {
      tarkistin = false;
      try{
        tiedosto = scan.nextLine();
        sanat = new Sanalista(tiedosto); //Luodaan oliot luokista Sanalista ja Hirsipuu
        status = new Hirsipuu(sanat.annaSanat(), arvaukset);
      }
      catch(IllegalArgumentException e){
        tarkistin = true;
        System.out.println("Anna tiedoston nimi uudelleen.");
      }
    } while (tarkistin);

    do {
      System.out.println("Haluatko pelata vai tutkia sanalistaa?\n1:Pelaa hirsipuuta\n2:Etsi sanoja pituuden perusteella\n3:Etsi sanoja kirjaimien perusteella");
      try{
        switch(menu = scan.nextInt()){
          case 1:
            scan.nextLine();
            gameloop();
            break;
          case 2:
            scan.nextLine();
            etsiPituus();
            break;
          case 3:
            scan.nextLine();
            etsiKirjain();
            break;
          default:
            scan.nextLine();
            break;
        }
      }
      catch(Exception e){
        System.out.println("Virheellinen syote. Anna uusi syote.");
        scan.nextLine();
        menu = 0;
      }
    } while(menu < 1 || menu > 3);
  }

  static void gameloop(){ //Päälooppi, jossa peli pyörii
    int n = 0;
    char arvaus;

    System.out.println("Arvattava sana:");

    while(n < status.getSana().length()){
      System.out.print("_ ");
      n++;
    }
    System.out.println("");

    do { //Pelikierroksen alkamiskohta
      System.out.println("Arvaa kirjain:");
      arvaus = scan.next().charAt(0);

      if(status.arvaa(arvaus) == true){
        System.out.println("Kirjain on oikein/Merkki on jo arvattu");
        System.out.println("Arvattava sana:");
        System.out.println(status.getPeitetty());
      }
      else{
        System.out.println("Kirjain on vaarin, arvauksia on jaljella " + status.arvauksiaOnJaljella());
      }
    } while(status.onLoppu() == false);

    if(status.getArvaukset() > 0){
      System.out.println("Onneksi olkoon! Voitit Pelin!");
    }
    else{
      System.out.println("Havisit pelin!");
    }
  }

 static void etsiPituus(){ //Lisätehtävä, jossa etsitään sanoja listasta pituuden perusteella
    int pituus = 0;
    boolean tarkistin;

    do {
      tarkistin = false;
      try{
        System.out.println("Anna sanan pituus");
        pituus = scan.nextInt();
      }
      catch(Exception e){
        System.out.println("Virheellinen syote. Anna uusi syote.");
        tarkistin = true;
      }
      scan.nextLine();
    } while(tarkistin);

    Sanalista uusiLista = sanat.sanatJoidenPituusOn(pituus);

    System.out.println("Sanat joiden pituus on " + pituus + " merkkia:");
    uusiLista.printSanat();
  }

  static void etsiKirjain(){ //Lisätehtävä, jossa etsitään sanoja niistä löytyvien merkkien perusteella
    String hakutemp;
    StringBuilder haku = new StringBuilder(20);
    boolean tarkistin;

    System.out.println("Syota halutut kirjaimet.");
    hakutemp = scan.nextLine();
    haku.append(hakutemp + "__________");
    Sanalista uusiLista = sanat.sanatJoissaMerkit(hakutemp.toString());
    System.out.println("Sanat jotka vastaavat hakua:");
    uusiLista.printSanat();

  }
}
