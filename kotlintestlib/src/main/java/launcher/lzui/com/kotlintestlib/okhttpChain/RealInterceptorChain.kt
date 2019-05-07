package launcher.lzui.com.kotlintestlib.okhttpChain

class RealInterceptorChain(var interceptors: List<Interceptor>, var index: Int, var request: String) : Interceptor.Chain {

    override fun process(request: String): String? {
        if (index >= interceptors.size) return null
        val next = RealInterceptorChain(interceptors, index + 1, request)
        val interceptor = interceptors[index]
        return interceptor.intercept(next)
    }

    override fun request(): String {
        return request
    }
}