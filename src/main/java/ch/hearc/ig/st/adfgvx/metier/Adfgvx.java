package ch.hearc.ig.st.adfgvx.metier;

public class Adfgvx {

  private static String[][] tableauSubstitution = new String[6][6];
  private static String cleChiffrement = "";

  public static String chiffrerPhrase(String phraseADechiffrer, String cle) {
    cleChiffrement = "";
    initialiseTableauSubstitution();
    definiCleTableau(cle);
    trierTableau();
    return chiffrerPhrase(phraseADechiffrer);
  }

  public static String dechiffrerPhrase(String phraseADechiffrer, String cle) {
    cleChiffrement = "";
    initialiseTableauSubstitution();
    definiCleTableau(cle);
    trierTableau();
    return dechiffrerPhrase(phraseADechiffrer);
  }

  private static String dechiffrerPhrase(String phraseADechiffrer) {
    String phraseDechiffreeTmp = "";
    String phraseDechiffree = "";

    // Transforme les lettres ADFGVX en indices
    for (int i = 0; i < phraseADechiffrer.length(); ++i) {
      switch (phraseADechiffrer.charAt(i)) {
        case 'A':
          phraseDechiffreeTmp += '0';
          break;
        case 'D':
          phraseDechiffreeTmp += '1';
          break;
        case 'F':
          phraseDechiffreeTmp += '2';
          break;
        case 'G':
          phraseDechiffreeTmp += '3';
          break;
        case 'V':
          phraseDechiffreeTmp += '4';
          break;
        case 'X':
          phraseDechiffreeTmp += '5';
          break;
      }
    }

    for (int i = 0; i < phraseDechiffreeTmp.length(); i+=2) {
      phraseDechiffree+=tableauSubstitution[Integer.valueOf(phraseDechiffreeTmp.charAt(i)-'0')][Integer.valueOf(phraseDechiffreeTmp.charAt(i+1)-'0')];
    }

    return phraseDechiffree;
  }

  private static String chiffrerPhrase(String phraseAChiffrer) {
    String phraseChiffreeTmp = "";
    String phraseChiffree = "";
    String lettreAChiffree = "";

    for (int i = 0; i < phraseAChiffrer.length(); ++i) {
      lettreAChiffree = String.valueOf(phraseAChiffrer.charAt(i));

      // Parcours du tableau et recherche de la lettre
      for (int j = 0; j < 6; ++j) {
        for (int k = 0; k < 6; ++k) {
          if (tableauSubstitution[j][k].equals(lettreAChiffree)) {
            phraseChiffreeTmp += String.valueOf(j) + String.valueOf(k);
            break;
          }
        }
      }
    }

    // Transforme les indices en lettres ADFGVX
    for (int i = 0; i < phraseChiffreeTmp.length(); ++i) {
      switch (phraseChiffreeTmp.charAt(i)) {
        case '0':
          phraseChiffree += 'A';
          break;
        case '1':
          phraseChiffree += 'D';
          break;
        case '2':
          phraseChiffree += 'F';
          break;
        case '3':
          phraseChiffree += 'G';
          break;
        case '4':
          phraseChiffree += 'V';
          break;
        case '5':
          phraseChiffree += 'X';
          break;
      }
    }

    return phraseChiffree;
  }

  private static void trierTableau() {
    System.out.println("La clé est associée au tableau : ");
    afficherTableau(true);

    String[][] tableauSubstitutionTmp = new String[6][6];
    String lettresCle = cleChiffrement.toUpperCase();
    cleChiffrement = "";
    String lettreSuivante;
    int indiceLettre = 0;

    // Parcours les lettres de la clé
    for (int i = 0; i < 6; ++i) {

      lettreSuivante = String.valueOf(lettresCle.charAt(0));
      indiceLettre = 0;
      for (int j = 0; j < lettresCle.length(); ++j) {
        // Si la lettre est plus petite (alphabétiquement)
        if (lettresCle.charAt(j) < lettreSuivante.charAt(0)) {
          // Affecte la lettre et l'indice
          lettreSuivante = String.valueOf(lettresCle.charAt(j));
          indiceLettre = j;
        }
      }
      for (int j = 0; j < 6; ++j) {
        tableauSubstitutionTmp[j][i] = tableauSubstitution[j][indiceLettre];
      }
      cleChiffrement += lettresCle.substring(indiceLettre, indiceLettre + 1);
      lettresCle = lettresCle.substring(0, indiceLettre) + String.valueOf((char) 123) + lettresCle
          .substring(indiceLettre + 1, lettresCle.length());

    }
    tableauSubstitution = tableauSubstitutionTmp;

    System.out.println("Puis le tableau est trié selon la clé (alphabétiquement): ");
    afficherTableau(true);
  }

