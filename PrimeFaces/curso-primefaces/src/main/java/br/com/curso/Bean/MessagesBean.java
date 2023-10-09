package br.com.curso.Bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@ViewScoped
public class MessagesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	 public void salvar() {
		 
		 FacesMessage message = new FacesMessage("Sucesso!");
		 FacesContext.getCurrentInstance().addMessage(null, message);
	 }
	 
	 public void erro() {
		 
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", null);
		 FacesContext.getCurrentInstance().addMessage(null, message);
	 }	 
	
	
}
