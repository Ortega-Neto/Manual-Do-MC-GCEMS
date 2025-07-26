package br.com.lconeto.manualdomc.meeting.presentation.follow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.presentation.check.CheckListAdapter
import br.com.lconeto.manualdomc.databinding.FragmentMeetingFollowUpBinding
import br.com.lconeto.manualdomc.meeting.data.follow.OrderOfBusiness
import com.google.android.material.textfield.TextInputLayout
import com.vicmikhailau.maskededittext.MaskedEditText

class MeetingFollowUpFragment : Fragment() {

    private var _binding: FragmentMeetingFollowUpBinding? = null
    private val binding get() = _binding!!
    private val args: MeetingFollowUpFragmentArgs by navArgs()

    private var agendaItems = listOf<String>()

//    private lateinit var agendaStatusAdapter: AgendaStatusAdapter

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

//        val actualAgendaItems = agendaItems
//        agendaStatusAdapter = AgendaStatusAdapter(actualAgendaItems)
//        binding.recyclerViewAgenda.apply {
//            layoutManager = LinearLayoutManager(context)
//            adapter = agendaStatusAdapter
//            isNestedScrollingEnabled = false
//        }
    }

    private fun setupListeners() {
        binding.finalizeButton.setOnClickListener {
            if (validateForm()) {
                // All fields are valid, proceed with finalization logic
                Toast.makeText(requireContext(), "Formulário finalizado com sucesso!", Toast.LENGTH_SHORT).show()
                // Here you would collect all data (including checkbox states, agenda statuses, etc.)
                // and potentially send it to a backend or save it locally.
            } else {
                Toast.makeText(
                    requireContext(),
                    "Por favor, preencha os campos obrigatórios.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun setupDonationInput() {
        // Apply the MoneyTextWatcher to the donation EditText
//        binding.editTextDonation.addTextChangedListener(MoneyTextWatcher(binding.editTextDonation))
    }

    private fun validateForm(): Boolean {
        var isValid = true

        // Validate Donation field
        isValid = validateDonationField(binding.textInputLayoutDonation, binding.editTextDonation) && isValid

        // Validate Finish Hour field
        isValid = validateMaskedEditText(binding.textInputLayoutFinishHour, binding.editTextFinishHour, 5) && isValid // ##h## is 5 chars

        return isValid
    }

    private fun validateDonationField(
        textInputLayout: TextInputLayout,
        editText: MaskedEditText
    ): Boolean {
        val text = editText.text.toString().trim()
        // After MoneyTextWatcher, the text will be formatted like "R$ 1.234,56"
        // We need to check if it's more than just "R$ 0,00" or empty
        if (text.isEmpty() || text == "R$ 0,00" || text == "R$") { // Check for empty or just mask
            textInputLayout.error = getString(R.string.meeting_follow_error_missing_input)
            return false
        }
        textInputLayout.error = null
        return true
    }

    private fun validateMaskedEditText(
        textInputLayout: TextInputLayout,
        editText: MaskedEditText,
        expectedLength: Int
    ): Boolean {
        val text = editText.text.toString().trim()
        val maskAppliedText = editText.text.toString() // Get text with mask characters

        // Check if field is empty or if the masked input is not fully filled
        if (text.isEmpty() || maskAppliedText.length < expectedLength) {
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

    // Adapter for "Ordem do Dia" (list_item_agenda_status.xml)
    // This is similar to the one used in MeetingReportFragment
//    class AgendaStatusAdapter(private val items: List<String>) :
//        RecyclerView.Adapter<AgendaStatusAdapter.AgendaStatusViewHolder>() {
//
//        inner class AgendaStatusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//            val itemNumber: TextView = itemView.findViewById(R.id.tv_agenda_item_number)
//            val itemDescription: TextView = itemView.findViewById(R.id.tv_agenda_item_description)
//            val cbApproved: CheckBox = itemView.findViewById(R.id.cb_approved)
//            val cbRejected: CheckBox = itemView.findViewById(R.id.cb_rejected)
//            val cbPostponed: CheckBox = itemView.findViewById(R.id.cb_postponed)
//
//            init {
//                // Ensure only one checkbox can be selected
//                val checkBoxes = listOf(cbApproved, cbRejected, cbPostponed)
//                checkBoxes.forEach { checkBox ->
//                    checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
//                        if (isChecked) {
//                            checkBoxes.forEach { otherCheckBox ->
//                                if (otherCheckBox != buttonView) {
//                                    otherCheckBox.isChecked = false
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgendaStatusViewHolder {
//            val view = LayoutInflater.from(parent.context)
//                .inflate(R.layout.list_item_agenda_status, parent, false)
//            return AgendaStatusViewHolder(view)
//        }
//
//        override fun onBindViewHolder(holder: AgendaStatusViewHolder, position: Int) {
//            holder.itemNumber.text = "${position + 1}."
//            holder.itemDescription.text = items[position]
//            // You would load the saved status (approved, rejected, postponed) here
//            // For now, they are unchecked by default
//            holder.cbApproved.isChecked = false
//            holder.cbRejected.isChecked = false
//            holder.cbPostponed.isChecked = false
//        }
//
//        override fun getItemCount(): Int = items.size
//    }
}
