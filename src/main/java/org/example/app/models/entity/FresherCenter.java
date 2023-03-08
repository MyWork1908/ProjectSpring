package org.example.app.models.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fresher_center", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"fresher_id", "center_code"})
})
public class FresherCenter {
    @Id
    @Column(name = "fresher_center_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fresherCenterId;

    @ManyToOne()
    @JoinColumn(name = "fresher_id")
    @JsonIgnore
    Fresher fresher;

    @ManyToOne()
    @JoinColumn(name = "center_code")
    @JsonIgnore
    Center center;
}
