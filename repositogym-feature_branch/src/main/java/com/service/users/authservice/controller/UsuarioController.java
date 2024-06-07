package com.service.users.authservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.users.authservice.dto.RegistroDTO;
import com.service.users.authservice.resources.AuthResDTO;
import com.service.users.authservice.resources.LogInDTO;
import com.service.users.authservice.resources.RequestDTO;
import com.service.users.authservice.resources.ResponseDTO;


	
	@RestController // Esto es una clase e indica es un controlador REST que maneja solicitudes HTTP
public class UsuarioController {
    
    // Este es un metodo para manejar solicitudes POST en la ruta "/registro" pal postmalone
		 @PostMapping("/registro")
		    public ResponseEntity<ResponseDTO<AuthResDTO>> regitrarUsuario(@RequestBody RequestDTO<RegistroDTO> registroRequest) {

			 	String nombreValido = "kurko";
		        String apellidoValido = "bein";
		        String fechaValida = "29/05/1996";
		        String correoValido = "kurko@hotmail.com";
		        String contrasenaValida = "123";
		        

		        AuthResDTO response_data = new AuthResDTO();

		        if (nombreValido.equals(registroRequest.getRequest_body().getNombre()) && 
		        	contrasenaValida.equals(registroRequest.getRequest_body().getPassword()) && 
		        	apellidoValido.equals(registroRequest.getRequest_body().getApellido()) &&
		        	correoValido.equals(registroRequest.getRequest_body().getCorreo()) &&
		        	fechaValida.equals(registroRequest.getRequest_body().getFecha())
		        	){
		            response_data.setMessage("logged-in");
		            response_data.setToken_key("ndkjdhfadd0q3980q923849q3r");
		            return ResponseEntity.ok(new ResponseDTO<AuthResDTO>("O0", "se procesa peticion", response_data));
		        } else {
		            response_data.setMessage("logged-fail");
		            response_data.setToken_key("fail?token?generation");
		            return ResponseEntity.badRequest().body(new ResponseDTO<AuthResDTO>("01","verifica tus credenciales de rewgistro", response_data));
		        }
		    }


		
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<AuthResDTO>> authenticateUser(@RequestBody RequestDTO<LogInDTO> loginRequest) {

        String username = "bullet@hotmail.com";
        String password = "123";

        AuthResDTO response_data = new AuthResDTO();

        if (username.equals(loginRequest.getRequest_body().getUser_value()) && 
            password.equals(loginRequest.getRequest_body().getUser_key())) {
            response_data.setMessage("logged-in");
            response_data.setToken_key("ndkjdhfadd0q3980q923849q3r");
            return ResponseEntity.ok(new ResponseDTO<AuthResDTO>("O0", "se procesa peticion", response_data));
        } else {
            response_data.setMessage("logged-fail");
            response_data.setToken_key("fail?token?generation");
            return ResponseEntity.badRequest().body(new ResponseDTO<AuthResDTO>("O1", "no se procesa peticion", response_data));
        }
    }
	        	
	        // Establecer la autenticación en el contexto de seguridad
	       // SecurityContextHolder.getContext().setAuthentication(authentication);

	        // Generar un token JWT utilizando el JwtTokenProvider
	       // String jwt = jwtTokenProvider.generateToken(authentication);

	        // Devolver la respuesta
	       // return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	    }


