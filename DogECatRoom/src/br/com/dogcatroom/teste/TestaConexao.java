package br.com.dogcatroom.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.dogcatroom.bo.FuncionarioBO;
import br.com.dogcatroom.conexao.ConnectionFactory;
import br.com.dogcatroom.dto.FuncionarioDTO;

class TestaConexao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection c = new ConnectionFactory().getConnection();
		cadastrarFuncionarioTeste();
		c.close();
	}

	private static void buscarfuncionarioAtivo() {
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		List<FuncionarioDTO> buscarTodosFuncionariosAtivo = funcionarioBO.buscarTodosFuncionariosAtivo();
		buscarTodosFuncionariosAtivo.size();
	}

	private static void cadastrarFuncionarioTeste() {
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		funcionarioDTO.setId(1);
		funcionarioDTO.setNome("Jacaré Banguela");
		funcionarioDTO.setCpf("04959203945");
		funcionarioDTO.setMatricula(201630);
		funcionarioDTO.setEndereco("Rua hakman");
		funcionarioDTO.setNumero("239");
		funcionarioDTO.setComplemento("QD 90");
		funcionarioDTO.setBairro("Alfremeno");
		funcionarioDTO.setCidade("Nanakusem");
		funcionarioDTO.setEstado("ZZ");
		funcionarioDTO.setTelCelular("90294343");
		funcionarioDTO.setTelFixo("30879090");
		funcionarioDTO.setEscolaridade("Superior Incompleto");
		funcionarioDTO.setOcupacao("Guerreiro");
		funcionarioDTO.setSalario(999999.56);
		funcionarioDTO.setAtivo(true);

		try {
			funcionarioBO.salvarFuncionario(funcionarioDTO);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

}
