package com.example.dd.dd.Services;

import com.example.dd.dd.Entities.Project;
import com.example.dd.dd.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        logger.info("Fetching all bids");
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        logger.info("Fetching Project with id: {}", id);
        return projectRepository.findById(id);
    }
    @Transactional
    public Project createProject(Project project) {
        logger.info("Creating bid: {}", project);
        return projectRepository.save(project);
    }
    @Transactional
    public void deleteProject(Long id) {
        logger.info("Deleting bid with project: {}", id);
        projectRepository.deleteById(id);
    }
}
