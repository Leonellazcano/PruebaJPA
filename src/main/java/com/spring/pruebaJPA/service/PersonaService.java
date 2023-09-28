
package com.spring.pruebaJPA.service;

import com.spring.pruebaJPA.model.Persona;
import com.spring.pruebaJPA.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {
    
    @Autowired
    private IPersonaRepository persoRepo;

    @Override
    public void savePersona(Persona perso) {
       persoRepo.save(perso);
    }

    @Override
    public List<Persona> getPersonas() {
       List<Persona> listaPersonas = persoRepo.findAll();
       return listaPersonas;
    }

    @Override
    public void deletePersona(long id) {
        persoRepo.deleteById(id);
       
    }

    @Override
    public Persona findPersona(long id) {
       Persona perso =  persoRepo.findById(id).orElse(null);
       return perso;
    }

    @Override
    public void editPersona(Long id, String nuevoNombre, String nuevoApellido, int nuevaEdad) {
        Persona perso = this.findPersona(id);
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setEdad(nuevaEdad);
        //guardar cambios 
        this.savePersona(perso);
    }

    @Override
    public void editPersona(Persona perso) {
         this.savePersona(perso);
    }
}
