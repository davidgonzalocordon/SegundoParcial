package co.edu.udes.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numberRoom", columnDefinition = "VARCHAR(255)", nullable = false)
    private String numberRoom;

    @Column(name = "floorRoom", columnDefinition = "VARCHAR(255)", nullable = false)
    private String floorRoom;

    @Column(name = "numberBeds", columnDefinition = "int", nullable = false)
    private int numberBeds;

    @ToString.Exclude
    @OneToMany(
            targetEntity = Reserva.class,
            fetch = FetchType.LAZY,
            mappedBy = "client"
    )
    private List<Reserva> reservations;
}
