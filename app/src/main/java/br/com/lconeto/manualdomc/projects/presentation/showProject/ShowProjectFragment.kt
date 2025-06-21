package br.com.lconeto.manualdomc.projects.presentation.showProject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.lconeto.manualdomc.common.domain.extensions.setTitleName
import br.com.lconeto.manualdomc.databinding.FragmentProjectsBinding
import br.com.lconeto.manualdomc.databinding.FragmentShowProjectBinding
import br.com.lconeto.manualdomc.projects.data.ProjectVO
import br.com.lconeto.manualdomc.projects.presentation.adapter.OnProjectClickListener
import br.com.lconeto.manualdomc.projects.presentation.adapter.ProjectsAdapter

class ShowProjectFragment : Fragment(), OnProjectClickListener {

    private var _binding: FragmentShowProjectBinding? = null

    private val binding get() = _binding!!
    private val args: ShowProjectFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowProjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitleName(args.project.name)
        populateView()
    }

    private fun populateView() {
        binding.projectImage.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), args.project.image)
        )
        binding.projectName.text = args.project.name
        binding.projectDescription.text = args.project.description
    }

    override fun onProjectClick(project: ProjectVO) {
        print(project)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
