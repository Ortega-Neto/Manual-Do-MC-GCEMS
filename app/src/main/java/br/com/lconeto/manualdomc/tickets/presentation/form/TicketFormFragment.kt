package br.com.lconeto.manualdomc.tickets.presentation.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.domain.extensions.copyTextToClipboard
import br.com.lconeto.manualdomc.common.domain.extensions.navigateTo
import br.com.lconeto.manualdomc.common.domain.extensions.setTitleName
import br.com.lconeto.manualdomc.databinding.FragmentTicketFormBinding
import br.com.lconeto.manualdomc.tickets.data.StepByStepTicket
import br.com.lconeto.manualdomc.tickets.data.TicketModel
import com.google.android.material.textfield.TextInputLayout

class TicketFormFragment : Fragment() {
    private val args: TicketFormFragmentArgs by navArgs()
    private var _binding: FragmentTicketFormBinding? = null
    private var inputs = listOf<TicketFormTextInput>()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTicketFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tittle = if (args.isAuth) R.string.ticket_auth else R.string.ticket_email
        setTitleName(getString(tittle))

        setupInputs()
        setupListeners()
    }

    private fun setupInputs() {
        inputs = listOf(
            TicketFormTextInput(true, binding.textInputLayoutMC),
            TicketFormTextInput(true, binding.textInputLayoutChapter),
            TicketFormTextInput(true, binding.textInputLayoutChapterNumber),
            TicketFormTextInput(!args.isAuth, binding.textInputLayoutName),
            TicketFormTextInput(!args.isAuth, binding.textInputLayoutId),
            TicketFormTextInput(!args.isAuth, binding.textInputLayoutEmail),
            TicketFormTextInput(args.isAuth, binding.textInputLayoutStore),
            TicketFormTextInput(args.isAuth, binding.textInputLayoutStoreNumber),
            TicketFormTextInput(args.isAuth, binding.textInputLayoutDay),
            TicketFormTextInput(args.isAuth, binding.textInputLayoutHour),
            TicketFormTextInput(args.isAuth, binding.textInputLayoutPackage)
        )
        inputs.forEach {
            if (!it.isToShow) {
                it.input.visibility = View.GONE
            }
        }
    }

    private fun setupListeners() {
        binding.copyButton.setOnClickListener {
            validateAndCreateModel()
        }
    }

    private fun validateAndCreateModel() {
        var canCreateModel = true

        inputs.forEach {
            val editText = it.input.editText
            if (it.input.isVisible && editText?.text.isNullOrBlank()) {
                it.input.error = getString(R.string.ticket_error_missing_input)
                it.input.isErrorEnabled = true
                canCreateModel = false
            } else {
                it.input.error = null
                it.input.isErrorEnabled = false
            }
        }

        if (canCreateModel) {
            copyTextToClipboard(createTextForClipboard())
            val action = TicketFormFragmentDirections.actionTicketFormFragmentToCheckListFragment(
                checkList = StepByStepTicket.checkList,
                checkObservation = StepByStepTicket.getObservationForTicket(args.isAuth),
                screenName = getString(R.string.ticket_create)
            )
            navigateTo(action)
        }
    }

    private fun createTextForClipboard(): String {
        return if (args.isAuth) {
            TicketModel.getStringFromAuthModel(
                chapter = binding.editTextChapter.text.toString(),
                chapterNumber = binding.editTextChapterNumber.text.toString().toInt(),
                store = binding.editTextStore.text.toString(),
                storeNumber = binding.editTextStoreNumber.text.toString().toInt(),
                day = binding.editTextDay.text.toString(),
                hour = binding.editTextHour.text.toString(),
                packageId = binding.editTextPackage.text.toString(),
                mcName = binding.editTextMC.text.toString()
            )
        } else {
            TicketModel.getStringFromEmailModel(
                chapter = binding.editTextChapter.text.toString(),
                chapterNumber = binding.editTextChapterNumber.text.toString().toInt(),
                name = binding.editTextName.text.toString(),
                id = binding.editTextId.text.toString().toInt(),
                email = binding.editTextEmail.text.toString(),
                mcName = binding.editTextMC.text.toString()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class TicketFormTextInput(
    val isToShow: Boolean,
    val input: TextInputLayout
)
