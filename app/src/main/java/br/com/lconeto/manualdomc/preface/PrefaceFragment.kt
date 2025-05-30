package br.com.lconeto.manualdomc.preface

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.lconeto.manualdomc.databinding.FragmentPrefaceBinding

class PrefaceFragment : Fragment() {

    private var _binding: FragmentPrefaceBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val prefaceViewModel =
            ViewModelProvider(this)[PrefaceViewModel::class.java]

        _binding = FragmentPrefaceBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        prefaceViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}