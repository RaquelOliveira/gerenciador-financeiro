package com.example.gastos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity {
	
	Button iniciar;
	Button sair;
	
	private OnClickListener onClickinicicar= new OnClickListener() {
		
		@Override
		public void onClick(View v) {

			Intent intent = new Intent(HomeActivity.this, MainActivity.class);
			startActivity(intent);
			
		}
	};
	
	private OnClickListener onClickSair= new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_HOME);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		iniciar = (Button) findViewById(R.id.ButtonIniciar1);
		sair = (Button) findViewById(R.id.buttonSair);
		
		iniciar.setOnClickListener(onClickinicicar);
		sair.setOnClickListener(onClickSair);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
