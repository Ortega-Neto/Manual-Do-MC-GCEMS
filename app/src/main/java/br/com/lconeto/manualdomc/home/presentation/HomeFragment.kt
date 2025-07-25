package br.com.lconeto.manualdomc.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.domain.extensions.navigateTo
import br.com.lconeto.manualdomc.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populateButtons()
        setupListeners()
    }

    private fun populateButtons() {
        binding.homeMeeting.textContactTitle.text = getString(R.string.home_meetings)
        binding.homeMeeting.imageContactTitle.setImageResource(R.drawable.ic_meeting)
        binding.homeRoles.textContactTitle.text = getString(R.string.home_roles)
        binding.homeRoles.imageContactTitle.setImageResource(R.drawable.ic_role)
        binding.homePackages.textContactTitle.text = getString(R.string.home_packages)
        binding.homePackages.imageContactTitle.setImageResource(R.drawable.ic_package)
        binding.homeTickets.textContactTitle.text = getString(R.string.home_tickets)
        binding.homeTickets.imageContactTitle.setImageResource(R.drawable.ic_ticket)
    }

    private fun setupListeners() {
        binding.homeMeeting.root.setOnClickListener { }
        binding.homeRoles.root.setOnClickListener {
            navigateTo(HomeFragmentDirections.actionNavHomeToEditRolesFragment())
        }
        binding.homePackages.root.setOnClickListener {
            navigateTo(HomeFragmentDirections.actionNavHomeToPackagesFragment())
        }
        binding.homeTickets.root.setOnClickListener {
            navigateTo(HomeFragmentDirections.actionNavHomeToTicketsFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
