package com.example.sbws2.controller;

import com.example.sbws2.model.Note;
import com.example.sbws2.model.User;
import com.example.sbws2.repo.NoteRepo;
import com.example.sbws2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    NoteRepo noteRepo;

    @GetMapping("/users")
    public List<User> retrieveUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable(value = "id") Long id){
        return userRepo.findById(id).get();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable(value = "id") Long id){
        userRepo.delete(userRepo.findById(id).get());
    }

    @GetMapping("users/{id}/notes")
    public List<Note> retrieveAllUsers(@PathVariable Long id){
        return userRepo.findById(id).get().getNotes();
    }

    @PostMapping("users/{id}/notes")
    public void addNote(@PathVariable Long id,@RequestBody Note note){

        Optional<User> optUser = userRepo.findById(id);

//        if(optUser.isPresent()){
//            throw new UserNotFoundException("id-" + id);
//        }

        User user = optUser.get();
        note.setUser(user);
        noteRepo.save(note);

    }
}
