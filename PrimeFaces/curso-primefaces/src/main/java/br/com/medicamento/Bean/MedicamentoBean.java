package br.com.medicamento.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.medicamento.Modelo.Medicamento;
import br.com.medicamento.Util.Mensagens;
import br.com.medicamento.Util.NegocioException;
import br.com.medicamento.service.MedicamentoService;

@Named
@ViewScoped
public class MedicamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Medicamento medicamento;

	@Inject
	private MedicamentoService service;

	private List<Medicamento> medicamentos;

	@PostConstruct // Assim que a classe for criada ele é construido
	public void carregar() {
		medicamentos = service.todosOsMedicamentos();
	}

	public void adicionar() {
		try {
			service.salvar(medicamento);
			medicamento = new Medicamento();
			carregar();

			Mensagens.info("Salvo com sucesso");

		} catch (NegocioException e) {
			Mensagens.erro(e.getMessage());
		}
	}

	public void excluir() {
		try {

			service.remove(medicamento);
			carregar();

			Mensagens.info(medicamento.getNome() + "Foi removido.");

		} catch (NegocioException e) {
			Mensagens.erro(e.getMessage());
		}
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

}
