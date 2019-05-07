package launcher.lzui.com.kotlintestlib.okhttpChain

import android.util.Log

class CacheInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): String? {
        println("CacheInterceptor start")
        println("CacheInterceptor end")
        return "success"
    }
}