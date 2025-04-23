package co.edu.udes.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HabitacionDTO {
    private Long id;
    private String numberRoom;
    private String floorRoom;
    private int numberBeds;

    private List<Long> reservationIds;
}
