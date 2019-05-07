package launcher.lzui.com.kotlintestlib.okhttpChain

interface Interceptor {

    companion object {
        val TAG :String = "Interceptor"
    }

    fun intercept(chain: Chain): String?

    interface Chain {
        fun request(): String
        fun process(request: String): String?
    }
}