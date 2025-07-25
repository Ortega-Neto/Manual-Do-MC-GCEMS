package br.com.lconeto.manualdomc.packages.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.domain.extensions.setTitleName
import br.com.lconeto.manualdomc.common.presentation.check.CheckListAdapter
import br.com.lconeto.manualdomc.databinding.FragmentPackagesBinding
import br.com.lconeto.manualdomc.packages.data.StepByStepPackage

class PackagesFragment : Fragment() {
    private var _binding: FragmentPackagesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPackagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitleName(getString(R.string.home_packages))
        val recyclerViewCreatePackage = binding.recyclerViewCreatePackage
        recyclerViewCreatePackage.layoutManager = LinearLayoutManager(requireContext())

        val adapter = CheckListAdapter(StepByStepPackage.checkList.listItem)
        recyclerViewCreatePackage.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
