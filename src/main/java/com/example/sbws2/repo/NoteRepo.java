package com.example.sbws2.repo;

import com.example.sbws2.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note,Long> { }
