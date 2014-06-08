package com.example.controlandedegastos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.aeso.controleGastos.entidades.Usuario;

public class UsuarioActivity extends Activity {
	
	EditText nome;
	EditText salario;
	EditText totalDesp;
	EditText salAtual;
	Button btnInserirDesp;
	
	private OnClickListener onclickSalvar= new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_usuario);
		
//		nome= (EditText) findViewById(R.id.txtNome);
//		salario= (EditText) findViewById(R.id.txtSal);
//		totalDesp= (EditText) findViewById(R.id.txtTotalDesp);
//		salAtual= (EditText) findViewById(R.id.txtSalAtual);
//		btnInserirDesp= (Button) findViewById(R.id.btnInserirDesp);
		
//		btnInserirDesp.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Intent intent = new Intent(UsuarioActivity.this,DespesaActivity.class);
//				startActivity(intent);
//			}
//		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.usuario, menu);
		return true;
	}
	
	public void usuario(){
		Usuario usuario= new Usuario();
		usuario.setNome(nome.getText().toString());
		usuario.setSalario(Double.parseDouble(salario.getText().toString()));
	}
	
	
	

}
