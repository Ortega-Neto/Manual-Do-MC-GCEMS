package br.com.lconeto.manualdomc.common.data.entity

data class Roles(
    var listOfRoles: List<RoleInfo> = listOf(
        RoleInfo(
            acronym = RoleConstants.MASTER_COUNSELOR,
            isNecessaryToStartReunion = true
        ),
        RoleInfo(
            acronym = RoleConstants.FIRST_COUNSELOR,
            isNecessaryToStartReunion = true
        ),
        RoleInfo(
            acronym = RoleConstants.SECOND_COUNSELOR,
            isNecessaryToStartReunion = true
        ),
        RoleInfo(
            acronym = RoleConstants.CHAPLAIN,
            isNecessaryToStartReunion = true
        ),
        RoleInfo(
            acronym = RoleConstants.MARSHAL,
            isNecessaryToStartReunion = true
        ),
        RoleInfo(
            acronym = RoleConstants.SENTINEL,
            isNecessaryToStartReunion = true
        ),
        RoleInfo(
            acronym = RoleConstants.FIRST_DEACON,
            isNecessaryToStartReunion = true
        ),
        RoleInfo(
            acronym = RoleConstants.SECOND_DEACON,
            isNecessaryToStartReunion = true
        ),
        RoleInfo(
            acronym = RoleConstants.FIRST_BUTLER,
            isNecessaryToStartReunion = true
        ),
        RoleInfo(
            acronym = RoleConstants.SECOND_BUTLER,
            isNecessaryToStartReunion = true
        ),
        RoleInfo(
            acronym = RoleConstants.STANDARD_BEARER,
            isNecessaryToStartReunion = true
        ),
        RoleInfo(
            acronym = RoleConstants.SECRETARY,
            isNecessaryToStartReunion = true
        ),
        RoleInfo(
            acronym = RoleConstants.SPEAKER
        ),
        RoleInfo(
            acronym = RoleConstants.TREASURER
        ),
        RoleInfo(
            acronym = RoleConstants.HOSPITABLE
        ),
        RoleInfo(
            acronym = RoleConstants.ORGANIST
        ),
        RoleInfo(
            acronym = RoleConstants.FIRST_PRECEPTOR
        ),
        RoleInfo(
            acronym = RoleConstants.SECOND_PRECEPTOR
        ),
        RoleInfo(
            acronym = RoleConstants.THIRD_PRECEPTOR
        ),
        RoleInfo(
            acronym = RoleConstants.FOURTH_PRECEPTOR
        ),
        RoleInfo(
            acronym = RoleConstants.FIFTH_PRECEPTOR
        ),
        RoleInfo(
            acronym = RoleConstants.SIXTH_PRECEPTOR
        ),
        RoleInfo(
            acronym = RoleConstants.SEVENTH_PRECEPTOR
        )
    )
)
