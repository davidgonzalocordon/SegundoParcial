package co.edu.udes.backend.mappers;

import co.edu.udes.backend.dto.ClienteDTO;
import co.edu.udes.backend.models.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {
                ReservaMapper.class,
                HabitacionMapper.class,
        })
public interface ClienteMapper {

    @Mapping(source = "reservationsIds", target = "reservations.id", qualifiedByName = "mapIdsToReservation")
    Cliente toEntity(ClienteDTO teacher);
    List<Cliente> toEntityList(List<ClienteDTO> teachers);

    @Mapping(source = "reservations.id", target = "reservationsIds", qualifiedByName = "mapReservationToIds")
    ClienteDTO toDto(Cliente teacher);
    List<ClienteDTO> toDtoList(List<Cliente> teachers);
}
