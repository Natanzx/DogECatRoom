package br.com.dogcatroom.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.dogcatroom.dao.IFuncionarioDAO;
import br.com.dogcatroom.dao.implementacao.FuncionarioDAO;
import br.com.dogcatroom.dto.FuncionarioDTO;

public class FuncionarioBO {

	FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	IFuncionarioDAO iFuncionarioDAO = funcionarioDAO;

	public void salvarFuncionario(FuncionarioDTO funcionarioDTO) throws Exception {
		if (funcionarioDTO.getId() == null || funcionarioDTO.getId() == 0) {
			if (funcionarioDTO.getNome() != null && funcionarioDTO.getCpf() != null
					&& funcionarioDTO.getBairro() != null && funcionarioDTO.getCidade() != null
					&& funcionarioDTO.getMatricula() != 0) {
				iFuncionarioDAO.cadastrarFuncionario(funcionarioDTO);
			}
		} else {
			if (funcionarioDTO.getId() != null && funcionarioDTO.getId() != 0) {
				iFuncionarioDAO.alterarFuncionario(funcionarioDTO);
			} else {

				throw new Exception("Preencher todos os campos.");
			}

		}
	}

	public List<FuncionarioDTO> buscarTodosFuncionariosAtivo() {
		List<FuncionarioDTO> buscarTodos = iFuncionarioDAO.buscarTodosFuncionariosAtivo();
		for (FuncionarioDTO funcionarioDTO : buscarTodos) {
			System.out.println(funcionarioDTO.getNome() + funcionarioDTO.getCidade() + funcionarioDTO.isAtivo());
		}

		return buscarTodos;
	}
	
	
	public FuncionarioDTO buscarFuncionarioPorID(FuncionarioDTO funcionarioDTO) throws SQLException{
		return iFuncionarioDAO.buscarFuncionarioPorID(funcionarioDTO);
		
	}
	
	public FuncionarioDTO autenticarLogin(FuncionarioDTO func){
		return iFuncionarioDAO.validaLogin(func);
	}

	public FuncionarioDTO recuperarSenha(FuncionarioDTO func){
		return iFuncionarioDAO.recuperarSenha(func);
	}
}
