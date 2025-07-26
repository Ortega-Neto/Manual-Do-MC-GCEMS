package br.com.lconeto.manualdomc.roles.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import br.com.lconeto.manualdomc.R
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.CHAPLAIN
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.FIFTH_PRECEPTOR
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.FIRST_BUTLER
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.FIRST_COUNSELOR
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.FIRST_DEACON
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.FIRST_PRECEPTOR
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.FOURTH_PRECEPTOR
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.HOSPITABLE
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.MARSHAL
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.MASTER_COUNSELOR
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.ORGANIST
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.SECOND_BUTLER
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.SECOND_COUNSELOR
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.SECOND_DEACON
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.SECOND_PRECEPTOR
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.SECRETARY
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.SENTINEL
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.SEVENTH_PRECEPTOR
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.SIXTH_PRECEPTOR
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.SPEAKER
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.STANDARD_BEARER
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.THIRD_PRECEPTOR
import br.com.lconeto.manualdomc.common.data.entity.role.RoleConstants.TREASURER
import br.com.lconeto.manualdomc.common.data.entity.role.RoleInfo
import br.com.lconeto.manualdomc.common.domain.extensions.copyTextToClipboard
import br.com.lconeto.manualdomc.common.domain.extensions.setTitleName
import br.com.lconeto.manualdomc.common.domain.extensions.toStringRoles
import br.com.lconeto.manualdomc.common.domain.extensions.toastMessage
import br.com.lconeto.manualdomc.common.presentation.loading.LoadingDialog
import br.com.lconeto.manualdomc.databinding.ComponentEditRoleItemBinding
import br.com.lconeto.manualdomc.databinding.FragmentEditRolesBinding
import br.com.lconeto.manualdomc.roles.data.getRoleByAcronym
import br.com.lconeto.manualdomc.roles.data.updateOccupantName
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
        setTitleName(getString(R.string.home_roles))

        loadingDialog = LoadingDialog(
            context = requireContext(),
            getString(R.string.dialog_loading_roles)
        )
        loadingDialog.show()
        getRoles()
        setupSaveButton()
    }

    private fun getRoles() {
        lifecycleScope.launch {
            editRolesViewModel.getRoles().collect {
                roles = it
                setupRolesContent()

                loadingDialog.dismiss()
            }
        }
    }

    private fun setupRolesContent() {
        setupRoleItem(binding.roleMc, roles.getRoleByAcronym(MASTER_COUNSELOR))
        setupRoleItem(binding.role1c, roles.getRoleByAcronym(FIRST_COUNSELOR))
        setupRoleItem(binding.role2c, roles.getRoleByAcronym(SECOND_COUNSELOR))
        setupRoleItem(binding.roleCap, roles.getRoleByAcronym(CHAPLAIN))
        setupRoleItem(binding.roleMcr, roles.getRoleByAcronym(MARSHAL))
        setupRoleItem(binding.role1d, roles.getRoleByAcronym(FIRST_DEACON))
        setupRoleItem(binding.role2d, roles.getRoleByAcronym(SECOND_DEACON))
        setupRoleItem(binding.role1m, roles.getRoleByAcronym(FIRST_BUTLER))
        setupRoleItem(binding.role2m, roles.getRoleByAcronym(SECOND_BUTLER))
        setupRoleItem(binding.rolePb, roles.getRoleByAcronym(STANDARD_BEARER))
        setupRoleItem(binding.roleEsc, roles.getRoleByAcronym(SECRETARY))
        setupRoleItem(binding.roleSen, roles.getRoleByAcronym(SENTINEL))
        setupRoleItem(binding.roleOr, roles.getRoleByAcronym(SPEAKER))
        setupRoleItem(binding.roleTes, roles.getRoleByAcronym(TREASURER))
        setupRoleItem(binding.roleHos, roles.getRoleByAcronym(HOSPITABLE))
        setupRoleItem(binding.roleOrg, roles.getRoleByAcronym(ORGANIST))
        setupRoleItem(binding.role1p, roles.getRoleByAcronym(FIRST_PRECEPTOR))
        setupRoleItem(binding.role2p, roles.getRoleByAcronym(SECOND_PRECEPTOR))
        setupRoleItem(binding.role3p, roles.getRoleByAcronym(THIRD_PRECEPTOR))
        setupRoleItem(binding.role4p, roles.getRoleByAcronym(FOURTH_PRECEPTOR))
        setupRoleItem(binding.role5p, roles.getRoleByAcronym(FIFTH_PRECEPTOR))
        setupRoleItem(binding.role6p, roles.getRoleByAcronym(SIXTH_PRECEPTOR))
        setupRoleItem(binding.role7p, roles.getRoleByAcronym(SEVENTH_PRECEPTOR))
    }

    private fun setupRoleItem(itemBinding: ComponentEditRoleItemBinding, role: RoleInfo) {
        itemBinding.textViewAcronym.text = role.acronym
        itemBinding.textInputLayoutName.hint = "Nome do ${role.acronym}"
        itemBinding.editTextName.setText(role.occupantName)

        roleInputMap[role] = itemBinding.textInputLayoutName
    }

    private fun setupSaveButton() {
        binding.saveButton.setOnClickListener {
            validateAndSaveRoles()
        }
        binding.copyRolesButton.setOnClickListener {
            copyTextToClipboard(roles.toStringRoles())
        }
    }

    private fun validateAndSaveRoles() {
        canSaveRoles = true
        val missingRoles = mutableListOf<String>()

        roleInputMap.forEach { (roleInfo, textInputLayout) ->
            val editText = textInputLayout.editText
            roles.updateOccupantName(roleInfo.acronym, editText?.text.toString())

            if (roleInfo.isNecessaryToStartReunion) {
                if (editText?.text.isNullOrBlank()) {
                    missingRoles.add(roleInfo.acronym)
                    textInputLayout.error = getString(R.string.roles_error_missing_role)
                    textInputLayout.isErrorEnabled = true
                    canSaveRoles = false
                } else {
                    textInputLayout.error = null
                    textInputLayout.isErrorEnabled = false
                }
            }
        }

        if (canSaveRoles) {
            saveRoles()
        }
    }

    private fun saveRoles() {
        lifecycleScope.launch {
            loadingDialog = LoadingDialog(
                context = requireContext(),
                getString(R.string.dialog_saing_roles)
            )
            loadingDialog.show()
            editRolesViewModel.saveRoles(roles).also {
                loadingDialog.dismiss()
                toastMessage(getString(R.string.roles_updated_roles))
                getRoles()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
