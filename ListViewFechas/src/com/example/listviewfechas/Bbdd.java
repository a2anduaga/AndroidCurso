package com.example.listviewfechas;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class Bbdd extends SQLiteOpenHelper{
	
	private final String sqlCrear = "CREATE TABLE ENTRADA (" +
			"_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
			"DIA TEXT," +
			"MES TEXT," +
			"YEAR TEXT," +
			"ASUNTO TEXT)";
	private String sqlUpgrade = "DROP TABLE IF EXISTS ENTRADA";
	private String sqlDelete = "DELETE FROM ENTRADA WHERE _ID=";

	
	public Bbdd(Context context, String name, CursorFactory factory, int version) {
		
		super(context, name, factory, version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(sqlCrear);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL(sqlUpgrade);
		onCreate(db);
	}
	
	public int insertarEntrada(String dia, String mes, String año, String asunto){
		
		int id=0;
		String query = ("INSERT INTO ENTRADA " + 
				" (DIA, MES, YEAR, ASUNTO) " +
				" VALUES('" + dia + "', '" + mes + "', '" + año +"', '" + asunto + "' )");
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL(query);
		db.close();
		SQLiteDatabase dbRead = getReadableDatabase();
		Cursor c = dbRead.rawQuery("select * from entrada", null);
		if (c.getCount() > 0) 
		{               
		    c.moveToLast();
		    id = c.getInt(c.getColumnIndex("_ID"));
		    c.close();
		}
		dbRead.close();
		return id;
	}
	
	public void borrarEntrada(int posicion){
		
		int id=0;
		SQLiteDatabase dbRead = getReadableDatabase();
		Cursor c = dbRead.rawQuery("select * from entrada", null);
		if (c.getCount() > 0) 
		{
			c.moveToPosition(posicion);
			id = c.getInt(c.getColumnIndex("_ID"));
		}
		c.close();
		dbRead.close();
		SQLiteDatabase db = getWritableDatabase();
		if(db!=null){
			db.execSQL(sqlDelete + id);
			db.close();   
		}
	}
	
	public ArrayList<String[]> selectAll()
	{
		ArrayList<String[]> entradas = new ArrayList<String[]>();
		String[] entrada = new String[5];
		SQLiteDatabase db = getReadableDatabase();
		if(db!=null){
			Cursor c = db.rawQuery("select * from ENTRADA", null);
			if (c.moveToFirst()) 
			{               
			    do {
			    	entrada[0] = c.getString(c.getColumnIndex("_ID"));
			    	entrada[1] = c.getString(c.getColumnIndex("DIA"));
			    	entrada[2] = c.getString(c.getColumnIndex("MES"));
			    	entrada[3] = c.getString(c.getColumnIndex("YEAR"));
			    	entrada[4] = c.getString(c.getColumnIndex("ASUNTO"));
			    	entradas.add(entrada);
			    	entrada = new String[5];
				} while (c.moveToNext());
			    c.close();
			}
			db.close();
		}
		return entradas;
	}
	
	public void delete(){
		
		SQLiteDatabase db = getWritableDatabase();
		if(db!=null){
			db.execSQL(sqlUpgrade);
			db.close();   
		}
	}
	public void create(){
		
		SQLiteDatabase db = getWritableDatabase();
		if(db!=null){
			db.execSQL(sqlCrear);
			db.close();   
		}
	}
}
