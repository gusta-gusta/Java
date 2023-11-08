package alura.Bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import alura.DAO.DAO;
import alura.Modelo.Autor;
import alura.Modelo.Livro;

@ManagedBean
@ViewScoped
public class LivroBean {

	private Livro livro = new Livro();
	private Integer autorId;

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public Integer getAutorId() {
		return autorId;
	}

	public Livro getLivro() {
		return livro;
	}

	public List<Livro> getLivros() {
		return new DAO<Livro>(Livro.class).listaTodos();
	}

	public List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}

	public List<Autor> getAutoresDoLivro() {
		return this.livro.getAutores();
	}

	public void adicionarAutor() {

		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(this.autorId);
		System.out.println("Usando autor " + autor.getNome());
		this.livro.adicionaAutor(autor);
	}
	
	public void remover(Livro l) {
		System.out.println("Removendo livro: " + l.getTitulo());
		
		new DAO<Livro>(Livro.class).remove(l);
		
	}
	
	public void editar(Livro l ) {
		System.out.println("O livro: " + l.getTitulo() + " está sendo editado....");
		
		this.livro = l;
	}
	
	


	public void gravar() {
		
		if (this.livro.getId() == null) {
			
		
		
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			/*
			 * throw new RuntimeException("Livro deve ter pelo menos um Autor.");
			 */
			FacesContext.getCurrentInstance().addMessage("autor",
					new FacesMessage("Livro deve ter pelo menos um Autor"));
			return;
		}

		new DAO<Livro>(Livro.class).adiciona(this.livro);
		} else {
			System.out.println("O livro: " + this.livro.getTitulo() + " foi atualizado com sucesso.");
			new DAO<Livro>(Livro.class).atualiza(this.livro);
		}
		this.livro = new Livro();
	}

	public void gravarAutor() {

		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(this.autorId);
		this.livro.adicionaAutor(autor);
		System.out.println("escrito por: " + autor.getNome());
	}

	public void comecaComDigitoUm(FacesContext fc, UIComponent component, Object value) throws ValidatorException {

		String valor = value.toString();
		if (!valor.startsWith("1")) {
			throw new ValidatorException(new FacesMessage("Deveria começar com 1"));
		}

	}

	public String formAutor() {
		System.out.println("Chamando o formulário do Autor");
		return "autor?faces-redirect=true";
	}

}