package br.com.lconeto.manualdomc.tickets.index.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.domain.extensions.navigateTo
import br.com.lconeto.manualdomc.common.domain.extensions.setTitleName
import br.com.lconeto.manualdomc.databinding.FragmentTicketsBinding
import br.com.lconeto.manualdomc.packages.data.SendPackageToCGEMS
import br.com.lconeto.manualdomc.packages.data.StepByStepPackage

class TicketsFragment : Fragment() {
    private var _binding: FragmentTicketsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTicketsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitleName(getString(R.string.home_tickets))

        setupInitializationMessage()
        populateButtons()
        setupListeners()
    }

    private fun setupInitializationMessage() {
        binding.textViewPackages.text = ALERT_TICKET
    }

    private fun populateButtons() {
        binding.ticketAuth.textContactTitle.text = getString(R.string.ticket_auth)
        binding.ticketAuth.imageContactTitle.setImageResource(R.drawable.ic_ticket_auth)
        binding.ticketEmail.textContactTitle.text = getString(R.string.ticket_email)
        binding.ticketEmail.imageContactTitle.setImageResource(R.drawable.ic_ticket_email)
    }

    private fun setupListeners() {
        binding.ticketAuth.root.setOnClickListener {
            navigateTo(
                TicketsFragmentDirections.actionTicketsFragmentToTicketFormFragment(
                    isAuth = true
                )
            )
        }
        binding.ticketEmail.root.setOnClickListener {
            navigateTo(
                TicketsFragmentDirections.actionTicketsFragmentToTicketFormFragment(
                    isAuth = false
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private companion object {
        const val ALERT_TICKET = "Quando utilizar um Ticket?\n\n" +
            "- Autorização para execução de Cerimônias;\n- Alteração de nomintas e documentos;\n" +
            "- Dúvidas referentes ao sistemas ou Campanhas Estaduais e Nacionais;\n" +
            "- Altereção de informações de membros e do Capítulo;\n- Registro de membros antigos;\n" +
            "- Solicitação de materiais e paramentos;\n- Prêmios."
    }
}
