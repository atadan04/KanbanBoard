package ru.komlev.KanbanBoard.api.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CloudinaryManager {
    private final Cloudinary cloudinary;

    public Map<String, Object> save(MultipartFile file) throws IOException {
        UUID id = UUID.randomUUID();
        return cloudinary.uploader().upload(file.getInputStream().readAllBytes(),
                ObjectUtils.asMap("public_id", id.toString()));
    }

    public void delete(String publicId) throws IOException {
        cloudinary.uploader().destroy(publicId, Collections.emptyMap());
    }

}
