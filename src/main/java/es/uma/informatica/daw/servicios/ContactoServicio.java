package es.uma.informatica.daw.servicios;

import es.uma.informatica.daw.dtos.ContactoDTO;
import es.uma.informatica.daw.excepciones.ContactoNoEncontrado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactoServicio {

    private long nextId = 0L; // Simula un ID autogenerado
    private List<ContactoDTO> contactos = new ArrayList<>();

    public List<ContactoDTO> obtenerTodosContactos() {
        return contactos;
    }

    public ContactoDTO obtenerContactoPorId(Long id) {
        for (ContactoDTO contacto : contactos) {
            if (contacto.getId().equals(id)) {
                return contacto;
            }
        }
        throw new ContactoNoEncontrado();

        /*
        return contactos.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .orElseThrow(ContactoNoEncontrado::new);*/
    }

    public ContactoDTO aniadirContacto(ContactoDTO contacto) {
        contacto.setId(++nextId);
        contactos.add(contacto);
        return contacto;
    }
    public void eliminarContacto(Long id) {
        ContactoDTO contacto = obtenerContactoPorId(id);
        contactos.remove(contacto);
    }
    public ContactoDTO modificarContacto(Long id, ContactoDTO contacto) {
        ContactoDTO existente = obtenerContactoPorId(id);
        existente.setNombre(contacto.getNombre());
        existente.setApellidos(contacto.getApellidos());
        existente.setEmail(contacto.getEmail());
        existente.setTelefono(contacto.getTelefono());
        return existente;

    }
}
