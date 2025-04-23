package co.edu.udes.backend.dto;


import java.util.List;

public class ClienteDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;

    private List<Long> groupIds;
    private List<Long> careerIds;
}

