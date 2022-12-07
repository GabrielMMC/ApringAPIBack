package br.com.si.CrudApp.service;

import br.com.si.CrudApp.model.PersonModelV1;
import br.com.si.CrudApp.repository.PersonRepositoryV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceV1 {

    @Autowired
    private PersonRepositoryV1 repository;

    public Optional<PersonModelV1> findById(long id){
        return repository.findById(id);
    }

    public List<PersonModelV1> findAll(){
        return repository.findAll();
    }

    public PersonModelV1 save(PersonModelV1 model){
        return repository.save(model);
    }

    public PersonModelV1 update(PersonModelV1 model){
        Optional<PersonModelV1> p = repository.findById(model.getId());
        if(p.isPresent()){
            p.get().setFullName(model.getFullName());
            p.get().setEmail(model.getEmail());
            p.get().setGender(model.getGender());
            return repository.save(p.get());
        } else {
            return null;
        }
    }

    public void delete(long id){
        Optional<PersonModelV1> p = repository.findById(id);
        if(p.isPresent()){
            repository.delete(p.get());
        }
    }

    public List<PersonModelV1> findByName(String name){
        return repository.findByFullNameContainsIgnoreCaseOrderByFullName(name);
    }

    public List<PersonModel> findByEmail(String email) {
        return repository.findDistinctByEmail(email);
    }

    public List<PersonModel> findByFirstName(String name) {
        return repository.findByFullNameStartsWith(name);
    }
}
