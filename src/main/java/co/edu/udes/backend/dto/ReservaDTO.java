package co.edu.udes.backend.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {

    private Long id;

    private long clientId;
    private long roomId;
}
