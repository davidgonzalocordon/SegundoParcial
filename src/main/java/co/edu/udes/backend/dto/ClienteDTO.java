package co.edu.udes.backend.dto;


import lombok.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;

    private List<Long> reservationsIds;
}

