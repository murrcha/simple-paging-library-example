package com.example.paging_library_example

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paging_library_example.adapter.RepositoryAdapter
import com.example.paging_library_example.api.Repository
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * @author Ksenya Kaysheva (murrcha@me.com)
 * @since june 2019
 */
class MainActivity : AppCompatActivity() {

    private val ioExecutor by lazy { Executors.newSingleThreadExecutor() }
    private val uiExecutor by lazy {
        object : Executor {
            private val mHandler = Handler(Looper.getMainLooper())
            override fun execute(command: Runnable) {
                mHandler.post(command)
            }
        }
    }

    private val adapter: RepositoryAdapter by lazy { RepositoryAdapter() }

    private val dataSource: RepositoryDataSource by lazy { RepositoryDataSource() }

    private val config: PagedList.Config by lazy {
        PagedList.Config.Builder()
            .setEnablePlaceholders(USE_PLACEHOLDERS)
            .setPageSize(PAGE_SIZE)
            .build()
    }

    private val pagedList: PagedList<Repository> by lazy {
        PagedList.Builder<Int, Repository>(dataSource, config)
            .setFetchExecutor(ioExecutor)
            .setNotifyExecutor(uiExecutor)
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdapter()
    }

    private fun initAdapter() {
        adapter.submitList(pagedList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    companion object {
        private const val PAGE_SIZE = 10
        private const val USE_PLACEHOLDERS = false
    }
}
