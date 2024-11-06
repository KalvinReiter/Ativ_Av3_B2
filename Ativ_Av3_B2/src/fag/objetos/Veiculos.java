package fag.objetos;

public class Veiculos {

	private String placa;
	private String modelo;
	private String tamanho;
	private int entrada;
	private int saida;
	
	
	
	public Veiculos(String placa, String modelo, String tamanho, int entrada) {
		this.placa = placa;
		this.modelo = modelo;
		this.tamanho = tamanho;
		this.entrada = entrada;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public int getEntrada() {
		return entrada;
	}
	public void setEntrada(int entrada) {
		this.entrada = entrada;
	}
	public int getSaida() {
		return saida;
	}
	public void setSaida(int saida) {
		this.saida = saida;
	}
	
	

	
	
}
