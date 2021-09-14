package com.fgardila.snapshots

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Snapshot(
    @get:Exclude var id: String = "", //Excluir una propiedad para que no se suba a Firebase
    var title: String = "",
    var photoUrl: String = "",
    var likeList: Map<String, Boolean> = mutableMapOf()
)
