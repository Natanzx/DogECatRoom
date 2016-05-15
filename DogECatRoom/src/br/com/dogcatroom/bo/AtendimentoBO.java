package br.com.dogcatroom.bo;

import br.com.dogcatroom.dao.impl.AtendimentoDAOImpl;
import br.com.dogcatroom.dto.AtendimentoDTO;

public class AtendimentoBO {

	AtendimentoDAOImpl atDAO = new AtendimentoDAOImpl();
	
	public void RealizarAtendimento(AtendimentoDTO atendDTO){
		atDAO.RealizarAtendimento(atendDTO);
	}
}
