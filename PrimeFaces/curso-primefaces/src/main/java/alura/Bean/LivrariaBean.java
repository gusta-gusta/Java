package alura.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import alura.Modelo.Livraria;
import alura.Util.NegocioException;
import alura.Service.LivrariaService;
import alura.Util.Mensagens;

@Named
@ViewScoped
public class LivrariaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Livraria livraria;
	
	@Inject
	private LivrariaService service;
	
	private List<Livraria> livros;
	
	@PostConstruct // Assim que a classe for criada ele é construido
	public void carregar() {
		livros = service.todosOsLivros();
	}
	
	
	public void adicionar() {
		
		
		try {
			service.salvar(livraria);
			livraria = new Livraria();
			carregar();

			Mensagens.info("Salvo com sucesso");

		} catch (NegocioException e) {
			Mensagens.erro(e.getMessage());
		}
	}

	public void excluir() {
		try {

			service.remove(livraria);
			carregar();

			Mensagens.info(livraria.getTitulo() + " Foi removido.");

		} catch (NegocioException e) {
			Mensagens.erro(e.getMessage());
		}
	}
	
	


	public Livraria getLivraria() {
		return livraria;
	}


	public void setLivraria(Livraria livraria) {
		this.livraria = livraria;
	}


	public List<Livraria> getLivros() {
		return livros;
	}
	
	
}
