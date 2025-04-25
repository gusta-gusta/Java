package produto.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import produto.api.model.Produto;
import produto.api.repository.ProdutoRepository;

@RequestMapping("/produtos")
@CrossOrigin(origins = "*") // permite chamadas do frontend (React Native)
public class ProdutoController {

	private final ProdutoRepository repository;

	public ProdutoController(ProdutoRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Produto> listar() {
		return repository.findAll();
	}

	@PostMapping
	public Produto adicionar(@RequestBody Produto produto) {
		return repository.save(produto);
	}

	@PutMapping("/{id}")
	public Produto atualizar(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
		return repository.findById(id).map(produto -> {
			produto.setNome(produtoAtualizado.getNome());
			produto.setQuantidade(produtoAtualizado.getQuantidade());
			return repository.save(produto);
		}).orElseGet(() -> {
			produtoAtualizado.setId(id);
			return repository.save(produtoAtualizado);
		});
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
