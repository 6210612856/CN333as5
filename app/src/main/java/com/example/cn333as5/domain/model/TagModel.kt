package com.example.cn333as5.domain.model

import com.example.cn333as5.database.TagDbModel

data class TagModel(
    val id: Long,
    val nameTag: String,
) {
    companion object {
        val DEFAULT = with(TagDbModel.DEFAULT_TAG) { TagModel(id, nameTag) }
    }
}