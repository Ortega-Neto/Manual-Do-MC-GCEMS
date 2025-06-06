package br.com.lconeto.manualdomc.projects.data

import br.com.lconeto.manualdomc.R

object ProjectsList {
    fun getProjectsList(): List<ProjectVO> = listOf(
        stateReferenceCertificate,
        improvementAdvice,
        excellence,
        goldenHospitable,
        goldenFreshman,
        goldenTreasurer,
    )

    private val stateReferenceCertificate = ProjectVO(
        code = EnumProjects.STATE_REFERENCE_CERTIFICATE,
        image = R.drawable.image_project_state_reference_certificate,
        name = "Certificado de Referência Estadual",
        description = "Esta "
    )

    private val improvementAdvice = ProjectVO(
        code = EnumProjects.IMPROVEMENT_ADVICE,
        image = R.drawable.image_project_improvement_advice,
        name = "Conselho de Aprimoramento de Diretorias",
        description = "Esta "
    )

    private val excellence = ProjectVO(
        code = EnumProjects.EXCELLENCE,
        image = R.drawable.image_project_excellence_ms,
        name = "Excelência MS",
        description = "Esta "
    )

    private val goldenHospitable = ProjectVO(
        code = EnumProjects.GOLDEN_HOSPITABLE,
        image = R.drawable.image_project_golden_hospitable,
        name = "CRE",
        description = "Esta "
    )

    private val goldenFreshman = ProjectVO(
        code = EnumProjects.GOLDEN_FRESHMAN,
        image = R.drawable.image_project_golden_freshman,
        name = "CRE",
        description = "Esta "
    )

    private val goldenTreasurer = ProjectVO(
        code = EnumProjects.GOLDEN_TREASURER,
        image = R.drawable.image_project_golden_treasurer,
        name = "CRE",
        description = "Esta "
    )
}