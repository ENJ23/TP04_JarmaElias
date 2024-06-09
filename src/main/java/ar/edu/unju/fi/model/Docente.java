package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Docente {
    private String legajo;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private boolean estado;
    
    public Docente() {
    	
    }

	public Docente(String legajo, String nombre, String apellido, String email, String telefono, boolean estado) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.estado = estado;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public boolean isEstado() {
		return estado;
	}
    
    
}
