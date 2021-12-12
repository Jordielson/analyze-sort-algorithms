package com.example.gerador;

import java.util.Arrays;
import java.util.Collections;

/**
 * Classe que vai gerar as sequencias que serao usadas pelos algoritmos de ordenacao.
 * As sequencias que podem ser geradas sao:
 * I - arranjos ordenados;
 * II - arranjos inversamente ordenados;
 * III - arranjos quase ordenados;
 * IV - arranjos aleatórios.
 * @author: Jordielson
 */
public class GeradorSequencias {
    /**
     * Gera uma sequencia ordenada de numeros inteiros com uma distancia maxima de 100 de 
     * um valor para o proximo elemento da lista
     * @param tamanhoSeq tamanho da sequencia a ser gerada
     * @return um array com a sequencia de numeros ordenados
     */
    public static  Integer[] gerarSeqOrdenado(int tamanhoSeq) {
        int distMaxEntreElementos = 100;
		Integer[] v = new Integer[tamanhoSeq];
		for(int i = 0, num = 0; i < tamanhoSeq; i++) {
            num = ((int) (Math.random()*distMaxEntreElementos)) + num + 1;
			v[i] = num;
		}
		return v;
	}

    /**
     * Gera uma sequencia ordenada de forma decrescente com uma distancia maxima de 
     * -100 de um valor para o proximo elemento da lista
     * @param tamanhoSeq tamanho da sequencia a ser gerada
     * @return um array com a sequencia de numeros ordenados decrescentemente
     */
    public static  Integer[] gerarSeqInversamenteOrdenado(int tamanhoSeq) {
		Integer[] v = GeradorSequencias.gerarSeqOrdenado(tamanhoSeq);
        for(int i = 0; i < tamanhoSeq/2; i++) {
			trocar(v, i, tamanhoSeq-1-i);
		}
		return v;
	}

    /**
     * Gera uma sequencia de com elementos quase ordenados, 
     * a qual possui no maximo 10% dos elementos trocados em um array inicialmente ordenado. 
     * @param tamanhoSeq tamanho da sequencia a ser gerada
     * @return uma sequencia com valores quase ordenados
     */
    public static Integer[] gerarSeqQuaseOrdenado(int tamanhoSeq) {
		Integer[] v = GeradorSequencias.gerarSeqOrdenado(tamanhoSeq);
		int fim = (int) (tamanhoSeq*0.1);
		while (fim > 0) {
			int i = (int)(Math.random()*tamanhoSeq);
			int j = (int)(Math.random()*tamanhoSeq);
			trocar(v, i, j);
			fim--;
		}
		
		return v;
	}

    /**
     * Gera uma sequencia de numeros aleatorios
     * @param tamanhoSeq tamanho da sequencia a ser gerada
     * @return a sequencia de numeros aleatorios
     */
    public static  Integer[] gerarSeqAleatorio(int tamanhoSeq) {
		Integer[] v = GeradorSequencias.gerarSeqOrdenado(tamanhoSeq);
        Collections.shuffle(Arrays.asList(v));
		return v;
	}

    /**
     *  Gerar uma sequencia dependendo do tipo passado pelo parametro
     * @param tamanhoSeq tamanho da sequencia a ser gerada
     * @param tipoSequencia tipo da sequencia podendo ser: ordenado, 
     *                      inversamente ordenado, quase ordenado ou aleatorio
     * @return a sequencia de inteiros que foi gerada
     */
    public static Integer[] gerar(int tamanhoSeq, TipoSeq tipoSeq) {
        if(tipoSeq == TipoSeq.ORDENADO) {
            return GeradorSequencias.gerarSeqOrdenado(tamanhoSeq);
        } else if(tipoSeq == TipoSeq.INV_ORDENADO) {
            return GeradorSequencias.gerarSeqInversamenteOrdenado(tamanhoSeq);
        } else if(tipoSeq == TipoSeq.QUASE_ORDENADO) {
            return GeradorSequencias.gerarSeqQuaseOrdenado(tamanhoSeq);
        } else {
            return GeradorSequencias.gerarSeqAleatorio(tamanhoSeq);
        }
    }
	
    /**
     * Troca a posicao de dois elementos em um array. 
     * Este metodo faz a troca no proprio vetor, por isso nao eh necessario retorno
     * @param v vetor que sera realizado a troca dos elementos
     * @param i posicao do vetor do primeiro elemento a ser trocado
     * @param j posicao do vetor do segundo elemento a ser trocado
     */
	private static void trocar(Integer[] v, int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}
}