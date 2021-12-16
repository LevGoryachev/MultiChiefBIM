package ru.goryachev.multichief.construction.service.converter;

import org.springframework.stereotype.Component;
import ru.goryachev.multichief.construction.model.dto.request.BimRequestDto;
import ru.goryachev.multichief.construction.model.dto.response.BimPreformDTO;
import ru.goryachev.multichief.construction.model.entity.Bim;

/**
 * SpecialBimConverter converts Entity to CommonDto and CommonDto to Entity using common fields.
 * @author Lev Goryachev
 * @version 2
 */

@Component
public class SpecialBimConverter /*implements Converter*/ {

    public BimPreformDTO entityToDto (Bim bim){
          BimPreformDTO bimPreformDTO = new BimPreformDTO();
          bimPreformDTO.setId(bim.getId());
          bimPreformDTO.setProjectCodeNumber(bim.getProjectCodeNumber());
          bimPreformDTO.setProjectName(bim.getProjectName());
          bimPreformDTO.setLod(bim.getLod());
          bimPreformDTO.setProjectType(bim.getProjectType()); // gregergggergerggrergergerg
          bimPreformDTO.setProjectTypeId(bim.getProjectTypeId());
          bimPreformDTO.setEirId(bim.getEirId());
          bimPreformDTO.setLink(bim.getLink());
          return bimPreformDTO;
    }

    public Bim dtoToEntity (BimRequestDto bimCommonDto) {
          Bim bim = new Bim();
          bim.setId(bimCommonDto.getId());
          bim.setProjectCodeNumber(bimCommonDto.getProjectCodeNumber());
          bim.setProjectName(bimCommonDto.getProjectName());
          bim.setLod(bimCommonDto.getLod());
          bim.setProjectTypeId(bimCommonDto.getProjectTypeId());
          bim.setEirId(bimCommonDto.getEirId());
          bim.setLink(bimCommonDto.getLink());
          return bim;
    }
}
