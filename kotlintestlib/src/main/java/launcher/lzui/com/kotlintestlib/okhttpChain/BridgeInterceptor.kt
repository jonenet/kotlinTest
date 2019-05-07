package launcher.lzui.com.kotlintestlib.okhttpChain

import android.util.Log

class BridgeInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): String? {
        val request = chain.request()
        println( "BridgeInterceptor start  request = $request")
        val response = chain.process(request)
        println("BridgeInterceptor end result = $response")
        return response
    }
}