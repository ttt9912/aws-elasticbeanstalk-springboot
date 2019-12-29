package ch.ttt.awseb.singlecontainerh2.service.userstory;

import ch.ttt.awseb.singlecontainerh2.data.userstory.Userstory;
import ch.ttt.awseb.singlecontainerh2.data.userstory.UserstoryJpaRepository;
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

    @GetMapping("/{id}")
    public ResponseEntity<Userstory> findById(@PathVariable final long id) {
        return userstoryJpaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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
        return userstoryJpaRepository.findById(userstory.getId())
                .map(exsiting -> {
                    final Userstory updated = userstoryJpaRepository.save(userstory);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
