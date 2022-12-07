package br.com.si.CrudApp.controller;

import br.com.si.CrudApp.model.PersonModelV1;
import br.com.si.CrudApp.service.PersonServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person/v1")
public class PersonControllerV1 {

    @Autowired
    private PersonServiceV1 service;

    @GetMapping("/{id}")
    public Optional<PersonModelV1> findById(@PathVariable("id") long id){
        return service.findById(id);
    }

    @PostMapping
    public PersonModelV1 save(@RequestBody PersonModelV1 model){
        return service.save(model);
    }

    @GetMapping
    public List<PersonModelV1> findAll(){
        return service.findAll();
    }

    @PutMapping
    public PersonModelV1 update(@RequestBody PersonModelV1 model){
        return service.update(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/name/{name}")
    public List<PersonModelV1> findByName(@PathVariable("name") String name){
        return service.findByName(name);
    }

    @GetMapping("/find/start_name/{name}")
    public List<PersonModel> findByStartName(@PathVariable("name") String name){
        return service.findByFirstName(name);
    }

    @GetMapping("/find/email/{email}")
    public List<PersonModel> findByEmail(@PathVariable("email") String email){
        return service.findByEmail(email);
    }

}
