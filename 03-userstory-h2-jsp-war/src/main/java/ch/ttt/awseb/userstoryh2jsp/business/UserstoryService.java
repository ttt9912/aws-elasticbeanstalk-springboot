package ch.ttt.awseb.userstoryh2jsp.business;

import ch.ttt.awseb.userstoryh2jsp.data.Userstory;
import ch.ttt.awseb.userstoryh2jsp.data.UserstoryJpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class UserstoryService {
    private final UserstoryJpaRepository userstoryJpaRepository;

    public UserstoryService(final UserstoryJpaRepository userstoryJpaRepository) {
        this.userstoryJpaRepository = userstoryJpaRepository;
    }

    public List<Userstory> findByUsername(final String username) {
        return userstoryJpaRepository.findByUsername(username);
    }

    public Userstory findById(final Long id) {
        return userstoryJpaRepository.findById(id).orElse(null);
    }

    public void update(final Userstory userstory) {
        userstoryJpaRepository.save(userstory);
    }

    public void create(final String username, final String description, final LocalDate targetDate,
                       final boolean isDone) {
        userstoryJpaRepository.save(new Userstory(null, username, description, targetDate, isDone));
    }

    public void deleteById(final Long id){
        userstoryJpaRepository.deleteById(id);
    }

}
