package ch.ttt.awseb.userstorycontainerized.data.userstory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/*
 * Validations are auto used by JPA at insert
 * and also propagated to DB Constraints
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Userstory {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String username;

    @NotNull
    @Size(min = 3, message = "Enter at least 3 Characters...")
    private String description;

    @NotNull
    private LocalDate targetDate;

    @NotNull
    private Boolean isDone;
}
