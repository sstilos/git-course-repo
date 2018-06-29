package com.example.sbws2.controller;


import com.example.sbws2.model.Note;
import com.example.sbws2.model.User;
import com.example.sbws2.repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    NoteRepo noteRepo;

    @GetMapping("/notes")
    public List<Note> getNotes(){
        return noteRepo.findAll();
    }

    @GetMapping("/notes/{id}")
    public Note getNote(@PathVariable(value = "id") Long id){
        return noteRepo.findById(id).get();
    }

    @PostMapping("/notes")
    public Note createNote(@RequestBody Note note){
        return noteRepo.save(note);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable(value = "id") Long id){
        noteRepo.delete(noteRepo.findById(id).get());
    }


}
