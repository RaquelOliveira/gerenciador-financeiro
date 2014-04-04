package com.example.gastos;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

	FrameLayout frame;
	EditText text; // texto para AlertDialog
	AlertDialog alert;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_check_list);

		ArrayList<Abas> abas = Factory();
		TabHost tabhost = getTabHost();
		View inf = LayoutInflater.from(this)
				.inflate(R.layout.activity_main,
						tabhost.getTabContentView(), true);

		frame = (FrameLayout) inf.findViewById(R.id.fram1);
		int id = 0;
		//Criando as abas dinamicamente
		for (Abas aba : abas) {
			Adapter adpt = new Adapter(this, aba);
			id++;

			ListView lista = new ListView(this);
			lista.setAdapter(adpt);
			lista.setId(id);

			frame.addView(lista);

			tabhost.addTab(tabhost.newTabSpec("aba" + id)
					.setIndicator(aba.AbaName).setContent(id));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	private ArrayList<Abas> Factory() {
		ArrayList<Abas> lista = new ArrayList<Abas>();

		String[] debito = { "" };
		String[] tipoDebito = { "dinheiro", "cheque", "cartão", "cheque pré"};
		String[] acompanhamento = {  };
			lista.add(new Abas("Débito", debito));
			lista.add(new Abas("Tipo de Débito", tipoDebito));
			lista.add(new Abas("Acompanhamento", acompanhamento));
		return lista;
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.item1) {
			// Limpa todos os CheckBox
			for (int i = 0; i < frame.getChildCount(); i++) {
				ListView lista = (ListView) frame.getChildAt(i);
				int x = lista.getCount();

				for (int y = 0; y < x; y++) {
					CheckBox box = (CheckBox) lista.getChildAt(y);

					if (!(box == null)) {
						if (box.isChecked())// valida se ta marcado, caso tiver incrementa
							box.setChecked(false);
					}
				}
			}
		} else if (item.getItemId() == R.id.item2) { // Adicionando itens a listagem

			AlertDialog.Builder alertB = new AlertDialog.Builder(this);
			alert = alertB.create();
			alertB.setTitle("Adicionar Débito");
			alertB.setMessage("Nome do novo Débito:");
			text = new EditText(this);
			alertB.setView(text);
			alertB.setPositiveButton("Confirmar", new OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					String valor = text.getText().toString();
					if (valor == null || valor.trim().length() == 0) {

					} else {
						CheckBox box = new CheckBox(MainActivity.this);
						box.setText(valor);
						ListView v = (ListView) getCurrentFocus();

						Adapter ladp = (Adapter) v.getAdapter();
						ladp.aba.lista.add(valor);
						ladp.notifyDataSetChanged();
					}
				}
			});

			alertB.setNegativeButton("Cancelar", new OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {

					alert.dismiss();
				}
			});
			alert = alertB.create();
			alert.show();
		}
		return true;
	}

}

