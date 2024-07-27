package com.dng.noteapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Fullname is required")
    @Size(max = 255)
    @Column(nullable = false)
    private String fullname;

    @Email(message = "Email is invalid")
    @NotBlank(message = "Email is required")
    @Size(max = 255, message = "Email must be less than 255 characters")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(max = 255)
    @Column(nullable = false)
    private String password;

    @Column(name = "facebook_account_id", columnDefinition = "INT DEFAULT 0")
    private int facebookAccountId = 0;

    @Column(name = "google_account_id", columnDefinition = "INT DEFAULT 0")
    private int googleAccountId = 0;

    @Column(name = "is_active", columnDefinition = "TINYINT(1) default 1")
    private boolean isActive = true;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN, USER
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Note> notes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tag> tags;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NoteLog> noteLogs;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Token> tokens;
}