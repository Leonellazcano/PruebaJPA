
package com.spring.pruebaJPA.controller;

import com.spring.pruebaJPA.model.Persona;
import com.spring.pruebaJPA.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
   
    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas(){
        
        return persoServ.getPersonas();
    }
    
    @PostMapping("/personas/crear")
    public String savePersona(@RequestBody Persona perso){
        persoServ.savePersona(perso);
        return "La persona fue creada correctamente.";
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable long id){
        persoServ.deletePersona(id);
        return "La persona fue eliminada.";
    }
    
    @PutMapping ("/personas/editar/{id}")
    public Persona editPersona (@PathVariable Long id,
            @RequestParam(required= false, name= "nombre") String nuevoNombre,
            @RequestParam(required= false, name= "apellido") String nuevoApellido,
            @RequestParam(required= false, name= "edad") int nuevaEdad){

          persoServ.editPersona(id,nuevoNombre,nuevoApellido, nuevaEdad);
          Persona perso = persoServ.findPersona(id);
          return perso;
          }
          
     @PutMapping ("/personas/editar")     
     public Persona editPersona(@RequestBody Persona perso){
             persoServ.editPersona(perso);
            
            return persoServ.findPersona(perso.getId());
            }     
    
    }
