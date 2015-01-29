package com.example.guardarpersonas;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Bbdd extends SQLiteOpenHelper{
	
	private final String sqlCrear = "CREATE TABLE PERSONA (" +
			"_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
			"NOMBRE TEXT," +
			"APELLIDO TEXT," +
			"TELEFONO TEXT," +
			"OBSERVACIONES TEXT," +
			"GRUPO TEXT)";
	private String sqlUpgrade = "DROP TABLE IF EXISTS PERSONA";
	private String sqlDelete = "DELETE FROM PERSONA WHERE _ID=";
	private String sqlSelectNombre = "SELECT NOMBRE FROM PERSONA WHERE _ID=";
	private String sqlSelectApell = "SELECT APELLIDO FROM PERSONA WHERE _ID=";
	private String sqlSelectTel = "SELECT TELEFONO FROM PERSONA WHERE _ID=";
	private String sqlSelectObs = "SELECT OBSERVACIONES FROM PERSONA WHERE _ID=";
	private String sqlSelectGrupo = "SELECT GRUPO FROM PERSONA WHERE _ID=";
	
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
	
	public int insertarPersona(String nombre, String apellido, String tel, String obs, String grupo){
		
		int id=0;
		String query = ("INSERT INTO PERSONA " + 
				" (NOMBRE, APELLIDO, TELEFONO, OBSERVACIONES, GRUPO) " +
				" VALUES('" + nombre + "', '" + apellido + "', '" + tel +"', '" + obs + "', '" + grupo + "' )");
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL(query);
		db.close();
		SQLiteDatabase dbRead = getReadableDatabase();
		Cursor c = dbRead.rawQuery("select * from persona", null);
		if (c.getCount() > 0) 
		{               
		    c.moveToLast();
		    id = c.getInt(c.getColumnIndex("_ID"));
		    c.close();
		}
		dbRead.close();
		return id;
	}
	
	public void borrarPersona(int id){
		
		SQLiteDatabase db = getWritableDatabase();
		if(db!=null){
			db.execSQL(sqlDelete + id);
			db.close();   
		}
	}
	
	public void editarPersona(int id, String nombre, String apellido, String tel, String obs, String grupo){
		
		SQLiteDatabase db = getWritableDatabase();
		if(db!=null){
			db.execSQL("UPDATE PERSONA SET NOMBRE='"+nombre+ 
					"', APELLIDO='"+apellido + 
					"', TELEFONO='"+ tel + 
					"', OBSERVACIONES='"+ obs + 
					"', GRUPO='"+ grupo + 
					"' WHERE _ID='" + id+"'");
			db.close();   
		}
	}
	public String mostrarNombre(int id){
		
		String nombre="";
		SQLiteDatabase db = getReadableDatabase();
		if(db!=null){
			Cursor c = db.rawQuery(sqlSelectNombre+id, null);
			if (c.getCount() > 0) 
			{               
			    c.moveToFirst();
			    nombre = c.getString(c.getColumnIndex("NOMBRE"));
			    c.close();
			}
			db.close();   
		}
		return nombre;
	}
	public String mostrarApellido(int id){
		
		String apellido="";
		SQLiteDatabase db = getReadableDatabase();
		if(db!=null){
			Cursor c = db.rawQuery(sqlSelectApell+id, null);
			if (c.getCount() > 0) 
			{               
			    c.moveToFirst();
			    apellido = c.getString(c.getColumnIndex("APELLIDO"));
			    c.close();
			}
			db.close();   
		}
		return apellido;
	}
	public String mostrarTel(int id){
		
		String tel="";
		SQLiteDatabase db = getReadableDatabase();
		if(db!=null){
			Cursor c = db.rawQuery(sqlSelectTel+id, null);
			if (c.getCount() > 0) 
			{               
			    c.moveToFirst();
			    tel = c.getString(c.getColumnIndex("TELEFONO"));
			    c.close();
			}
			db.close();   
		}
		return tel;
	}
	public String mostrarObs(int id){
		
		String obs="";
		SQLiteDatabase db = getReadableDatabase();
		if(db!=null){
			Cursor c = db.rawQuery(sqlSelectObs+id, null);
			if (c.getCount() > 0) 
			{               
			    c.moveToFirst();
			    obs = c.getString(c.getColumnIndex("OBSERVACIONES"));
			    c.close();
			}
			db.close();   
		}
		return obs;
	}
	public String mostrarGrupo(int id){
	
	String grupo="";
	SQLiteDatabase db = getReadableDatabase();
	if(db!=null){
		Cursor c = db.rawQuery(sqlSelectGrupo+id, null);
		if (c.getCount() > 0) 
		{               
		    c.moveToFirst();
		    grupo = c.getString(c.getColumnIndex("GRUPO"));
		    c.close();
		}
		db.close();   
	}
	return grupo;
	}
	public ArrayList<String[]> buscarNombre(String nombre)
	{
		ArrayList<String[]> personas = new ArrayList<String[]>();
		String[] person = new String[6];
		SQLiteDatabase db = getReadableDatabase();
		if(db!=null){
			Cursor c = db.rawQuery("select * from PERSONA where NOMBRE LIKE '%"+nombre+"%'", null);
			if (c.moveToFirst())  
			{               
				do {
				    person[0] = c.getString(c.getColumnIndex("_ID"));
				    person[1] = c.getString(c.getColumnIndex("NOMBRE"));
				    person[2] = c.getString(c.getColumnIndex("APELLIDO"));
				    person[3] = c.getString(c.getColumnIndex("TELEFONO"));
				    person[4] = c.getString(c.getColumnIndex("OBSERVACIONES"));
				    person[5] = c.getString(c.getColumnIndex("GRUPO"));
				    personas.add(person);
				    person = new String[6];
				} while (c.moveToNext());
			    c.close(); 
			}
			db.close();   
		}
		return personas;
	}
	public ArrayList<String[]> buscarApellido(String apellido)
	{
		ArrayList<String[]> personas = new ArrayList<String[]>();
		String[] person = new String[6];
		SQLiteDatabase db = getReadableDatabase();
		if(db!=null){
			Cursor c = db.rawQuery("select * from PERSONA where APELLIDO LIKE '%"+apellido+"%'", null);
			if (c.moveToFirst()) 
			{               
				do {
				    person[0] = c.getString(c.getColumnIndex("_ID"));
				    person[1] = c.getString(c.getColumnIndex("NOMBRE"));
				    person[2] = c.getString(c.getColumnIndex("APELLIDO"));
				    person[3] = c.getString(c.getColumnIndex("TELEFONO"));
				    person[4] = c.getString(c.getColumnIndex("OBSERVACIONES"));
				    person[5] = c.getString(c.getColumnIndex("GRUPO"));
				    personas.add(person);
				    person = new String[6];
				} while (c.moveToNext());
			    c.close();
			}
			db.close();   
		}
		return personas;
	}
	public ArrayList<String[]> buscarTel(String tel)
	{
		ArrayList<String[]> personas = new ArrayList<String[]>();
		String[] person = new String[6];
		SQLiteDatabase db = getReadableDatabase();
		if(db!=null){
			Cursor c = db.rawQuery("select * from PERSONA where TELEFONO LIKE '%"+tel+"%'", null);
			if (c.moveToFirst()) 
			{               
			    do {
				    person[0] = c.getString(c.getColumnIndex("_ID"));
				    person[1] = c.getString(c.getColumnIndex("NOMBRE"));
				    person[2] = c.getString(c.getColumnIndex("APELLIDO"));
				    person[3] = c.getString(c.getColumnIndex("TELEFONO"));
				    person[4] = c.getString(c.getColumnIndex("OBSERVACIONES"));
				    person[5] = c.getString(c.getColumnIndex("GRUPO"));
				    personas.add(person);
				    person = new String[6];
				} while (c.moveToNext());
			    c.close();
			}
			db.close();   
		}
		return personas;
	}
	public ArrayList<String[]> buscarObs(String obs)
	{
		ArrayList<String[]> personas = new ArrayList<String[]>();
		String[] person = new String[6];
		SQLiteDatabase db = getReadableDatabase();
		if(db!=null){
			Cursor c = db.rawQuery("select * from PERSONA where OBSERVACIONES LIKE '%"+obs+"%'", null);
			if (c.moveToFirst()) 
			{               
			    do {
				    person[0] = c.getString(c.getColumnIndex("_ID"));
				    person[1] = c.getString(c.getColumnIndex("NOMBRE"));
				    person[2] = c.getString(c.getColumnIndex("APELLIDO"));
				    person[3] = c.getString(c.getColumnIndex("TELEFONO"));
				    person[4] = c.getString(c.getColumnIndex("OBSERVACIONES"));
				    person[5] = c.getString(c.getColumnIndex("GRUPO"));
				    personas.add(person);
				    person = new String[6];
				} while (c.moveToNext());
			    c.close();
			}
			db.close();   
		}
		return personas;
	}
	public ArrayList<String[]> buscarGrupo(String grupo)
	{
		ArrayList<String[]> personas = new ArrayList<String[]>();
		String[] person = new String[6];
		SQLiteDatabase db = getReadableDatabase();
		if(db!=null){
			Cursor c = db.rawQuery("select * from PERSONA where GRUPO LIKE '%"+grupo+"%'", null);
			if (c.moveToFirst()) 
			{               
			    do {
				    person[0] = c.getString(c.getColumnIndex("_ID"));
				    person[1] = c.getString(c.getColumnIndex("NOMBRE"));
				    person[2] = c.getString(c.getColumnIndex("APELLIDO"));
				    person[3] = c.getString(c.getColumnIndex("TELEFONO"));
				    person[4] = c.getString(c.getColumnIndex("OBSERVACIONES"));
				    person[5] = c.getString(c.getColumnIndex("GRUPO"));
				    personas.add(person);
				    person = new String[6];
				} while (c.moveToNext());
			    c.close();
			}
			db.close();   
		}
		return personas;
	}
	public ArrayList<String[]> selectAll()
	{
		ArrayList<String[]> personas = new ArrayList<String[]>();
		String[] person = new String[6];
		SQLiteDatabase db = getReadableDatabase();
		if(db!=null){
			Cursor c = db.rawQuery("select * from PERSONA", null);
			if (c.moveToFirst()) 
			{               
			    do {
				    person[0] = c.getString(c.getColumnIndex("_ID"));
				    person[1] = c.getString(c.getColumnIndex("NOMBRE"));
				    person[2] = c.getString(c.getColumnIndex("APELLIDO"));
				    person[3] = c.getString(c.getColumnIndex("TELEFONO"));
				    person[4] = c.getString(c.getColumnIndex("OBSERVACIONES"));
				    person[5] = c.getString(c.getColumnIndex("GRUPO"));
				    personas.add(person);
				    person = new String[6];
				} while (c.moveToNext());
			    c.close();
			}
			db.close();
		}
		return personas;
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
