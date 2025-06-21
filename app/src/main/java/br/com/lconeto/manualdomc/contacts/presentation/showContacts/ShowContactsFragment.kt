package br.com.lconeto.manualdomc.contacts.presentation.showContacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.lconeto.manualdomc.common.domain.extensions.setTitleName
import br.com.lconeto.manualdomc.contacts.presentation.showContacts.adapter.ShowContactAdapter
import br.com.lconeto.manualdomc.databinding.FragmentShowContactsBinding

class ShowContactsFragment : Fragment() {

    private var _binding: FragmentShowContactsBinding? = null
    private val binding get() = _binding!!
    private val args: ShowContactsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitleName(args.contactCategory.title)
        populateRecyclerView()
    }

    private fun populateRecyclerView() {
        val projectsRecyclerView: RecyclerView = binding.contactsRecyclerView
        projectsRecyclerView.layoutManager = GridLayoutManager(requireContext(), 1)

        projectsRecyclerView.adapter = ShowContactAdapter(
            contacts = args.contactCategory.contacts,
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
