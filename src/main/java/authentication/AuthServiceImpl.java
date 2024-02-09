package authentication;

import entity.Admin;
import entity.HR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AdminRepository;
import repository.HRRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private final HRRepository hrRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(HRRepository hrRepository, AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.hrRepository = hrRepository;
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public HR authenticateHR(String username, String password) {
        HR hr = hrRepository.findByUsername(username);
        if (hr != null && passwordEncoder.getClass(password, hr.getPassword())) {
            return hr;
        }
        return null;
    }

    @Override
    public Admin authenticateAdmin(String username, String password) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null && passwordEncoder.matches(password, admin.getPassword())) {
            return admin;
        }
        return null;
    }
}
