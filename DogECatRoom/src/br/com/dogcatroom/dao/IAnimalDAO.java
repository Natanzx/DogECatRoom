package br.com.dogcatroom.dao;

import java.util.List;

import br.com.dogcatroom.dto.AnimalDTO;
import br.com.dogcatroom.dto.ClienteDTO;

public interface IAnimalDAO {
	
	void cadastrarAnimal(AnimalDTO animalDTO);
	
	void alterarAnimal(AnimalDTO a);
	
	List<AnimalDTO> buscarAnimaisPeloidCliente(int idCliente);
	
	AnimalDTO buscaAnimalPorID(int idAnimal);
	
	void excluirAnimal(int idAnimal);
	
}
