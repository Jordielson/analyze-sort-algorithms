package com.example.metodos;

public class MergeSort extends Ordenacao {

	public void ordenar(Integer[] v) {
		mergeSort(v, v.length);
	}
	
	private void mergeSort(Integer[] a, int n) {
	    if (n < 2) {
			qtdOperacao+=2;
	        return;
	    }
	    int mid = n / 2;
	    Integer[] l = new Integer[mid];
	    Integer[] r = new Integer[n - mid];

	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
			/**
			 * Operacoes:
			 * l[i] = a[i];
			 * i < mid
			 * i++
			 */
			qtdOperacao+=3;
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
			/**
			 * Operacoes:
			 * r[i - mid] = a[i];
			 * i < n
			 * i++
			 */
			qtdOperacao+=3;
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);

	    merge(a, l, r, mid, n - mid);
		/**
		 * Operacoes:
		 * n < 2
		 * int mid = n / 2;
	     * Integer[] l = new Integer[mid];
	     * Integer[] r = new Integer[n - mid];
		 * int i = 0
		 * int i = mid
		 * mergeSort(l, mid);
	     * mergeSort(r, n - mid);
		 * merge(a, l, r, mid, n - mid);
		 */
		qtdOperacao+=9; 
	}
	
	private void merge(Integer[] a, Integer[] l, Integer[] r, int left, int right) {
	    int i = 0, j = 0, k = 0;
	    while (i < left && j < right) {
			comparacaoDeChaves++;
	        if (l[i] <= r[j]) {
	            a[k++] = l[i++];
				movimentacaoDeRegistro++;
	        }
	        else {
				a[k++] = r[j++];
				movimentacaoDeRegistro++;
	        }
			/**
			 * Operacoes:
			 * i < left && j < right
			 * l[i] <= r[j]
			 * a[k++] = l[i++] ou a[k++] = r[j++]
			 */
			qtdOperacao+=3;
	    }
	    while (i < left) {
	        a[k++] = l[i++];
			movimentacaoDeRegistro++;
			qtdOperacao+=2;
	    }
	    while (j < right) {
	        a[k++] = r[j++];
			movimentacaoDeRegistro++;
			qtdOperacao+=2;
	    }
		/**
		 * Operacoes:
		 * int i = 0
		 * j = 0
		 * k = 0
		 * i < left && j < right
		 * i < left
		 * j < right
		 */
		qtdOperacao+=6;
	}

	@Override
	public String toString() {
		return "MergeSort";
	}
}


