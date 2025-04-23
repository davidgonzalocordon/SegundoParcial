package co.edu.udes.backend.mappers;

import co.edu.udes.backend.dto.ReservaDTO;
import co.edu.udes.backend.models.Cliente;
import co.edu.udes.backend.models.Habitacion;
import co.edu.udes.backend.models.Reserva;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-22T20:26:16-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24 (Oracle Corporation)"
)
@Component
public class ReservaMapperImpl implements ReservaMapper {

    @Override
    public Reserva toEntity(ReservaDTO teacher) {
        if ( teacher == null ) {
            return null;
        }

        Reserva.ReservaBuilder reserva = Reserva.builder();

        reserva.client( reservaDTOToCliente( teacher ) );
        reserva.room( reservaDTOToHabitacion( teacher ) );
        reserva.id( teacher.getId() );

        return reserva.build();
    }

    @Override
    public List<Reserva> toEntityList(List<ReservaDTO> teachers) {
        if ( teachers == null ) {
            return null;
        }

        List<Reserva> list = new ArrayList<Reserva>( teachers.size() );
        for ( ReservaDTO reservaDTO : teachers ) {
            list.add( toEntity( reservaDTO ) );
        }

        return list;
    }

    @Override
    public ReservaDTO toDto(Reserva teacher) {
        if ( teacher == null ) {
            return null;
        }

        ReservaDTO.ReservaDTOBuilder reservaDTO = ReservaDTO.builder();

        Long id = teacherClientId( teacher );
        if ( id != null ) {
            reservaDTO.clientId( id );
        }
        Long id1 = teacherRoomId( teacher );
        if ( id1 != null ) {
            reservaDTO.roomId( id1 );
        }
        reservaDTO.id( teacher.getId() );

        return reservaDTO.build();
    }

    @Override
    public List<ReservaDTO> toDtoList(List<Reserva> teachers) {
        if ( teachers == null ) {
            return null;
        }

        List<ReservaDTO> list = new ArrayList<ReservaDTO>( teachers.size() );
        for ( Reserva reserva : teachers ) {
            list.add( toDto( reserva ) );
        }

        return list;
    }

    protected Cliente reservaDTOToCliente(ReservaDTO reservaDTO) {
        if ( reservaDTO == null ) {
            return null;
        }

        Cliente.ClienteBuilder cliente = Cliente.builder();

        cliente.id( reservaDTO.getClientId() );

        return cliente.build();
    }

    protected Habitacion reservaDTOToHabitacion(ReservaDTO reservaDTO) {
        if ( reservaDTO == null ) {
            return null;
        }

        Habitacion.HabitacionBuilder habitacion = Habitacion.builder();

        habitacion.id( reservaDTO.getRoomId() );

        return habitacion.build();
    }

    private Long teacherClientId(Reserva reserva) {
        Cliente client = reserva.getClient();
        if ( client == null ) {
            return null;
        }
        return client.getId();
    }

    private Long teacherRoomId(Reserva reserva) {
        Habitacion room = reserva.getRoom();
        if ( room == null ) {
            return null;
        }
        return room.getId();
    }
}
