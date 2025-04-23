package co.edu.udes.backend.mappers;

import co.edu.udes.backend.dto.ReservaDTO;
import co.edu.udes.backend.models.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {
                ReservaMapper.class,
                HabitacionMapper.class,
                ClienteMapper.class,
        })
public interface ReservaMapper {

    @Mapping(source = "clientId", target = "client.id")
    @Mapping(source = "roomId", target = "room.id")
    Reserva toEntity(ReservaDTO teacher);
    List<Reserva> toEntityList(List<ReservaDTO> teachers);

    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "room.id", target = "roomId")
    ReservaDTO toDto(Reserva teacher);
    List<ReservaDTO> toDtoList(List<Reserva> teachers);
}
