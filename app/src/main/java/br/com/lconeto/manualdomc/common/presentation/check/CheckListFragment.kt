package br.com.lconeto.manualdomc.common.presentation.check

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lconeto.manualdomc.common.domain.extensions.navigateTo
import br.com.lconeto.manualdomc.common.domain.extensions.setTitleName
import br.com.lconeto.manualdomc.databinding.FragmentCheckListBinding

class CheckListFragment : Fragment() {
    private val args: CheckListFragmentArgs by navArgs()
    private var _binding: FragmentCheckListBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCheckListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitleName(args.screenName)

        setupCheckList()
        setupObservation()
        setupListeners()
    }

    private fun setupCheckList() {
        binding.checkListTittle.text = args.checkList.tittle

        val recyclerViewCreatePackage = binding.recyclerViewCreatePackage
        recyclerViewCreatePackage.layoutManager = LinearLayoutManager(requireContext())

        val adapter = CheckListAdapter(args.checkList.listItem)
        recyclerViewCreatePackage.adapter = adapter
    }

    private fun setupObservation() {
        args.checkObservation?.let {
            binding.textViewCheckAlert.text = getString(it.textId)
            binding.linearLayoutAlert.visibility = View.VISIBLE
        }
    }

    private fun setupListeners() {
        binding.finishButton.setOnClickListener {
            val action = CheckListFragmentDirections.actionCheckListFragmentToNavHome()
            navigateTo(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
