package br.com.dogcatroom.bo;

import br.com.dogcatroom.dao.implementacao.ClienteDAOImpl;
import br.com.dogcatroom.dto.ClienteDTO;

public class ClienteBO {

	ClienteDAOImpl cDAO = new ClienteDAOImpl();
	
	public ClienteDTO BuscarCliente(ClienteDTO cDTO){
		return cDAO.buscarCliente(cDTO);
	}
	
}
