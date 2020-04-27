package br.com.ordemservice.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ordemservice.domains.model.OrdemServico;
import br.com.ordemservice.domains.service.GestaoOrdemServicoService;


@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

	
	@Autowired
	GestaoOrdemServicoService gestaoOrdemServico;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico  criar(@Valid @RequestBody OrdemServico ordemServico)
	{
	
	return gestaoOrdemServico.criar(ordemServico);
	}
	
	
	@GetMapping
	public List<OrdemServico> listar() {
		return gestaoOrdemServico.listarOrdemServico();
		
	}
	@GetMapping("/{ordemServicoId}")
	public ResponseEntity<OrdemServico> buscar(@PathVariable Long ordemServicoId) {
		return gestaoOrdemServico.bucarPorId(ordemServicoId);
		
		
	}
}
