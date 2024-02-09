package authentication;

import entity.Admin;
import entity.HR;

public interface AuthService {
    HR authenticateHR(String username, String password);
    Admin authenticateAdmin(String username, String password);
}
