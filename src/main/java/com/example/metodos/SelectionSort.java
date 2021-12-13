package com.example.metodos;

public class SelectionSort extends Ordenacao {

	@Override
	public void ordenar(Integer[] v) {
		// Laco para percorrer toda a lista
		for (int fixo = 0; fixo < v.length - 1; fixo++) {
			int menor = fixo;

			// Laco para encontrar o menor valor de um posicao (definida pela variavel fixo) 
			// ate o restante do vetor, ou seja, a parte do vetor que nao esta ordenada
			for (int i = menor + 1; i < v.length; i++) {
				comparacaoDeChaves++;
				if (v[i] < v[menor]) {
					menor = i;
					qtdOperacao++;
				}
				/** Operacoes:
				 * i < v.length
				 * i++
				 * v[i] < v[menor]
				 */
				qtdOperacao+=3;
			}

			Integer aux = v[fixo];
			v[fixo] = v[menor];
			v[menor] = aux;
			movimentacaoDeRegistro+=2;
			
			/** Operacoes:
			 * fixo < v.length - 1
			 * fixo++
			 * int menor = fixo
			 * int i = menor + 1
			 * i < v.length
			 * Integer aux = v[fixo];
			 * v[fixo] = v[menor];
			 * v[menor] = aux;
			 */
			qtdOperacao+=8;
		}
		/** Operacoes:
		 * int fixo = 0
		 * fixo < v.length - 1
		 */
	}

	@Override
	public String toString() {
		return "SelectionSort";
	}
}

