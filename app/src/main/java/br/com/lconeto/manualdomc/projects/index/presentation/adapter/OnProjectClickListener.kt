package br.com.lconeto.manualdomc.projects.index.presentation.adapter

import br.com.lconeto.manualdomc.projects.index.data.ProjectVO

interface OnProjectClickListener {
    fun onProjectClick(project: ProjectVO)
}
