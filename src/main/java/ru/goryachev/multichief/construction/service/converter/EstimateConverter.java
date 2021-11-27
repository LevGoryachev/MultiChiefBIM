package ru.goryachev.multichief.construction.service.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.dto.common.EstimateCommonDto;
import ru.goryachev.multichief.construction.model.entity.Estimate;

/**
 * EstimateConverter. Converter is used for converting Entity to CommonDto and CommonDto to Entity using common fields.
 * @author Lev Goryachev
 * @version 1.1
 */

@Component
public class EstimateConverter implements Converter {
    private ModelMapper modelMapper;

      public EstimateConverter() {
            this.modelMapper = new ModelMapper();
      }

    @Override
    public CommonDto entityToDto (Object estimate){
          return modelMapper.map(estimate, EstimateCommonDto.class);
    }

    @Override
    public Object dtoToEntity (CommonDto estimateCommonDto) {
          return modelMapper.map(estimateCommonDto, Estimate.class);
    }
}
