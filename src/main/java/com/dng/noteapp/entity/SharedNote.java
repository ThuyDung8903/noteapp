package com.dng.noteapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shared_note", uniqueConstraints = { @UniqueConstraint(columnNames = { "note_id", "shared_user_id" }) })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SharedNote extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shared_user_id", nullable = false)
    private User sharedUser;

    @Column(name = "is_contribution_accepted", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean isContributionAccepted = true;
}