package co.edu.udes.backend.services;

import co.edu.udes.backend.mappers.ClienteMapper;
import co.edu.udes.backend.mappers.HabitacionMapper;
import co.edu.udes.backend.mappers.ReservaMapper;
import co.edu.udes.backend.repositories.ClienteRepository;
import co.edu.udes.backend.repositories.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HabitacionService {
    private final ReservaRepository reservaRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    private HabitacionMapper habitacionMapper;
    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private ReservaMapper reservaMapper;
}
