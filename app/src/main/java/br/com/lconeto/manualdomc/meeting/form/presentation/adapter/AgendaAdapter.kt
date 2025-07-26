package br.com.lconeto.manualdomc.meeting.form.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.lconeto.manualdomc.databinding.ListItemAgendaTextBinding // Importe o binding gerado

class AgendaAdapter(private val items: List<String>) :
    RecyclerView.Adapter<AgendaAdapter.AgendaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgendaViewHolder {
        val binding = ListItemAgendaTextBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AgendaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AgendaViewHolder, position: Int) {
        val agendaItem = items[position]
        holder.bind(agendaItem)
    }

    override fun getItemCount(): Int = items.size

    class AgendaViewHolder(private val binding: ListItemAgendaTextBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(itemText: String) {
            binding.textAgendaItem.text = itemText
        }
    }
}
