package repository;

import entity.Contatti;
import entity.HR;

import java.util.List;


public interface ContattiRepository extends JpaRepository<Contatti, Long> {
    List<Contatti> findByHr(HR hr);
}
