/**
 * Copyright (c) 2019 Rafael Julio
 *
 * This software is released under the MIT License.
 * https://opensource.org/licenses/MIT
 */

package com.github.rafifos.basquete;

/**
 * Realiza o relatório estatístico dos jogadores de um time de basquete de uma
 * temporada.
 */
public class App
{
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
     * Ponto de início da aplicação.
     * @param args - Os argumentos do programa. Atualmente não utilizado.
     */
    public static void main(String[] args) {
        printMenu();
    }
}
