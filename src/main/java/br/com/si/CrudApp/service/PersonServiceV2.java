package br.com.si.CrudApp.service;

import br.com.si.CrudApp.model.PersonModelV2;
import br.com.si.CrudApp.repository.PersonRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceV2 {

    @Autowired
    private PersonRepositoryV2 repository;

    public Optional<PersonModelV2> findById(long id){
        return repository.findById(id);
    }

    public Page<PersonModelV2> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public PersonModelV2 save(PersonModelV2 model){
        return repository.save(model);
    }

    public PersonModelV2 update(PersonModelV2 model){
        Optional<PersonModelV2> p = repository.findById(model.getId());
        if(p.isPresent()){
            p.get().setFullName(model.getFullName());
            p.get().setEmail(model.getEmail());
            p.get().setGender(model.getGender());
            //..new attributes V2 -------------------
            p.get().setBirthDate(model.getBirthDate());
            p.get().setCity(model.getCity());
            //---------------------------------------
            return repository.save(p.get());
        } else {
            return null;
        }
    }

    public void delete(long id){
        Optional<PersonModelV2> p = repository.findById(id);
        if(p.isPresent()){
            repository.delete(p.get());
        }
    }

    public List<PersonModelV2> findByName(String name){
        return repository.findByFullNameContainsIgnoreCaseOrderByFullName(name);
    }


}
