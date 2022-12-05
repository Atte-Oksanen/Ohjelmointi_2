class Asukkaat {
  static int n;
  private String nimi;

  public Asukkaat(String nimi){
    this.nimi = nimi;
  }

  public void printAsukas(){
     n++;
     System.out.println("Asukas "+ n + " " + nimi);
   }
 }
