package br.com.dogcatroom.bo;

import java.util.List;

import br.com.dogcatroom.dao.implementacao.ClienteDAO;
import br.com.dogcatroom.dto.ClienteDTO;

public class ClienteBO {

	ClienteDAO clienteDao = new ClienteDAO();
	
	public void cadastarCliente(ClienteDTO cliente){
		clienteDao.cadastrar(cliente);
	}
	
	public List<ClienteDTO> buscarTodosClientes(){
		return clienteDao.buscarTodos();
	}
	
}
