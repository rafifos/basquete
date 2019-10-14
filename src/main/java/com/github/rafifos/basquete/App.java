/**
 * Copyright (c) 2019 Rafael Julio
 *
 * This software is released under the MIT License.
 * https://opensource.org/licenses/MIT
 */

package com.github.rafifos.basquete;

import java.util.Scanner;

/**
 * Realiza o relatório estatístico dos jogadores de um time de basquete de uma
 * temporada.
 */
public class App {
  /**
   * Limpa o buffer de saída do terminal/console. Equivalente à `clear` ou `cls`.
   */
  private static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /**
   * Imprime o menu principal.
   */
  private static void printMenu() {
    clearScreen();
    System.out.println("======== TIME DE BASQUETE ========");
    System.out.println("1 – Dados dos jogadores");
    System.out.println("2 – Média de alturas");
    System.out.println("3 – Desvio padrão das alturas");
    System.out.println("4 – Maior e Menor altura");
    System.out.println("5 – Mediana das alturas");
    System.out.println("6 – Finalizar");
    System.out.print("Digite uma opção: ");
  }

  /**
   * Ponto de início da aplicação.
   *
   * @param args - Os argumentos do programa. Atualmente não utilizado.
   */
  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);

    int option = 0;

    do {
      switch (option) {
      default:
        printMenu();
        option = stdin.nextInt();
        break;
      }
    } while (option != 6);

    stdin.close();
    clearScreen();
    System.out.println("Encerrando.");
    System.exit(0);
  }
}
