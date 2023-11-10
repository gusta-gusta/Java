package alura.Bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import alura.DAO.DAO;
import alura.Modelo.Autor;

@SessionScoped
@ManagedBean
public class AutorBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Autor autor = new Autor();
	
	private Integer autorId;
	
	public List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}

	public void editarAutorPelaId() {
		this.autor = new DAO<Autor>(Autor.class).buscaPorId(autorId);
	}
	
	
	
	public String voltar() {
		System.out.println("voltando para a página  ");
		
		return "Autor?faces-redirect=true";
	}
	
	public void editar(Autor a ) {
		System.out.println("O Autor: " + a.getNome() + " está sendo editado....");
		
		this.autor = a;
	}
	
	public void gravar() {
		if (this.autor.getId() == null) {
			
		
		System.out.println("Gravando autor " + this.autor.getNome());

		new DAO<Autor>(Autor.class).adiciona(this.autor);
		}else {
			System.out.println("O Autor: " + this.autor.getNome() + " foi atualizado com sucesso.");
			new DAO<Autor>(Autor.class).atualiza(this.autor);
		}
		this.autor = new Autor();
	}
	
	public void remover(Autor a) {
		System.out.println("Removendo Autor: " + a.getNome());
		
		new DAO<Autor>(Autor.class).remove(a);
		
	}
	

	
	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public Autor getAutor() {
		return autor;
	}
	
	
}

