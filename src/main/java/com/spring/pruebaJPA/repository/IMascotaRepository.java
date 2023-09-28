
package com.spring.pruebaJPA.repository;

import com.spring.pruebaJPA.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMascotaRepository extends JpaRepository <Mascota, Long> {
    
}
