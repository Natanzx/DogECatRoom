package br.com.dogcatroom.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.dogcatroom.Exception.BusinesException;
import br.com.dogcatroom.dao.IClienteDAO;
import br.com.dogcatroom.dao.implementacao.ClienteDAO;
import br.com.dogcatroom.dto.ClienteDTO;
import br.com.dogcatroom.dto.ServicoDTO;

public class ClienteBO {

	ClienteDAO clienteDao = new ClienteDAO();
	IClienteDAO iClienteDao = clienteDao;
	
	public void cadastarCliente (ClienteDTO cliente) throws BusinesException, SQLException{
		if (cliente.getId() == 0) {
			if (cliente.getNome() != null) {
				iClienteDao.cadastrarCliente(cliente);
			}else {
				throw new BusinesException(
						"Por favor preencher todos os campos.");
			}
		}
		
	}
	
	public void alterarCliente(ClienteDTO cliente)throws BusinesException, SQLException{
		if (cliente.getId() != 0) {
			iClienteDao.alterarCliente(cliente);
		}else {
			throw new BusinesException(
					"Por favor preencher todos os campos.");
		}
	}
	
	public List<ClienteDTO> buscarTodosClientes() throws SQLException{
		return iClienteDao.buscarTodosClientes();
	}
	
	public ClienteDTO buscarClientePorID(Integer id){
		return iClienteDao.buscarClientePorID(id);
	}
	
	public void excluirCliente(ClienteDTO cliente){
		iClienteDao.excluirCliente(cliente);
	}
	
}
