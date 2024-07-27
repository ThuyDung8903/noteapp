package com.dng.noteapp.repository;

import com.dng.noteapp.entity.SharedNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedNoteRepository extends JpaRepository<SharedNote, Long> {

}