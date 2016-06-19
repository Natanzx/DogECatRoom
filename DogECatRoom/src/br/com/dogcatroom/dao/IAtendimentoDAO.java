package br.com.dogcatroom.dao;

import java.util.List;

import br.com.dogcatroom.dto.AtendimentoDTO;
import br.com.dogcatroom.dto.RelatoriosDTO;

public interface IAtendimentoDAO {

	
	public void cadastrarAtendimento(AtendimentoDTO atendimento);
	
	public List<AtendimentoDTO> buscarTodosAtendimentos();
	
}
