package br.com.alura.domain;

public class Abrigo {

	private Long id;
	private String nome;
	private String teleone;
	private String email;

	public Abrigo(String nome, String telefone, String email) {
		this.nome = nome;
		this.teleone = telefone;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTeleone() {
		return teleone;
	}

	public void setTeleone(String teleone) {
		this.teleone = teleone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
