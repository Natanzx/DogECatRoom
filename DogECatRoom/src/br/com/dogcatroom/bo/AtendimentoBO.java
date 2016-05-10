package br.com.dogcatroom.bo;

import br.com.dogcatroom.dao.AtendimentoDAO;
import br.com.dogcatroom.dto.AtendimentoDTO;

public class AtendimentoBO {

	AtendimentoDAO atDAO = new AtendimentoDAO();
	
	public void RealizarAtendimento(AtendimentoDTO atendDTO){
		atDAO.RealizarAtendimento(atendDTO);
	}
}
