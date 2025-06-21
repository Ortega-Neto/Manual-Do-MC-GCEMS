package br.com.lconeto.manualdomc.bank.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.domain.extensions.copyTextToClipboard
import br.com.lconeto.manualdomc.common.domain.extensions.extractOnlyNumbers
import br.com.lconeto.manualdomc.databinding.FragmentBankDetailsBinding

class BankDetailsFragment : Fragment() {
    private var _binding: FragmentBankDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBankDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
    }

    private fun setupUi() {
        binding.btnCopyPix.setOnClickListener {
            it.copyTextToClipboard(getString(R.string.bank_details_pix).extractOnlyNumbers())
        }
        binding.btnCopyAccount.setOnClickListener {
            it.copyTextToClipboard(getBankAccountForClipboard())
        }
        binding.btnCopyEmailSecretary.setOnClickListener {
            it.copyTextToClipboard(getString(R.string.bank_details_email_secretary))
        }
        binding.btnCopyEmailAdjuntSecretary.setOnClickListener {
            it.copyTextToClipboard(getString(R.string.bank_details_email_adjunt_secretary))
        }
    }

    private fun getBankAccountForClipboard(): String {
        val agency = getString(R.string.bank_details_account_agency)
        val number = getString(R.string.bank_details_account_number)
        val type = getString(R.string.bank_details_account_type)
        val holder = getString(R.string.bank_details_account_holder)

        return "$holder \n" +
            "$agency \n" +
            "$number \n" + type
    }
}
