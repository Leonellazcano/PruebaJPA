
package com.spring.pruebaJPA.service;

import com.spring.pruebaJPA.model.Mascota;
import com.spring.pruebaJPA.repository.IMascotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService {
    @Autowired
    private IMascotaRepository repoMasco;
    
    @Override
    public void saveMascota(Mascota masco) {
        repoMasco.save(masco);
    }

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listaMascotas = repoMasco.findAll();
        return listaMascotas;
       
    }

    @Override
    public void editMascota(Long id, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor) {
      Mascota masco = this.findMascota(id);
      masco.setNombre(nuevoNombre);
      masco.setEspecie(nuevaEspecie);
      masco.setRaza(nuevaRaza);
      masco.setColor(nuevoColor);
      this.saveMascota(masco);
    }

    @Override
    public void deleteMascota(long id) {
        repoMasco.deleteById(id);
       
    }

    @Override
    public Mascota findMascota(long id) {
       Mascota masco = repoMasco.findById(id).orElse(null);
       return masco;
    }
    
}
