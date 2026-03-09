package es.uma.informatica.daw.servicios;

import es.uma.informatica.daw.dtos.ContactoDTO;
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
        return contactos.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public ContactoDTO aniadirContacto(ContactoDTO contacto) {
        contacto.setId(++nextId);
        contactos.add(contacto);
        return contacto;
    }
}
