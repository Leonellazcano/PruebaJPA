package com.spring.pruebaJPA.controller;

import com.spring.pruebaJPA.model.Mascota;
import com.spring.pruebaJPA.service.IMascotaService;
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
public class MascotaController {
    
     @Autowired
    private IMascotaService mascoServ;
    
    @GetMapping("/mascotas/traer")
    public List<Mascota> getMascotas(){
        
        return mascoServ.getMascotas();
    }
    
    @PostMapping("/mascotas/crear")
    public String saveMascota(@RequestBody Mascota masco){
        mascoServ.saveMascota(masco);
        return "La mascota fue creada correctamente.";
    }
    
    @DeleteMapping("/mascotas/borrar/{id}")
    public String deletePersona(@PathVariable long id){
        mascoServ.deleteMascota(id);
        return "La mascota fue eliminada.";
    }
    
    @PutMapping ("/mascotas/editar/{id}")
    public Mascota editMascota (@PathVariable Long id,
            @RequestParam(required= false, name= "nombre") String nuevoNombre,
            @RequestParam(required= false, name= "especie") String nuevaEspecie,
            @RequestParam(required= false, name= "raza") String nuevaRaza,
            @RequestParam(required= false, name= "color") String nuevoColor) {  

          mascoServ.editMascota(id, nuevoNombre, nuevaEspecie, nuevaRaza, nuevoColor); 
          Mascota masco = mascoServ.findMascota(id);
          return masco;

      
           }

}
    
    
    
    
    

    

