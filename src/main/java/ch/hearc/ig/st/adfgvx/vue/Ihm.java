package ch.hearc.ig.st.adfgvx.vue;

import ch.hearc.ig.st.adfgvx.metier.Adfgvx;
import java.util.Scanner;

public class Ihm {
  Scanner sc = new Scanner(System.in);
  String p1;
  String phrase;

  public void menu() {
    while (true) {
      System.out.println("\n\n=====================================");
      System.out.println("======== Chiffre ADFGVX - Menu ======");
      System.out.println("=====================================\n");

      System.out.println("1. Chiffrer une phrase");
      System.out.println("2. Déchiffrer une phrase");
      System.out.println("0. Quitter l'application\n");

      System.out.print("Votre sélection : ");
      p1 = sc.nextLine();
      System.out.println("");

      switch (p1.charAt(0)) {
        case '1':
          System.out.println("Veuillez saisir la phrase à chiffrer :");
          phrase = sc.nextLine();
          phrase = Adfgvx.chiffrerPhrase(phrase);
          System.out.println("Votre phrase chiffrée est : "+phrase);
          break;
        case '2':
          System.out.println("Veuillez saisir la phrase à déchiffrer :");
          phrase = sc.nextLine();
          phrase = Adfgvx.dechiffrerPhrase(phrase);
          System.out.println("Votre phrase déchiffrée est : "+phrase);
          break;
        case '0':
          System.exit(0);
          break;
      }
    }
  }
}
