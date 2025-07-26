package br.com.lconeto.manualdomc.meeting.form.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.lconeto.manualdomc.R

class AgendaAdapter(private val items: List<String>) :
    RecyclerView.Adapter<AgendaAdapter.AgendaViewHolder>() {

    inner class AgendaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text_agenda_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgendaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_agenda_text, parent, false)
        return AgendaViewHolder(view)
    }

    override fun onBindViewHolder(holder: AgendaViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    override fun getItemCount(): Int = items.size
}
