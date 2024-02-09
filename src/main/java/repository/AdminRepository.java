package repository;

import entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsernameAndPassword(String username, String password);

    Admin findByUsername(String username);
}

