/**
 * Copyright (c) 2019 Rafael Julio
 *
 * This software is released under the MIT License.
 * https://opensource.org/licenses/MIT
 */

package com.github.rafifos.basquete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Realiza o relatório estatístico dos jogadores de um time de basquete de uma
 * temporada.
 */
public class App {
  public static List<Player> orderedPlayers = new ArrayList<>();

  private static Scanner stdin = new Scanner(System.in);
  private static String option = "0";
  private static List<Player> players = new ArrayList<>();

  /**
   * Ponto de início da aplicação.
   *
   * @param args - Os argumentos do programa. Atualmente não utilizado.
   */
  public static void main(String[] args) {
    do {
      switch (option) {
      case "1":
        handlePlayerData();
        break;
      case "2":
        getPlayerHeightAverage();
        break;
      case "4":
        showSmallestAndHighestPlayer();
        break;
      case "6":
        exitProgram(0, true);
        break;
      default:
        printMenu();
        option = stdin.next();
        break;
      }
    } while (true);
  }

  /**
   * Limpa o buffer de saída do terminal/console. Equivalente ao `clear` ou `cls`.
   */
  private static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /**
   * Reseta a opção a ser digitada pelo usuário, isso é usado para retornar ao
   * menu.
   */
  private static void setDefaultOption() {
    option = "0";
    clearScreen();
  }

  /**
   * Sai do programa.
   *
   * @param exitCode          - Código de saída para o programa retornar ao SO.
   * @param shouldClearScreen - Se o programa deve ou não limpar a tela depois de
   *                          sair.
   */
  private static void exitProgram(int exitCode, boolean shouldClearScreen) {
    stdin.close();
    if (shouldClearScreen) {
      clearScreen();
    }
    System.out.println("Encerrando.");
    System.exit(exitCode);
  }

  private static void exitMethod(boolean shouldClearScreen) {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException ie) {
      ie.printStackTrace();
      exitProgram(1, false);
    }

    if (shouldClearScreen) {
      clearScreen();
    }
    setDefaultOption();
  }

  /**
   * Imprime o menu principal.
   */
  private static void printMenu() {
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
   * Lida com os dados dos jogadores, mais precisamente com o Nome e a Altura.
   */
  private static void handlePlayerData() {
    String currentName = null;
    double currentHeight = 0.0;

    for (int i = 0; i < 2; i++) {
      System.out.print("Digite o nome do Jogador: ");
      currentName = stdin.next();

      System.out.print("Digite a altura do Jogador: ");
      try {
        currentHeight = stdin.nextDouble();
      } catch (InputMismatchException ime) {
        System.out.println("Formato da altura inválida. Retornando ao menu principal.");

        exitMethod(false);
        return;
      }

      players.add(new Player(currentName, currentHeight));
    }

    orderedPlayers = players;
    Collections.sort(orderedPlayers);
    setDefaultOption();
  }

  /**
   * Calcula a média das alturas dos jogadores.
   */
  private static void getPlayerHeightAverage() {
    double _averageHeight = 0;

    clearScreen();

    for (int i = 0; i < players.size(); i++) {
      _averageHeight += players.get(i).getHeight();
    }

    _averageHeight = _averageHeight / players.size();

    System.out.println("A média das alturas do time é: " + _averageHeight);

    exitMethod(true);
  }

  /**
   * Mostra o Jogador mais baixo e o Jogador mais alto.
   */
  private static void showSmallestAndHighestPlayer() {
    clearScreen();

    System.out.print("O jogador mais baixo é: ");
    System.out.print(orderedPlayers.get(0).getName());
    System.out.println(", com " + orderedPlayers.get(0).getHeight() + "m de altura");

    System.out.print("O jogador mais alto é: ");
    System.out.print(orderedPlayers.get(orderedPlayers.size() - 1).getName());
    System.out.println(", com " + orderedPlayers.get(orderedPlayers.size() - 1).getHeight() + "m de altura");

    exitMethod(true);
  }
}
