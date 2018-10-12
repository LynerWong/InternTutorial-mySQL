package respository;

import model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleRespository extends JpaRepository<Person, String>{
}
