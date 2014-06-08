package br.aeso.controleGastos.entidades;

import java.util.List;

public class Usuario {
	String nome;
	double salario;
	double valorDespesa;
	double salAtual;
	List<Despesas> despesas;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public double getValorDespesa() {
		return valorDespesa;
	}
	public void setValorDespesa(double valorDespesa) {
		this.valorDespesa = valorDespesa;
	}
	public double getSalAtual() {
		return salAtual;
	}
	public void setSalAtual(double salAtual) {
		this.salAtual = salAtual;
	}
	public List<Despesas> getDespesas() {
		return despesas;
	}
	public void setDespesas(List<Despesas> despesas) {
		this.despesas = despesas;
	}
	
	

}
