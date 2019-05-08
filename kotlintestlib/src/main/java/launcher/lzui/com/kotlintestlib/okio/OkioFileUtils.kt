package launcher.lzui.com.kotlintestlib.okio

import java.io.File
import okio.*
import java.nio.charset.Charset


class OkioFileUtils {

    companion object {

        fun readFile(file: File): String? {
            val source = file.source()
            val buffer = source.buffer()

            while (true) {
                val readUtf8Line = buffer.readUtf8Line()
                if ("code" == readUtf8Line)
                    break
                else
                    println(readUtf8Line)
            }


            return null
        }

        fun writeFile(file: File) {
            val buffer = file.sink().buffer()
            buffer.writeString("test1\ntest2\ncode\ntest3", Charset.defaultCharset()).flush()
        }

    }

}
