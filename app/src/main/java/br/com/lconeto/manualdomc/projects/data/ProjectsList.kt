package br.com.lconeto.manualdomc.projects.data

import br.com.lconeto.manualdomc.R

object ProjectsList {
    fun getProjectsList(): List<ProjectVO> = listOf(
        stateReferenceCertificate,
        goldenHospitable,
        goldenFreshman,
        goldenTreasurer,
    )

    private val stateReferenceCertificate = ProjectVO(
        code = EnumProjects.STATE_REFERENCE_CERTIFICATE,
        image = R.drawable.image_project_state_reference_certificate,
        name = "Certificado de Referência Estadual",
        description = """
            Esta campanha visa fornecer um guia para uma gestão de excelência e promover uma competição saudável entre os Capítulos de nosso estado. Ao término do mandato de nosso gabinete, serão recompensados aqueles que se destacarem nas gestões de 2024.2, 2 conforme anunciado em edital.
        """.trimIndent()
    )

    private val goldenHospitable = ProjectVO(
        code = EnumProjects.GOLDEN_HOSPITABLE,
        image = R.drawable.image_project_golden_hospitable,
        name = "CRE",
        description = """
            Ações sociais são uma das principais formas de ajudarmos e fazermos diferença na sociedade, e é dever de um capítulo realizá-las. Por isso, temos o cargo de Hospitaleiro, cujas responsabilidades incluem programar e colocar em prática essas ações. Dessa forma, esta campanha busca recompensar os oficiais que desempenharem de forma exemplar o seu trabalho dentro de seus capítulos, cumprindo todas as atividades exigidas no edital.
        """.trimIndent()
    )

    private val goldenFreshman = ProjectVO(
        code = EnumProjects.GOLDEN_FRESHMAN,
        image = R.drawable.image_project_golden_freshman,
        name = "CRE",
        description = """
            A campanha "Iniciático Destaque" tem como objetivo guiar os novos membros em uma jornada inicial de busca por aprendizado e reflexão dentro da ordem. Eles serão instruídos por seus tutores para concluir a campanha, realizando todos os trabalhos necessários. Dessa forma, esperamos que desenvolvam um maior interesse pelo estudo de nossa ordem.
        """.trimIndent()
    )

    private val goldenTreasurer = ProjectVO(
        code = EnumProjects.GOLDEN_TREASURER,
        image = R.drawable.image_project_golden_treasurer,
        name = "CRE",
        description = """
            A campanha "Tesoureiro de Ouro" tem como objetivo incentivar e recompensar os tesoureiros dos capítulos de nosso estado que desempenharem suas funções de maneira excepcional, cumprindo todos os seus deveres e prestando assistência ao Mestre Conselheiro.
        """.trimIndent()
    )
}
