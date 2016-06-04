package br.com.dogcatroom.bo;

import java.util.List;

import br.com.dogcatroom.dao.IClienteDAO;
import br.com.dogcatroom.dao.implementacao.ClienteDAO;
import br.com.dogcatroom.dto.ClienteDTO;

public class ClienteBO {

	ClienteDAO clienteDao = new ClienteDAO();
	IClienteDAO iClienteDao = clienteDao;
	
	public void cadastarCliente(ClienteDTO cliente){
		iClienteDao.cadastrarCliente(cliente);
	}
	
	public void alterarCliente(ClienteDTO cliente){
		iClienteDao.alterarCliente(cliente);
	}
	
	public List<ClienteDTO> buscarTodosClientes(){
		return iClienteDao.buscarTodosClientes();
	}
	
	public ClienteDTO buscarClientePorID(Integer id){
		return iClienteDao.buscarClientePorID(id);
	}
	
	public void excluirCliente(ClienteDTO cliente){
		iClienteDao.excluirCliente(cliente);
	}
	
}
