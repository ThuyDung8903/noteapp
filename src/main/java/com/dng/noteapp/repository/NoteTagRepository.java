package com.dng.noteapp.repository;

import com.dng.noteapp.entity.NoteTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteTagRepository extends JpaRepository<NoteTag, Long> {

}