package launcher.lzui.com.kotlintestlib.okhttpLoginTest

import android.text.TextUtils
import android.util.Base64
import okhttp3.*
import java.util.Objects.hash


/**
 * Desc: TODO
 *
 * Author: zhoulai
 * PackageName: launcher.lzui.com.kotlintestlib.okhttpLoginTest
 * ProjectName: kotlinTest
 * Date: 2019/5/8 13:51
 */
class YLAuthInterceptorTest(private var mBasicAuthId: String, private var mBasicAuthPass: String) : Interceptor {

    @Volatile
    var mToken: String? = null
    @Volatile
    var mMacKey: String? = null


    override fun intercept(chain: Interceptor.Chain): Response {
        val origin = chain.request()
        val originHeaders = origin.headers()
        val newHeaders = Headers.Builder()
        var authType = "Token"
        var i = 0
        val size = originHeaders.size()
        while (i < size) {
            if (!TextUtils.equals(originHeaders.name(i), "Auth-Type")) {
                newHeaders.add(originHeaders.name(i), originHeaders.value(i))
            } else {
                authType = originHeaders.value(i)
            }
            i++
        }
        val newRequest = origin.newBuilder()
                .headers(newHeaders.build())
        when (authType) {
//            不需要Token
            "Basic" -> basicAuth(newRequest, origin.url(), System.currentTimeMillis())
            "Token" -> tokenAuth(newRequest, origin.url(), System.currentTimeMillis())
            else -> tokenAuth(newRequest, origin.url(), System.currentTimeMillis())
        }
        return chain.proceed(newRequest.build())
    }

    // 登陆成功后设置
    fun setAuth(token: String, macKey: String) {          // 3
        mToken = token
        mMacKey = macKey
    }

    /**
     * 登陆成功后请求
     */
    private fun tokenAuth(newRequest: Request.Builder, url: HttpUrl,
                          timestamp: Long) {                                   // 4
        if (TextUtils.isEmpty(mToken) || TextUtils.isEmpty(mMacKey)) {
//            throw YLApiError(/**... */)                             // 1
        }
        val text = "token=" + mToken + "timestamp=" + timestamp
        val mac = hash(text + "mac_key=" + mMacKey)

        val newUrl = url.newBuilder()
                .addQueryParameter("timestamp", timestamp.toString())
                .addQueryParameter("mac", mac.toString())
                .addQueryParameter("token", mToken)

        newRequest.url(newUrl.build())
    }

    /**
     * 未登录时请求
     */
    private fun basicAuth(newRequest: Request.Builder, url: HttpUrl,
                          timestamp: Long) {
        val text = "timestamp=$timestamp"

        val macKey = hash(mBasicAuthId + mBasicAuthPass)
        val mac = text + "mac_key=" + macKey

        val newUrl = url.newBuilder()
                .addQueryParameter("timestamp", timestamp.toString())
                .addQueryParameter("mac", mac)

        newRequest.url(newUrl.build())
        newRequest.addHeader("Authorization",
                basicAuthHeader(mBasicAuthId, mBasicAuthPass))
    }


    private fun basicAuthHeader(username: String, pwd: String): String {
        val userAndPassword = "$username:$pwd"
        return "Basic " + Base64.encodeToString(
                userAndPassword.toByteArray(charset("UTF-8")), Base64.NO_WRAP)
    }
}