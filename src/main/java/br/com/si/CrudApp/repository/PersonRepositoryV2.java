package br.com.si.CrudApp.repository;

import br.com.si.CrudApp.model.PersonModelV1;
import br.com.si.CrudApp.model.PersonModelV2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepositoryV2 extends JpaRepository<PersonModelV2, Long> {

    public Optional<PersonModelV2> findById(long id);

    List<PersonModelV2> findByFullNameContainsIgnoreCaseOrderByFullName(String name);

    //..new method - V2 ------------------------------------
    List<PersonModelV2> findByBirthDateBetween(Date date1,
                                               Date date2);

    Page<PersonModelV2> findAll(Pageable pageable);

    List<PersonModelV2> findAll();


}
