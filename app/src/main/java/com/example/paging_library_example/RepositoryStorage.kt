package com.example.paging_library_example

import com.example.paging_library_example.api.GitHubService
import com.example.paging_library_example.api.SearchResponse
import retrofit2.Call

/**
 * @author Ksenya Kaysheva (murrcha@me.com)
 * @since june 2019
 */
object RepositoryStorage {

    fun fetchRepository(page: Int, perPage: Int): Call<SearchResponse> =
        GitHubService.create().searchRepos("android", page, perPage)
}
