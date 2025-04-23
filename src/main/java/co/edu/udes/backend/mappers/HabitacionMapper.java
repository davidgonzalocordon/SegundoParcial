package co.edu.udes.backend.mappers;

import co.edu.udes.backend.dto.HabitacionDTO;
import co.edu.udes.backend.models.Habitacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {
                ReservaMapper.class,
                HabitacionMapper.class,
        })
public interface HabitacionMapper {

    @Mapping(source = "reservationsIds", target = "reservations.id", qualifiedByName = "mapIdsToReservations")
    Habitacion toEntity(HabitacionDTO teacher);
    List<Habitacion> toEntityList(List<HabitacionDTO> teachers);

    @Mapping(source = "reservations.id", target = "reservationsIds", qualifiedByName = "mapReservationsToIds")
    HabitacionDTO toDto(Habitacion teacher);
    List<HabitacionDTO> toDtoList(List<Habitacion> teachers);
}
