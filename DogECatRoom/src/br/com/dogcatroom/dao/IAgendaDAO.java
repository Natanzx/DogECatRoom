package br.com.dogcatroom.dao;

import java.util.List;

import br.com.dogcatroom.dto.AgendaDTO;

public interface IAgendaDAO {

	void cadastrarAgenda(AgendaDTO agendaDTO);

	List<AgendaDTO> buscarAgendas(List<AgendaDTO> agendaDTOs);

	AgendaDTO buscarAgenda(AgendaDTO agendaDTO);

	void alterarAgendamento(AgendaDTO agendaDTO);

	void excluirAgenda(AgendaDTO agendaDTO);

}
