package br.com.curso.Modelo;

public enum TipoAtividade {
	
	APRESENTACAO("Apresentação"), CURSO("Curso"), MINICURSO("Minicurso"), PALESTRA("Palestra"), SEMINARIO("Seminário"), SIMPOSIO("Simpósio"), OUTRA("Outras");
	
	private String descricao;

	 public String getDescricao() {
		return this.descricao;
	}

	TipoAtividade(String descricao) {
		this.descricao = descricao;
	}
	
	

}
