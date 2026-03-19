package es.uma.informatica.daw.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Grupo {
    @Id @GeneratedValue
    private Long id;
    private String nombre;
    @ManyToMany(mappedBy = "grupo")
    private List<Contacto> contactos;
}
