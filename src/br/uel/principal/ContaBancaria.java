package br.uel.principal;

import java.math.BigDecimal;
import java.util.Locale;
import java.text.NumberFormat;

public class ContaBancaria {
	protected String cliente;
	protected String numeroConta;
	protected BigDecimal saldo;
	
	protected String getCliente() {
		return cliente;
	}
	
	protected void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	protected String getNumeroConta() {
		return numeroConta;
	}
	
	protected void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	protected BigDecimal getSaldo() {
		return saldo;
	}
	
	protected void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	protected void sacar(BigDecimal saque) {
		if(this.saldo.compareTo(saque) >= 0) {
			this.saldo = this.saldo.subtract(saque);
			System.out.printf("\nSaque de %s realizado, restam %s reais na conta\n", NumberFormat.getInstance(Locale.US).format(saque), NumberFormat.getInstance(Locale.US).format(this.saldo));
		}else {
			System.out.println("\nSaldo insuficiente");
		}
	}
	
	protected void depositar(BigDecimal deposito) {
		this.saldo = this.saldo.add(deposito);
		System.out.printf("\nDeposito de %s realizado, totalizando %s reais na conta\n", NumberFormat.getInstance(Locale.US).format(deposito), NumberFormat.getInstance(Locale.US).format(this.saldo));
	}
}
