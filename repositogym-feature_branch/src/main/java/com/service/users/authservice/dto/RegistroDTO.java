package com.service.users.authservice.dto;

public class RegistroDTO {
	private String nombre;
    private String apellido;
    private String fecha;
    private String correo;
    private String password;

    public RegistroDTO() {
    }

    public RegistroDTO(String nombre, String apellido, String fecha, String correo, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.correo = correo;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFecha() {
    	return fecha;
    	
    }
    public void setFecha(String fecha) {
    	this.fecha = fecha;
    }
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

  
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

   
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
