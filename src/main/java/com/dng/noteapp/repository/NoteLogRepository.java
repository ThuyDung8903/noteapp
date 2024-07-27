package com.dng.noteapp.repository;

import com.dng.noteapp.entity.NoteLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteLogRepository extends JpaRepository<NoteLog, Long> {

}