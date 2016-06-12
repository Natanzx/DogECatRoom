package br.com.dogcatroom.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.dogcatroom.Exception.BusinesException;
import br.com.dogcatroom.dao.IServicoDAO;
import br.com.dogcatroom.dao.implementacao.ServicoDAO;
import br.com.dogcatroom.dto.ClienteDTO;
import br.com.dogcatroom.dto.ServicoDTO;

public class ServicoBO {

	ServicoDAO servicoDAO = new ServicoDAO();
	IServicoDAO iServicoDAO = servicoDAO;

	public List<ServicoDTO> BuscarServicos() throws SQLException {
		return iServicoDAO.buscarTodosServicos();
	}

	public void salvarServico(ServicoDTO servicoDTO) throws BusinesException, SQLException {
		if (servicoDTO.getId() == null || servicoDTO.getId() == 0) {
			if (servicoDTO.getNome() != null && servicoDTO.getValor() != 0) {
				iServicoDAO.cadastrarServico(servicoDTO);
			}
		} else {
			if (servicoDTO.getId() != null && servicoDTO.getId() != 0) {
				iServicoDAO.alterarServico(servicoDTO);
			} else {
				throw new BusinesException(
						"Por favor preencher todos os campos. O Valor não pode ser menor ou igual a 0");
			}
		}
	}

	public void excluirServico(ServicoDTO servico) throws SQLException {
		iServicoDAO.excluirServico(servico);
		
	}

	public ServicoDTO buscarServicoPorID(Integer id) throws SQLException {
		return iServicoDAO.buscarPorID(id);
	}
	
	
	
}
