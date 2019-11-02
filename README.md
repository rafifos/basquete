# Atividade Prática Supervisionada - Algoritmos e Programação

**Dados Estatísticos – Time de Basquete**

Supervisionado por: *Simone de Abreu* e Igor *Oliveira Borges*

## Descrição da Atividade

A ideia da atividade é fazer um programa que implemente um relatório estatístico dos jogadores de um time de basquete de uma temporada. Esse relatório é importante para o técnico definir se seu time está com índices de desenvolvimento bons em relação aos demais times da temporada.

Sabe-se que em um time de basquete são necessários 5 jogadores em quadra, podendo ter até outros 5 jogadores reservas, contabilizando 10 jogadores por time no total.

Para cada um dos jogadores do time, seu programa deve ler o nome e a altura. Usar um vetor de Strings para armazenar os nomes e um vetor para armazenar as alturas.

Após a entrada dos dados dos 10 jogadores, o programa deve apresentar o seguinte menu de opções:

```
======== TIME DE BASQUETE ========
1 – Dados dos jogadores
2 – Média de alturas
3 – Desvio padrão das alturas
4 – Maior e Menor altura
5 – Mediana das alturas
6 – Finalizar

Digite uma opção:
```

## Itens do Menu

1. Exibir o nome e a altura de cada jogador do time.
2. Calcular e apresentar a média das alturas do time de basquete.
3. Apenas se a média já estiver sido calculada, calcular o desvio padrão
que é dado pela fórmula: `(Σ(alturasˆ2) + total de alturas) - mediaˆ2`.
4. Encontrar o jogador mais alto e o jogador mais baixo do time. Apresentar o nome do jogador e a sua altura.
5. Calcula a mediana das alturas. A mediana é o elemento central de uma lista *ordenada*. Caso o conjunto de dados seja par, então a mediana é a média dos dois valores centrais. Pesquise como **"ordenar vetor em JAVA"**.
Lembre-se que o vetor de nomes também devem ser alterados, para tanto, pesquise a função de cópia de strings – `clone()`.
6. Finaliza a execução do programa.

## Regras e Restrições

ara o correto desenvolvimento do programa algumas regras e restrições devem ser cumpridas:

1. A tela de início do programa deve apresentar (`System.out.println()`) o nome completo e o RA de cada integrante do grupo!
2. A altura de cada jogador, não pode ser 0 negativa. Caso seja digitado um valor inválido, o programa deverá solicitar um novo valor.
3. Para qualquer uma das regras listadas, o programa não pode ser finalizado. O programa deve fazer as validações de entrada e somente prosseguir quando os dados de entrada forem válidos.
4. O programa somente deve ser finalizado ao escolher o item 6 do menu.
5. **Pode** utilizar o conceito de métodos – pesquisar nos livros de referência.
6. Para armazenar os nomes dos jogadores, o grupo deve pesquisar o
conceito de matrizes (**"vetor de Strings em Java"** no google).

## Entregáveis

O trabalho deve ser desenvolvido em equipes de no mínimo 3 e no máximo 5 alunos.
Cada equipe deve realizar a entrega do projeto compactado, **no formato ZIP**, pelo Blackboard.

## Critérios de Avaliação

Cada grupo terá o seu trabalho avaliado utilizando os seguintes critérios:

- Correta implementação e funcionamento do algoritmo.
- Legibilidade (comentários e organização).
- Nomeação adequada de variáveis.
- Pontualidade na entrega no Blackboard.
