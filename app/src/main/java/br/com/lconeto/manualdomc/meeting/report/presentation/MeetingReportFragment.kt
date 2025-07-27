package br.com.lconeto.manualdomc.meeting.report.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.domain.extensions.copyTextToClipboard
import br.com.lconeto.manualdomc.common.domain.extensions.navigateTo
import br.com.lconeto.manualdomc.common.presentation.loading.LoadingDialog
import br.com.lconeto.manualdomc.common.presentation.meeting.MeetingMemoryViewModel
import br.com.lconeto.manualdomc.databinding.FragmentMeetingReportBinding
import br.com.lconeto.manualdomc.meeting.report.presentation.adapter.AgendaAdapter
import kotlinx.coroutines.launch

class MeetingReportFragment : Fragment() {
    private var _binding: FragmentMeetingReportBinding? = null
    private val binding get() = _binding!!
    private val args: MeetingReportFragmentArgs by navArgs()

    private val meetingMemoryViewModel by lazy {
        ViewModelProvider(
            this,
            MeetingMemoryViewModel.Factory(requireContext())
        )[MeetingMemoryViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMeetingReportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        setupButton()
    }

    private fun setupUI() {
        val meetingData = args.meetingData

        binding.tvDate.text = meetingData.day
        binding.tvStartTime.text = meetingData.startHour
        binding.tvEndTime.text = meetingData.finishHour
        binding.tvDonationsValue.text = meetingData.donations
        binding.tvWordOfDay.text = meetingData.wordOfTheDay
        binding.textViewReportRoles.text = meetingData.roles

        val agendaAdapter = AgendaAdapter(meetingData.agendaItems)
        binding.recyclerViewReviewAgendaItems.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = agendaAdapter
        }
    }

    private fun setupButton() {
        val buttonText = if (args.isNewMeeting) {
            R.string.meeting_report_button_save
        } else {
            R.string.meeting_report_button_copy
        }
        binding.saveMeetingButton.text = getString(buttonText)
        binding.saveMeetingButton.setOnClickListener {
            if (args.isNewMeeting) {
                lifecycleScope.launch {
                    val loadingDialog = LoadingDialog(
                        context = requireContext(),
                        getString(R.string.meeting_report_saving_meeting)
                    )
                    loadingDialog.show()
                    meetingMemoryViewModel.saveMeeting(args.meetingData).also {
                        loadingDialog.dismiss()
                        navigateTo(
                            action = MeetingReportFragmentDirections.actionMeetingFragmentReportToNavHome()
                        )
                    }
                }
            } else {
                copyTextToClipboard(args.meetingData.toStringMeeting())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
