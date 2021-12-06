package ru.goryachev.multichief.construction.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.goryachev.multichief.construction.exception.MultiChiefEmptyListException;
import ru.goryachev.multichief.construction.exception.MultiChiefObjectNotFoundException;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.entity.ProjectType;
import ru.goryachev.multichief.construction.repository.ProjectTypeRepository;
import ru.goryachev.multichief.construction.service.StandardService;
import ru.goryachev.multichief.construction.service.converter.ProjectTypeConverter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * StandardProjectTypeService works with types: ProjectTypeCommonDto, ProjectType
 * @author Lev Goryachev
 * @version 1.1
 */

@Service
@PropertySource("classpath:service_layer.properties")
public class StandardProjectTypeService implements StandardService {

    @Value("${model.entity.alias.projecttype}")
    private String projectTypeEntityAlias;

    private ProjectTypeRepository projectTypeRepository;
    private ProjectTypeConverter projectTypeConverter;

    @Autowired
    public StandardProjectTypeService(ProjectTypeRepository projectTypeRepository, ProjectTypeConverter projectTypeConverter) {
        this.projectTypeRepository = projectTypeRepository;
        this.projectTypeConverter = projectTypeConverter;
    }

    @Override
    public List<CommonDto> getAll () {
        List<ProjectType> allMaterials = projectTypeRepository.findAll();
        if (allMaterials.isEmpty()) {
            throw new MultiChiefEmptyListException(projectTypeEntityAlias);
        }
        return allMaterials.stream().map(projectTypeConverter::entityToDto).collect(Collectors.toList());
    }

    public CommonDto getById (Long id) {
        ProjectType projectType = projectTypeRepository.findById(id).orElseThrow(() -> new MultiChiefObjectNotFoundException(projectTypeEntityAlias, id));
        return projectTypeConverter.entityToDto(projectType);
    }

    @Override
    public Map<String, Object> create (CommonDto projectTypeCommonDto) {
        ProjectType projectType = (ProjectType) projectTypeConverter.dtoToEntity(projectTypeCommonDto);

        ProjectType savedProjectType = projectTypeRepository.save(projectType);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", projectTypeEntityAlias + " " + "was saved in DB");
        responseBody.put("id", savedProjectType.getId());
        responseBody.put("name", savedProjectType.getTypeName());
        return responseBody;
    }

    @Override
    public Map<String, Object> update (CommonDto modifiedProjectType) {
        ProjectType projectType = (ProjectType) projectTypeConverter.dtoToEntity(modifiedProjectType);

        ProjectType savedProjectType = projectTypeRepository.save(projectType);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", projectTypeEntityAlias + " " + "was updated");
        responseBody.put("id", savedProjectType.getId());
        responseBody.put("name", savedProjectType.getTypeName());
        return responseBody;
    }

    @Override
    public Map<String, Object> delete (Long id) {
        projectTypeRepository.deleteById(id);
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("result", projectTypeEntityAlias + " " + "with id" + " " + id + " " + "was deleted");
        return responseBody;
    }
}
