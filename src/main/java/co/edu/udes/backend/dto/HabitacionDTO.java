package co.edu.udes.backend.dto;

import co.edu.udes.backend.models.Reserva;

import java.util.List;

public class HabitacionDTO {
    private Long id;
    private String numberRoom;
    private String floorRoom;
    private int numberBeds;

    private List<Long> reservationIds;
}
