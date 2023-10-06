package br.com.curso.Bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.curso.Modelo.Atividade;
import br.com.curso.Modelo.TipoAtividade;
import java.io.Serializable;

@Named
@SessionScoped
public class AtividadeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Atividade atividade;
	
	public TipoAtividade[] getAtividades() {
		return TipoAtividade.values();
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	
	
}
