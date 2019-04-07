package by.psu.service.dto.mappers;

import by.psu.model.postgres.PositionImage;
import by.psu.service.dto.PositionImageDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface PositionImageMapper {

    @Mapping(source = "image.id", target = "image")
    @Mapping(source = "image.url", target = "url")
    PositionImageDTO to(PositionImage nsi);

    @InheritInverseConfiguration
    PositionImage from(PositionImageDTO nsi);

}
