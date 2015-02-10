package com.example.guardarpersonas;

public class Lista_entrada {

	private int idImagen;
	private String nombre;
	private String apellido;
	private String id;
	
	public Lista_entrada(int idImagen, String nombre, String apellido, String id)
	{
		this.idImagen=idImagen;
		this.nombre=nombre;
		this.apellido=apellido;
		this.id=id;
	}

	public int getIdImagen() {
		return idImagen;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}
	public String getId() {
		return id;
	}
}
