package com.dng.noteapp.repository;

import com.dng.noteapp.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}