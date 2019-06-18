package com.example.paging_library_example.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.paging_library_example.api.Repository

/**
 * @author Ksenya Kaysheva (murrcha@me.com)
 * @since june 2019
 */
object RepositoryDiffUtilCallback : DiffUtil.ItemCallback<Repository>() {

    override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean = oldItem == newItem
}