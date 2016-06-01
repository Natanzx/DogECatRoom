package br.com.dogcatroom.bo;

import java.util.List;

import br.com.dogcatroom.dao.implementacao.ServicoDAO;
import br.com.dogcatroom.dto.ServicoDTO;

public class ServicoBO {

	ServicoDAO serDAO = new ServicoDAO();
	
	public List<ServicoDTO> BuscarServicos(){
		return serDAO.buscarTodos();
	}
	
	public ServicoDTO buscarServicoPorID(Integer id){
		return serDAO.buscarPorID(id);
	}
	
	public void cadastrarServico(ServicoDTO servico){
		serDAO.cadastrar(servico);
	}
	
	public void excluirServico(ServicoDTO servico){
		serDAO.excluir(servico);
	}
	
	public void alterarServico(ServicoDTO servico){
		serDAO.alterarServico(servico);
	}
}
