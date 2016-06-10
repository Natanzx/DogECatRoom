package br.com.dogcatroom.dao;

import java.util.List;

import br.com.dogcatroom.dto.AnimalDTO;
import br.com.dogcatroom.dto.ClienteDTO;

public interface IAnimalDAO {
	
	void cadastrarAnimal(AnimalDTO animalDTO);
	
	List<AnimalDTO> buscarAnimaisPeloidCliente(int idCliente);
	
	void excluirAnimal(int idAnimal);
	
}
