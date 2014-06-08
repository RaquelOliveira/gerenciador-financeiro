package com.example.controlandedegastos;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import br.aeso.controleGastos.entidades.Despesas;
import br.aeso.controleGastos.repo.Repositorio;

public class DespesaActivity extends Activity {
	
	EditText descricao;
	EditText valor;
	Despesas despesas;
	Button btnSalvar;
	Repositorio rep;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_despesa);
		rep= new Repositorio(getApplicationContext());
		
		descricao= (EditText) findViewById(R.id.edtDescricao);
		valor= (EditText) findViewById(R.id.edtValor);
		btnSalvar= (Button) findViewById(R.id.btnSalvarDesp); 
		
		btnSalvar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				salvarDespesa();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.despesa, menu);
		return true;
	}
	
	public void salvarDespesa(){
		despesas= new Despesas();
		despesas.setDescricao(descricao.getText().toString());
		despesas.setValorDebito(Double.parseDouble(valor.getText().toString()));
		
		Repositorio bd= new Repositorio(this);
		bd.inserirDebito(despesas);	
	}

}
