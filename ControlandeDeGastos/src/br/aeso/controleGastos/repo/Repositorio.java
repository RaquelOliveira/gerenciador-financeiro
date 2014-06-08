package br.aeso.controleGastos.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.aeso.controleGastos.entidades.Despesas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Repositorio {
	
	private SQLiteDatabase bd;
	
	public Repositorio(Context context){
		Repo auxBd= new Repo(context);
		 bd= auxBd.getWritableDatabase();
	}
	
	public void inserirDebito(Despesas despesa){
		ContentValues valores= new ContentValues();
		valores.put("descricao", despesa.getDescricao());
		valores.put("valor", despesa.getValorDebito());
		
		bd.insert("despesa", null, valores);
		
	}
	
	
	public void alterarDespesa(Despesas despesa){
		ContentValues valores= new ContentValues();
		valores.put("descricao", despesa.getDescricao());
		valores.put("valor", despesa.getValorDebito());
		
		bd.update("despesa", valores, "_id=?", new String[]{""+despesa.getId()});
	}
	
	public void deletarDespesa(Despesas despesa){
		bd.delete("despesa", "_id=?", new String[]{""+despesa.getId()});
	}
	
	
	public List<Despesas> BuscarDespesa(){
		List<Despesas> despesas= new ArrayList<Despesas>();
		String[] colunas= new String[]{"_id","descricao","valor"};
		
		Cursor cursor= bd.query("DESPESA", colunas, null, null, null, null, "valor");
		
		if(cursor.getCount()>0){
			
			
			
			do{
				Despesas desp= new Despesas();
				desp.setId(cursor.getInt(0));
				desp.setDescricao(cursor.getString(1));
				desp.setValorDebito(cursor.getDouble(2));
				
				
				despesas.add(desp);
				
			}while(cursor.moveToNext());
		}
		
		return despesas;
	}
	
	
}
