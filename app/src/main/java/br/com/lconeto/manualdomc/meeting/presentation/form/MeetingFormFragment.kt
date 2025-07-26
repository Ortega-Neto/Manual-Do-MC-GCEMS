package br.com.lconeto.manualdomc.meeting.presentation.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.domain.extensions.navigateTo
import br.com.lconeto.manualdomc.common.domain.extensions.toStringRoles
import br.com.lconeto.manualdomc.common.domain.extensions.toastMessage
import br.com.lconeto.manualdomc.databinding.FragmentMeetingFormBinding
import br.com.lconeto.manualdomc.meeting.data.MeetingData
import com.google.android.material.textfield.TextInputLayout
import com.vicmikhailau.maskededittext.MaskedEditText
import kotlinx.coroutines.launch

class MeetingFormFragment : Fragment() {

    private var _binding: FragmentMeetingFormBinding? = null
    private val binding get() = _binding!!

    private val agendaItems = mutableListOf<String>()
    private lateinit var agendaAdapter: AgendaAdapter

    private val meetingFormViewModel by lazy {
        ViewModelProvider(
            this,
            MeetingFormViewModel.Factory(requireContext())
        )[MeetingFormViewModel::class.java]
    }
    private var roles: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMeetingFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            meetingFormViewModel.getRoles().collect {
                roles = it.toStringRoles()
            }
        }

        setupRecyclerView()
        setupListeners()
    }

    private fun setupRecyclerView() {
        agendaAdapter = AgendaAdapter(agendaItems)
        binding.recyclerViewAgendaItems.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = agendaAdapter
        }
    }

    private fun setupListeners() {
        binding.textInputLayoutAgenda.setEndIconOnClickListener {
            addAgendaItem()
        }

        binding.editTextAgenda.setOnEditorActionListener { _, actionId, event ->
            val isEnterKeyPressed = (
                event?.keyCode == android.view.KeyEvent.KEYCODE_ENTER &&
                    event.action == android.view.KeyEvent.ACTION_DOWN
                )
            val isDoneAction = (actionId == EditorInfo.IME_ACTION_DONE)

            if (isDoneAction || isEnterKeyPressed) {
                addAgendaItem()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }

        binding.advanceButton.setOnClickListener {
            if (validateForm()) createMeetingAndNavigate()
        }
    }

    private fun addAgendaItem() {
        val newItem = binding.editTextAgenda.text.toString().trim()
        if (newItem.isNotBlank()) {
            agendaItems.add(newItem)
            agendaAdapter.notifyItemInserted(agendaItems.size - 1)
            binding.editTextAgenda.text?.clear()
            binding.recyclerViewAgendaItems.scrollToPosition(agendaItems.size - 1)
        } else {
            toastMessage(getString(R.string.meeting_form_error_missing_agenda))
        }
    }

    private fun validateForm(): Boolean {
        var isValid = true

        isValid = validateMaskedEditText(
            binding.textInputLayoutDay, binding.editTextDay
        ) && isValid
        isValid = validateMaskedEditText(
            binding.textInputLayoutStartHour, binding.editTextStartHour
        ) && isValid

        isValid = validateTextInputEditText(
            binding.textInputLayoutWordOfTheDay, binding.editTextWordOfTheDay
        ) && isValid

        if (agendaItems.isEmpty()) {
            toastMessage(getString(R.string.meeting_form_error_missing_agenda))
            isValid = false
        }

        return isValid
    }

    private fun validateMaskedEditText(
        textInputLayout: TextInputLayout,
        editText: MaskedEditText
    ): Boolean {
        val text = editText.text.toString().trim()

        if (text.isEmpty()) {
            textInputLayout.error = getString(R.string.meeting_form_error_missing_input)
            return false
        }
        textInputLayout.error = null
        return true
    }

    private fun validateTextInputEditText(
        textInputLayout: TextInputLayout,
        editText: com.google.android.material.textfield.TextInputEditText
    ): Boolean {
        val text = editText.text.toString().trim()
        if (text.isEmpty()) {
            textInputLayout.error = getString(R.string.meeting_form_error_missing_input)
            return false
        }
        textInputLayout.error = null
        return true
    }

    private fun createMeetingAndNavigate() {
        val meetingData = MeetingData(
            day = binding.editTextDay.text.toString(),
            startHour = binding.editTextStartHour.text.toString(),
            wordOfTheDay = binding.editTextWordOfTheDay.text.toString(),
            agendaItems = agendaItems,
            roles = roles
        )

        navigateTo(
            action = MeetingFormFragmentDirections.actionMeetingFormFragmentToMeetingFollowUpFragment(
                meetingData = meetingData
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
