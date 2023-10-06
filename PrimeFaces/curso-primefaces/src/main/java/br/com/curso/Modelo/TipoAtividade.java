package br.com.curso.Modelo;

public enum TipoAtividade {
	
	APRESENTACAO("Apresentação"), CURSO("Curso"), MINICURSO("Minicurso"), PALESTRA("Palestra"), SEMINARIO("Seminário"), SIMPOSIO("Simpósio"), OUTRA("Outras");
	
	private String descricao;

	 String getDescricao() {
		return descricao;
	}

	TipoAtividade(String descricao) {
		this.descricao = descricao;
	}
	
	

}
