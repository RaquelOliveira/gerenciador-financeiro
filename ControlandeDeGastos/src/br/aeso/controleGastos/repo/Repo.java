package br.aeso.controleGastos.repo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Repo extends SQLiteOpenHelper {
	private static final String NOME_BD="BDContas";
	private static final int VERSAO_BD=1;
	
	

	public Repo(Context ctx) {
		super(ctx, NOME_BD, null, VERSAO_BD); 
		
	}

	@Override
	public void onCreate(SQLiteDatabase bd) {
		bd.execSQL("CREATE TABLE DESPESA (_id primary key autoincrement, descricao text not null, valor float not null ) ");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {
		bd.execSQL("DROP TABLE DESPESA; ");
		onCreate(bd);
		
	}

}
