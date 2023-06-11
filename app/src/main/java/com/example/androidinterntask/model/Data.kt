package com.example.androidinterntask.model

import com.google.gson.annotations.SerializedName

data class Data (

    @SerializedName("recent_links"      ) var recentLinks     : ArrayList<RecentLinks> = arrayListOf(),
    @SerializedName("top_links"         ) var topLinks        : ArrayList<TopLinks>    = arrayListOf(),
    //@SerializedName("overall_url_chart" ) var overallUrlChart : OverallUrlChart?       = OverallUrlChart()

)