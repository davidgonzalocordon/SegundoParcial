package co.edu.udes.backend.mappers;

import co.edu.udes.backend.dto.ClienteDTO;
import co.edu.udes.backend.models.Cliente;
import co.edu.udes.backend.models.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        uses = {
                ReservaMapper.class,
                HabitacionMapper.class,
                ClienteMapper.class,
        })
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(source = "reservationsIds", target = "reservations.id", qualifiedByName = "mapIdsToReservations")
    Cliente toEntity(ClienteDTO room);
    List<Cliente> toEntityList(List<ClienteDTO> rooms);

    @Mapping(source = "reservations.id", target = "reservationsIds", qualifiedByName = "mapReservationToIds")
    ClienteDTO toDto(Cliente teacher);
    List<ClienteDTO> toDtoList(List<Cliente> teachers);

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
