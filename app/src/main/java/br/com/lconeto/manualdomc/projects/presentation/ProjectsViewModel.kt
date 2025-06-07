package br.com.lconeto.manualdomc.projects.presentation

import androidx.lifecycle.ViewModel
import br.com.lconeto.manualdomc.projects.data.ProjectVO
import br.com.lconeto.manualdomc.projects.data.ProjectsList

class ProjectsViewModel : ViewModel() {

    fun getProjects(): List<ProjectVO> = ProjectsList.getProjectsList()
}
