package ch.ttt.awseb.userstoryh2jsp.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userstory {

    @Id
    @GeneratedValue
    private Long id;
    private String username;

    @Size(min=10, message="Enter at least 10 Characters...")
    private String description;
    private LocalDate targetDate;
    private boolean isDone;
}
