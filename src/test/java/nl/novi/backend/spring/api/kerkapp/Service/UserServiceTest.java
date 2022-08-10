package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Authority;
import nl.novi.backend.spring.api.kerkapp.Entitiy.User;
import nl.novi.backend.spring.api.kerkapp.Exception.RecordNotFoundException;
import nl.novi.backend.spring.api.kerkapp.Exception.UsernameNotFoundException;
import nl.novi.backend.spring.api.kerkapp.Repository.UserRepository;
import nl.novi.backend.spring.api.kerkapp.dto.UserDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    void testGetUsers() {
        // Setup
        // Configure UserRepository.findAll(...).
        final User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        user.setEnabled(false);
        user.setEmail("email");
        user.getAuthorities().addAll(Set.of(new Authority("username", "authority")));
        final List<User> users = List.of(user);
        when(mockUserRepository.findAll()).thenReturn(users);

        // Run the test
        final List<UserDto> result = userServiceUnderTest.getUsers();

        // Verify the results
    }

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
    void testGetUserDto() {
        // Setup
        // Configure UserRepository.findById(...).
        final User user1 = new User();
        user1.setUsername("username");
        user1.setPassword("password");
        user1.setEnabled(false);
        user1.setEmail("email");
        user1.getAuthorities().addAll(Set.of(new Authority("username", "authority")));
        final Optional<User> user = Optional.of(user1);
        when(mockUserRepository.findById("username")).thenReturn(user);

        // Run the test
        final UserDto result = userServiceUnderTest.getUserDto("username");

        // Verify the results
    }

    @Test
    void testGetUserDto_UserRepositoryReturnsAbsent() {
        // Setup
        when(mockUserRepository.findById("username")).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> userServiceUnderTest.getUserDto("username"))
                .isInstanceOf(UsernameNotFoundException.class);
    }

    @Test
    void testGetUser() {
        // Setup
        // Configure UserRepository.findById(...).
        final User user1 = new User();
        user1.setUsername("username");
        user1.setPassword("password");
        user1.setEnabled(false);
        user1.setEmail("email");
        user1.getAuthorities().addAll(Set.of(new Authority("username", "authority")));
        final Optional<User> user = Optional.of(user1);
        when(mockUserRepository.findById("username")).thenReturn(user);

        // Run the test
        final User result = userServiceUnderTest.getUser("username");

        // Verify the results
    }

    @Test
    void testGetUser_UserRepositoryReturnsAbsent() {
        // Setup
        when(mockUserRepository.findById("username")).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> userServiceUnderTest.getUser("username"))
                .isInstanceOf(UsernameNotFoundException.class);
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

    @Test
    @Disabled
    void testUpdateUser() throws RecordNotFoundException {
        // Setup
        final UserDto newUser = new UserDto();
        newUser.setId(0L);
        newUser.setUsername("username");
        newUser.setPassword("password");
        newUser.setEnabled(false);
        newUser.setEmail("email");
        newUser.setAuthorities(Set.of(new Authority("username", "authority")));

        when(mockUserRepository.existsByUsername("username")).thenReturn(false);

        // Configure UserRepository.findById(...).
        final User user1 = new User();
        user1.setUsername("username");
        user1.setPassword("password");
        user1.setEnabled(false);
        user1.setEmail("email");
        user1.getAuthorities().addAll(Set.of(new Authority("username", "authority")));
        final Optional<User> user = Optional.of(user1);
        when(mockUserRepository.findById("username")).thenReturn(user);

        // Configure UserRepository.save(...).
        final User user2 = new User();
        user2.setUsername("username");
        user2.setPassword("password");
        user2.setEnabled(false);
        user2.setEmail("email");
        user2.getAuthorities().addAll(Set.of(new Authority("username", "authority")));
        when(mockUserRepository.save(any(User.class))).thenReturn(user2);

        // Run the test
        userServiceUnderTest.updateUser("username", newUser);

        // Verify the results
        verify(mockUserRepository).save(any(User.class));
    }

    @Test
    @Disabled
    void testUpdateUser_UserRepositoryFindByIdReturnsAbsent() {
        // Setup
        final UserDto newUser = new UserDto();
        newUser.setId(0L);
        newUser.setUsername("username");
        newUser.setPassword("password");
        newUser.setEnabled(false);
        newUser.setEmail("email");
        newUser.setAuthorities(Set.of(new Authority("username", "authority")));

        when(mockUserRepository.existsByUsername("username")).thenReturn(false);
        when(mockUserRepository.findById("username")).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> userServiceUnderTest.updateUser("username", newUser))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @Disabled
    void testUpdateUser_ThrowsRecordNotFoundException() {
        // Setup
        final UserDto newUser = new UserDto();
        newUser.setId(0L);
        newUser.setUsername("username");
        newUser.setPassword("password");
        newUser.setEnabled(false);
        newUser.setEmail("email");
        newUser.setAuthorities(Set.of(new Authority("username", "authority")));

        when(mockUserRepository.existsByUsername("username")).thenReturn(false);

        // Configure UserRepository.findById(...).
        final User user1 = new User();
        user1.setUsername("username");
        user1.setPassword("password");
        user1.setEnabled(false);
        user1.setEmail("email");
        user1.getAuthorities().addAll(Set.of(new Authority("username", "authority")));
        final Optional<User> user = Optional.of(user1);
        when(mockUserRepository.findById("username")).thenReturn(user);

        // Configure UserRepository.save(...).
        final User user2 = new User();
        user2.setUsername("username");
        user2.setPassword("password");
        user2.setEnabled(false);
        user2.setEmail("email");
        user2.getAuthorities().addAll(Set.of(new Authority("username", "authority")));
        when(mockUserRepository.save(any(User.class))).thenReturn(user2);

        // Run the test
        assertThatThrownBy(() -> userServiceUnderTest.updateUser("username", newUser))
                .isInstanceOf(RecordNotFoundException.class);
        verify(mockUserRepository).save(any(User.class));
    }

    @Test
    @Disabled
    void testGetAuthorities() {
        // Setup
        when(mockUserRepository.existsByUsername("username")).thenReturn(false);

        // Configure UserRepository.findById(...).
        final User user1 = new User();
        user1.setUsername("username");
        user1.setPassword("password");
        user1.setEnabled(false);
        user1.setEmail("email");
        user1.getAuthorities().addAll(Set.of(new Authority("username", "authority")));
        final Optional<User> user = Optional.of(user1);
        when(mockUserRepository.findById("username")).thenReturn(user);

        // Run the test
        final Set<Authority> result = userServiceUnderTest.getAuthorities("username");

        // Verify the results
    }

    @Test
    @Disabled
    void testGetAuthorities_UserRepositoryFindByIdReturnsAbsent() {
        // Setup
        when(mockUserRepository.existsByUsername("username")).thenReturn(false);
        when(mockUserRepository.findById("username")).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> userServiceUnderTest.getAuthorities("username"))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @Disabled
    void testAddAuthority() {
        // Setup
        when(mockUserRepository.existsByUsername("username")).thenReturn(false);

        // Configure UserRepository.findById(...).
        final User user1 = new User();
        user1.setUsername("username");
        user1.setPassword("password");
        user1.setEnabled(false);
        user1.setEmail("email");
        user1.getAuthorities().addAll(Set.of(new Authority("username", "authority")));
        final Optional<User> user = Optional.of(user1);
        when(mockUserRepository.findById("username")).thenReturn(user);

        // Configure UserRepository.save(...).
        final User user2 = new User();
        user2.setUsername("username");
        user2.setPassword("password");
        user2.setEnabled(false);
        user2.setEmail("email");
        user2.getAuthorities().addAll(Set.of(new Authority("username", "authority")));
        when(mockUserRepository.save(any(User.class))).thenReturn(user2);

        // Run the test
        userServiceUnderTest.addAuthority("username", "authority");

        // Verify the results
        verify(mockUserRepository).save(any(User.class));
    }

    @Test
    @Disabled
    void testAddAuthority_UserRepositoryFindByIdReturnsAbsent() {
        // Setup
        when(mockUserRepository.existsByUsername("username")).thenReturn(false);
        when(mockUserRepository.findById("username")).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> userServiceUnderTest.addAuthority("username", "authority"))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @Disabled
    void testRemoveAuthority() {
        // Setup
        when(mockUserRepository.existsByUsername("username")).thenReturn(false);

        // Configure UserRepository.findById(...).
        final User user1 = new User();
        user1.setUsername("username");
        user1.setPassword("password");
        user1.setEnabled(false);
        user1.setEmail("email");
        user1.getAuthorities().addAll(Set.of(new Authority("username", "authority")));
        final Optional<User> user = Optional.of(user1);
        when(mockUserRepository.findById("username")).thenReturn(user);

        // Configure UserRepository.save(...).
        final User user2 = new User();
        user2.setUsername("username");
        user2.setPassword("password");
        user2.setEnabled(false);
        user2.setEmail("email");
        user2.getAuthorities().addAll(Set.of(new Authority("username", "authority")));
        when(mockUserRepository.save(any(User.class))).thenReturn(user2);

        // Run the test
        userServiceUnderTest.removeAuthority("username", "authority");

        // Verify the results
        verify(mockUserRepository).save(any(User.class));
    }

    @Test
    @Disabled
    void testRemoveAuthority_UserRepositoryFindByIdReturnsAbsent() {
        // Setup
        when(mockUserRepository.existsByUsername("username")).thenReturn(false);
        when(mockUserRepository.findById("username")).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> userServiceUnderTest.removeAuthority("username", "authority"))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void testToUser() {
        // Setup
        final UserDto userDto = new UserDto();
        userDto.setId(0L);
        userDto.setUsername("username");
        userDto.setPassword("password");
        userDto.setEnabled(false);
        userDto.setEmail("email");
        userDto.setAuthorities(Set.of(new Authority("username", "authority")));

        // Run the test
        final User result = userServiceUnderTest.toUser(userDto);

        // Verify the results
    }

    @Test
    void testFromUser() {
        // Setup
        final User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        user.setEnabled(false);
        user.setEmail("email");
        user.getAuthorities().addAll(Set.of(new Authority("username", "authority")));

        // Run the test
        final UserDto result = UserService.fromUser(user);

        // Verify the results
    }
}
