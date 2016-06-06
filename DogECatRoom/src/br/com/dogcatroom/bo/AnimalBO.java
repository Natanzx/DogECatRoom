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

	public List<AnimalDTO> buscarPeloCliente(ClienteDTO clienteDTO) {
		return animalDAO.buscarAnimaisPeloCliente(clienteDTO);
	}
	
	public void excluir(AnimalDTO animalDTO) {
		animalDAO.excluirAnimal(animalDTO);
	}		
	
}
