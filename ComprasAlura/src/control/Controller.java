package control;

import model.Compra;
import model.Loja;
import view.ScanRead;

import java.util.Collection;
import java.util.Collections;

public class Controller {
    public void Start(){
        Loja loja = new Loja();

        int finalizar;
        double valorDaCompra;
        loja.setLimiteCompras(ScanRead.defineLimite());
        loja.setSaldo(loja.moviemntaSaldo(loja.getLimiteCompras()));
        System.out.println("########");
        System.out.println("saldo - "+loja.getSaldo());
        System.out.println("########");
        do {
            Compra compra = new Compra();
            compra.setDescricaoProdt(ScanRead.escrevaDescricao());
            valorDaCompra = ScanRead.escreavaValor();
            while(valorDaCompra>loja.getSaldo()){
                ScanRead.msgGeral("Valor Acima do seu limite de Crédito !!!");
                valorDaCompra = ScanRead.escreavaValor();
            }
            compra.setValorCompra(valorDaCompra);
            loja.addToList(compra);
            compra.setValorTotal(loja.retornaTotalComprado());
            loja.setSaldo(loja.moviemntaSaldo(compra.getValorTotal()));
            System.out.println("########");
            System.out.println("saldo - "+loja.getSaldo());
            System.out.println("########");
            if(loja.getSaldo()>0){
                finalizar = ScanRead.optionSwitch();
            }else {
                finalizar = 1;
            }
        }while(finalizar!=1);

        ScanRead.exibeExtrato(loja.geraLista());
        System.out.println("########");
        System.out.println("saldo - "+loja.getSaldo());
        System.out.println("########");








    }
}
