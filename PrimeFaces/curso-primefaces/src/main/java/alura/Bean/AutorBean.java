package alura.Bean;


import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import alura.DAO.AutorDAO;
import alura.Modelo.Autor;
import alura.Util.Transacional;

@Named
@ViewScoped //javax.faces.view.ViewScoped;
public class AutorBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Autor autor = new Autor();
	
	@Inject
	private AutorDAO  autorDAO; //CDI faz new AutorDAO() e injeta
	
	private Integer autorId;
	
	@Transacional
	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if(this.autor.getId() == null) {
			this.autorDAO.adiciona(this.autor);
		} else {
			this.autorDAO.atualiza(this.autor);
		}

		this.autor = new Autor();

		return "/alura/livro?faces-redirect=true";
	}
	
	@Transacional
	public void remover(Autor autor) {
		System.out.println("Removendo autor " + autor.getNome());
		this.autorDAO.remove(autor);
	}
	
	public List<Autor> getAutores() {
		return this.autorDAO.listaTodos();
	}
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public AutorDAO getAutorDAO() {
		return autorDAO;
	}

	public void setAutorDAO(AutorDAO autorDAO) {
		this.autorDAO = autorDAO;
	}
	
	public Integer getAutorId() {
		return autorId;
	}
	
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public void carregarAutorPelaId() {
		this.autor = this.autorDAO.buscaPorId(autorId);
	}
	
}
