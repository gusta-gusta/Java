package alura.Bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import alura.DAO.UsuarioDAO;
import alura.Modelo.Usuario;

@SessionScoped
@ManagedBean
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario = new Usuario();
	
	
	//Metodos
	
	public String efetuaLogin() {
		System.out.println("Fazendo login do usuário: " + this.usuario.getEmail());
		
		boolean existe = new UsuarioDAO().existe(this.usuario);
		
		if (existe) {
			return "livro?faces-redirect=true";	
		}
				
		return null;	
		
	}
	
	
	
	
	
	// Getters e Setters

	public Usuario getUsuario() {
		return usuario;
		
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		
	}
	
	
}

