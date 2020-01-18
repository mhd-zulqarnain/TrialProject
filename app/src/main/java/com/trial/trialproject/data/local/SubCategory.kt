package com.trial.trialproject.data.local

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SubCategory(
    subcategoryId: Long,
    categoryId: Long,
    subcategoryName: String,
    subcategoryImage: String,
    subcategTooltip: String
) {

    @SerializedName("subcategory_id")
    @Expose
        var subcategoryId: Long? = subcategoryId
    @SerializedName("subcategory_name")
    @Expose
    var subcategoryName: String? = subcategoryName
    @SerializedName("subcategory_image")
    @Expose
    var subcategoryImage: String? = subcategoryImage
    @SerializedName("subcateg_tooltip")
    @Expose
    var subcategTooltip: String? = subcategTooltip
    var categoryId: Long? = categoryId


}
