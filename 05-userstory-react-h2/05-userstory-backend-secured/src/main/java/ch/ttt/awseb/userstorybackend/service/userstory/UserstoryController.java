package ch.ttt.awseb.userstorybackend.service.userstory;

import ch.ttt.awseb.userstorybackend.data.userstory.Userstory;
import ch.ttt.awseb.userstorybackend.data.userstory.UserstoryJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userstories")
public class UserstoryController {

    private final UserstoryJpaRepository userstoryJpaRepository;

    public UserstoryController(final UserstoryJpaRepository userstoryJpaRepository) {
        this.userstoryJpaRepository = userstoryJpaRepository;
    }


    @GetMapping
    public List<Userstory> findAll() {
        return userstoryJpaRepository.findAll();
    }

    @GetMapping("/{username}")
    public List<Userstory> findByUsername(@PathVariable final String username) {
        return userstoryJpaRepository.findByUsername(username);
    }

    @GetMapping("/{id}")
    public Userstory findById(@PathVariable final long id) {
        return userstoryJpaRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final long id) {
        userstoryJpaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody final Userstory userstory) {
        userstoryJpaRepository.save(userstory);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Userstory> update(@RequestBody final Userstory userstory) {
        final Userstory existing = findById(userstory.getId());

        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        final Userstory updated = userstoryJpaRepository.save(userstory);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
