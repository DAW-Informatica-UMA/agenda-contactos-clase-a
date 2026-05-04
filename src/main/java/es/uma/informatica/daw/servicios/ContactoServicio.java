package es.uma.informatica.daw.servicios;

import es.uma.informatica.daw.dtos.ContactoDTO;
import es.uma.informatica.daw.entidades.Contacto;
import es.uma.informatica.daw.excepciones.ContactoNoEncontrado;
import es.uma.informatica.daw.repositorios.ContactoRepositorio;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactoServicio {


    private ContactoRepositorio repositorio;
    private JmsTemplate jmsTemplate;

    public ContactoServicio(ContactoRepositorio repositorio, JmsTemplate jmsTemplate) {
        this.repositorio = repositorio;
        this.jmsTemplate = jmsTemplate;
    }

    public List<Contacto> obtenerTodosContactos() {
        return repositorio.findAll();
    }

    public Contacto obtenerContactoPorId(Long id) {
        return repositorio.findById(id)
            .orElseThrow(() -> new ContactoNoEncontrado());
    }

    public List<Contacto> obtenerContactosPorNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }

    public Contacto aniadirContacto(Contacto contacto) {
        contacto.setId(null);
        jmsTemplate.convertAndSend("contactos", "Añadido contacto: "+contacto.getNombre());
        return repositorio.save(contacto);
    }
    public void eliminarContacto(Long id) {
        Contacto contacto = obtenerContactoPorId(id);
        jmsTemplate.convertAndSend("contactos", "Eliminado contacto: "+contacto.getNombre());
        repositorio.deleteById(id);
    }
    public Contacto modificarContacto(Long id, Contacto contacto) {
        Contacto existente = obtenerContactoPorId(id);
        existente.setNombre(contacto.getNombre());
        existente.setApellidos(contacto.getApellidos());
        existente.setEmail(contacto.getEmail());
        existente.setTelefono(contacto.getTelefono());
        jmsTemplate.convertAndSend("contactos", "Modificado contacto: "+contacto.getNombre());
        repositorio.save(existente);
        return existente;

    }
}
