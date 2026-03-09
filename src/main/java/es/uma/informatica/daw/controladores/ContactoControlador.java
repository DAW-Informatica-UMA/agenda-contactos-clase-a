package es.uma.informatica.daw.controladores;

import es.uma.informatica.daw.dtos.ContactoDTO;
import es.uma.informatica.daw.servicios.ContactoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactos")
public class ContactoControlador {

    private ContactoServicio servicio;

    public ContactoControlador(ContactoServicio servicio) {
        this.servicio = servicio;
    }


    @GetMapping("")
    public List<ContactoDTO> obtenerTodosContactos() {
        return servicio.obtenerTodosContactos();
    }

    @PostMapping("")
    public ContactoDTO aniadirContacto(@RequestBody ContactoDTO contacto) {
        return servicio.aniadirContacto(contacto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactoDTO> obtenerUnContacto(@PathVariable Long id) {
        ContactoDTO contacto = servicio.obtenerContactoPorId(id);
        return ResponseEntity.ofNullable(contacto);
    }
}
