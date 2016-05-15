package br.com.dogcatroom.bo;

import br.com.dogcatroom.dao.impl.ServicoDAO;
import br.com.dogcatroom.dto.ServicoDTO;

public class ServicoBO {

	ServicoDAO serDAO = new ServicoDAO();
	
	public ServicoDTO BuscarServico(ServicoDTO servDTO){
		return serDAO.BuscarServico(servDTO);
	}
}
