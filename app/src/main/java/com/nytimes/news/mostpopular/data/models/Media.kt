package com.nytimes.news.mostpopular.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Media(
    @SerializedName("type")
    var type: String,
    @SerializedName("subtype")
    var subtype: String,
    @SerializedName("caption")
    var caption: String,
    @SerializedName("copyright")
    var copyright: String,
    @SerializedName("approved_for_syndication")
    var approvedForSyndication: Int,
    @SerializedName("media-metadata")
    var mediaMetaData: List<MediaMetaData>
) : Parcelable {
    fun geturl(): String {
        return mediaMetaData?.get(0)?.url
    }


}