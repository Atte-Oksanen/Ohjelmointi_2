class Asukkaat {
  static int n, y;
  private String[][] lista = new String [100] [2];


public void SetAsukas(String nimi, String ika){
  lista[n][0] = nimi;
  lista[n][1] = ika;
  n++;
}

 public void printAsukas(){
   while(y < n){
     System.out.println("\nAsukkaat:");
     System.out.println("Nimi:" + lista[y][0]+" Syntyma-aika:" + lista[y][1]);
     y++;
   }
 }


}
