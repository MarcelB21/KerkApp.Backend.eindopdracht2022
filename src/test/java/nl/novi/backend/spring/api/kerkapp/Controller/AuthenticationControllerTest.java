package nl.novi.backend.spring.api.kerkapp.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.security.auth.UserPrincipal;
import nl.novi.backend.spring.api.kerkapp.payload.AuthenticationRequest;
import nl.novi.backend.spring.api.kerkapp.utils.JwtUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.security.Principal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ContextConfiguration(classes = {AuthenticationController.class, AuthenticationManager.class, UserDetailsService.class})
@ExtendWith(MockitoExtension.class)
class AuthenticationControllerTest {

    @InjectMocks
    private AuthenticationController authenticationController;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private UserDetailsService userDetailsService;

    @Mock
    private JwtUtil jwtUtil;

    @Test
    @DisplayName("Should return a token when the username and password are correct")
    void createAuthenticationTokenWhenUsernameAndPasswordAreCorrectThenReturnAToken() throws Exception {
        String username = "username";
        String password = "password";

        AuthenticationRequest authenticationRequest = new AuthenticationRequest(username, password);

        ResponseEntity<?> responseEntity =
                authenticationController.createAuthenticationToken(authenticationRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("Should return the principal")
    void authenticatedShouldReturnThePrincipal() {
        Authentication authentication = mock(Authentication.class);
        Principal principal = mock(Principal.class);

        ResponseEntity<Object> responseEntity =
                authenticationController.authenticated(authentication, principal);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(principal, responseEntity.getBody());
    }

    @Test
    void testAuthenticated() {
        AuthenticationController authenticationController = new AuthenticationController();
        TestingAuthenticationToken authentication = new TestingAuthenticationToken("Principal", "Credentials");

        ResponseEntity<Object> actualAuthenticatedResult = authenticationController.authenticated(authentication,
                new UserPrincipal("principal"));
        assertTrue(actualAuthenticatedResult.hasBody());
        assertEquals(HttpStatus.OK, actualAuthenticatedResult.getStatusCode());
        assertTrue(actualAuthenticatedResult.getHeaders().isEmpty());
    }

    @Test
    @DisplayName("Create Token")
    void testCreateAuthenticationToken() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/authenticate")
                .contentType(MediaType.APPLICATION_JSON);

        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setPassword("brzezinski");
        authenticationRequest.setUsername("marcel");
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content((new ObjectMapper()).writeValueAsString(authenticationRequest));
        MockMvcBuilders.standaloneSetup(this.authenticationController).build().perform(requestBuilder);
    }

}