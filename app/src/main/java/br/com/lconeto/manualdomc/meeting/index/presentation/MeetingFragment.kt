package br.com.lconeto.manualdomc.meeting.index.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.data.entity.check.CheckList
import br.com.lconeto.manualdomc.common.data.entity.check.CheckObservation
import br.com.lconeto.manualdomc.common.domain.extensions.navigateTo
import br.com.lconeto.manualdomc.common.domain.extensions.setTitleName
import br.com.lconeto.manualdomc.databinding.FragmentMeetingBinding
import br.com.lconeto.manualdomc.meeting.check.data.MeetingCheckListType
import br.com.lconeto.manualdomc.meeting.check.presentation.MeetingCheckListDialogFragment
import br.com.lconeto.manualdomc.meeting.check.presentation.MeetingCheckListTypeSelected
import br.com.lconeto.manualdomc.meeting.index.data.types.MeetingClassRoomOrganization
import br.com.lconeto.manualdomc.meeting.index.data.types.MeetingElevation
import br.com.lconeto.manualdomc.meeting.index.data.types.MeetingInitialization
import br.com.lconeto.manualdomc.meeting.index.data.types.MeetingPublic

class MeetingFragment : Fragment() {
    private var _binding: FragmentMeetingBinding? = null

    private val binding get() = _binding!!
    private lateinit var bottomSheet: MeetingCheckListDialogFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMeetingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitleName(getString(R.string.home_meeting))

        populateButtons()
        setupListeners()
    }

    private fun populateButtons() {
        binding.meetingTips.textContactTitle.text = getString(R.string.meeting_tips)
        binding.meetingTips.imageContactTitle.setImageResource(R.drawable.ic_meeting_tips)
        binding.meetingCheckList.textContactTitle.text = getString(R.string.meeting_check_list)
        binding.meetingCheckList.imageContactTitle.setImageResource(R.drawable.ic_meeting_check_list)
        binding.meetingRoles.textContactTitle.text = getString(R.string.meeting_roles)
        binding.meetingRoles.imageContactTitle.setImageResource(R.drawable.ic_role)
        binding.meetingForm.textContactTitle.text = getString(R.string.meeting_follow)
        binding.meetingForm.imageContactTitle.setImageResource(R.drawable.ic_meeting_follow)
        binding.meetingRegister.textContactTitle.text = getString(R.string.meeting_register)
        binding.meetingRegister.imageContactTitle.setImageResource(R.drawable.ic_meeting_register)
    }

    private fun setupListeners() {
        binding.meetingTips.root.setOnClickListener {
            navigateTo(
                action = MeetingFragmentDirections.actionMeetingFragmentToMeetingTipsFragment()
            )
        }
        binding.meetingCheckList.root.setOnClickListener {
            showBottomSheet()
        }
        binding.meetingRoles.root.setOnClickListener {
            navigateTo(
                action = MeetingFragmentDirections.actionMeetingFragmentToEditRolesFragment()
            )
        }
        binding.meetingForm.root.setOnClickListener {
            navigateTo(
                action = MeetingFragmentDirections.actionMeetingFragmentToMeetingFormFragment()
            )
        }
        binding.meetingRegister.root.setOnClickListener {
            navigateTo(
                action = MeetingFragmentDirections.actionMeetingFragmentToMeetingRegisterListFragment()
            )
        }
    }

    private fun showBottomSheet() {
        bottomSheet = MeetingCheckListDialogFragment(
            object : MeetingCheckListTypeSelected {
                override fun navigateToCheckList(type: MeetingCheckListType) {
                    when (type) {
                        MeetingCheckListType.ORGANIZATION -> {
                            navigateToCheckList(
                                checkList = MeetingClassRoomOrganization.checkList,
                                screenName = R.string.meeting_organization
                            )
                        }
                        MeetingCheckListType.INITIALIZATION -> {
                            navigateToCheckList(
                                checkList = MeetingInitialization.checkList,
                                checkObservation = MeetingInitialization.observation,
                                screenName = R.string.meeting_initialization
                            )
                        }
                        MeetingCheckListType.ELEVATION -> {
                            navigateToCheckList(
                                checkList = MeetingElevation.checkList,
                                checkObservation = MeetingElevation.observation,
                                screenName = R.string.meeting_elevation
                            )
                        }
                        MeetingCheckListType.PUBLIC -> {
                            navigateToCheckList(
                                checkList = MeetingPublic.checkList,
                                checkObservation = MeetingPublic.observation,
                                screenName = R.string.meeting_public
                            )
                        }
                    }
                }
            }
        )
        bottomSheet.show(requireActivity().supportFragmentManager, bottomSheet.tag)
    }

    private fun navigateToCheckList(
        checkList: CheckList,
        checkObservation: CheckObservation? = null,
        screenName: Int
    ) {
        navigateTo(
            action = MeetingFragmentDirections.actionMeetingFragmentToCheckListFragment(
                checkList = checkList,
                checkObservation = checkObservation,
                screenName = getString(screenName)
            )
        )
        bottomSheet.dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
