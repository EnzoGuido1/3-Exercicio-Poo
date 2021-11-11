package br.uel.principal;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class Principal {
	ContaCorrente checkingAccount = new ContaCorrente();
	ContaPoupanca savingsAccount = new ContaPoupanca();
	int tipoConta;
	
	public void cadastrarConta(Integer tipo, String cliente, String numeroConta, BigDecimal saldo) {
		Scanner input = new Scanner(System.in);
		input.useLocale(Locale.US);
		
		tipoConta = tipo;
		
		if(tipo == 1) { //checking account 
			checkingAccount.setCliente(cliente);
			checkingAccount.setNumeroConta(numeroConta);
			checkingAccount.setSaldo(saldo);
			System.out.printf("Insira o limite da conta corrente\n");
			BigDecimal limit = input.nextBigDecimal();
			checkingAccount.setLimite(limit);
		}else if(tipo == 2) { //savings account
			savingsAccount.setCliente(cliente);
			savingsAccount.setNumeroConta(numeroConta);
			savingsAccount.setSaldo(saldo);
			System.out.printf("Insira o rendimento diario da conta poupança\n");
			Integer dailyIncome = input.nextInt();
			savingsAccount.setDiaRendimento(dailyIncome);
		}
		
	}
	
	public void sacarQuantia(Integer tipo, BigDecimal saque) {
		if(tipo == 1) { //checking account 
			checkingAccount.sacar(saque);
		}else if(tipo == 2) { //savings account
			savingsAccount.sacar(saque);
		}
		
	}
	
	public void atualizarPoupanca(Double porcentagem) {
		savingsAccount.calcularNovoSaldo(BigDecimal.valueOf(porcentagem));
	}
	
	public void depositarQuantia(Integer tipo, BigDecimal deposito) {
		if(tipo == 1) { //checking account 
			checkingAccount.depositar(deposito);
		}else if(tipo == 2) { //savings account
			savingsAccount.depositar(deposito);
		}
		
	}
	
	public void mostrarSaldo(Integer tipo) {
		if(tipo == 1) { //checking account 
			System.out.printf("\nSaldo Atual da conta corrente: %s\n", checkingAccount.saldo);
		}else if(tipo == 2) { //savings account
			System.out.printf("\nSaldo Atual da conta poupança: %s\n", savingsAccount.saldo);
		}
		
	}
}
