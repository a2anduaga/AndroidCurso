package com.example.guardarpersonas;

public class Lista_entrada {

	private int idImagen;
	private String nombre;
	private String apellido;
	
	public Lista_entrada(int idImagen, String nombre, String apellido)
	{
		this.idImagen=idImagen;
		this.nombre=nombre;
		this.apellido=apellido;
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
	
}
