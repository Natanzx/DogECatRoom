package br.com.dogcatroom.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.dogcatroom.Exception.BusinesException;
import br.com.dogcatroom.dao.IAtendimentoDAO;
import br.com.dogcatroom.dao.implementacao.AtendimentoDAO;
import br.com.dogcatroom.dto.AtendimentoDTO;
import br.com.dogcatroom.dto.ClienteDTO;

public class AtendimentoBO {
	
	AtendimentoDAO atendimentoDao = new AtendimentoDAO();
	IAtendimentoDAO iAtendimentoDao = atendimentoDao;
	
	public void cadastarAtendimento (AtendimentoDTO atendimento) throws BusinesException, SQLException{
		if (atendimento.getId() == 0) {
			iAtendimentoDao.cadastrarAtendimento(atendimento);
		}else {
			throw new BusinesException(
					"Por favor preencher todos os campos.");
		}
	}
	
	public List<AtendimentoDTO> buscarTodosAtendimentos() throws SQLException{
		return iAtendimentoDao.buscarTodosAtendimentos();
	}
}
