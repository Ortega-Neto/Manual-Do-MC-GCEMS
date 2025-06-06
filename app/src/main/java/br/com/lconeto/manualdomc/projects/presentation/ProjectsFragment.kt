package br.com.lconeto.manualdomc.projects.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.lconeto.manualdomc.databinding.FragmentProjectsBinding
import br.com.lconeto.manualdomc.projects.data.ProjectVO
import br.com.lconeto.manualdomc.projects.presentation.adapter.OnProjectClickListener
import br.com.lconeto.manualdomc.projects.presentation.adapter.ProjectsAdapter

class ProjectsFragment : Fragment(), OnProjectClickListener {

    private var _binding: FragmentProjectsBinding? = null

    private val binding get() = _binding!!

    private val projectsViewModel by lazy {
        ViewModelProvider(this)[ProjectsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProjectsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populateRecyclerView()
    }

    private fun populateRecyclerView() {
        val projectsRecyclerView: RecyclerView = binding.projectsRecyclerView
        projectsRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        projectsRecyclerView.adapter = ProjectsAdapter(
            projects = projectsViewModel.getProjects(),
            clickListener = this
        )
    }

    override fun onProjectClick(project: ProjectVO) {
        findNavController().navigate(
            ProjectsFragmentDirections.actionNavProjectsToShowProjectFragment(
                project = project
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}