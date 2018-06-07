package debug

import android.app.Application
import com.guiying.module.common.http.HttpClient
import com.guiying.module.common.http.OnResultListener

class GirlsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        login()
    }

    private fun login() {
       val client= HttpClient.Builder().baseUrl("http://gank.io/api/data/")
                .url("福利/10/1")
                .build()

        client.get(object : OnResultListener<String>(){
            override fun onSuccess(result: String?) {
                super.onSuccess(result)
            }

            override fun onError(code: Int, message: String?) {
                super.onError(code, message)
            }

            override fun onFailure(message: String?) {
                super.onFailure(message)
            }
        })
    }
}