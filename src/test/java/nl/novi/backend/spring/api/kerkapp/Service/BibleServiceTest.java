package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Bible;
import nl.novi.backend.spring.api.kerkapp.Repository.BibleRepository;
import nl.novi.backend.spring.api.kerkapp.Repository.FileUploadRepository;
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
class BibleServiceTest {

    @Mock
    private BibleRepository mockBibleRepository;
    @Mock
    private FileUploadRepository mockUploadRepository;

    private BibleService bibleServiceUnderTest;

    @BeforeEach
    void setUp() {
        bibleServiceUnderTest = new BibleService(mockBibleRepository, mockUploadRepository);
    }



    @Test
    void testGetVersesByKeyword_BibleRepositoryReturnsNoItems() {
        // Setup
        when(mockBibleRepository.findByScriptureContainingIgnoreCase("keyword")).thenReturn(Collections.emptyList());

        // Run the test
        final List<Bible> result = bibleServiceUnderTest.getVersesByKeyword("keyword");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
