package br.com.lconeto.manualdomc.roles.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.CHAPLAIN_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.FIFTH_PRECEPTOR_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.FIRST_BUTLER_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.FIRST_COUNSELOR_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.FIRST_DEACON_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.FIRST_PRECEPTOR_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.FOURTH_PRECEPTOR_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.HOSPITABLE_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.MARSHAL_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.MASTER_COUNSELOR_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.ORGANIST_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.SECOND_BUTLER_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.SECOND_COUNSELOR_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.SECOND_DEACON_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.SECOND_PRECEPTOR_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.SECRETARY_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.SENTINEL_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.SEVENTH_PRECEPTOR_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.SIXTH_PRECEPTOR_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.SPEAKER_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.STANDARD_BEARER_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.THIRD_PRECEPTOR_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleConstants.TREASURER_POSITION
import br.com.lconeto.manualdomc.common.data.entity.RoleInfo
import br.com.lconeto.manualdomc.common.presentation.LoadingDialog
import br.com.lconeto.manualdomc.databinding.ComponentEditRoleItemBinding
import br.com.lconeto.manualdomc.databinding.FragmentEditRolesBinding
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch

class EditRolesFragment : Fragment() {
    private var _binding: FragmentEditRolesBinding? = null
    private val binding get() = _binding!!

    private val editRolesViewModel by lazy {
        ViewModelProvider(
            this,
            EditRolesViewModel.Factory(requireContext())
        )[EditRolesViewModel::class.java]
    }

    private lateinit var roles: List<RoleInfo>
    private lateinit var loadingDialog: LoadingDialog
    private val roleInputMap = hashMapOf<RoleInfo, TextInputLayout>()
    private var canSaveRoles = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditRolesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadingDialog = LoadingDialog(
            context = requireContext(),
            "carregando"
        )
        loadingDialog.show()
        getRoles()
    }

    private fun getRoles() {
        lifecycleScope.launch {
            editRolesViewModel.getRoles().collect {
                roles = it
                setupRolesContent()
                setupSaveButton()

                loadingDialog.dismiss()
            }
        }
    }

    private fun setupRolesContent() {
        setupRoleItem(binding.roleMc, roles[MASTER_COUNSELOR_POSITION])
        setupRoleItem(binding.role1c, roles[FIRST_COUNSELOR_POSITION])
        setupRoleItem(binding.role2c, roles[SECOND_COUNSELOR_POSITION])
        setupRoleItem(binding.roleCap, roles[CHAPLAIN_POSITION])
        setupRoleItem(binding.roleMcr, roles[MARSHAL_POSITION])
        setupRoleItem(binding.role1d, roles[FIRST_DEACON_POSITION])
        setupRoleItem(binding.role2d, roles[SECOND_DEACON_POSITION])
        setupRoleItem(binding.role1m, roles[FIRST_BUTLER_POSITION])
        setupRoleItem(binding.role2m, roles[SECOND_BUTLER_POSITION])
        setupRoleItem(binding.rolePb, roles[STANDARD_BEARER_POSITION])
        setupRoleItem(binding.roleEsc, roles[SECRETARY_POSITION])
        setupRoleItem(binding.roleSen, roles[SENTINEL_POSITION])
        setupRoleItem(binding.roleOr, roles[SPEAKER_POSITION])
        setupRoleItem(binding.roleTes, roles[TREASURER_POSITION])
        setupRoleItem(binding.roleHos, roles[HOSPITABLE_POSITION])
        setupRoleItem(binding.roleOrg, roles[ORGANIST_POSITION])
        setupRoleItem(binding.role1p, roles[FIRST_PRECEPTOR_POSITION])
        setupRoleItem(binding.role2p, roles[SECOND_PRECEPTOR_POSITION])
        setupRoleItem(binding.role3p, roles[THIRD_PRECEPTOR_POSITION])
        setupRoleItem(binding.role4p, roles[FOURTH_PRECEPTOR_POSITION])
        setupRoleItem(binding.role5p, roles[FIFTH_PRECEPTOR_POSITION])
        setupRoleItem(binding.role6p, roles[SIXTH_PRECEPTOR_POSITION])
        setupRoleItem(binding.role7p, roles[SEVENTH_PRECEPTOR_POSITION])
    }

    private fun setupRoleItem(itemBinding: ComponentEditRoleItemBinding, role: RoleInfo) {
        itemBinding.textViewAcronym.text = role.acronym
        itemBinding.textInputLayoutName.hint = "Nome do ${role.acronym}"

        roleInputMap[role] = itemBinding.textInputLayoutName
    }

    private fun setupSaveButton() {
        binding.saveButton.setOnClickListener {
            validateAndSaveRoles()
        }
    }

    private fun validateAndSaveRoles() {
        canSaveRoles = true
        val missingRoles = mutableListOf<String>()

        var index = 0
        roleInputMap.forEach { (roleInfo, textInputLayout) ->
            val editText = textInputLayout.editText
            if (roleInfo.isNecessaryToStartReunion) {
                if (editText?.text.isNullOrBlank()) {
                    missingRoles.add(roleInfo.acronym)
                    textInputLayout.error = getString(R.string.roles_error_missing_role)
                    textInputLayout.isErrorEnabled = true
                    canSaveRoles = false
                } else {
                    textInputLayout.error = null
                    textInputLayout.isErrorEnabled = false
                    roles[index].occupantName = roleInfo.occupantName
                }
                index++
            }
        }

        if (canSaveRoles) {
            saveRoles()
        }
    }

    private fun saveRoles() {
        lifecycleScope.launch {
            editRolesViewModel.saveRoles(roles)
        }
    }
}
