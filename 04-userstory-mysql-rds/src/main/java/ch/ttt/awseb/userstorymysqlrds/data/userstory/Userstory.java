package ch.ttt.awseb.userstorymysqlrds.data.userstory;

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

    @Size(min=3, message="Enter at least 3 Characters...")
    private String description;
    private LocalDate targetDate;
    private Boolean isDone; // note: primitive does not work
}
