package launcher.lzui.com.kotlintestlib

data class PeopleBean(
    var people: List<People> = listOf()
)

data class People(
    var firstName: String = "",
    var lastName: String = ""
)