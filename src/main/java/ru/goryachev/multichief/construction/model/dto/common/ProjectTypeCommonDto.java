package ru.goryachev.multichief.construction.model.dto.common;

import ru.goryachev.multichief.construction.model.dto.CommonDto;

import java.util.Objects;

/**
 * ProjectTypeCommonDto is an intermediate object of the sub-domain ProjectType,
 * used for requests and responses (communication between microservices).
 * @author Lev Goryachev
 * @version 1.1
 */

public class ProjectTypeCommonDto implements CommonDto {

    private Long id;

    private String typeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectTypeCommonDto)) return false;
        ProjectTypeCommonDto that = (ProjectTypeCommonDto) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTypeName(), that.getTypeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTypeName());
    }

    @Override
    public String toString() {
        return "ProjectTypeCommonDto{" +
                "typeName='" + typeName + '\'' +
                '}';
    }
}
