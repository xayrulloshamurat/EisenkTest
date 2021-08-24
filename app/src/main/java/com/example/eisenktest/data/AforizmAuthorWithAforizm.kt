package com.example.eisenktest.data

import androidx.room.Embedded
import androidx.room.Relation

data class AforizmAuthorWithAforizm(
    @Embedded val aforizmAuthorModel: AforizmAuthorModel,
    @Relation(
        parentColumn = "id",
        entityColumn = "authorId"
    )
    val aforizmModel: AforizmModel
)