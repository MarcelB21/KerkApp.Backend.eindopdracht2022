package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Catechism;
import nl.novi.backend.spring.api.kerkapp.Repository.CatechismRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatechismServiceTest {

    @Mock
    private CatechismRepository mockCatechismRepository;

    private CatechismService catechismServiceUnderTest;

    @BeforeEach
    void setUp() {
        catechismServiceUnderTest = new CatechismService(mockCatechismRepository);
    }

    @Test
    void testGetAllCatechism_CatechismRepositoryReturnsNoItems() {
        // Setup
        when(mockCatechismRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Catechism> result = catechismServiceUnderTest.getAllCatechism();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetByZondagCatechism_CatechismRepositoryReturnsNoItems() {
        // Setup
        when(mockCatechismRepository.findByZondag(0)).thenReturn(Collections.emptyList());

        // Run the test
        final List<Catechism> result = catechismServiceUnderTest.getByZondagCatechism(0);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetByDeelCatechism_CatechismRepositoryReturnsNoItems() {
        // Setup
        when(mockCatechismRepository.findByDeel(0)).thenReturn(Collections.emptyList());

        // Run the test
        final List<Catechism> result = catechismServiceUnderTest.getByDeelCatechism(0);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testFindByDeelAndZondag_CatechismRepositoryReturnsNoItems() {
        // Setup
        when(mockCatechismRepository.findByDeelAndZondag(0, 0)).thenReturn(Collections.emptyList());

        // Run the test
        final List<Catechism> result = catechismServiceUnderTest.findByDeelAndZondag(0, 0);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
