package org.example.app.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "fresher")
public class Fresher {
    @Id
    @Column(name = "fresher_id", unique = true)
    private String fresherId;
    @Column(name = "fresher_name")
    private String fresherName;
    @Column(name = "fresher_address")
    private String fresherAddress;
    @Column(name = "fresher_phone", unique = true)
    private String fresherPhone;
    @Column(name = "fresher_email", unique = true)
    private String fresherEmail;

    @OneToMany(mappedBy = "fresher", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    Set<FresherCenter> fresherCenters;
    @OneToMany(mappedBy = "fresher", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    Set<Score> scores;

    public Fresher(String fresherId, String fresherName,
                   String fresherAddress, String fresherPhone, String fresherEmail) {
        this.fresherId = fresherId;
        this.fresherName = fresherName;
        this.fresherAddress = fresherAddress;
        this.fresherPhone = fresherPhone;
        this.fresherEmail = fresherEmail;
    }
}
