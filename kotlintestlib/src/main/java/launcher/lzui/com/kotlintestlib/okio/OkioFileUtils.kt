package launcher.lzui.com.kotlintestlib.okio

import okio.Sink
import okio.buffer
import okio.sink
import okio.source
import java.io.File
import java.io.FileOutputStream
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
            val buffer = file.sink(true).buffer()
            buffer.writeString("test1\ntest2\ncode\ntest3", Charset.defaultCharset()).flush()
        }

    }

    fun File.sink(append: Boolean = false): Sink {
       return FileOutputStream(this, append).sink()
    }


}
