package com.dng.noteapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tokens")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Token is required")
    @Column(unique = true, nullable = false)
    @Size(max = 255)
    private String token;

    @NotBlank(message = "Token_type is required")
    @Column(name = "token_type", nullable = false)
    private String tokenType;

    @Column(name = "expiration_date", columnDefinition = "DATETIME")
    private LocalDateTime expirationDate;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean revoked;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}