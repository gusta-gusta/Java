package alura.Bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import alura.Modelo.Autor;

@Named
@ViewScoped
public class AutorBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Autor autor;

}
