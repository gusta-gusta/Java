package alura.Bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import alura.DAO.UsuarioDAO;
import alura.Modelo.Usuario;


@Named
@ViewScoped // javax.faces.view.ViewScoped;
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String efetuaLogin() {
		System.out.println("fazendo login do usuario " + this.usuario.getEmail());
		
		FacesContext context = FacesContext.getCurrentInstance();
		boolean existe = new UsuarioDAO().existe(this.usuario);
		if(existe ) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return "/alura/livro?faces-redirect=true";
		}
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Usuário não encontrado"));
		
		return "/alura/login?faces-redirect=true";
	}
	
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return "/alura/login?faces-redirect=true";
	}
}
