package com.example.daftartim.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.daftartim.R.layout
import com.example.daftartim.data.model.TeamResponse
import com.example.daftartim.data.model.TeamResponse.Team
import com.example.daftartim.data.remote.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        getData()
    }
    private fun getData(){
        ApiClient.create().ambilDataTim()
            .enqueue(object :Callback<TeamResponse>{
                override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                    Log.e("Error : ", t.message)
                }

                override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {

                    if (response.isSuccessful) {
                        Log.d("HASIL request ",
                            response.body()!!.toString()
                        )
                    } else {
                        Log.d("HASIL Request ",
                            response.message())
                    }
                }
            }
            )
    }

}
