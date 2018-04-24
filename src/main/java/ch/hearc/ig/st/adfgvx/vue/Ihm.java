package ch.hearc.ig.st.adfgvx.vue;

import java.util.Scanner;

public class Ihm {
  Scanner sc = new Scanner(System.in);
  String p1;
  String p2;

  public void menu() {
    System.out.println("\n\n=====================================");
    System.out.println("======== Chiffre ADFGVX - Menu ======");
    System.out.println("=====================================\n");

    System.out.println("1. Chiffrer une phrase");
    System.out.println("2. Déchiffrer une phrase");
    System.out.println("0. Quitter l'application\n");

    System.out.print("Votre sélection : ");
    p1 = sc.nextLine();
    System.out.println("");

    switch (p1.charAt(0)){
      case '1':
        System.out.println("Choix 1");
        break;
      case '2':
        System.out.println("Choix 2");
        break;
      case '0':
        System.exit(0);
        break;
    }
  }
}
