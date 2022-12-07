package br.com.si.CrudApp.repository;

import br.com.si.CrudApp.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long> {

    public Optional<PersonModel> findById(long id);

    List<PersonModel> findByFullNameContainsIgnoreCaseOrderByFullName(String name);

    List<PersonModel> findDistinctByEmail(String email);

    List<PersonModel> findByFullNameStartsWith(String name);


}
