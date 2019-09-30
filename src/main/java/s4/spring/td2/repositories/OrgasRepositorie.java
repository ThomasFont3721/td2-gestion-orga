package s4.spring.td2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import s4.spring.td2.entities.Corganization;

@Repository
public interface OrgasRepositorie extends JpaRepository<Corganization, Long> {
    List<Corganization> findByDomaine(String domaine);
    List<Corganization> findByName(String name);
    @Query("select o from Corganization o where o.alias like %?1% or o.domaine like %?1% or o.name like %?1%")
    List<Corganization> findByText(String text);
}
