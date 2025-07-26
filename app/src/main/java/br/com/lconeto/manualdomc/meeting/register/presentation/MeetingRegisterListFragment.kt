package br.com.lconeto.manualdomc.meeting.register.presentation

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.domain.extensions.navigateTo
import br.com.lconeto.manualdomc.common.domain.extensions.setTitleName
import br.com.lconeto.manualdomc.common.domain.extensions.toastMessage
import br.com.lconeto.manualdomc.common.presentation.loading.LoadingDialog
import br.com.lconeto.manualdomc.common.presentation.meeting.MeetingMemoryViewModel
import br.com.lconeto.manualdomc.databinding.FragmentMeetingRegisterListBinding
import br.com.lconeto.manualdomc.meeting.index.data.MeetingData
import br.com.lconeto.manualdomc.meeting.register.presentation.adapter.MeetingListAdapter
import kotlinx.coroutines.launch

class MeetingRegisterListFragment : Fragment() {

    private var _binding: FragmentMeetingRegisterListBinding? = null
    private val binding get() = _binding!!

    private val meetingMemoryViewModel by lazy {
        ViewModelProvider(
            this,
            MeetingMemoryViewModel.Factory(requireContext())
        )[MeetingMemoryViewModel::class.java]
    }
    private lateinit var loadingDialog: LoadingDialog
    private lateinit var adapter: MeetingListAdapter // Declare it here

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMeetingRegisterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitleName(getString(R.string.meeting_register))

        setupRecyclerView()
        getMeetings()
    }

    private fun getMeetings() {
        lifecycleScope.launch {
            loadingDialog = LoadingDialog(
                context = requireContext(),
                message = getString(R.string.meeting_register_searching)
            )
            loadingDialog.show()

            meetingMemoryViewModel.getMeetings().collect { meetings ->
                verifyEmptyMeetings(meetings)
                loadingDialog.dismiss()
            }
        }
    }

    private fun verifyEmptyMeetings(meetings: List<MeetingData>) {
        if (meetings.isNotEmpty()) {
            adapter.submitList(meetings)
        } else {
            toastMessage("Nenhuma reunião registrada ainda!")
            findNavController().popBackStack()
        }
    }

    private fun setupRecyclerView() {
        adapter = MeetingListAdapter(
            onItemClick = { meeting ->
                navigateTo(
                    action = MeetingRegisterListFragmentDirections
                        .actionMeetingRegisterListFragmentToMeetingFragmentReport(
                            meetingData = meeting,
                            isNewMeeting = false
                        )
                )
            },
            onDeleteClick = { meeting ->
                showDeleteConfirmationDialog(meeting)
            }
        )
        val recyclerView = binding.recyclerViewMeetings
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun showDeleteConfirmationDialog(meeting: MeetingData) {
        AlertDialog.Builder(requireContext())
            .setTitle("Confirmar Exclusão")
            .setMessage("Tem certeza que deseja excluir a reunião do dia ${meeting.day} (${meeting.startHour})?")
            .setPositiveButton("Excluir") { dialog, which ->
                deleteMeeting(meeting)
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun deleteMeeting(meeting: MeetingData) {
        lifecycleScope.launch {
            loadingDialog = LoadingDialog(
                context = requireContext(),
                message = getString(R.string.meeting_register_deleting)
            )
            loadingDialog.show()

            meetingMemoryViewModel.deleteMeeting(meeting)
            toastMessage("Reunião removida com sucesso!")
            loadingDialog.dismiss()
            getMeetings()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
