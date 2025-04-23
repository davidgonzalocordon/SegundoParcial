package co.edu.udes.backend.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clients")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(255)", nullable = false)
    private String name;

    @Column(name = "email", columnDefinition = "VARCHAR(255)", nullable = false)
    private String email;

    @Column(name = "phone", columnDefinition = "VARCHAR(255)", nullable = false)
    private String phone;

    @Column(name = "address", columnDefinition = "VARCHAR(255)", nullable = false)
    private String address;

    @ToString.Exclude
    @OneToMany(
            targetEntity = Reserva.class,
            fetch = FetchType.LAZY,
            mappedBy = "room"
    )
    private List<Reserva> reservations;

}
