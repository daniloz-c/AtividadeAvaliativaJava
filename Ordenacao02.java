/*
Nos indicadores 1. Apresenta as particulares entre Programação Estruturada e Programação Orientada a Objetos, que tem como critério a Comparação, e 2. Utiliza coleções para manipulações de dados em uma linguagem de programação, que tem como critério a Relação, o objetivo é desenvolver a prática em Programação Orientada a Objetos, permitindo ao estudante aplicar uma linguagem de desenvolvimento orientado a objetos, de maneira a apresentar soluções de problemas no cotidiano.

Para analisar o aprendizado, desenvolva o modelo de ordenação proposto, utilizando as estruturas de Array propostas em sala de aula. O desenvolvimento deve conter:
* Comentários de Código demonstrando a estrutura
* Indentação de Código
* Utilização de Estruturas de Repetição para solução a ordenação
* Aplicação de camelCase e PascalCase para o código fonte
* Nomenclatura de variáveis que determinem sua utilização

O programa deverá receber uma lista de valores de um arquivo de texto, onde esta lista não terá uma determinação de quantidade fixa, podendo variar de arquivo para arquivo. Após, deverá ser alocado os valores dentro da estrutura de Array (não poderão ser aplicadas Collections para solução), e realizada a ordenção dos valores, imprimindo em tela os passos ocorridos desta ordenação. Após, deverá ser utilizado uma Collection para o recebimento dos mesmos valores, de maneira que estes valores já estejam ordenados. Ao final, deverá ser impresso em tela o valor ordenado do Array e da Collection, garantindo que estejam iguais, e deverá ser exportado em um arquivo de texto esses valores.
 */

 // ======================================= BUBBLE SORT =================================================================================


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ordenacao02 {

    public static void main(String[] args) {
        try {
            Path caminho = Paths.get("valores.txt");

            // Lê todas as linhas do arquivo
            List<String> linhas = Files.readAllLines(caminho);

            // Cria array com tamanho igual ao número de linhas
            int[] valores = new int[linhas.size()];

            // Converte cada linha em inteiro
            for (int i = 0; i < linhas.size(); i++) {
                valores[i] = Integer.parseInt(linhas.get(i));
            }

            // Imprime o array original
            System.out.println("Array lido do arquivo:");
            for (int valor : valores) {
                System.out.print(valor + " ");
            }
            System.out.println();

            // Chama os métodos de ordenação
            OrdenaNormal(valores.clone()); // clone para manter o original
            OrdenaCollection(valores);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro na conversão de número: " + e.getMessage());
        }
    }

    public static void OrdenaNormal(int[] valores) {
        // a variável "tamanho" irá armazenar o tamanho do array "valores"
        int tamanhoArray = valores.length;
        // criaremos a uma banderinha que irá informar se houve alguma troca nas posições do array
        boolean trocou;
        // esse for representará o número de passadas que algoritmo vai dar no array
        // na primeira vez o valor maior vai para o final da fila, o segundo maior vai para o última posição e assim por diante        
        // - 1 é por que já chegou no último elemento, não precisa comparálo mais

        for (int i = 0; i < tamanhoArray - 1; i++) {
            trocou = false;
             // esse for interno irá percorrer o array e comparar os elementos vizinhos
            for (int j = 0; j < tamanhoArray - i - 1; j++) {
                // se o valor da esquerda valores[j] foi maior que o direita valores[j + 1] eles trocarão
                if (valores[j] > valores[j + 1]) {
                    // auxiliar serve pra fazer essa troca.
                    int auxiliar = valores[j];
                    valores[j] = valores[j + 1];
                    valores[j + 1] = auxiliar;
                    // quando troca o trocou serve para alerta que foi trocado
                    trocou = true;

                    // Imprime o array a cada troca
                    for (int k = 0; k < tamanhoArray; k++) {
                        System.out.print(valores[k] + " ");
                    }
                    System.out.println();
                }
            }
            if (!trocou) break; // Otimização: para se já estiver ordenado(economiza tempo e desempenho
        }

        // Imprime array ordenado
        System.out.println("Array ordenado (Bubble Sort):");
        for (int valor : valores) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    // funçao do Collection
    public static void OrdenaCollection(int[] valores) {
        List<Integer> lista = new ArrayList<>();
        for (int valor : valores) {
            lista.add(valor);
        }

        Collections.sort(lista);

        System.out.println("Collection ordenada (Collections.sort):");
        for (int valor : lista) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}