package br.com.lconeto.manualdomc.packages.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.domain.extensions.navigateTo
import br.com.lconeto.manualdomc.common.domain.extensions.setTitleName
import br.com.lconeto.manualdomc.databinding.FragmentPackagesBinding
import br.com.lconeto.manualdomc.packages.data.SendPackageToCGEMS
import br.com.lconeto.manualdomc.packages.data.StepByStepPackage

class PackagesFragment : Fragment() {
    private var _binding: FragmentPackagesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPackagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitleName(getString(R.string.home_packages))

        setupInitializationMessage()
        populateButtons()
        setupListeners()
    }

    private fun setupInitializationMessage() {
        binding.textViewPackages.text = ALERT_INITIALIZATION
    }

    private fun populateButtons() {
        binding.packageCreate.textContactTitle.text = getString(R.string.package_create)
        binding.packageCreate.imageContactTitle.setImageResource(R.drawable.ic_package_create)
        binding.packageSend.textContactTitle.text = getString(R.string.package_send)
        binding.packageSend.imageContactTitle.setImageResource(R.drawable.ic_package_send)
    }

    private fun setupListeners() {
        binding.packageCreate.root.setOnClickListener {
            val checkList = StepByStepPackage.checkList
            val checkObservation = StepByStepPackage.checkObservation
            navigateTo(
                PackagesFragmentDirections.actionPackagesFragmentToCheckListFragment(
                    checkList = checkList,
                    checkObservation = checkObservation,
                    screenName = getString(R.string.package_create)
                )
            )
        }
        binding.packageSend.root.setOnClickListener {
            val checkList = SendPackageToCGEMS.checkList
            navigateTo(PackagesFragmentDirections.actionPackagesFragmentToCheckListFragment(
                    checkList = checkList,
                    screenName = getString(R.string.package_create)
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private companion object {
        const val ALERT_INITIALIZATION = "Em caso de pacote de iniciação, os seguintes dados são obrigatórios:\n\n" +
            "1. Nome do Candidato e dos pais;\n2. Data de nascimento;\n3. CPF;\n" +
            "4. Endereço;\n5. Telefone;\n" +
            "6. E-MAIL VÁLIDO (Senha para o primeiro acesso será enviado para o e-mail cadastrado)."
    }
}
