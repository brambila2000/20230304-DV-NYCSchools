package com.example.a20230304_dv_nycschools.ui.view

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.a20230304_dv_nycschools.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!isConnected(this)){
            Toast.makeText(this, "No Network Connection Good Bye!", Toast.LENGTH_LONG).show()
            Thread.sleep(4000)
            finish()
        }
    }

    fun isConnected(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val cap =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (cap != null) {
                if (cap.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    return true
                } else if (cap.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    return true
                }
            }
        }
        return false
    }
}