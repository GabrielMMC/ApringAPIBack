package br.com.si.CrudApp.repository;

import br.com.si.CrudApp.model.ProfessionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessionRepository extends JpaRepository<ProfessionModel, Long> {

    //..a optional return
    Optional<ProfessionModel> findById(long id);

    //..JPA derived query to retrive a list by name
    List<ProfessionModel> findByNameContainsIgnoreCase(String name);

}
