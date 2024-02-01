package org.adaschool.sistemareservasada.application.mapper;

import org.adaschool.sistemareservasada.application.mapper.base.IBaseMapper;
import org.adaschool.sistemareservasada.domain.dto.MovieDTO;
import org.adaschool.sistemareservasada.domain.entity.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper extends IBaseMapper {
    Movie toEntity(MovieDTO dto);

    MovieDTO toDto(Movie entity);

    List<Movie> toEntityList(List<MovieDTO> dtoList);

    List<MovieDTO> toDtoList(List<Movie> entityList);
}
