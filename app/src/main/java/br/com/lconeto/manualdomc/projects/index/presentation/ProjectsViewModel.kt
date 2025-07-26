package br.com.lconeto.manualdomc.projects.index.presentation

import androidx.lifecycle.ViewModel
import br.com.lconeto.manualdomc.projects.index.data.ProjectVO
import br.com.lconeto.manualdomc.projects.index.data.ProjectsList

class ProjectsViewModel : ViewModel() {

    fun getProjects(): List<ProjectVO> = ProjectsList.getProjectsList()
}
