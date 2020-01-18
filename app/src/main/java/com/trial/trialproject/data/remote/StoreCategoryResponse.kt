package com.trial.trialproject.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.trial.trialproject.data.local.StoreCategory


class StoreCategoryResponse {

    @SerializedName("status")
    @Expose
    var status: Boolean? = null
    @SerializedName("code")
    @Expose
    var code: Int? = null
    @SerializedName("data")
    @Expose
    var storeCategories: List<StoreCategory>? = null

}
