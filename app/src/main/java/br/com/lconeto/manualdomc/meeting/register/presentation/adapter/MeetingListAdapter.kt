package br.com.lconeto.manualdomc.meeting.register.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.lconeto.manualdomc.databinding.ListItemMeetingBinding
import br.com.lconeto.manualdomc.meeting.index.data.MeetingData

class MeetingListAdapter(
    private var meetings: MutableList<MeetingData> = mutableListOf(),
    private val onItemClick: (MeetingData) -> Unit,
    private val onDeleteClick: (MeetingData) -> Unit
) : RecyclerView.Adapter<MeetingListAdapter.MeetingListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeetingListViewHolder {
        val binding = ListItemMeetingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MeetingListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MeetingListViewHolder, position: Int) {
        val meeting = meetings[position]
        holder.bind(meeting, onItemClick, onDeleteClick)
    }

    override fun getItemCount(): Int = meetings.size

    fun submitList(newMeetings: List<MeetingData>) {
        meetings.clear()
        meetings.addAll(newMeetings)
        notifyDataSetChanged()
    }

    class MeetingListViewHolder(private val binding: ListItemMeetingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            meeting: MeetingData,
            onItemClick: (MeetingData) -> Unit,
            onDeleteClick: (MeetingData) -> Unit
        ) {
            binding.tvMeetingDate.text = meeting.day
            binding.tvMeetingTime.text = "${meeting.startHour} - ${meeting.finishHour}"
            binding.tvMeetingWordOfTheDay.text = "Palavra do dia: ${meeting.wordOfTheDay}"

            binding.root.setOnClickListener {
                onItemClick(meeting)
            }

            binding.ivDeleteMeeting.setOnClickListener {
                onDeleteClick(meeting)
            }
        }
    }
}
