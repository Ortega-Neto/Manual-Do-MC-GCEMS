package br.com.lconeto.manualdomc.meeting.presentation.tips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.domain.extensions.setTitleName
import br.com.lconeto.manualdomc.databinding.FragmentMeetingTipsBinding
import br.com.lconeto.manualdomc.meeting.data.MeetingPlanningTips

class MeetingTipsFragment : Fragment() {
    private var _binding: FragmentMeetingTipsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMeetingTipsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitleName(getString(R.string.meeting_tips))

        setupTexts()
    }

    private fun setupTexts() {
        MeetingPlanningTips.let {
            binding.firstTip.componentTipTitle.text = it.TIP_1_TITLE
            binding.firstTip.componentTipDescription.text = it.TIP_1_DESCRIPTION

            binding.secondTip.componentTipTitle.text = it.TIP_2_TITLE
            binding.secondTip.componentTipDescription.text = it.TIP_2_DESCRIPTION

            binding.thirdTip.componentTipTitle.text = it.TIP_3_TITLE
            binding.thirdTip.componentTipDescription.text = it.TIP_3_DESCRIPTION

            binding.fourthTip.componentTipTitle.text = it.TIP_4_TITLE
            binding.fourthTip.componentTipDescription.text = it.TIP_4_DESCRIPTION

            binding.fifthTip.componentTipTitle.text = it.TIP_5_TITLE
            binding.fifthTip.componentTipDescription.text = it.TIP_5_DESCRIPTION

            binding.sixthTip.componentTipTitle.text = it.TIP_6_TITLE
            binding.sixthTip.componentTipDescription.text = it.TIP_6_DESCRIPTION

            binding.seventhTip.componentTipTitle.text = it.TIP_7_TITLE
            binding.seventhTip.componentTipDescription.text = it.TIP_7_DESCRIPTION
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
