package launcher.lzui.com.kotlintestlib.okio

import java.io.File
import java.util.*

fun main() {
    var sourceFile1 = File("source1.exe")
    var copyFile1 = File("copy1.exe")

    var sourceFile2 = File("source2.exe")
    var copyFile2 = File("copy2.exe")
//    OkioFileUtils.writeFile(file)
//
//    OkioFileUtils.readFile(file)
    Thread(Runnable {
        println("copyOkio = ${Date(System.currentTimeMillis())}")
        for (i in (0..200)) {
            OkioFileUtils.copyOkio(sourceFile1, copyFile1)
        }
        println("copyOkio = ${Date(System.currentTimeMillis())}")
    }).start()

    println("=================================================")

    Thread(Runnable {
        println("copyStream = ${Date(System.currentTimeMillis())}")
        for (i in (0..200)) {
            OkioFileUtils.copyStream(sourceFile2, copyFile2)
        }
        println("copyStream = ${Date(System.currentTimeMillis())}")
    }).start()

//    var decodeHex = "89504e470d0a1a0a".decodeHex()
//    println(decodeHex)
}