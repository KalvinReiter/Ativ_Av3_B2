package fag.objetos;

public class Historico {

	private String placaHist;
	private int entradaHist;
	private int saidaHist;
	private Double precoHist;
	
	
	
	public Historico(String placaHist, int entradaHist, int saidaHist, Double precoHist) {
		this.placaHist = placaHist;
		this.entradaHist = entradaHist;
		this.saidaHist = saidaHist;
		this.precoHist = precoHist;
	}
	public String getPlacaHist() {
		return placaHist;
	}
	public void setPlacaHist(String placaHist) {
		this.placaHist = placaHist;
	}
	public int getEntradaHist() {
		return entradaHist;
	}
	public void setEntradaHist(int entradaHist) {
		this.entradaHist = entradaHist;
	}
	public int getSaidaHist() {
		return saidaHist;
	}
	public void setSaidaHist(int saidaHist) {
		this.saidaHist = saidaHist;
	}
	public Double getPrecoHist() {
		return precoHist;
	}
	public void setPrecoHist(Double precoHist) {
		this.precoHist = precoHist;
	}
	
	@Override
	public String toString() {
		
		return "Placa: " + placaHist + ", Horário de entrada: " + entradaHist + ", Horário de saída" + saidaHist + ", Preço final: R$" +precoHist;
		
	}
	
}
