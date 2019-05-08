package launcher.lzui.com.kotlintestlib.okio

import java.io.File

fun main() {
    val file = File("test.txt")
    OkioFileUtils.writeFile(file)

    OkioFileUtils.readFile(file)
}