package launcher.lzui.com.kotlintestlib

import java.util.*

enum class Color( val rgb: Int) {
    RED( 0xFF0000), BLACK(0x000000), BLUE(0x0000FF), GREEN(0x00FF00), WHITE(0xFF0000);



    // 打印出所有的枚举值
//    inline fun <reified T : Enum<T>> printAllValues() {
//        print(enumValues<T>().joinToString())
////        print(enumValueOf<T>("RED"))
//    }
}


fun main() {
    val color: Color = Color.GREEN

//    println(Color.values())
//    println(Color.valueOf("RED"))
//    println(color.name)
//    println(color.ordinal)

    for (value in Color.values()) {
        println(value.rgb)
        println(value.name)
    }
//    color.printAllValues<Color>()
}

