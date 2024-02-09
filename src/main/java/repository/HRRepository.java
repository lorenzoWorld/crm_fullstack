package repository;

import entity.HR;


public interface HRRepository extends JpaRepository<HR, Long> {
    HR findByUsernameAndPassword(String username, String password);

    HR findByUsername(String username);
}

