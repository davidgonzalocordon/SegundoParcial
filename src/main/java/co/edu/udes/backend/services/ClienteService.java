package co.edu.udes.backend.services;

import co.edu.udes.backend.dto.ClienteDTO;
import co.edu.udes.backend.mappers.ClienteMapper;
import co.edu.udes.backend.mappers.HabitacionMapper;
import co.edu.udes.backend.mappers.ReservaMapper;
import co.edu.udes.backend.models.Cliente;
import co.edu.udes.backend.repositories.ClienteRepository;
import co.edu.udes.backend.repositories.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ReservaRepository reservaRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    private HabitacionMapper habitacionMapper;
    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private ReservaMapper reservaMapper;

    public List<ClienteDTO> getAll() {
        List<Cliente> lessons = clienteRepository.findAll();
        return clienteMapper.toDtoList(lessons);
    }

    public ClienteDTO getById(Long id) {
        return clienteMapper.toDto(clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found with id: " + id)));
    }

    public ClienteDTO create(Cliente lesson) {
        return clienteMapper.toDto(clienteRepository.save(lesson));
    }

    public List<ClienteDTO> createMultiple(List<Cliente> clientes) {
        for (Cliente newCliente : clientes) {
            newCliente.add(create(cliente));
        }
        return newCliente;
    }

    public ClienteDTO update(Long id, Cliente lesson) {
        Cliente existing = ClienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found with id: " + id));


        return clienteMapper.toDto(clienteRepository.save(existing));
    }

    public void delete(Long id) {
        clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found with id: " + id));
        clienteRepository.deleteById(id);
    }



}
