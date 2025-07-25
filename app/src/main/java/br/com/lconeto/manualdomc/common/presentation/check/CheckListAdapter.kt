package br.com.lconeto.manualdomc.common.presentation.check

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.lconeto.manualdomc.databinding.ComponentCheckBoxBinding

class CheckListAdapter(private val checkListItems: List<String>) :
    RecyclerView.Adapter<CheckListAdapter.CheckListViewHolder>() {

    class CheckListViewHolder(val binding: ComponentCheckBoxBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckListViewHolder {
        val binding = ComponentCheckBoxBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CheckListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CheckListViewHolder, position: Int) {
        val itemText = checkListItems[position]

        holder.binding.checkboxItem.text = itemText

        holder.binding.checkboxItem.isChecked = false
        holder.binding.checkboxItem.paintFlags = holder.binding.checkboxItem.paintFlags and
            Paint.STRIKE_THRU_TEXT_FLAG.inv()

        holder.binding.checkboxItem.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                holder.binding.checkboxItem.paintFlags = holder.binding.checkboxItem.paintFlags or
                    Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                holder.binding.checkboxItem.paintFlags = holder.binding.checkboxItem.paintFlags and
                    Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
        }
    }

    override fun getItemCount(): Int {
        return checkListItems.size
    }
}
