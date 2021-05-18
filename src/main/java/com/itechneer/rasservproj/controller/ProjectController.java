package com.itechneer.rasservproj.controller;

import com.itechneer.rasservproj.models.Project;
import com.itechneer.rasservproj.payload.response.JwtResponse;
import com.itechneer.rasservproj.payload.response.MessageResponse;
import com.itechneer.rasservproj.security.services.ProjectService;
import com.itechneer.rasservproj.security.services.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping ("/api/project")
public class ProjectController {

//    @Autowired
//    private ProjectService projectService;

    @Autowired
    private ProjectServiceImpl projectService;

    // display list of projects
    @GetMapping("/home")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List <Project> viewHomePage() {
        //return this.projectService.getAllProjects();
        return projectService.getAllProjects();

    }
//    public ResponseEntity <?> viewHomePage() {
//        //return this.projectService.getAllProjects();
//
//        return ResponseEntity.ok(projectService.getAllProjects());
//
//    }

    // display list of projects
    /*@GetMapping("/searchByName")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List <Project> searchByName(Model model) {
        //findPaginated(1, "projname", "asc", model);
        //"project home access";
        //List <Project> = projectService.getAllProjects();
    }*/

    //save project
    @PostMapping("/saveProject")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void saveProject(@Valid @RequestBody Project project) {
        // save project to database
        projectService.saveProject(project);

    }
    
    // edit selected Project
    @GetMapping("/editProject/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Project editProject(@PathVariable (value = "id") long id) {

        // get project from the service
        Project project = projectService.getProjectById(id);

        return project;
    }
    
    // update the selected Project
    @PutMapping("/updateProject/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void updateProject(@Valid @RequestBody Project project) {

        // update existing project
        //projectService.updateProject(project);
        projectService.saveProject(project);
    }
}
