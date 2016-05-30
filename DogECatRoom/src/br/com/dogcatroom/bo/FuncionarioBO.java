package br.com.dogcatroom.bo;

import br.com.dogcatroom.dao.implementacao.FuncionarioDAO;
import br.com.dogcatroom.dto.FuncionarioDTO;

public class FuncionarioBO {

	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	public void salvarFuncionario(FuncionarioDTO funcionarioDTO) throws Exception {

		if (funcionarioDTO.getId() == null || funcionarioDTO.getId()== 0) {
			if (funcionarioDTO.getNome() != null && funcionarioDTO.getCpf() != null
					&& funcionarioDTO.getBairro() != null && funcionarioDTO.getCidade() != null
					&& funcionarioDTO.getMatricula() != 0) {
                   funcionarioDAO.cadastrarFuncionario(funcionarioDTO);
			}
		}else{
			if(funcionarioDTO.getId() != null && funcionarioDTO.getId() != 0  ){
				
			}
		}
      throw new Exception("Preencher todos os campos.");    
	
	}

}
