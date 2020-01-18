package com.trial.trialproject.data.local

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StoreCategory(
    categoryId: Long,
    categoryName: String,
    categoryImage: String,
    categTooltip: String
) {

    @SerializedName("category_id")
    @Expose
    var categoryId: Long? = categoryId
    @SerializedName("category_name")
    @Expose
    var categoryName: String? = categoryName
    @SerializedName("category_image")
    @Expose
    var categoryImage: String? = categoryImage
    @SerializedName("categ_tooltip")
    @Expose
    var categTooltip: String? = categTooltip
    @SerializedName("sub_categories")
    @Expose
    var subCategories: List<SubCategory>? = null

}
