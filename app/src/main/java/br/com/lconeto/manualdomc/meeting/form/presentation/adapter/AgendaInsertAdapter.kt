package br.com.lconeto.manualdomc.meeting.form.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.lconeto.manualdomc.databinding.ListItemAgendaInsertBinding

class AgendaInsertAdapter(
    private val items: MutableList<String>,
    private val onDeleteClick: (String) -> Unit
) : RecyclerView.Adapter<AgendaInsertAdapter.MeetingListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeetingListViewHolder {
        val binding =
            ListItemAgendaInsertBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MeetingListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MeetingListViewHolder, position: Int) {
        val items = items[position]
        holder.bind(items, onDeleteClick)
    }

    override fun getItemCount(): Int = items.size

    class MeetingListViewHolder(private val binding: ListItemAgendaInsertBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            itemText: String,
            onDeleteClick: (String) -> Unit
        ) {
            binding.tvAgendaTittle.text = itemText

            binding.ivDeleteMeeting.setOnClickListener {
                onDeleteClick(itemText)
            }
        }
    }
}
