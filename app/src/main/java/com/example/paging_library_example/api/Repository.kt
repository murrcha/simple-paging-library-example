package com.example.paging_library_example.api

import com.google.gson.annotations.SerializedName

/**
 * @author Ksenya Kaysheva (murrcha@me.com)
 * @since june 2019
 */
data class Repository(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("description") val description: String?,
    @SerializedName("html_url") val url: String
)
