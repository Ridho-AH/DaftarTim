package com.example.daftartim.data.remote

import com.example.daftartim.data.model.TeamResponse
import com.example.daftartim.data.model.TeamResponse.Team
import retrofit2.Call
import retrofit2.http.GET

interface Repository {
    @GET("1/lookup_all_teams.php?id=4328")
    fun ambilDataTim():Call<TeamResponse>

}