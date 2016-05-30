package br.com.dogcatroom.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.dogcatroom.bo.FuncionarioBO;
import br.com.dogcatroom.conexao.ConnectionFactory;
import br.com.dogcatroom.dto.FuncionarioDTO;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection c = new ConnectionFactory().getConnection();
		cadastrarFuncionarioTeste();
		c.close();
	}

	
	private static void cadastrarFuncionarioTeste() {
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		funcionarioDTO.setNome("Estev�o Candido");
		funcionarioDTO.setCpf("02511641100");
		funcionarioDTO.setMatricula(282726);
		funcionarioDTO.setEndereco("Rua 14");
		funcionarioDTO.setNumero("27");
		funcionarioDTO.setComplemento("QD 52");
		funcionarioDTO.setBairro("Morada Nobre");
		funcionarioDTO.setCidade("Valparaiso de Goi�s");
		funcionarioDTO.setEstado("GO");
		funcionarioDTO.setTelCelular("92465125");
		funcionarioDTO.setTelFixo("30252893");
		funcionarioDTO.setEscolaridade("Superior Incompleto");
		funcionarioDTO.setOcupacao("Estgi�rio");
		funcionarioDTO.setSalario(10000.56);
		funcionarioDTO.setAtivo(true);

		funcionarioBO.salvarFuncionario(funcionarioDTO);
	}
	
	
}
