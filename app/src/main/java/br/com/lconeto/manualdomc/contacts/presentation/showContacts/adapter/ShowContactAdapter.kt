package br.com.lconeto.manualdomc.contacts.presentation.showContacts.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
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
                contactEmail.setOnClickListener {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:${contact.email}")
                    }
                    if (intent.resolveActivity(it.context.packageManager) != null) {
                        it.context.startActivity(intent)
                    } else {
                        Toast.makeText(
                            it.context,
                            "Nenhum aplicativo de e-mail encontrado.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                copyEmail.setOnClickListener {
                    copyTextToClipboard(it.context, contact.email, "E-mail copiado!")
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
            contactPhone.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${contact.cellphone.filter { it.isDigit() }}")
                }
                if (intent.resolveActivity(it.context.packageManager) != null) {
                    it.context.startActivity(intent)
                } else {
                    Toast.makeText(
                        it.context,
                        "Nenhum aplicativo de telefone encontrado.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            copyPhone.setOnClickListener {
                copyTextToClipboard(it.context, contact.cellphone, "Telefone copiado!")
            }
        }

        private fun copyTextToClipboard(context: Context, text: String, message: String) {
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Copied Text", text)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}
