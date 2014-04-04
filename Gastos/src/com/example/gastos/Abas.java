package com.example.gastos;

import java.util.ArrayList;

public class Abas {

	String AbaName;
	ArrayList<String> lista;
	public Abas(String abaName, String lista[]) {
		
		this.AbaName = abaName;
		this.lista = new ArrayList<String>();
		for (String string : lista) {
			this.lista.add(string);
		}
	} 
	

}
