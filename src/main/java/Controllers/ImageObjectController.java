package Controllers;

import Classes.ImageObject;
import Repositories.ImageObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageObjectController {
    @Autowired
    private ImageObjectRepository repository;

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("name") String name, @RequestParam("text") String text) throws IOException {
        ImageObject newImageObject = new ImageObject();
        newImageObject.setName(name);
        newImageObject.setText(text);
        newImageObject.setImage(file.getBytes());

        repository.save(newImageObject);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageObject> getImageObject(@PathVariable Long id) {
        ImageObject imageObject = repository.findById(id).orElse(null);
        return ResponseEntity.ok(imageObject);
    }

    @GetMapping
    public ResponseEntity<List<ImageObject>> getAllImages() {
        List<ImageObject> images = repository.findAll();
        return ResponseEntity.ok(images);
    }
}
