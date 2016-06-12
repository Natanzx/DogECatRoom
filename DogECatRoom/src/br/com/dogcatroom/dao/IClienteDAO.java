package br.com.dogcatroom.dao;

import java.util.List;

import br.com.dogcatroom.dto.ClienteDTO;

public interface IClienteDAO {

	public void cadastrarCliente(ClienteDTO cliente);
	
	public void alterarCliente(ClienteDTO cliente);
	
	public void excluirCliente(ClienteDTO cliente);
	
	public List<ClienteDTO> buscarTodosClientes();
	
	public ClienteDTO buscarClientePorID(Integer id);

	public List<ClienteDTO> buscarClienteAnimais();
	
}
