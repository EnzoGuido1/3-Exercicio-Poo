package br.uel.principal;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

//Esta sendo utilizada a formatacao numerica dos estados unidos,
//portanto ponto significa casas decimais e virgula significa casas dos milhares 
//exemplo - "8,000.00" oito mil - "8.20" oito (unidade) e vinte (decimal)
//Utilizar essa formatacao na insercao de quaisquer valores numericos

public class menu {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		input.useLocale(Locale.US);
		
		Integer aux = 1;
		
		Integer tipoConta = 0;
		
		Principal execucao = new Principal();
		
		System.out.println("Insira 1 para cadastrar uma conta corrente ou 2 para cadastrar uma conta poupanca");
		tipoConta = input.nextInt();
		System.out.println("Insira o nome do cliente");
		String cliente = input.next();
		System.out.println("Insira o numero da conta");
		String numeroConta = input.next();
		System.out.println("Insira o saldo da conta");
		BigDecimal saldo = input.nextBigDecimal();
		execucao.cadastrarConta(tipoConta, cliente, numeroConta, saldo);
		
		while(aux != 0) {
			if(tipoConta == 1)
				System.out.println("\nInsira 1 para sacar um valor da conta, 2 para depositar um valor na conta,\n3 para mostrar saldo da conta ou 0 para encerrar o programa ");
			else if(tipoConta == 2) {
				System.out.println("\nInsira 1 para sacar um valor da conta, 2 para depositar um valor na conta,\n3 para mostrar saldo da conta, 4 para atualizar conta poupanca ou 0 para encerrar o programa ");
			}
			
			aux = input.nextInt();
			
			if(aux == 1) {
				System.out.println("Insira a quantia do saque");
				BigDecimal saque = input.nextBigDecimal();
				execucao.sacarQuantia(tipoConta, saque);
				
			}else if(aux == 2) {
				System.out.println("Insira a quantia do deposito");
				BigDecimal deposito = input.nextBigDecimal();
				execucao.depositarQuantia(tipoConta, deposito);
				
			}else if(aux == 3) {
				execucao.mostrarSaldo(tipoConta);
				
			}else if(aux == 4) {
				System.out.println("Insira a porcentagem de aumento no saldo da poupanca em decimal (exemplo: 0.10 = 10%)");
				Double porcentagem = input.nextDouble();
				execucao.atualizarPoupanca(porcentagem);
				
			}
			
		}
			
		input.close();
	}
}
