package br.com.lconeto.manualdomc.projects.presentation.adapter

import br.com.lconeto.manualdomc.projects.data.ProjectVO

interface OnProjectClickListener {
    fun onProjectClick(project: ProjectVO)
}