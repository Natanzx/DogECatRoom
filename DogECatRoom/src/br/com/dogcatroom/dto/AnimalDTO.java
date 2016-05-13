package br.com.dogcatroom.dto;

public class AnimalDTO {

	private int idAnimal;
	private String nome;
	private String tipo;
	private String raca;
	private String cor;
	private String dataNasc;
	private char sexo;
	private boolean pedigre;
	private int numPedigre;
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public boolean isPedigre() {
		return pedigre;
	}
	public void setPedigre(boolean pedigre) {
		this.pedigre = pedigre;
	}
	public int getNumPedigre() {
		return numPedigre;
	}
	public void setNumPedigre(int numPedigre) {
		this.numPedigre = numPedigre;
	}
	
	
}
