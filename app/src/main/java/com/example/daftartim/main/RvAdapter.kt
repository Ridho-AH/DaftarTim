package com.example.daftartim.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daftartim.R
import com.example.daftartim.data.model.TeamResponse.Team
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item.iv_tim
import kotlinx.android.synthetic.main.list_item.tv_nama_stadion
import kotlinx.android.synthetic.main.list_item.tv_nama_tim

class RvAdapter(val dataTim:List<Team>)
    :RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item,
                parent,false))
    }

    override fun getItemCount(): Int =dataTim.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(dataTim[position])
    }

    class ViewHolder(override val containerView: View)
        :RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bindData(item:Team){
            tv_nama_tim.text=item.strTeam
            tv_nama_stadion.text=item.strStadium
            Glide.with(containerView)
                .load(item.strTeamLogo)
                .into(iv_tim)
        }
    }
}