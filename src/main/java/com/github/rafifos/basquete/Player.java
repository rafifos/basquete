/**
 * Copyright (c) 2019 Rafael Julio
 *
 * This software is released under the MIT License.
 * https://opensource.org/licenses/MIT
 */

package com.github.rafifos.basquete;

/**
 * Define os jogadores e tudo o que eles são.
 */
public class Player implements Comparable<Player> {
  private String name;
  private double height;
  private int ra;

  /**
   * Construtor da classe player.
   *
   * @param name   - Nome do jogador.
   * @param height - Altura do jogador.
   * @param ra     - RA do jogador.
   */
  public Player(final String name, final double height, final int ra) {
    this.name = name;
    this.height = height;
    this.ra = ra;
  }

  /**
   * Encapsulamento do nome do jogador.
   *
   * @return Nome do jogador
   */
  public String getName() {
    return this.name;
  }

  /**
   * Encapsulamento da altura do jogador.
   *
   * @return Altura do jogador
   */
  public double getHeight() {
    return this.height;
  }

  /**
   * Encapsulamento do RA do jogador.
   *
   * @return RA do jogador
   */
  public double getRa() {
    return this.ra;
  }

  @Override
  public int compareTo(Player comparePlayer) {
    double compareHeight = comparePlayer.getHeight();

    if (height == compareHeight) {
      return 0;
    } else if (height > compareHeight) {
      return 1;
    }

    return -1;
  }
}
