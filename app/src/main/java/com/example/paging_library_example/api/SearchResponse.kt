package com.example.paging_library_example.api

import com.google.gson.annotations.SerializedName

/**
 * @author Ksenya Kaysheva (murrcha@me.com)
 * @since june 2019
 */
data class SearchResponse(
    @SerializedName("total_count")
    val totalCount: Int = 0,
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean = false,
    @SerializedName("items")
    val items: List<Repository> = emptyList(),
    val nextPage: Int? = null
)
