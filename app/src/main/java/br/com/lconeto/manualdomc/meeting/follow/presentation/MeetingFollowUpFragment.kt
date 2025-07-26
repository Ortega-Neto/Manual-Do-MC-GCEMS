package br.com.lconeto.manualdomc.meeting.follow.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.domain.extensions.navigateTo
import br.com.lconeto.manualdomc.common.domain.watcher.MoneyTextWatcher
import br.com.lconeto.manualdomc.common.presentation.check.CheckListAdapter
import br.com.lconeto.manualdomc.databinding.FragmentMeetingFollowUpBinding
import br.com.lconeto.manualdomc.meeting.follow.data.OrderOfBusiness
import br.com.lconeto.manualdomc.meeting.form.presentation.adapter.AgendaAdapter
import com.google.android.material.textfield.TextInputLayout
import com.vicmikhailau.maskededittext.MaskedEditText

class MeetingFollowUpFragment : Fragment() {

    private var _binding: FragmentMeetingFollowUpBinding? = null
    private val binding get() = _binding!!
    private val args: MeetingFollowUpFragmentArgs by navArgs()

    private var agendaItems = listOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMeetingFollowUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        agendaItems = args.meetingData.agendaItems

        setupRecyclerViews()
        setupListeners()
        setupDonationInput()
    }

    private fun setupRecyclerViews() {
        binding.recyclerViewOrderOfBusiness.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CheckListAdapter(OrderOfBusiness.list)
            isNestedScrollingEnabled = false
        }

        binding.recyclerViewAgenda.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = AgendaAdapter(agendaItems)
            isNestedScrollingEnabled = false
        }
    }

    private fun setupListeners() {
        binding.finalizeButton.setOnClickListener {
            if (validateForm()) {
                args.meetingData.finishHour = binding.editTextFinishHour.text.toString()
                args.meetingData.donations = binding.editTextDonation.text.toString()

                navigateTo(
                    action = MeetingFollowUpFragmentDirections.actionMeetingFollowUpFragmentToMeetingFragmentReport(
                        meetingData = args.meetingData,
                        isNewMeeting = true
                    )
                )
            }
        }
    }

    private fun setupDonationInput() {
        binding.editTextDonation.addTextChangedListener(MoneyTextWatcher(binding.editTextDonation))
    }

    private fun validateForm(): Boolean {
        var isValid = true
        isValid = validateDonationField(binding.textInputLayoutDonation, binding.editTextDonation) && isValid
        isValid = validateMaskedEditText(binding.textInputLayoutFinishHour, binding.editTextFinishHour) && isValid

        return isValid
    }

    private fun validateDonationField(
        textInputLayout: TextInputLayout,
        editText: MaskedEditText
    ): Boolean {
        val text = editText.text.toString().trim()
        if (text.isEmpty() || text == "R$") {
            textInputLayout.error = getString(R.string.meeting_follow_error_missing_input)
            return false
        }
        textInputLayout.error = null
        return true
    }

    private fun validateMaskedEditText(
        textInputLayout: TextInputLayout,
        editText: MaskedEditText
    ): Boolean {
        val text = editText.text.toString().trim()

        if (text.isEmpty()) {
            textInputLayout.error = getString(R.string.meeting_follow_error_missing_input)
            return false
        }
        textInputLayout.error = null
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
