package com.dam2.actividad5.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsuarioForm {
@NotNull
@Size(min=3, max=30, message="Campo nombre debe tener entre 3 y 30 caracteres")
private String name;

@Email(message="Email debe ser válido")
private String email;



@Override
public String toString() {
return "UsuarioForm [name=" + name + ", email=" + email + "]";
}



public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}


}