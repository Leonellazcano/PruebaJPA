
package com.spring.pruebaJPA.service;

import com.spring.pruebaJPA.model.Mascota;
import java.util.List;


public interface IMascotaService {
     //Metodos para Mascota
    //Create
    public void saveMascota(Mascota masco);

    //Read
    public List<Mascota> getMascotas();

    //Update
    public void editMascota(Long id, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor);
  
    //Delete
    public void deleteMascota(long id);

    //Find
    public Mascota findMascota(long id);
}
