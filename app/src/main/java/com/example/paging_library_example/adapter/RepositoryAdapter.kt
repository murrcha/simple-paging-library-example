package com.example.paging_library_example.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.example.paging_library_example.api.Repository

/**
 * @author Ksenya Kaysheva (murrcha@me.com)
 * @since june 2019
 */
class RepositoryAdapter : PagedListAdapter<Repository, RepositoryViewHolder>(RepositoryDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
