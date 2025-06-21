package br.com.lconeto.manualdomc.contacts.presentation.showContacts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.lconeto.manualdomc.common.domain.extensions.copyTextToClipboard
import br.com.lconeto.manualdomc.contacts.data.Contact
import br.com.lconeto.manualdomc.databinding.ListItemContactBinding

class ShowContactAdapter(private val contacts: List<Contact>) :
    RecyclerView.Adapter<ShowContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ListItemContactBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int = contacts.size

    inner class ContactViewHolder(private val binding: ListItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: Contact) {
            with(binding) {
                contactName.text = contact.name
                contactTitle.text = contact.function

                setEmail(contact)
                setCellphone(contact)
            }
        }

        private fun ListItemContactBinding.setEmail(contact: Contact) {
            if (contact.email.isNotBlank()) {
                iconEmail.visibility = android.view.View.VISIBLE
                labelEmail.visibility = android.view.View.VISIBLE
                contactEmail.visibility = android.view.View.VISIBLE
                copyEmail.visibility = android.view.View.VISIBLE

                contactEmail.text = contact.email
                copyEmail.setOnClickListener {
                    it.copyTextToClipboard(contact.email)
                }
            } else {
                iconEmail.visibility = android.view.View.GONE
                labelEmail.visibility = android.view.View.GONE
                contactEmail.visibility = android.view.View.GONE
                copyEmail.visibility = android.view.View.GONE
            }
        }

        private fun ListItemContactBinding.setCellphone(contact: Contact) {
            contactPhone.text = contact.cellphone
            copyPhone.setOnClickListener {
                it.copyTextToClipboard(contact.cellphone)
            }
        }
    }
}
