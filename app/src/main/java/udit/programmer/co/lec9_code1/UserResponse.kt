package udit.programmer.co.lec9_code1

data class UserResponse(
    val totalCount: Int? = null,
    val incompleteResults: Boolean? = null,
    val items: List<Users>? = null
)