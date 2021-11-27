package ru.goryachev.multichief.construction.service.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.dto.common.ProjectTypeCommonDto;
import ru.goryachev.multichief.construction.model.entity.ProjectType;

/**
 * ProjectTypeConverter. Converter is used for converting Entity to CommonDto and CommonDto to Entity using common fields.
 * @author Lev Goryachev
 * @version 1.1
 */

@Component
public class ProjectTypeConverter implements Converter {
    private ModelMapper modelMapper;

      public ProjectTypeConverter() {
            this.modelMapper = new ModelMapper();
      }

    @Override
    public CommonDto entityToDto (Object projectType){
          return modelMapper.map(projectType, ProjectTypeCommonDto.class);
    }

    @Override
    public Object dtoToEntity (CommonDto projectTypeCommonDto) {
          return modelMapper.map(projectTypeCommonDto, ProjectType.class);
    }
}
