package com.menna.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menna.cursomc.domain.Cliente;
import com.menna.cursomc.repositories.ClienteRepository;
import com.menna.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		
		//return obj.orElse(null);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
               "Objeto nao encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	
	
}
