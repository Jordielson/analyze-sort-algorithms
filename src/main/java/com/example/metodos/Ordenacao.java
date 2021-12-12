package com.example.metodos;

public abstract class Ordenacao {
	protected long movimentacaoDeRegistro;
	protected long comparacaoDeChaves;
	protected long qtdOperacao;

	/**
	 * Metodo para realizar a ordenacao
	 * @param v vetor a ser ordenado
	 */
	public abstract void ordenar(Integer[] v);


	public void setMovimentacaoDeRegistro(long movimentacaoDeRegistro) {
		this.movimentacaoDeRegistro = movimentacaoDeRegistro;		
	}

	public long getMovimentacaoDeRegistro() {
		return movimentacaoDeRegistro;
	}

	public void setcomparacaoDeChaves(long comparacaoDeChaves) {
		this.comparacaoDeChaves = comparacaoDeChaves;
		
	}

	public long getcomparacaoDeChaves() {
		return comparacaoDeChaves;
	}	

	public String toString() {
		return "Ordenacao";
	}


	public long getQtdOperacao() {
		return qtdOperacao;
	}

	public void setQtdOperacao(long qtdOperacao) {
		this.qtdOperacao = qtdOperacao;
	}
}
