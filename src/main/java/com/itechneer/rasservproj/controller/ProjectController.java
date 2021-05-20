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

    @Autowired
    private ProjectServiceImpl projectService;

    // display list of projects
    @GetMapping("/home")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Iterable<Project> findAll(@RequestParam (value="isDeleted", required = false, defaultValue = "false")boolean isDeleted){
        return projectService.findAll(isDeleted);
    }

    @PostMapping("/saveProject")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public void saveProject(@Valid @RequestBody Project project) {
        // save project to database
        projectService.saveProject(project);

    }

    //// edit selected Project
    @GetMapping("/editProject/{id}")
    @PreAuthorize("hasRole('ADMIN')")
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

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @DeleteMapping("/deleteProject/{id}")
    public void delete(@PathVariable("id") Long id) {
        projectService.deleteProjectById(id);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Project> page = projectService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Project> listProjects = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listProjects", listProjects);
        return "index";

    }
}
