package br.com.dogcatroom.bo;

import br.com.dogcatroom.dao.ClienteDAO;
import br.com.dogcatroom.dto.ClienteDTO;

public class ClienteBO {

	ClienteDAO cDAO = new ClienteDAO();
	
	public ClienteDTO BuscarCliente(ClienteDTO cDTO){
		return cDAO.buscarCliente(cDTO);
	}
	
}
