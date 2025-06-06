package br.com.lconeto.manualdomc.projects.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.lconeto.manualdomc.databinding.ListItemProjectBinding
import br.com.lconeto.manualdomc.projects.data.ProjectVO

class ProjectsAdapter(
    private val projects: List<ProjectVO>,
    private val clickListener: OnProjectClickListener
) : RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val binding = ListItemProjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val project = projects[position]
        holder.bind(project, clickListener)
    }

    override fun getItemCount(): Int = projects.size

    class ProjectViewHolder(private val binding: ListItemProjectBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(project: ProjectVO, clickListener: OnProjectClickListener) {
            binding.projectImage.setImageResource(project.image)
            binding.projectName.text = project.name

            binding.root.setOnClickListener {
                clickListener.onProjectClick(project)
            }
        }
    }
}
