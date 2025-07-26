package br.com.lconeto.manualdomc.meeting.presentation.check

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lconeto.manualdomc.databinding.BottomSheetMeetingTypeBinding
import br.com.lconeto.manualdomc.meeting.data.check.MeetingCheckListType
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MeetingCheckListDialogFragment(
    private val meetingCheckListTypeSelected: MeetingCheckListTypeSelected
) : BottomSheetDialogFragment() {

    private var _binding: BottomSheetMeetingTypeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetMeetingTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.organizationButton.setOnClickListener {
            meetingCheckListTypeSelected.navigateToCheckList(type = MeetingCheckListType.ORGANIZATION)
        }

        binding.initializationButton.setOnClickListener {
            meetingCheckListTypeSelected.navigateToCheckList(type = MeetingCheckListType.INITIALIZATION)
        }

        binding.elevationButton.setOnClickListener {
            meetingCheckListTypeSelected.navigateToCheckList(type = MeetingCheckListType.ELEVATION)
        }

        binding.publicButton.setOnClickListener {
            meetingCheckListTypeSelected.navigateToCheckList(type = MeetingCheckListType.PUBLIC)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
