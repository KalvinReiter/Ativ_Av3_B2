package fag.objetos;

public class Vagas {

	private int numVaga;
	private String tamanhoVaga;
	private String disp;
	private String placaVaga;
	
	
	
	
	public Vagas(int numVaga, String tamanhoVaga, String disp) {
		this.numVaga = numVaga;
		this.tamanhoVaga = tamanhoVaga;
		this.disp = disp;
	}
	
	public Vagas(String disp, String placaVaga) {
		this.disp = disp;
		this.placaVaga = placaVaga;
	}
	
	public int getNumVaga() {
		return numVaga;
	}
	public void setNumVaga(int numVaga) {
		this.numVaga = numVaga;
	}
	public String getTamanhoVaga() {
		return tamanhoVaga;
	}
	public void setTamanhoVaga(String tamanhoVaga) {
		this.tamanhoVaga = tamanhoVaga;
	}
	public String getDisp() {
		return disp;
	}
	public void setDisp(String disp) {
		this.disp = disp;
	}
	public String getPlacaVaga() {
		return placaVaga;
	}
	public void setPlacaVaga(String placaVaga) {
		this.placaVaga = placaVaga;
	}
	
	@Override
	public String toString() {
		
		return "Vaga " + numVaga + "= Tamanho " + tamanhoVaga + ", " + disp;
		
	}
	

}
