package launcher.lzui.com.kotlintestlib.okhttpChain

class RealInterceptorChain(var interceptors: List<Interceptor>, var index: Int, var request: String) : Interceptor.Chain {

//    处理流程，
    override fun process(request: String): String? {
        if (index >= interceptors.size) return null
        val next = RealInterceptorChain(interceptors, index + 1, request)
        val interceptor = interceptors[index]
        // 每调用一次都会执行intercept方法，并把下一个chain传下去，在intercept方法中，又会执行request方法和process方法，
        // 如果到了最后一个还没有结果返回，就认为结束
        // 如果有interceptor没有执行 process 方法，也会结束链
        // 1，2
        return interceptor.intercept(next)
    }

    override fun request(): String {
        return request
    }
}