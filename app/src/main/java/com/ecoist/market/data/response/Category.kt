package com.ecoist.market.data.response

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Kirill Stoianov on 18/09/2020.
 */
@Parcelize
@Keep
data class Category(
    @SerializedName("id") val id: Int,
    @SerializedName("idParent") val idParent: Int,
    @SerializedName("name") val name: String,
    @SerializedName("alias") val alias: String,
    @SerializedName("compared") val compared: Int,
    @SerializedName("deleted") val deleted: Int,
    @SerializedName("showBanner") val showBanner: Int,
    @SerializedName("categoryOrder") val categoryOrder: Int,
    @SerializedName("product_list_cols") val product_list_cols: Int,
    @SerializedName("short_desc_on_product") val short_desc_on_product: Int,
    @SerializedName("show_mods") val show_mods: Int,
    @SerializedName("isPublic") val isPublic: Int,
    @SerializedName("show_links") val show_links: Int
) : Parcelable