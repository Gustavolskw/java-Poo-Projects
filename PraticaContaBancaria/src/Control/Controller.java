package Control;

import Model.*;
import View.EntradaSaida;
import java.util.ArrayList;
public class 	Controller {
	Conta conta = null;
	Movimentacao movimentacao = null;
	public void exibeMenu() {
		Usuario usuario = new Usuario();
		this.conta = new Conta();
		var poupanca1 = new Poupanca();
		var corrente1 = new Corrente();
		this.movimentacao = new Movimentacao();
		var deposito1 = new Deposito();
		boolean saldoBaixo = false;
		int escolha;
		ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();
		ArrayList<Cofre> listaCorrente = new ArrayList<Cofre>();
		ArrayList<Cofre> listaPoupanca = new ArrayList<Cofre>();
		ArrayList<Conta> tiposDeConta = new ArrayList<Conta>();
		ArrayList<Movimentacao> correnteTipoTrans = new ArrayList<Movimentacao>();
		ArrayList<Movimentacao> poupancaTipoTrans = new ArrayList<Movimentacao>();
		ArrayList<Movimentacao> listaDeDepositos = new ArrayList<Movimentacao>();
		ArrayList<Movimentacao> listaDeSaques = new ArrayList<Movimentacao>();
		ArrayList<Movimentacao> tipoDeTransacaoGeral = new ArrayList<Movimentacao>();
		ArrayList<Movimentacao> dataDeMovimentacao = new ArrayList<Movimentacao>();

		//Cadastrar usuario
		EntradaSaida.mensagemGeral("Bem Vindo ao Banco da Somália\nCrie uma Nova Conta");
		usuario.cadastro();

		//entrada na conta
		escolha = EntradaSaida.escolhaEntrada();
		if(escolha==0) {
			System.out.println(usuario.getPing());
			int passe = EntradaSaida.login();
			System.out.println(passe);
			while (passe!=usuario.getPing()){
				EntradaSaida.mensagemGeral("Senha Incorreta!!!");
				passe = EntradaSaida.login();
			}

			//Priemeiro deposito
			EntradaSaida.mensagemGeral("Para inicar você precisa depositar uma valor a conta...");
			this.movimentacao.setData(EntradaSaida.solicitaData());
			dataDeMovimentacao.add(this.movimentacao);
			this.conta.setTipo(EntradaSaida.solicitaTipoDeConta());
			tiposDeConta.add(this.conta);

			if(this.conta.getTipo().equalsIgnoreCase("Corrente")) {
				Movimentacao corenteTipoTrans1 = new Movimentacao();
				corenteTipoTrans1.setTipo("Depositar");
				correnteTipoTrans.add(corenteTipoTrans1);
				tipoDeTransacaoGeral.add(corenteTipoTrans1);
				deposito1.setValor(EntradaSaida.solicitarInformacoesDeposito());
				listaDeMovimentacao.add(deposito1);
				listaDeDepositos.add(deposito1);
				corrente1.setTransferConta(deposito1.getValor());
				listaCorrente.add(corrente1);


			}else {
				Movimentacao PoupancaTipoTrans1 = new Movimentacao();
				PoupancaTipoTrans1.setTipo("Deposito");
				poupancaTipoTrans.add(PoupancaTipoTrans1);
				tipoDeTransacaoGeral.add(PoupancaTipoTrans1);
				deposito1.setValor(EntradaSaida.solicitarInformacoesDeposito());
				listaDeMovimentacao.add(deposito1);
				listaDeDepositos.add(deposito1);
				poupanca1.setTransferConta(deposito1.getValor());
				listaPoupanca.add(poupanca1);

			}
			this.conta.depositar(deposito1.getValor());

			//Operacoes dentro da conta
			do {
				escolha = EntradaSaida.escolha();
				switch (escolha) {
					case 0:
						//Opcao de movimentar Conta (Sacar) (Depositar)
						var tipoConta = new Conta();
						var dataTransacao = new Movimentacao();
						dataTransacao.setData(EntradaSaida.solicitaData());
						dataDeMovimentacao.add(dataTransacao);
						tipoConta.setTipo(EntradaSaida.solicitaTipoDeConta());
						tiposDeConta.add(tipoConta);
						if(tipoConta.getTipo().equalsIgnoreCase("Corrente")){
							//Conta corrente
							var corrente = new Corrente();
							Movimentacao transacaoCorrente = new Movimentacao();
							transacaoCorrente.setTipo(EntradaSaida.solicitaOpcaoDeMovimentacao());
							correnteTipoTrans.add(transacaoCorrente);
							tipoDeTransacaoGeral.add(transacaoCorrente);
							if(this.conta.getSaldo()<10){
								saldoBaixo = true;
							}
							if (transacaoCorrente.getTipo().equalsIgnoreCase("Depositar")) {

								var deposito = new Deposito();
								deposito.setValor(EntradaSaida.solicitarInformacoesDeposito());
								listaDeMovimentacao.add(deposito);
								listaDeDepositos.add(deposito);
								corrente.setTransferConta(deposito.getValor());
								listaCorrente.add(corrente);

								this.conta.depositar( deposito.getValor());

							}else {
								if(!saldoBaixo){
									var saque = new Saque();
									saque.setValor(EntradaSaida.solicitarInformacoesSaque());
									while(saque.getValor()>this.conta.getSaldo()){
										EntradaSaida.mensagemGeral("O valor Digitado é acima do Saldo atual!!!");
										saque.setValor(EntradaSaida.solicitarInformacoesSaque());
									}
									listaDeMovimentacao.add(saque);
									listaDeSaques.add(saque);
									corrente.setTransferConta(saque.getValor());
									listaCorrente.add(corrente);
									this.conta.sacar(saque.getValor());

								}else{
									EntradaSaida.mensagemGeral("Seu Saldo é Baixo para realizar um Saque");
								}
							}
						}else {
							//conta poupança
							var poupanca = new Poupanca();
							Movimentacao transacaoPoupanca = new Movimentacao();
							transacaoPoupanca.setTipo(EntradaSaida.solicitaOpcaoDeMovimentacao());
							poupancaTipoTrans.add(transacaoPoupanca );
							tipoDeTransacaoGeral.add(transacaoPoupanca);
							if (this.conta.getSaldo() < 10) {
								saldoBaixo = true;
							}
							if (transacaoPoupanca.getTipo().equalsIgnoreCase("Depositar")) {


								var deposito = new Deposito();
								deposito.setValor(EntradaSaida.solicitarInformacoesDeposito());
								listaDeMovimentacao.add(deposito);
								listaDeDepositos.add(deposito);
								poupanca.setTransferConta(deposito.getValor());
								listaPoupanca.add(poupanca);
								this.conta.depositar(deposito.getValor());

							} else {

								if (!saldoBaixo) {
									var saque = new Saque();
									saque.setValor(EntradaSaida.solicitarInformacoesSaque());
									while (saque.getValor() > this.conta.getSaldo()) {
										EntradaSaida.mensagemGeral("O valor Digitado é acima do Saldo atual!!!");
										saque.setValor(EntradaSaida.solicitarInformacoesSaque());
									}
									listaDeMovimentacao.add(saque);
									listaDeSaques.add(saque);
									poupanca.setTransferConta(saque.getValor());
									listaPoupanca.add(poupanca);
									this.conta.sacar( saque.getValor());

								} else {
									EntradaSaida.mensagemGeral("Seu Saldo é Baixo para realizar um Saque");
								}
							}
						}
						break;
					case 1:
						int escolhaExtrato = EntradaSaida.solicitaOpcoesDeExtrato();
						switch (escolhaExtrato){
							case 0:
								this.conta.gerarExtrato( listaDeMovimentacao, tiposDeConta, tipoDeTransacaoGeral,dataDeMovimentacao);
								break;
							case 1:
								this.conta.gerarExtratoDepositos(listaDeDepositos, tiposDeConta);
								break;
							case 2:
								this.conta.gerarExtratoSaques(listaDeSaques, tiposDeConta);
								break;
							case 3:
								this.conta.gerarExtratoPoupanca(poupancaTipoTrans, listaPoupanca);
								break;
							case 4:
								this.conta.gerarExtratoCorrente(correnteTipoTrans, listaCorrente);
								break;
							case 5:
								EntradaSaida.exibirSaldo(this.conta.gerarSaldo(conta.getSaldo()));
						}
						break;
					case 2:
						EntradaSaida.exibirDadosDaConta(this.conta.gerarDadosDaConta(usuario.getNome(), usuario.getEndereco(), usuario.getCpf()));
						break;
				}
			} while (escolha != 3);
			EntradaSaida.msgEncerraPrograma();

			System.exit(0);
		}else{
			EntradaSaida.msgEncerraPrograma();
			System.exit(0);
		}

	}
}
