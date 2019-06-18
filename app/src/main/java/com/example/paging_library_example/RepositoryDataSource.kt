package com.example.paging_library_example

import android.util.Log
import androidx.paging.PositionalDataSource
import com.example.paging_library_example.api.Repository
import com.example.paging_library_example.api.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Ksenya Kaysheva (murrcha@me.com)
 * @since june 2019
 */
class RepositoryDataSource : PositionalDataSource<Repository>() {

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Repository>) {
        Log.d("DATA_SOURCE", "loadRange, startPosition = ${params.startPosition}, loadSize = ${params.loadSize}")

        RepositoryStorage.fetchRepository(params.startPosition, params.loadSize)
            .enqueue(object : Callback<SearchResponse> {

                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                    Log.e("RESPONSE", "onFailure ", t)
                }

                override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                    if (response.isSuccessful) {
                        val searchResponse = response.body()
                        val repositories = searchResponse?.items
                        repositories?.forEach {
                            Log.d("RESPONSE", "Next repository ${it.name} ${it.url}")
                        }
                        callback.onResult(repositories!!.toMutableList())
                    } else {
                        Log.e("RESPONSE", "onResponse ${response.errorBody()}")
                    }
                }
            })
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Repository>) {
        Log.d("DATA_SOURCE", "loadInitial, requestedStartPosition = ${params.requestedStartPosition}, requestedLoadSize = ${params.requestedLoadSize}")

        RepositoryStorage.fetchRepository(params.requestedStartPosition, params.requestedLoadSize)
            .enqueue(object : Callback<SearchResponse> {

                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                    Log.e("RESPONSE", "onFailure ", t)
                }

                override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                    if (response.isSuccessful) {
                        val searchResponse = response.body()
                        val repositories = searchResponse?.items
                        repositories?.forEach {
                            Log.d("RESPONSE", "First repository ${it.name} ${it.url}")
                        }
                        callback.onResult(repositories!!.toMutableList(), 0)
                    } else {
                        Log.e("RESPONSE", "onResponse ${response.errorBody()}")
                    }
                }
            })
    }
}
