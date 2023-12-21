package alura.Util;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class JSFUtil {

	
	@Produces // produz o entity
	@RequestScoped // Vai produzir a cada requisição
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
}
