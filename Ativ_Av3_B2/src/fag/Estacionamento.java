package fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import fag.objetos.Historico;

import fag.objetos.Vagas;
import fag.objetos.Veiculos;



public class Estacionamento {

	private static List<Vagas> listaDeVagas = new ArrayList<Vagas>();
	private static List <Veiculos> listaDeVeiculos = new ArrayList<Veiculos>();
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static String tamanho;
	
	public static int numVaga;
	public static String placaVaga;
	public static double precoHist;
	public static int garantia;
	public static int entradaHist;
	public static int saidaHist;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List <Historico> listaDeHistorico = new ArrayList<Historico>();

		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("----------------------Bem vindo Estacionamento Dal Lago----------------------");
		
		for (int opcao = 1 ; opcao > 0 ; ) {
			
			System.out.println("\nEscolha a opção que deseja:\n 1- Cadastrar nova vaga; \n 2- Dar entrada em veículo; \n 3- Dar saída em veículo; \n 4- Gerar relatório de vagas ocupadas; \n 5- Gerar histórico de permanência; \n 0- Sair.");
			opcao = scanner.nextInt();
			
			if (opcao == 1) {
				
				System.out.println("\nOpção selecionada foi: 1- Cadastrar nova vaga");
				System.out.println("Digite as seguintes informações: ");
				
				System.out.println("\nDigite o número para a nova vaga:");
				numVaga = scanner.nextInt();
				
				while(numVaga < 0) { 
					
					System.out.println("O número da vaga deve ser positivo");
					numVaga = scanner.nextInt();
					
				}
				
				System.out.println("Digite o tamanho para a nova vaga:\n 1- Pequena\n 2- Média\n 3- Grande");
				int opcaoTamanho = scanner.nextInt();
				
				while(opcaoTamanho < 1 || opcaoTamanho > 3) { 
					
					System.out.println("O número informado é inválido, tente novamente:");
					opcaoTamanho = scanner.nextInt();
					
				}
				
				String tamanhoVaga;
				
				if (opcaoTamanho == 1) {
					
					System.out.println("Opção selecionada foi: 1- Pequena");
					tamanhoVaga = "Pequena";
					
				} else if (opcaoTamanho == 2) {
					
					System.out.println("Opção selecionada foi: 2- Média");
					tamanhoVaga = "Média";
					
				} else {
					
					System.out.println("Opção selecionada foi: 3- Grande");
					tamanhoVaga = "Grande";
					
				}
				
				Vagas vagas = new Vagas(numVaga, tamanhoVaga, "Disponível");
				listaDeVagas.add(vagas);
				System.out.println("Vaga cadastrada:\n"+vagas);
				
			} else if( opcao == 2 ) {
				
				tamanho = "0";
				
				Vagas vagaDisponivel = encontrarVagaDisponivel();
				Vagas tamanhoDisponivel = encontrarTamanhoDisponivel(tamanho);
				
				System.out.println("\nOpção selecionada foi: 2- Dar entrada em veículo");
				
				if(vagaDisponivel!=null) {
					
					System.out.println("Digite as seguintes informações: ");
					
					System.out.println("\nDigite a placa do carro:");
					String placa = scanner.next();
					
					System.out.println("Digite o modelo do carro:");
					String modelo = scanner.next();
					
					System.out.println("Digite o tamanho para a nova vaga:\n 1- Pequena\n 2- Média\n 3- Grande");
					int opcaoTamanho = scanner.nextInt();
					
					while(opcaoTamanho < 1 || opcaoTamanho > 3) { 
						
						System.out.println("O número informado é inválido, tente novamente:");
						opcaoTamanho = scanner.nextInt();
						
					}
					
					String tamanho;
					
					if (opcaoTamanho == 1) {
						
						System.out.println("Opção selecionada foi: 1- Pequena");
						tamanho = "Pequena";
						
					} else if (opcaoTamanho == 2) {
						
						System.out.println("Opção selecionada foi: 2- Média");
						tamanho = "Média";
						
					} else {
						
						System.out.println("Opção selecionada foi: 3- Grande");
						tamanho = "Grande";
						
					}
					
					if (tamanhoDisponivel != null) {
						
						System.out.println("Qual é o minuto de entrada do carro?");
						int tempo = scanner.nextInt();
						
						while (tempo<0 || tempo>59) {
							
							System.out.println("Minuto digitado incorreto, tente no formato (00-59):");
							tempo = scanner.nextInt();
							
						}
						
						int entrada = tempo;
						System.out.println("Qual é a hora de entrada do carro?");
						tempo = scanner.nextInt();
						
						while (tempo<0 || tempo>23) {
							
							System.out.println("Hora digitada incorreta, tente no formato (00-23):");
							tempo = scanner.nextInt();
							
						}
						
						entrada = entrada + tempo*60; //isso pega a hora de entrada em minutos
						
						
						
						Veiculos veiculo = new Veiculos(placa, modelo, tamanho, entrada);
						listaDeVeiculos.add(veiculo);
						
						tamanhoDisponivel.setDisp("Ocupada");
					    tamanhoDisponivel.setPlacaVaga(placa);
						
					} else {
						
						System.out.println("Não há vagas com esse tamanho disponivel, cadastre novas vagas ou tente mais tarde.");
						
					}
					
					
				} else {
					
					System.out.println("Não há vagas disponíveis no momento, cadastre novas vagas ou tente novamente mais tarde.");
					
				}
				
				
			} else if (opcao == 3) {
				
				placaVaga = "0";
				
				Vagas vagaOcupada = encontrarVagaOcupada();
				
				
				
				System.out.println("\nOpção selecionada foi: 3- Dar saída em veículo.");
				
				
				if (vagaOcupada != null) {
					
					System.out.println("Digite as seguintes informações: ");
					
					System.out.println("\nQual é a placa do carro?");
					placaVaga = scanner.next();
					
					Vagas vagaEncontrada = encontrarVaga(placaVaga);
					Veiculos veiculoEncontrado = encontrarVeiculo(placaVaga);
					
					if (vagaEncontrada != null) {
						
						int entrada = veiculoEncontrado.getEntrada();
						
						System.out.println("Qual é o minuto de saida do veículo?");
						int tempo = scanner.nextInt();
						
						while (tempo<0 || tempo>59) {
							
							System.out.println("Minuto digitado incorreto, tente no formato (00-59):");
							tempo = scanner.nextInt();
							
						}
						
						int saida = tempo;
						
						
						System.out.println("Qual é a hora de saida do veículo?");
						tempo = scanner.nextInt();
						
						while (tempo<0 || tempo>23) {
							
							System.out.println("Hora digitada incorreta, tente no formato (00-23):");
							tempo = scanner.nextInt();
							
						}
						
						saida = saida + tempo*60;
						
						if (saida<entrada) {
							
							System.out.println("Horários imcompativeis, o horário de saída deve ser superior ao de entrada");
							
						} else {
							
							int calculo = saida-entrada;
							
							if (calculo<=60) {
								
								precoHist = 5.00; 
								
								
							} else if (calculo>60 && calculo<=180) {
								
								precoHist = 10.00;
								
							} else {
								
								precoHist = 15.00;
								
							}
							
							System.out.println("O preço final ficou: R$" +precoHist);
							
							
							vagaEncontrada.setDisp("Disponível");
							vagaEncontrada.setPlacaVaga(null);
							
							Historico historico = new Historico(placaVaga, entrada, saida, precoHist);
							listaDeHistorico.add(historico);
							
							listaDeVeiculos.remove(veiculoEncontrado);
						}
						
					} else {
						
						System.out.println("Não foi encontrado nenhum carro com está placa em uma vaga.");
						
					}
					
					
					
				} else {
					
					System.out.println("Não foram encontradas vagas ocupadas, dê a entrada em um veículo antes.");
					
				}
				
				
			} else if(opcao ==4) {
				
				System.out.println("\nOpção selecionada foi: 4- Gerar relatório de vagas ocupadas.");
				
				
				if(listaDeVagas.isEmpty()) {
					
					System.out.println("Não há nenhuma vaga cadastrada.");
					
				} else {
				
					System.out.println ("\nVagas ocupadas:");
	            
					for (Vagas vagasPercorreFor : listaDeVagas) {	
						if("Ocupada".equals(vagasPercorreFor.getDisp())){
							System.out.println (vagasPercorreFor);
							garantia = 1;
						}
					}
					
					if (garantia != 1) {
						System.out.println("Não há nenhuma vaga ocupada.");
						garantia = 0;
					}
				}
				
			} else if(opcao ==5) {
			
				System.out.println("\nOpção selecionada foi: 5- Gerar histórico de permanência.");
				
				if(listaDeHistorico.isEmpty()) {
					
					System.out.println("Não houve nenhuma saida cadastrada.");
					
				} else {
					
					for (Historico histPercorreFor : listaDeHistorico) {
						String horarioEntrada = entradaHora(histPercorreFor.getEntradaHist());
					    String horarioSaida = saidaHora(histPercorreFor.getSaidaHist());

					    System.out.println("Placa do Veículo: " + histPercorreFor.getPlacaHist());
					    System.out.println("Hora de Entrada: " + horarioEntrada);
					    System.out.println("Hora de Saída: " + horarioSaida);
					    System.out.println("Valor Pago: R$ " + String.format("%.2f", histPercorreFor.getPrecoHist()));
					    
					}
					
					
				}
				
				
				
			}
		}
		
