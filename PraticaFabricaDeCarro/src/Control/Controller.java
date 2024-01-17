package Control;

import Model.Carros;
import Model.Combustao;
import Model.Eletrico;
import Model.Fabrica;
import View.EntradaSaida;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Controller {
    private Fabrica fabrica =null;

    public void exibeMenu() {
        int opcao;
        boolean carroPronto = false;
        String escolha;
        ArrayList<Carros> listaDecarrosCombustao = new ArrayList<Carros>();
        ArrayList<Carros> listaDecarrosEletricos = new ArrayList<Carros>();
		 
		
        do {
            opcao = EntradaSaida.solicitaOpcao();

            String listaDeCarrosList = "";
            switch (opcao) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Construir um Novo Carro", "Construir Carro", JOptionPane.INFORMATION_MESSAGE);
                    this.fabrica = new Fabrica();
                    String tipoDeCarro = EntradaSaida.solicitaTipo();
                    if (tipoDeCarro.equals("Elétrico")) {
                        escolha =  "Elétrico";
                        fabrica.setQuantidadeProduzida(EntradaSaida.solicitaquantidadeProduzida("Elétrico"));
                        for (int i = 0; i < this.fabrica.getQuantidadeProduzida(); i++) {
                            listaDecarrosEletricos.add(fabrica.fabricarCarroEletrc(i, escolha));
							 
                        }

                    } else {
                        fabrica.setQuantidadeProduzida(EntradaSaida.solicitaquantidadeProduzida("Combustão"));
                        escolha = "Combustão";
                        for (int i = 0; i < this.fabrica.getQuantidadeProduzida(); i++) {
                            listaDecarrosCombustao.add(fabrica.fabricaCarroCombst(i, escolha));
							 
                        }

                    }
                    this.fabrica.criarListasDeCarros(listaDecarrosEletricos, listaDecarrosCombustao);
                    if (tipoDeCarro.equals("Elétrico")) {

                        for (Carros eletricos : fabrica.getListaDecarrosEletricos()) {
                            System.out.println("Tipo de Carro: "+ eletricos.getTipoDeCarro());
                            System.out.println("Marcha: " + eletricos.getMarcha());
                            System.out.println("Quantidade de portas; " + eletricos.getQtdPortas());
                            System.out.println("Cor: " + eletricos.getCor());
                            System.out.println("Modelo: " + eletricos.getModelo());
                            System.out.println("Quantidade de baterias: " + eletricos.getQtdBaterias());
                        }
                    }else {
                        for (Carros combustaos : fabrica.getListaDecarrosCombustao()) {
                            System.out.println("Tipo de Carro: "+ combustaos.getTipoDeCarro());
                            System.out.println("Marcha: " + combustaos.getMarcha());
                            System.out.println("Quantidade de portas; " + combustaos.getQtdPortas());
                            System.out.println("Cor: " + combustaos.getCor());
                            System.out.println("Modelo: " + combustaos.getModelo());
                            System.out.println("Tipo de Motor: " + combustaos.getTipoDeMotor());
                        }
                    }

                    carroPronto = true;
                    break;
                case 1:
                    if (!carroPronto) {
                        EntradaSaida.semCarroFabricado();
                    } else {
                        JOptionPane.showMessageDialog(null, "Ver lista de Modelos");
                        listaDeCarrosList += this.fabrica.gerarlistas();
                        EntradaSaida.exibeListas(listaDeCarrosList);
                    }
                    break;
                case 2:
					 if (!carroPronto) {
						  EntradaSaida.semCarroFabricado();
					 } else {
						  JOptionPane.showMessageDialog(null, "Comprar Carros.");
						 fabrica.ComprarCarro();
					 }
                    break;
            }
        }while(opcao!=3);
        EntradaSaida.msgEncerraPrograma();
        System.exit(0);
    }
}
