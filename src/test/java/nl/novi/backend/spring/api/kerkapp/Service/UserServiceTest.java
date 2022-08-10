package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Authority;
import nl.novi.backend.spring.api.kerkapp.Entitiy.User;
import nl.novi.backend.spring.api.kerkapp.Repository.UserRepository;
import nl.novi.backend.spring.api.kerkapp.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService userServiceUnderTest;

    @Test
    void testGetUsers_UserRepositoryReturnsNoItems() {
        // Setup
        when(mockUserRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<UserDto> result = userServiceUnderTest.getUsers();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testUserExists() {
        // Setup
        when(mockUserRepository.existsByUsername("username")).thenReturn(false);

        // Run the test
        final boolean result = userServiceUnderTest.userExists("username");

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testCreateUser() {
        // Setup
        final UserDto userDto = new UserDto();
        userDto.setId(0L);
        userDto.setUsername("username");
        userDto.setPassword("password");
        userDto.setEnabled(false);
        userDto.setEmail("email");
        userDto.setAuthorities(Set.of(new Authority("username", "authority")));

        // Configure UserRepository.save(...).
        final User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        user.setEnabled(false);
        user.setEmail("email");
        user.getAuthorities().addAll(Set.of(new Authority("username", "authority")));
        when(mockUserRepository.save(any(User.class))).thenReturn(user);

        // Run the test
        final String result = userServiceUnderTest.createUser(userDto);

        // Verify the results
        assertThat(result).isEqualTo("username");
    }

    @Test
    void testDeleteUser() {
        // Setup
        // Configure UserRepository.deleteByUsername(...).
        final User user1 = new User();
        user1.setUsername("username");
        user1.setPassword("password");
        user1.setEnabled(false);
        user1.setEmail("email");
        user1.getAuthorities().addAll(Set.of(new Authority("username", "authority")));
        final Optional<User> user = Optional.of(user1);
        when(mockUserRepository.deleteByUsername("username")).thenReturn(user);

        // Run the test
        userServiceUnderTest.deleteUser("username");

        // Verify the results
        verify(mockUserRepository).deleteByUsername("username");
    }
}
