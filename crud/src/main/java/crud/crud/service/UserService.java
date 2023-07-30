package crud.crud.service;
import crud.crud.exception.ResourceNotFoundException;
import crud.crud.service.IUserService;
import crud.crud.repo.IuserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private final IuserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) {
               return userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Invalid email or password."));
            }
        };
    }
}