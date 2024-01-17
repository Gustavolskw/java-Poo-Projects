package view;

import java.util.Scanner;

public class ScanRead {

public static float defineLimite(){
    Scanner limite = new Scanner(System.in);
    System.out.println("Digite o limite do seu Crédito:");
    return limite.nextFloat();
}
    public static double escreavaValor(){
        Scanner valorReturn = new Scanner(System.in);
        System.out.println("Digite o preço do produto");
        return valorReturn.nextDouble();
    }
    public static String escrevaDescricao(){
        Scanner descricaoReturn = new Scanner(System.in);
        System.out.println("Digite a Descrição do produto");
        return descricaoReturn.nextLine();
    }
    public static void msgGeral(String mensagem){
        System.out.println(mensagem);
    }
    public static int optionSwitch(){
        Scanner option = new Scanner(System.in);
        System.out.println("Digite 0 para continuar e 1 para Sair");
        return option.nextInt();
    }
    public static void exibeExtrato(String listas){
        System.out.println(listas);
    }





}
