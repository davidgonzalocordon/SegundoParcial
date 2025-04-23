package co.edu.udes.backend.mappers;

import co.edu.udes.backend.dto.HabitacionDTO;
import co.edu.udes.backend.models.Habitacion;
import co.edu.udes.backend.models.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        uses = {
                ReservaMapper.class,
                HabitacionMapper.class,
                ClienteMapper.class,
        })
public interface HabitacionMapper {

    @Mapping(source = "reservationsIds", target = "reservations.id", qualifiedByName = "mapIdsToReservations")
    Habitacion toEntity(HabitacionDTO room);
    List<Habitacion> toEntityList(List<HabitacionDTO> rooms);

    @Mapping(source = "reservations.id", target = "reservationsIds", qualifiedByName = "mapReservationsToIds")
    HabitacionDTO toDto(Habitacion room);
    List<HabitacionDTO> toDtoList(List<Habitacion> rooms);

    @Named("mapIdsToReservations")
    static List<Reserva> mapIdsToReservations(List<Long> ids) {
        if (ids == null) return null;
        List<Reserva> reservas = new ArrayList<>();
        for (Long id : ids) {
            Reserva reserva = new Reserva();
            reserva.setId(id);
            reservas.add(reserva);
        }
        return reservas;
    }

    @Named("mapReservationsToIds")
    static List<Long> mapReservationsToIds(List<Reserva> reservas) {
        if (reservas == null) return null;
        return reservas.stream()
                .map(Reserva::getId)
                .toList();
    }
}
