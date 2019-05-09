package launcher.lzui.com.kotlintestlib.okio

import okio.*
import java.io.*
import java.nio.charset.Charset


class OkioFileUtils {

    companion object {

//        private fun File.sink(append: Boolean = false): Sink {
//            return FileOutputStream(this, append).sink()
//        }

        fun copyOkio(oldFile: File, copyFile: File): Boolean {
            var flag: Boolean
            var sourceBuffer: BufferedSource? = null
            var sinkBuffer: BufferedSink? = null
            try {
                sourceBuffer = oldFile.source().buffer()
                sinkBuffer = copyFile.sink().buffer()
                while (true) {
                    val readByteArray = sourceBuffer.readByteArray()
                    if (readByteArray.isNotEmpty()) {
                        sinkBuffer.write(readByteArray).flush()
                    } else {
                        break
                    }
                }
                flag = true
            } catch (e: Exception) {
                flag = false
                e.printStackTrace()
            } finally {
                sourceBuffer!!.close()
                sinkBuffer!!.close()
            }
            return flag
        }

        fun copyStream(oldFile: File, copyFile: File): Boolean {
            var flag: Boolean
            var fileInputStream: BufferedInputStream? = null
            var fileOutputStream: BufferedOutputStream? = null
            try {
                fileInputStream = BufferedInputStream(FileInputStream(oldFile))
                fileOutputStream = BufferedOutputStream(FileOutputStream(copyFile))
                val byteArray = ByteArray(4096)
                while (true) {
                    val len = fileInputStream.read(byteArray)
                    if (len != -1) {
                        fileOutputStream.write(byteArray, 0, len)
                    } else {
                        break
                    }
                }
                flag = true
            } catch (e: IOException) {
                e.printStackTrace()
                flag = false
            } finally {
                fileInputStream!!.close()
                fileOutputStream!!.close()
            }
            return flag

        }

        fun writeFile(file: File) {
            // Sink 写数据
            val buffer = file.sink(true).buffer()
            buffer.writeString("test1\ntest2\ncode\ntest3", Charset.defaultCharset()).flush()
        }


        fun readFile(file: File): String? {
            // Source 读数据
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


    }


}
