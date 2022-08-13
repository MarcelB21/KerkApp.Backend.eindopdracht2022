package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Repository.CreedRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreedServiceTest {

    @Mock
    private CreedRepository mockCreedRepository;

    private CreedService creedServiceUnderTest;

    @BeforeEach
    void setUp() {
        creedServiceUnderTest = new CreedService(mockCreedRepository);
    }

    @Test
    void testGetAllCreed_CreedRepositoryReturnsNoItems() {
        // Setup
        when(mockCreedRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final String result = creedServiceUnderTest.getAllCreed();

        // Verify the results
        assertThat(result).isEqualTo("");
    }
}
