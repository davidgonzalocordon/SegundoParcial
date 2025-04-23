package co.edu.udes.backend.dto;

import co.edu.udes.backend.models.Cliente;
import co.edu.udes.backend.models.Habitacion;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ReservaDTO {

    private Long id;

    private long clientId;
    private long roomId;
}
