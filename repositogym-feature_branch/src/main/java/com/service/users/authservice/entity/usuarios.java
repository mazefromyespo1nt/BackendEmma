package com.service.users.authservice.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "usuarios")
@Getter
@Setter
public class usuarios {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "id_usuario")
	private Integer idusuario;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String lastname;
	@Column(name = "fecha_nacimento")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	@Column(name = "email")
	private String email;
	@Column(name = "fecha_registro")
	@CreationTimestamp
	private String fecharegistro;
	@Column(name = "acces_cred")
	private String password;
	
 
}
