package br.com.dogcatroom.dto;

public class AtendimentoDTO {

	private int id;
	private String data;
	private String hora;
	private AnimalDTO animal;
	private ServicoDTO servico;
	private FuncionarioDTO funcionario;
	
	
	public AnimalDTO getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalDTO animal) {
		this.animal = animal;
	}

	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public ServicoDTO getServico() {
		return servico;
	}

	public void setServico(ServicoDTO servico) {
		this.servico = servico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
