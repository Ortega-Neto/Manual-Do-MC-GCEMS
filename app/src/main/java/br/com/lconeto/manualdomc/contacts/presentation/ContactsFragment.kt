package br.com.lconeto.manualdomc.contacts.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.lconeto.manualdomc.contacts.data.contactLists.ContactCategory
import br.com.lconeto.manualdomc.databinding.FragmentContactsBinding

class ContactsFragment : Fragment() {

    private var _binding: FragmentContactsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populateButtons()
        setupListeners()
    }

    private fun populateButtons() {
        binding.contactGc.run {
            imageContactTitle.setImageResource(ContactCategory.GrandCouncil.icon)
            textContactTitle.text = ContactCategory.GrandCouncil.acronym
        }

        binding.contactSc.run {
            imageContactTitle.setImageResource(ContactCategory.StateCouncil.icon)
            textContactTitle.text = ContactCategory.StateCouncil.acronym
        }

        binding.contactEo.run {
            imageContactTitle.setImageResource(ContactCategory.ExecutiveOfficers.icon)
            textContactTitle.text = ContactCategory.ExecutiveOfficers.acronym
        }

        binding.contactRmc.run {
            imageContactTitle.setImageResource(ContactCategory.RegionalMasterCouncilors.icon)
            textContactTitle.text = ContactCategory.RegionalMasterCouncilors.acronym
        }
    }

    private fun setupListeners() {
        binding.contactGc.root.setOnClickListener {
            navigateToContactList(ContactCategory.GrandCouncil)
        }
        binding.contactSc.root.setOnClickListener {
            navigateToContactList(ContactCategory.StateCouncil)
        }
        binding.contactEo.root.setOnClickListener {
            navigateToContactList(ContactCategory.ExecutiveOfficers)
        }
        binding.contactRmc.root.setOnClickListener {
            navigateToContactList(ContactCategory.RegionalMasterCouncilors)
        }
    }

    private fun navigateToContactList(contactCategory: ContactCategory) {
        val action = ContactsFragmentDirections.actionNavContactsToShowContactsFragment(
            contactCategory = contactCategory
        )
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
