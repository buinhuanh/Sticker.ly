package com.example.stickerly.Model

import com.google.android.gms.common.api.Releasable

data class StickerModel(
     var name:String="",
     val author:String="",
     val dowloads:String="",
     val release_date:String="",
     val stickers:List<String> = emptyList()
 )