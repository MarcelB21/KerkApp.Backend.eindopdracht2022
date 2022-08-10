package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Authority;
import nl.novi.backend.spring.api.kerkapp.Entitiy.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomUserDetailsServiceTest {

    @Mock
    private UserService mockUserService;

    @InjectMocks
    private CustomUserDetailsService customUserDetailsServiceUnderTest;

    @Test
    void testLoadUserByUsername() {
        // Setup
        // Configure UserService.getUser(...).
        final User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        user.setEnabled(false);
        user.setEmail("email");
        user.getAuthorities().addAll(Set.of(new Authority("username", "authority")));
        when(mockUserService.getUser("username")).thenReturn(user);

        // Run the test
        final UserDetails result = customUserDetailsServiceUnderTest.loadUserByUsername("username");

        // Verify the results
    }
}
