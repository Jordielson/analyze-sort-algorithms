package com.example;

import com.example.gerador.TipoSeq;
import com.example.metodos.*;
import com.example.programa.Programa;

public class App 
{
    public static void main( String[] args ) {
		Ordenacao[] metodo = {new BubbleSort(), new InsertionSort(), new SelectionSort(), new QuickSort(), new MergeSort()};
        TipoSeq[] tipos = {TipoSeq.ORDENADO, TipoSeq.INV_ORDENADO, TipoSeq.QUASE_ORDENADO, TipoSeq.ALEATORIO};
		int[] tamanhos = {10, 100, 1000, 10000, 100000, 1000000};
        int qtdExecucoes = 1;
		Programa.executar(metodo[2], qtdExecucoes, tipos[0], tamanhos);
    }
}