  private static void definiCleTableau(String cle) {
    String cleTemporaire = "";

    // Passe la clé en majuscule
    cle = cle.toUpperCase();

    System.out.println("La clé passée est : " + cle);

    // Complète par les lettres (ADFGVX) afin qu'il y ait au minimum 6 lettres
    cleTemporaire = cle + "ADFGVX";
    System.out
        .println("Ajout des lettres ADFGVX pour en avoir minimum 6 différentes : " + cleTemporaire);

    // Enlève les lettres redondantes
    for (int i = 0; i < cleTemporaire.length(); ++i) {
      if (!cleChiffrement.contains(String.valueOf(cleTemporaire.charAt(i)))) {
        cleChiffrement += cleTemporaire.charAt(i);
      }
    }
    System.out.println("Les lettres redondantes sont enlevées : " + cleChiffrement);

    // On ne prends que les 6 premiers caractères
    cleChiffrement = cleChiffrement.substring(0, 6);
    System.out
        .println("On ne prends que les 6 premiers caractères, la clé est donc : " + cleChiffrement);
  }

  private static void initialiseTableauSubstitution() {
    // Initialisation du tableau de substitution
    // 8  T  B  W  R  Q
    // P  4  C  G  2  9
    // 3  O  5  M  X  E
    // D  A  Z  J  S  Y
    // L  H  7  U  V  0
    // N  1  K  6  I  F
    tableauSubstitution[0][0] = "8";
    tableauSubstitution[0][1] = "t";
    tableauSubstitution[0][2] = "b";
    tableauSubstitution[0][3] = "w";
    tableauSubstitution[0][4] = "r";
    tableauSubstitution[0][5] = "q";

    tableauSubstitution[1][0] = "p";
    tableauSubstitution[1][1] = "4";
    tableauSubstitution[1][2] = "c";
    tableauSubstitution[1][3] = "g";
    tableauSubstitution[1][4] = "2";
    tableauSubstitution[1][5] = "9";

    tableauSubstitution[2][0] = "3";
    tableauSubstitution[2][1] = "o";
    tableauSubstitution[2][2] = "5";
    tableauSubstitution[2][3] = "m";
    tableauSubstitution[2][4] = "x";
    tableauSubstitution[2][5] = "e";

    tableauSubstitution[3][0] = "d";
    tableauSubstitution[3][1] = "a";
    tableauSubstitution[3][2] = "z";
    tableauSubstitution[3][3] = "j";
    tableauSubstitution[3][4] = "s";
    tableauSubstitution[3][5] = "y";

    tableauSubstitution[4][0] = "l";
    tableauSubstitution[4][1] = "h";
    tableauSubstitution[4][2] = "7";
    tableauSubstitution[4][3] = "u";
    tableauSubstitution[4][4] = "v";
    tableauSubstitution[4][5] = "0";

    tableauSubstitution[5][0] = "n";
    tableauSubstitution[5][1] = "1";
    tableauSubstitution[5][2] = "k";
    tableauSubstitution[5][3] = "6";
    tableauSubstitution[5][4] = "i";
    tableauSubstitution[5][5] = "f";

    System.out.println("Tableau de substitution utilisé :");
    afficherTableau(false);
  }

  private static void afficherTableau(boolean afficherCle) {
    if(afficherCle){
      System.out.print("   "+cleChiffrement.charAt(0));
      System.out.print("  "+cleChiffrement.charAt(1));
      System.out.print("  "+cleChiffrement.charAt(2));
      System.out.print("  "+cleChiffrement.charAt(3));
      System.out.print("  "+cleChiffrement.charAt(4));
      System.out.print("  "+cleChiffrement.charAt(5)+"\n");
    }
    System.out.println("   A  D  F  G  V  X");
    // Parcours le tableau de substitution et l'affiche
    for (int i = 0; i < 6; ++i) {
      switch (i){
        case 0:
          System.out.print("A  ");
          break;
        case 1:
          System.out.print("D  ");
          break;
        case 2:
          System.out.print("F  ");
          break;
        case 3:
          System.out.print("G  ");
          break;
        case 4:
          System.out.print("V  ");
          break;
        case 5:
          System.out.print("X  ");
          break;
      }
      for (int j = 0; j < 6; ++j) {
        System.out.print(tableauSubstitution[i][j] + "  ");
      }
      System.out.print("\n");
    }
  }
}
