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
        _binding = FragmentPrefaceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textPrefaceDescription.text = """
            Um novo capítulo se desvela diante de você, trazendo a nobre responsabilidade de liderar aqueles que confiam em sua capacidade. O Guia para Mestres Conselheiros será seu farol, iluminando sua jornada e ajudando a enfrentar desafios e a aproveitar oportunidades de crescimento.
            
            Lembre-se, você é mais do que um "indivíduo com um colar". Você é o maestro de uma sinfonia, unindo talentos. Trabalhe em equipe, distribua responsabilidades e fortaleça a união, pois é assim que formamos líderes e fortalecemos o futuro.
            
            A rica história de seu capítulo agora está em suas mãos. Como arquiteto do futuro, molde cada página com sabedoria, pois suas ações ecoarão no tempo, influenciando as próximas gerações.
            
            Liderar na Ordem DeMolay é inspirar e servir. Mostre que seus irmãos são essenciais para manter viva a chama eterna dessa Nobre Causa. Seja exemplo de humildade e caridade, provando que a chama jamais se apagará enquanto houver liderança com propósito.
            
            Avance com coragem e resiliência. A confiança depositada em você reflete seu potencial. Deixe um legado que ilumine o caminho para as gerações futuras e fortaleça a Ordem DeMolay.
        """.trimIndent()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}