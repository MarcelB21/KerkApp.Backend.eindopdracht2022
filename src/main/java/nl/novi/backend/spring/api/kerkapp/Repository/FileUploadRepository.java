package nl.novi.backend.spring.api.kerkapp.Repository;

import nl.novi.backend.spring.api.kerkapp.Entitiy.FileUploadResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface FileUploadRepository extends JpaRepository<FileUploadResponse, String> {
    Optional<FileUploadResponse> findByFileName(String fileName);
}
