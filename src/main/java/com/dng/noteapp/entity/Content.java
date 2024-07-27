package com.dng.noteapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contents")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;

    @Enumerated(EnumType.STRING)
    @Column(name = "content_type", nullable = false)
    private ContentType contentType;

    @Column(name = "text_content")
    @Lob
    private String textContent;

    @Column(name = "image_url")
    @Size(max = 255)
    private String imageUrl;

    @Size(max = 255)
    private String caption;

    @Column(name = "is_completed", columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isCompleted = false;

    public enum ContentType {
        TEXT, IMAGE
    }
}
