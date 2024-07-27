package com.dng.noteapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "note_tags", uniqueConstraints = { @UniqueConstraint(columnNames = { "note_id", "tag_id" }) })
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteTag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
}