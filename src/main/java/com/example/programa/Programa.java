package com.example.programa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.gerador.GeradorSequencias;
import com.example.gerador.TipoSeq;
import com.example.metodos.Ordenacao;
import com.example.persiste.PersisteCSV;

public class Programa {

    public static void executar(Ordenacao metodo, int qtdExecucoes, TipoSeq tipoSequencia, int[] tamanhos) {
		String[] cabecalhoArquivo = new String[tamanhos.length+1];
		cabecalhoArquivo[0] = "Descricao";
		for (int i = 0; i < tamanhos.length; i++) {
			cabecalhoArquivo[i+1] = tamanhos[i]+"";
			
		}
		int qtdVetores = tamanhos.length;
		long[][][] execucoes = new long[qtdExecucoes][4][tamanhos.length];
		long[][] media = new long[4][tamanhos.length];

		for (int i = 0; i < qtdExecucoes; i++) {
			for (int j = 0; j < tamanhos.length; j++) {
				Integer[] v = GeradorSequencias.gerar(tamanhos[j], tipoSequencia);

				long tempoInicial = System.currentTimeMillis();
				metodo.ordenar(v);
				long tempoFinal = System.currentTimeMillis();
				Programa.isSort(v);
				
				execucoes[i][0][j] = tempoFinal - tempoInicial;
				media[0][j] += execucoes[i][0][j];

				execucoes[i][1][j] = metodo.getcomparacaoDeChaves();
				media[1][j] += metodo.getcomparacaoDeChaves();

				execucoes[i][2][j] = metodo.getMovimentacaoDeRegistro();
				media[2][j] += metodo.getMovimentacaoDeRegistro();

				execucoes[i][3][j] = metodo.getQtdOperacao();
				media[3][j] += metodo.getQtdOperacao();

				metodo.setMovimentacaoDeRegistro(0);
				metodo.setcomparacaoDeChaves(0);
				metodo.setQtdOperacao(0);
			}
		}

		List<String[]> linhas = new ArrayList<>();

		//Tempo de execucao do algoritimo
		Programa.calcularMedia(execucoes, media, 0, qtdVetores, qtdExecucoes, linhas, "Tempo");

		// Quantidade de comparacao de registros realizadas pelo algoritmo
		Programa.calcularMedia(execucoes, media, 1, qtdVetores, qtdExecucoes, linhas , "Comparacao de Registros");
		
		// Quantidade de Movimentacoes de Registros realizadas pelo algoritmo
		
		Programa.calcularMedia(execucoes, media, 2, qtdVetores, qtdExecucoes, linhas, "Movimentacao de Registros");

		// Quantidade de Operacoes realizadas pelo algoritmo
		Programa.calcularMedia(execucoes, media, 3, qtdVetores, qtdExecucoes, linhas, "Quantidade de Operacoes");

		try {
			PersisteCSV.salvar(metodo.toString() + "-" + tipoSequencia.name(), linhas, cabecalhoArquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verifica se o vetor esta ordenado, 
	 * gera uma excecao em tempo de execucao 
	 * se o vetor nao estiver ordenado
	 * @param v vetor
	 */
	private static void isSort(Integer[] v) {
		for(int j = 0; j < v.length - 1; j++) {
			if(v[j] > v[j + 1]) {
				throw new RuntimeException("Algoritmo de ordenacao nao esta ordenando corretamente");
			}
		}
	}

	/**
	 * Calcula a media aritmetica das execucoes do algoritmo 
	 * e gera as linhas que serao usadas no arquivo csv
	 * @param execucoes
	 * @param media
	 * @param posicao
	 * @param qtdVetores
	 * @param qtdExecucoes
	 * @param linhas
	 * @param metrica
	 */
	private static void calcularMedia(long[][][] execucoes, long[][] media, int posicao, int qtdVetores, int qtdExecucoes, List<String[]> linhas, String metrica ) {
		String[] linha;
		// Adciona na lista todos os teste realizados
		for (int i = 0; i < qtdExecucoes; i++) {
			linha = new String[qtdVetores+1];
			linha[0] = metrica + " - " + (i+1) + " Execucao ";
			for (int j = 0; j < qtdVetores; j++) {
				linha[j+1] = execucoes[i][posicao][j] + "";
			}
			linhas.add(linha);
		}
		
		// Calcula a media de todos os testes realizados
		linha = new String[qtdVetores+1];
		linha[0] = metrica + " - Media";
		for (int i = 0; i < qtdVetores; i++) {
			linha[i+1] = ((double) media[posicao][i]/qtdExecucoes) + "";
		}
		linhas.add(linha);

	}
}
