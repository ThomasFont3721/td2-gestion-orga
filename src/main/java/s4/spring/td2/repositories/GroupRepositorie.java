package s4.spring.td2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import s4.spring.td2.entities.Cgroupe;

public interface GroupRepositorie extends JpaRepository<Cgroupe, Long>{
    //List<Cgroupe> findByORGANIZATION_ID(int ORGANIZATION_ID);
}
