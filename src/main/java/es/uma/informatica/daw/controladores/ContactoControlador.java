package es.uma.informatica.daw.controladores;

import es.uma.informatica.daw.dtos.ContactoDTO;
import es.uma.informatica.daw.excepciones.ContactoNoEncontrado;
import es.uma.informatica.daw.servicios.ContactoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<ContactoDTO> aniadirContacto(@RequestBody ContactoDTO contacto,
                                                       UriComponentsBuilder uriBuilder) {
        ContactoDTO aniadido = servicio.aniadirContacto(contacto);
        URI location = uriBuilder.path("/contactos/{id}")
                        .buildAndExpand(aniadido.getId())
                        .toUri();
        return ResponseEntity.created(location).body(aniadido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactoDTO> obtenerUnContacto(@PathVariable Long id) {
        ContactoDTO contacto = servicio.obtenerContactoPorId(id);
        return ResponseEntity.ofNullable(contacto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarContacto(@PathVariable Long id) {
        servicio.eliminarContacto(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactoDTO> modificarContacto(@PathVariable Long id,
                                         @RequestBody ContactoDTO contacto){
        contacto = servicio.modificarContacto(id, contacto);
        return ResponseEntity.ofNullable(contacto);
    }


    @ExceptionHandler(ContactoNoEncontrado.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void noEncontrado() {
    }

}
