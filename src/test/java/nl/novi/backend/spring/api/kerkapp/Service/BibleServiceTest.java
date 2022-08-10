package nl.novi.backend.spring.api.kerkapp.Service;

import nl.novi.backend.spring.api.kerkapp.Entitiy.Bible;
import nl.novi.backend.spring.api.kerkapp.Entitiy.FileUploadResponse;
import nl.novi.backend.spring.api.kerkapp.Exception.RecordNotFoundException;
import nl.novi.backend.spring.api.kerkapp.Repository.BibleRepository;
import nl.novi.backend.spring.api.kerkapp.Repository.FileUploadRepository;
import nl.novi.backend.spring.api.kerkapp.dto.BibleDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    void testGetVerseByBooknameChapter() {
        // Setup
        // Configure BibleRepository.findByBooknameIgnoreCaseAndChapter(...).
        final List<Bible> bibles = List.of(new Bible(0, 0, 0, "scripture", "bookname"));
        when(mockBibleRepository.findByBooknameIgnoreCaseAndChapter("bookname", 0)).thenReturn(bibles);

        // Run the test
        final BibleDto result = bibleServiceUnderTest.getVerseByBooknameChapter("bookname", 0);

        // Verify the results
    }

    @Test
    void testGetVerseByBooknameChapterVerse() throws RecordNotFoundException {
        // Setup
        // Configure BibleRepository.findByBooknameIgnoreCaseAndChapterAndVerse(...).
        final Optional<Bible> bible = Optional.of(new Bible(0, 0, 0, "scripture", "bookname"));
        when(mockBibleRepository.findByBooknameIgnoreCaseAndChapterAndVerse("bookname", 0, 0)).thenReturn(bible);

        // Run the test
        final BibleDto result = bibleServiceUnderTest.getVerseByBooknameChapterVerse("bookname", 0, 0);

        // Verify the results
    }

    @Test
    void testGetVerseByBooknameChapterVerse_BibleRepositoryReturnsAbsent() {
        // Setup
        when(mockBibleRepository.findByBooknameIgnoreCaseAndChapterAndVerse("bookname", 0, 0))
                .thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> bibleServiceUnderTest.getVerseByBooknameChapterVerse("bookname", 0, 0))
                .isInstanceOf(RecordNotFoundException.class);
    }

    @Test
    void testGetByVerseBetweenVerse() {
        // Setup
        // Configure BibleRepository.findByBooknameIgnoreCaseAndChapter(...).
        final List<Bible> bibles = List.of(new Bible(0, 0, 0, "scripture", "bookname"));
        when(mockBibleRepository.findByBooknameIgnoreCaseAndChapter("bookname", 0)).thenReturn(bibles);

        // Run the test
        final BibleDto result = bibleServiceUnderTest.getByVerseBetweenVerse("bookname", 0, 0, 0);

        // Verify the results
    }

    @Test
    void testToDto() {
        // Setup
        final List<FileUploadResponse> files = List.of(new FileUploadResponse("fileName", "contentType", "url"));

        // Run the test
        final BibleDto result = bibleServiceUnderTest.toDto("bookname", 0, List.of("value"), files);

        // Verify the results
    }

    @Test
    void testAssignPhotoToBibleVerse_BibleRepositoryFindByBooknameIgnoreCaseAndChapterAndVerseReturnsAbsent() {
        // Setup
        final MultipartFile file = null;
        when(mockBibleRepository.findByBooknameIgnoreCaseAndChapterAndVerse("bookname", 0, 0))
                .thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> bibleServiceUnderTest.assignPhotoToBibleVerse("bookname", 0, 0, file))
                .isInstanceOf(RecordNotFoundException.class);
    }

    @Test
    void testGetVersesByKeyword() {
        // Setup
        // Configure BibleRepository.findByScriptureContainingIgnoreCase(...).
        final List<Bible> bibles = List.of(new Bible(0, 0, 0, "scripture", "bookname"));
        when(mockBibleRepository.findByScriptureContainingIgnoreCase("keyword")).thenReturn(bibles);

        // Run the test
        final List<Bible> result = bibleServiceUnderTest.getVersesByKeyword("keyword");

        // Verify the results
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
