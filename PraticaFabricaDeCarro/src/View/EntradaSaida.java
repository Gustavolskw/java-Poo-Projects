package View;

import Control.Controller;
import Model.Carros;

import javax.swing.*;
import java.util.ArrayList;

public class EntradaSaida {
    Controller controler = new Controller();
    public static int solicitaOpcao() {
        String[] opcoes = {"Fabricar Carro", "Ver Lista De Modelos", "Comprar Carro", "Sair"};
        JComboBox<String> menu = new JComboBox<>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, "Selecione a opcao que deseja executar.", JOptionPane.DEFAULT_OPTION);
        return menu.getSelectedIndex();
    }

    public static String solicitaCor(int ordem) {
        String[] opcoes = {"Branco", "Preto", "Azul", "Cinza", "Vermelho"};
        int escolha =  JOptionPane.showOptionDialog(null, "Escreva a cor desejada do seu Caro", ordem+"º Carro", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0] );
        if (escolha == 0){
            return "Branco";
        }else if (escolha==1){
            return "Preto";
        } else if (escolha == 2) {
            return "Azul";
        } else if (escolha==3) {
            return "Cinza";
        } else {
            return "Vermelho";
        }
    }

    public static String solicitaModelo(int ordem){
        String[] modelos = {"SUV", "Esportivo", "Popular", "Camionete"};
        int escolha =  JOptionPane.showOptionDialog(null, "Qual o modelo de carro que você deseja ?", ordem+"º Carro", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, modelos, modelos[2]);
        if(escolha == 0){
        return "SUV";
        }else if(escolha == 1 ) {
            return "Esportivo";
        }else if(escolha == 2){
            return "Popular";
        }else {
            return "Camionete";
        }
    }

    public static String  solicitaTipo() {

        String[] opcoes = {"Elétrico", "Combustão"};
        int escolh = JOptionPane.showOptionDialog(null, "Escolha Qual o modelo do veiculo", "Modelo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes);
        if (escolh == 0 ){
            return "Elétrico";
        }else{
        return "Combustão";
        }
    }

    public static int solicitaquantidadeProduzida(String tipoDeCarro) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de carro(s) do tipo "+tipoDeCarro+" A serem produzidos" ));
    }

    public static String solicitaMarcha(int ordem) {
        String[] opcoes = {"Automático", "Manual"};
        int escolha =  JOptionPane.showOptionDialog(null, "Escolha Qual o tipo de Marcha voce deseja", ordem+"º Carro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        if(escolha == 0){
            return "Automático";
        }else{
            return "Manual";
        }
    }

    public static int solicitaQtdPortas(int ordem) {
        String [] opcoes = {"2","4"};
        int escolha =  JOptionPane.showOptionDialog(null, "Quantidade de portas que você deseja ter no seu carro", ordem+"º Carro", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);
        if (escolha == 0){
            return 2;
        }else {
            return 4;
        }
    }

    public static int solicitaQtdBaterias(int ordem) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Qauntidade de Baterias que você deseja ter no seu carro", ordem+"º Carro",-1 ));
    }

    public static String solicitaTipoDeMotor(int ordem) {
        String[] opcoes = {"Diesel", "Gasolina", "Flex"};
        int escolha =  JOptionPane.showOptionDialog(null, "Escolha Qual o tipo de Marcha voce deseja", ordem+"º Carro",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[2]);
        if(escolha == 0){
            return "Diesel";
        }else if(escolha==1){
            return "Gasolina";
        }else{
            return "Flex";
        }
    }


    public static void semCarroFabricado() {
        JOptionPane.showMessageDialog(null, "Não há carros produzidos ainda", "Sem Carros", JOptionPane.ERROR_MESSAGE);
    }
    public static void exibeListas(String informacoes){
        JOptionPane.showMessageDialog(null, informacoes, "Listas de carros Fabricados", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int solicitaEscolhaDeCarro(ArrayList<Carros> listaDeCarros, String tipoDeCarro) {
		 int qtdCarros = listaDeCarros.size();
		 
		 String[] modeloCarros = new String[qtdCarros];
		 for(int  i = 0; i<qtdCarros; i++){
			  modeloCarros[i] = "Modelo - "+listaDeCarros.get(i).getModelo() +" | Cor - "+ listaDeCarros.get(i).getCor() +" | Portas - "+ listaDeCarros.get(i).getQtdPortas()+" | Marcha - "+ listaDeCarros.get(i).getMarcha(); ;
		 }
		 String msg = "Escolha O Carro "+tipoDeCarro+" a ser comprado";
		 JComboBox exibicaoCarros = new JComboBox(modeloCarros);
		 int confirmacao = JOptionPane.showConfirmDialog(null, exibicaoCarros, msg, JOptionPane.OK_CANCEL_OPTION);
		 
		 if(confirmacao == 0 ){
			  return exibicaoCarros.getSelectedIndex();
		 }else{
			  return  -1 ;
		 }
	}
    public static void msgEncerraPrograma(){
        JOptionPane.showMessageDialog(null, "O programa será encerrado");
    }
	 
	 public static void mostraCarroComprado(String carros) {
		 JOptionPane.showMessageDialog(null, carros, "Carro Comprado!", JOptionPane.INFORMATION_MESSAGE);
	 }
}
