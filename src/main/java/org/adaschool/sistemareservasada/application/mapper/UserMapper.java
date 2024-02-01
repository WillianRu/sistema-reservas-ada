package org.adaschool.sistemareservasada.application.mapper;

import org.adaschool.sistemareservasada.application.mapper.base.IBaseMapper;
import org.adaschool.sistemareservasada.domain.dto.UserAccountDTO;
import org.adaschool.sistemareservasada.domain.entity.UserAccount;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper extends IBaseMapper {
    UserAccount toEntity(UserAccountDTO dto);

    UserAccountDTO toDto(UserAccount entity);

    List<UserAccount> toEntityList(List<UserAccountDTO> dtoList);

    List<UserAccountDTO> toDtoList(List<UserAccount> entityList);
}