		System.out.println("Opção selecionada foi: 0- Sair do acesso como Hospede.");
		System.out.println("--------------------------------Volte sempre!--------------------------------");
		System.out.println("-----------------------------------------------------------------------------");
		
	}
	
	public static Vagas encontrarVagaDisponivel() {
        for (Vagas vagas : listaDeVagas) {
        	if ("Disponível".equals(vagas.getDisp())) {
                return vagas; 
            }
        }
        return null; 
    }
	
	public static Vagas encontrarTamanhoDisponivel(String tamanho) {
	    for (Vagas vagas : listaDeVagas) {
	        if ("Disponível".equals(vagas.getDisp())) {
	            
	            if (tamanho.equals("Pequena") && "Pequena".equals(vagas.getTamanhoVaga())) {
	                return vagas;
	            } else if ("Média".equals(tamanho) && ("Média".equals(vagas.getTamanhoVaga()) || "Grande".equals(vagas.getTamanhoVaga()))) {
	                return vagas;
	            } else {
	                return vagas;
	            }
	        }
	    }
	    return null;  
	}
	
	public static Vagas encontrarVagaOcupada() {
        for (Vagas vagas : listaDeVagas) {
        	if ("Ocupada".equals(vagas.getDisp())) {
                return vagas; 
            }
        }
        return null; 
    }
	
	public static Vagas encontrarVaga(String placaVaga) {
        for (Vagas vagas : listaDeVagas) {
        	if (placaVaga.equals(vagas.getPlacaVaga())) {
                return vagas; 
            }
        }
        return null; 
    }
	
	public static Veiculos encontrarVeiculo(String placaVaga) {
        for (Veiculos veiculo : listaDeVeiculos) {
        	if (placaVaga.equals(veiculo.getPlaca())) {
                return veiculo;
            }
        }
        return null; 
    }

	
	public static String entradaHora(int entradaHist) {
	    int horas = entradaHist / 60;  
	    int minutosRestantes = entradaHist % 60;  
	    return String.format("%02d:%02d", horas, minutosRestantes);  
	}
	
	public static String saidaHora(int saidaHist) {
	    int horas = saidaHist / 60;  
	    int minutosRestantes = saidaHist % 60;  
	    return String.format("%02d:%02d", horas, minutosRestantes);  
	}
}
