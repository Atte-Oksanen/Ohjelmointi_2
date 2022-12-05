import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;

class Sanalista {
  private File sanat;
  private Scanner scan;
  private List<String> lista = new ArrayList<String>();

  public Sanalista(){ //Konstruktori, jota käytetään luodessa olioita lisätehtävien metodeita varten

  }

  public Sanalista (String tiedosto){
    int n = 0;
    try {
       sanat = new File(tiedosto);
       scan = new Scanner(sanat);

       while(scan.hasNextLine()){
         lista.add(scan.nextLine());
         n++;
       }
     }
     catch (FileNotFoundException e){
       System.out.println("Tiedoston avaamisessa tapahtui virhe.");
     }
  }

 public List<String> annaSanat(){
   return(lista);
 }

 public Sanalista sanatJoidenPituusOn(int pituus){ //LISÄTEHTÄVÄ Metodi etsii sanoja, joiden pituus määritetään metodin parametrissä
   Sanalista uusiLista = new Sanalista();
   int n = 0;

   while(n < lista.size()){
     if(lista.get(n).length() == pituus){
       uusiLista.lista.add(lista.get(n));
     }
     n++;
   }
   return(uusiLista);
 }

 public Sanalista sanatJoissaMerkit(String mjono){ //LISÄTEHTÄVÄ Metodi etsii sanoja, jotka sisältävät kirjaimia tietyillä paikoilla merkkijonossa.
   boolean tarkistin = true;
   int n = 0, z = 0;
   Sanalista uusiLista = new Sanalista();

   while(n < lista.size()){
     z = 0;
     while(z < lista.get(n).length()){
       tarkistin = true;
       try{
         if(mjono.charAt(z) == lista.get(n).charAt(z) || mjono.charAt(z) == lista.get(n).charAt(z) + 32 || mjono.charAt(z) == lista.get(n).charAt(z) - 32 || mjono.charAt(z) == '_'){}
         else{
           tarkistin = false;
           break;
         }
       }
       catch (StringIndexOutOfBoundsException e){
         tarkistin = false;
       }

       z++;
     }
     if(tarkistin){
       uusiLista.lista.add(lista.get(n));
     }
     n++;
   }
   return(uusiLista);
 }

 public void printSanat(){
   int n = 0;

   if(lista.size() < 1){
     System.out.println("Hakuehdoilla ei loytynyt sanoja.");
   }
   while(n < lista.size()){
     System.out.println(lista.get(n));
     n++;
   }
 }
}
