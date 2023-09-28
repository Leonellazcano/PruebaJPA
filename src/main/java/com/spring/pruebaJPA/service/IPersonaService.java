package com.spring.pruebaJPA.service;

import com.spring.pruebaJPA.model.Persona;
import java.util.List;

public interface IPersonaService {

    //Metodos para Persona
    //Create
    public void savePersona(Persona perso);

    //Read
    public List<Persona> getPersonas();

    //Update
    public void editPersona(Long id, String nuevoNombre, String nuevoApellido, int nuevaEdad);
  
    //Delete
    public void deletePersona(long id);

    //Find
    public Persona findPersona(long id);

    public void editPersona(Persona perso);

}
