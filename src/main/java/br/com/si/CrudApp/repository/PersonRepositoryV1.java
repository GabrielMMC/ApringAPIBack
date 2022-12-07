package br.com.si.CrudApp.repository;

import br.com.si.CrudApp.model.PersonModelV1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepositoryV1 extends JpaRepository<PersonModelV1, Long> {

    public Optional<PersonModelV1> findById(long id);

    List<PersonModelV1> findByFullNameContainsIgnoreCaseOrderByFullName(String name);


}
