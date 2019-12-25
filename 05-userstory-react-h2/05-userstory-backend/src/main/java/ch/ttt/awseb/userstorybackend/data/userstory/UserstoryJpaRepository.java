package ch.ttt.awseb.userstorybackend.data.userstory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserstoryJpaRepository extends JpaRepository<Userstory, Long> {
    List<Userstory> findByUsername(String username);
}
