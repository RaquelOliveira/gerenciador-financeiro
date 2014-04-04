package com.example.gastos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class Adapter extends BaseAdapter implements OnCheckedChangeListener {
	
	Abas aba;
	Context context;
	LayoutInflater li;

	public Adapter(Context context, Abas aba) {
		this.aba = aba;
		this.context = context;
		li = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return aba.lista.size();
	}

	@Override
	public Object getItem(int position) {
		return 1;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CheckBox cb;
		if (convertView == null) {
			cb = new CheckBox(context);
			cb.setChecked(false);
			cb.setOnCheckedChangeListener(this);
		} else {
			cb = (CheckBox) convertView;
		}
		cb.setText(aba.lista.get(position));
		return cb;
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			
			ViewGroup grupo = (ViewGroup) buttonView.getParent().getParent();
			int filhos = grupo.getChildCount();
			int total = 0;
			int totalMarcados = 0;
			for (int i = 0; i < filhos; i++) {
				total += ((ListView) grupo.getChildAt(i)).getCount();
			}
			for (int i = 0; i < filhos; i++) {
				ListView lista = (ListView) grupo.getChildAt(i);
				int tam = lista.getCount();
				for (int y = 0; y < tam; y++) {
					CheckBox box = (CheckBox) lista.getChildAt(y);
					if (!(box == null)) {
						if (box.isChecked())
							++totalMarcados;
					}
				}
			}
			
			if (total == totalMarcados) {
				AlertDialog.Builder alertaC = new AlertDialog.Builder(context);
				alertaC.setTitle("Lista Completa.")
						.setMessage("Sua mala esta completa.\n Boa viagem")
						.setPositiveButton("Confirmar", new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								((Activity) context).finish();
								Intent nova = new Intent((Activity) context,
										HomeActivity.class);
								((Activity) context).startActivity(nova);
							}
						});
				AlertDialog alerta = alertaC.create();
				alerta.show();
			}
		}  
	} 

}

