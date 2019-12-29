package ch.ttt.awseb.multicontainermysql.data.userstory;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserstoryJpaRepositoryTest {

    @Autowired
    UserstoryJpaRepository userstoryJpaRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testdata_inserted() {
        final List<Userstory> userstories = userstoryJpaRepository.findAll();
        userstories.forEach(System.out::println);

        assertThat(userstories).hasSize(3);
    }

}