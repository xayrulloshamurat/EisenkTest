package com.example.eisenktest.data

import androidx.room.Embedded
import androidx.room.Relation

data class AforizmAuthorWithAforizm(
    @Embedded val aforizmModel: AforizmModel,
    @Relation(
        parentColumn = "authorId",
        entityColumn = "id"
    )
    val aforizmAuthorModel: AforizmAuthorModel
)