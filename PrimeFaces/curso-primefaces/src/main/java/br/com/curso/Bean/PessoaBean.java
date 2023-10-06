package br.com.curso.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.curso.Modelo.Pessoa;

@Named
@SessionScoped
public class PessoaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pessoa pessoa;
	
		
	
	private List<Pessoa> pessoas = new ArrayList<>();
	
	
	
	public String adicionar() {
		
		pessoas.add(pessoa);
		limpar();
		return null;
	}
	
	
	public String parar() {		
		return null;
		
	}
	
	private void limpar() {
		
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	
	
	
	
}
