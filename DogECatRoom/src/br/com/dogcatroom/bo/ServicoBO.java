package br.com.dogcatroom.bo;

import br.com.dogcatroom.dao.implementacao.ServicoDAOImpl;
import br.com.dogcatroom.dto.ServicoDTO;

public class ServicoBO {

	ServicoDAOImpl serDAO = new ServicoDAOImpl();
	
	public ServicoDTO BuscarServico(ServicoDTO servDTO){
		return serDAO.BuscarServico(servDTO);
	}
}
