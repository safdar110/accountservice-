package com.itechneer.rasservproj.repository;

import com.itechneer.rasservproj.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    //List<Project> findbyProjectName(String projName);
}
