package br.com.lconeto.manualdomc.projects.showProject.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import br.com.lconeto.manualdomc.common.domain.extensions.openPdfFromAssets
import br.com.lconeto.manualdomc.common.domain.extensions.requestStoragePermissions
import br.com.lconeto.manualdomc.common.domain.extensions.setTitleName
import br.com.lconeto.manualdomc.common.domain.extensions.toastMessage
import br.com.lconeto.manualdomc.databinding.FragmentShowProjectBinding
import br.com.lconeto.manualdomc.projects.index.data.ProjectVO
import br.com.lconeto.manualdomc.projects.index.presentation.adapter.OnProjectClickListener

class ShowProjectFragment : Fragment(), OnProjectClickListener {

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val granted = permissions.entries.all { it.value }
        if (granted) {
            toastMessage("Permissões concedidas!")
        } else {
            toastMessage("Permissões negadas. O aplicativo pode não funcionar corretamente.")
        }
    }

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
        setupListeners()
    }

    private fun populateView() {
        binding.projectImage.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), args.project.image)
        )
        binding.projectName.text = args.project.name
        binding.projectDescription.text = args.project.description
    }

    private fun setupListeners() {
        binding.openPdfButton.setOnClickListener {
            requestStoragePermissions(requestPermissionLauncher).also {
                openPdfFromAssets(args.project.pdfFileName)
            }
        }
    }

    override fun onProjectClick(project: ProjectVO) {
        print(project)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
