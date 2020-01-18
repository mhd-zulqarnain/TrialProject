package com.trial.trialproject.services

import com.trial.trialproject.data.remote.ProductSearchResponse
import com.trial.trialproject.data.remote.StoreCategoryResponse
import retrofit2.Call
import retrofit2.http.*


interface TrailServices {
    @GET
    fun getDataFromUrl(@Url url:String): Call<Any>

    @FormUrlEncoded
    @POST("merchantservices/getStoreCatalog")
    fun getAllProducts(@Field("client_key") client_key: String,
                       @Field("admin_id") admin_id: String,
                       @Field("store_id") store_id: String,
                       @Field("page") page: Int
    ) : Call<ProductSearchResponse>

    @FormUrlEncoded
    @POST("/services/getCategory")
    fun getCategory(@Field("client_key") client_key:String,
                    @Field("store_id") store_id:String)
            : Call<StoreCategoryResponse>
}