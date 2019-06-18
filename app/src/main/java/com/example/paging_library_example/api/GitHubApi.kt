package com.example.paging_library_example.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Ksenya Kaysheva (murrcha@me.com)
 * @since june 2019
 */
interface GitHubApi {

    @GET("search/repositories?sort=stars")
    fun searchRepos(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): Call<SearchResponse>
}
