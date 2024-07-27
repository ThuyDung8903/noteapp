package com.dng.noteapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tags")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank(message = "Name is required")
    @Size(max = 255)
    @Column(nullable = false)
    private String name;

    @Column(name = "is_active", columnDefinition = "TINYINT(1) default 1")
    private boolean isActive = true;

    @ManyToMany(mappedBy = "tags", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Note> notes;
}