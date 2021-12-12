package com.example.metodos;

public class BubbleSort extends Ordenacao {

	public void ordenar(Integer[] v) {
		for(int i = 0; i < v.length - 1; i++) {
			boolean estaOrdenado = true;

			for(int j = 0; j < v.length - 1 - i; j++) {
				comparacaoDeChaves++;
				if(v[j] > v[j + 1]) {
					movimentacaoDeRegistro++;
					int aux = v[j];
					v[j] = v[j + 1];
					v[j + 1] = aux;
					estaOrdenado = false;

					/** Operacoes:
						3 operacoes da movimentacao do registro
						mudanca da variavel estaOrdenado para false
			 		*/
					qtdOperacao += 4;
				}
				/** Operacoes:
					incremento da variavel j
					comparacao do laco for com variavel j
					comparacao de chaves
			 	*/
				 qtdOperacao += 3;
			}
			
			if(estaOrdenado) {   	  
				break;
			}
			/** Operacoes:
				incremento da variavel i
				comparacao do laco for com variavel i
				inicializacao da variavel estaOrdenado
				inicializacao da variavel j
				ultima comparacao do laco for com varial j
				verificacao se a lista esta ordenada
			 */
			qtdOperacao += 5;
		}
		// Uma operacao de int = 0 e uma da ultima comparacao do laco for ou break
		qtdOperacao += 2; 
	}

	@Override
	public String toString() {
		return "BubbleSort";
	}
}


