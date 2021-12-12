package com.example.metodos;

public class QuickSort extends Ordenacao {

	@Override
	public void ordenar(Integer[] v) {
		if(v.length > 0)
			ordenar(v, 0, v.length-1);
	}
	
	private void ordenar(Integer[] v, int inicio, int fim) {
		int e, d;
		Integer aux, pivo;
		
		e = inicio;
		d = fim;
		int random = (int) (Math.random()*(fim+1-inicio) + inicio);
		pivo = v[random];
		while(e < d) {
			while(v[e] < pivo) {
				comparacaoDeChaves++;
				e++;
				/** Operacoes:
				 * v[e] > pivo
				 * e++
				 */
				qtdOperacao+=2;
			}
			while(v[d] > pivo) {
				comparacaoDeChaves++;
				d--;
				/** Operacoes:
				 * v[d] > pivo
				 * d--
				 */
				qtdOperacao+=2;
			}
			if(e <= d) {
				aux = v[e];
				v[e] = v[d];
				v[d] = aux;
				movimentacaoDeRegistro++;
				e++;
				d--;
				/** Operacoes:
				 * aux = v[e];
				 * v[e] = v[d];
				 * v[d] = aux;
				 * e++;
				 * d--;
				 */
				qtdOperacao+=5;
			}

			/** Operacoes:
			* e < d
			* v[e] < pivo
			* v[d] < pivo
			* e <= d
			*/
			qtdOperacao+=4;
		} // fim while
		if(d > inicio) {
			ordenar(v, inicio, d);
		}
		if(e < fim) {
			ordenar(v, e, fim);
		}

		/** Operacoes:
		 * int e, d;
		 * Integer aux, pivo;
		 * e = inicio;
		 * d = fim;
		 * int random = (int) (Math.random()*(fim+1-inicio) + inicio);
		 * pivo = v[random];
		 * d > inicio
		 * e < fim
		 */
		qtdOperacao+=8;
	}

	@Override
	public String toString() {
		return "QuickSort";
	}
}
