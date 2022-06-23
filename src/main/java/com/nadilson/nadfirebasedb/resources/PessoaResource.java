package com.nadilson.nadfirebasedb.resources;

import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nadilson.nadfirebasedb.domain.Pessoa;
import com.nadilson.nadfirebasedb.services.PessoaService;

@RestController
public class PessoaResource {

	public PessoaService pessoaService;

	public PessoaResource(PessoaService pessoaService) {
		super();
		this.pessoaService = pessoaService;
	}
	
	@PostMapping("/create")
	public String create(@RequestBody Pessoa pessoa) throws InterruptedException, ExecutionException {
		return pessoaService.createUser(pessoa);
	}
	
	@GetMapping("/get")
	public String getUser(@RequestParam Long id) throws InterruptedException, ExecutionException {
		return pessoaService.getUser(id);
	}
	
	@PutMapping("/update")
	public String updateUser(@RequestBody Pessoa pessoa) throws InterruptedException, ExecutionException {
		return pessoaService.updateUser(pessoa);
	}
	
	@PutMapping("/delete")
	public String deleteuser(@RequestParam Long id) throws InterruptedException, ExecutionException {
		return pessoaService.deleteUser(id);
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> testEndpoint() {
		return ResponseEntity.ok("Endpoint está funcionando como esperado!");
	}
}
