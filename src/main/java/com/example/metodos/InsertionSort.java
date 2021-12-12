package com.example.metodos;

public class InsertionSort extends Ordenacao {
	@Override
	public void ordenar(Integer[] v) {
		int key;
		int j;
		
		// Laco para percorrer todo o vetor
		for (int i = 1; i < v.length; ++i) {
			key = v[i];
			j = i - 1;

			// Laco para percorrer a parte ordenado do vetor e encontrar o indice correto 
			// para inserir a chave
			while (j >= 0) {
				comparacaoDeChaves++;
				if (v[j] > key) {
					v[j + 1] = v[j];
					movimentacaoDeRegistro++;
					j--;
					
					/** Operacoes:
					 * j--
					 * v[j + 1] = v[j];
					 */
					qtdOperacao+=2;
				} else {
					// se v[j] eh menor que a chave podemos finalizar o laco 
					// pois o indice para inserir a chave ja foi encontrado
					break;
				}
				/**
				 * Operacoes:
				 * j >= 0;
				 * v[j] > key;
				 */
				qtdOperacao+=2;
				
			}
			v[j + 1] = key;
			movimentacaoDeRegistro++;
			/** Operacoes:
			 * key = v[i];
			 * j = i - 1;
			 * j >= 0 ou break
			 * v[j + 1] = key;
			 * i < v.length
			 * ++i
			 */
			qtdOperacao+=6;
		}	

		/** Operacoes
		 * int key
		 * int j
		 * int i = 1
		 */
		qtdOperacao+=3;
	}

	@Override
	public String toString() {
		return "InsertionSort";
	}
}


