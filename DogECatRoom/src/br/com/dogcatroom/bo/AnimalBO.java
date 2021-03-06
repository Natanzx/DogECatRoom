package br.com.dogcatroom.bo;

import java.util.List;

import br.com.dogcatroom.dao.IAnimalDAO;
import br.com.dogcatroom.dao.implementacao.AnimalDAO;
import br.com.dogcatroom.dto.AnimalDTO;
import br.com.dogcatroom.dto.ClienteDTO;

public class AnimalBO {

	AnimalDAO animalDAO = new AnimalDAO();
	IAnimalDAO iAnimalDAO = animalDAO;

	public void cadastrar(AnimalDTO animalDTO) {
		animalDAO.cadastrarAnimal(animalDTO);
	}

	public void alterar(AnimalDTO animalDTO) {
		animalDAO.alterarAnimal(animalDTO);
	}
	
	public List<AnimalDTO> buscarPeloidCliente(int idCliente) {
		return animalDAO.buscarAnimaisPeloidCliente(idCliente);
	}
	
	public AnimalDTO buscaAnimalPorID(int idAnimal) {
		return animalDAO.buscaAnimalPorID(idAnimal);
	}	
	
	public void excluir(int idAnimal) {
		animalDAO.excluirAnimal(idAnimal);
	}		
	
}
