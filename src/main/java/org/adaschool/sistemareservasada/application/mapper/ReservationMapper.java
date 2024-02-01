package org.adaschool.sistemareservasada.application.mapper;

import org.adaschool.sistemareservasada.application.mapper.base.IBaseMapper;
import org.adaschool.sistemareservasada.domain.dto.ReservationDTO;
import org.adaschool.sistemareservasada.domain.entity.Reservation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper extends IBaseMapper {
    Reservation toEntity(ReservationDTO dto);

    ReservationDTO toDto(Reservation entity);

    List<Reservation> toEntityList(List<ReservationDTO> dtoList);

    List<ReservationDTO> toDtoList(List<Reservation> entityList);
}
