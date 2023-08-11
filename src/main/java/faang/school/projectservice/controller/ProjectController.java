package faang.school.projectservice.controller;

import faang.school.projectservice.dto.project.ProjectDto;
import faang.school.projectservice.exception.DataValidationException;
import faang.school.projectservice.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    public ProjectDto create(ProjectDto projectDto) {
        validateProject(projectDto == null || projectDto.getName().length() < 128
                || projectDto.getDescription().length() < 4096, "Project is empty");
        return projectService.create(projectDto);
    }

    private void validateProject(boolean condition, String errorMessage) {
        if (condition) {
            throw new DataValidationException(errorMessage);
        }
    }
}