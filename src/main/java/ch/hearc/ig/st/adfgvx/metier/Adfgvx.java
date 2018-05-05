package ch.hearc.ig.st.adfgvx.metier;

public class Adfgvx {
  private static String[][] tableauSubstitution=new String[6][6];

  public static String chiffrerPhrase(String phraseADechiffrer, String cle){
    init();
    return "";
  }

  public static String dechiffrerPhrase(String phraseADechiffrer, String cle){
    init();
    return "";
  }

  private static void init(){
    // Initilisation du tableau de substitution
    // 8  T  B  W  R  Q
    // P  4  C  G  2  9
    // 3  O  5  M  X  E
    // D  A  Z  J  S  Y
    // L  H  7  U  V  0
    // N  1  K  6  I  F
    tableauSubstitution[0][0]="8";
    tableauSubstitution[0][1]="t";
    tableauSubstitution[0][2]="b";
    tableauSubstitution[0][3]="w";
    tableauSubstitution[0][4]="r";
    tableauSubstitution[0][5]="q";

    tableauSubstitution[1][0]="p";
    tableauSubstitution[1][1]="4";
    tableauSubstitution[1][2]="c";
    tableauSubstitution[1][3]="g";
    tableauSubstitution[1][4]="2";
    tableauSubstitution[1][5]="9";

    tableauSubstitution[2][0]="3";
    tableauSubstitution[2][1]="o";
    tableauSubstitution[2][2]="5";
    tableauSubstitution[2][3]="m";
    tableauSubstitution[2][4]="x";
    tableauSubstitution[2][5]="e";

    tableauSubstitution[3][0]="d";
    tableauSubstitution[3][1]="a";
    tableauSubstitution[3][2]="z";
    tableauSubstitution[3][3]="j";
    tableauSubstitution[3][4]="s";
    tableauSubstitution[3][5]="y";

    tableauSubstitution[4][0]="l";
    tableauSubstitution[4][1]="h";
    tableauSubstitution[4][2]="7";
    tableauSubstitution[4][3]="u";
    tableauSubstitution[4][4]="v";
    tableauSubstitution[4][5]="0";

    tableauSubstitution[5][0]="n";
    tableauSubstitution[5][1]="1";
    tableauSubstitution[5][2]="k";
    tableauSubstitution[5][3]="6";
    tableauSubstitution[5][4]="i";
    tableauSubstitution[5][5]="f";

    System.out.println("Tableau de substitution utilisé :");
    for(int i=0;i<6;++i){
      for(int j=0;j<6;++j){
        System.out.print(tableauSubstitution[i][j]+"  ");
      }
      System.out.print("\n");
    }
  }
}
