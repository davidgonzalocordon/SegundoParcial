package co.edu.udes.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_client",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Cliente client;

    @ManyToOne
    @JoinColumn(name = "id_room",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Habitacion room;

}
