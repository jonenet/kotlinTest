package launcher.lzui.com.kotlintestlib.okhttpChain

class RetryAndFollowInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): String? {
        val request = chain.request()
        println("RetryAndFollowInterceptor start request = $request")
        val response = chain.process(request)
        println("RetryAndFollowInterceptor end result = $response")
        return response
    }

}