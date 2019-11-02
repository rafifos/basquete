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
  private static Scanner stdin = new Scanner(System.in);
  private static String option = "0";
  private static List<Player> players = new ArrayList<>();
  private static List<Player> orderedPlayers = new ArrayList<>();

  private static double playerHeightAverage = 0;

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
        showPlayerHeightAverage();
        break;
      case "3":
        showStandardDeviation();
        break;
      case "4":
        showSmallestAndHighestPlayer();
        break;
      case "5":
        showPlayerHeightMedian();
        break;
      case "6":
        exitProgram(0, true);
        break;
      default:
        showMenu();
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

  /**
   * Pseudo-macro usado no encerramento de métodos e funções.
   *
   * @param shouldClearScreen - Se a tela deve ou não ser limpa após encerrar o
   *                          método/função.
   */
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
   * Mostra o menu principal.
   */
  private static void showMenu() {
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
    clearScreen();

    String currentName = null;
    double currentHeight = 0.0;

    for (int i = 0; i < 10; i++) {
      clearScreen();
      stdin.nextLine();

      System.out.print("Digite o nome do Jogador: ");
      currentName = stdin.nextLine();

      System.out.print("Digite a altura do Jogador: ");
      try {
        currentHeight = stdin.nextDouble();
      } catch (InputMismatchException ime) {
        System.out.println("Formato da altura inválida. Retornando ao menu principal.");

        exitMethod(true);
        return;
      }

      if (currentHeight < 0) {
        System.out.println("A altura não pode ser negativa. Retornando ao menu principal.");

        exitMethod(true);
      }

      players.add(new Player(currentName, currentHeight));
    }

    orderedPlayers = players;
    Collections.sort(orderedPlayers);

    clearScreen();

    for (int i = 0; i < players.size(); i++) {
      System.out.println("Nome: " + players.get(i).getName());
      System.out.println("Altura: " + players.get(i).getHeight() + "m");
      System.out.print("\n");
    }

    exitMethod(true);
  }

  /**
   * Calcula e mostra a média das alturas dos jogadores.
   */
  private static void showPlayerHeightAverage() {
    playerHeightAverage = 0;

    clearScreen();

    for (int i = 0; i < players.size(); i++) {
      playerHeightAverage += players.get(i).getHeight();
    }

    playerHeightAverage = playerHeightAverage / players.size();

    System.out.println("A média das alturas do time é: " + playerHeightAverage + "m");

    exitMethod(true);
  }

  /**
   * Calcula e mostra o desvio padrão dos jogadores. showPlayerHeightAverage()
   * deve ser executado antes.
   */
  private static void showStandardDeviation() {
    double _heightsSquared = 0;
    double _standardDeviation = 0;

    clearScreen();

    if (playerHeightAverage == 0) {
      System.out.println("Você deve calcular a média antes. Retornando ao menu principal.");
      exitMethod(true);
    }

    // Realiza a soma de todas as alturasˆ2 dos jogadores.
    for (int i = 0; i < players.size(); i++) {
      _heightsSquared += Math.pow(players.get(i).getHeight(), 2);
    }

    _standardDeviation = (_heightsSquared / players.size()) - Math.pow(playerHeightAverage, 2);

    System.out.println("O desvio padrão dos jogadores é: " + _standardDeviation);

    exitMethod(true);
  }

  /**
   * Calcula e mostra o Jogador mais baixo e o Jogador mais alto.
   */
  private static void showSmallestAndHighestPlayer() {
    clearScreen();

    System.out.print("O jogador mais baixo é: ");
    System.out.print(orderedPlayers.get(0).getName());
    System.out.println(", com " + orderedPlayers.get(0).getHeight() + "m");

    System.out.print("O jogador mais alto é: ");
    System.out.print(orderedPlayers.get(orderedPlayers.size() - 1).getName());
    System.out.println(", com " + orderedPlayers.get(orderedPlayers.size() - 1).getHeight() + "m");

    exitMethod(true);
  }

  /**
   * Calcula e mostra a mediana das alturas dos jogadores
   */
  private static void showPlayerHeightMedian() {
    int middle = orderedPlayers.size() / 2;
    double _heightMedian = 0;

    clearScreen();

    if (middle > 0 && middle % 2 == 0) {
      // Array é impar.
      _heightMedian = orderedPlayers.get(middle).getHeight();
    } else {
      // Array é par.
      _heightMedian = orderedPlayers.get(middle).getHeight() + orderedPlayers.get(middle - 1).getHeight();
      _heightMedian = _heightMedian / 2;
    }

    System.out.println("A mediana das alturas do time é: " + _heightMedian + "m");

    exitMethod(true);
  }
}
