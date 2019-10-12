package com.example.daftartim.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daftartim.R.layout
import com.example.daftartim.data.model.TeamResponse
import com.example.daftartim.data.model.TeamResponse.Team
import com.example.daftartim.data.remote.ApiClient
import kotlinx.android.synthetic.main.activity_main.rv_tim
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val listTeam= mutableListOf<Team>()
    val adapter=RvAdapter(listTeam)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        rv_tim.apply {
            adapter=this@MainActivity.adapter
            layoutManager=
                LinearLayoutManager(this@MainActivity)
        }
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
                            response.body()!!.toString())
                        listTeam.clear()
                        listTeam.addAll(response.body()!!.teams!!)
                        adapter.notifyDataSetChanged()
                    } else {
                        Log.d("HASIL Request ",
                            response.message())
                    }
                }
            }
            )
    }

}
