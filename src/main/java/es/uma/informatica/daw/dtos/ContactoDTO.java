package es.uma.informatica.daw.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactoDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
}
