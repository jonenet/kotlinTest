package launcher.lzui.com.kotlintestlib.okhttpChain


fun main() {
    val interceptors = ArrayList<Interceptor>()
    interceptors.add(RetryAndFollowInterceptor())
    interceptors.add(BridgeInterceptor())
    interceptors.add(CacheInterceptor())

    val realInterceptorChain = RealInterceptorChain(interceptors, 0, "request")
    realInterceptorChain.process(realInterceptorChain.request)
}