package alura.Bean;import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import alura.DAO.AutorDAO;
import alura.DAO.LivroDAO;
import alura.Modelo.Autor;
import alura.Modelo.Livro;
import alura.Util.Transacional;

@Named
@ViewScoped // javax.faces.view.ViewScoped;
public class LivroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Livro livro = new Livro();

	private Integer autorId;
	
	@Inject
	private LivroDAO livroDAO;
	
	@Inject
	private AutorDAO autorDAO;
	
	@Inject
	FacesContext context;

	private List<Livro> livros;
	
	private List<String> generos = Arrays.asList("Romance", "Drama", "Ação");

	public List<String> getGeneros() {
	    return generos;
	}

	public List<Livro> getLivros() {
		if (this.livros == null) {
			this.livros = livroDAO.listaTodos();
		}
		return livros;
	}

	public List<Autor> getAutores() {
		return autorDAO.listaTodos();
	}

	public List<Autor> getAutoresDoLivro() {
		return this.livro.getAutores();
	}

	public void carregarLivroPelaId() {
		this.livro = livroDAO.buscaPorId(this.livro.getId()); 
	}
	
	public void gravarAutor() {
		Autor autor = autorDAO.buscaPorId(this.autorId);
		this.livro.adicionaAutor(autor);
		System.out.println(livro.getTitulo() + " Foi Escrito por: " + autor.getNome());
	}
	
	@Transacional
	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			context.addMessage("autor",
					new FacesMessage("Livro deve ter pelo menos um Autor."));
			return;
		}

		if(this.livro.getId() == null) {
			livroDAO.adiciona(this.livro);
			this.livros = livroDAO.listaTodos();
		} else {
			livroDAO.atualiza(this.livro);
		}

		this.livro = new Livro();
	}

	@Transacional
	public void remover(Livro livro) {
		System.out.println("Removendo livro");
		livroDAO.remove(livro);
	}
	
	public void removerAutorDoLivro(Autor autor) {
		System.out.println("Removendo Autor:  " + autor.getNome() + " do Livro: " + livro.getTitulo());
		this.livro.removeAutor(autor);
	}
	
	public void carregar(Livro livro) {
		System.out.println("Carregando livro");
		this.livro = this.livroDAO.buscaPorId(livro.getId());
	}
	
	public String formAutor() {
		System.out.println("Chamanda do formulário do Autor.");
		return "/alura/autor?faces-redirect=true";
	}

	public void comecaComDigitoUm(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException {

		String valor = value.toString();
		if (!valor.startsWith("1")) {
			throw new ValidatorException(new FacesMessage(
					"ISBN deveria começar com 1"));
		}

	}

	public LivroDAO getLivroDAO() {
		return livroDAO;
	}

	public void setLivroDAO(LivroDAO livroDAO) {
		this.livroDAO = livroDAO;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public void setGeneros(List<String> generos) {
		this.generos = generos;
	}
	
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public Integer getAutorId() {
		return autorId;
	}
	
	public Livro getLivro() {
		return livro;
	}

	public AutorDAO getAutorDAO() {
		return autorDAO;
	}

	public void setAutorDAO(AutorDAO autorDAO) {
		this.autorDAO = autorDAO;
	}

	@Override
	public String toString() {
		return "LivroBean [livro=" + livro + ", autorId=" + autorId + ", livroDAO=" + livroDAO + ", autorDAO="
				+ autorDAO + ", livros=" + livros + ", generos=" + generos + "]";
	}
	
	
	
}
