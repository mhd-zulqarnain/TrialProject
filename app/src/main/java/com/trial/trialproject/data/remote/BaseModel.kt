package com.trial.trialproject.data.remote

data class BaseModel<T>(
    val header: Header?,
    val body: ResponseBody<T>
)

class Header(
    var response_code: Int,
    var message: String

)

class ResponseBody<T>(
    var response_code: Int,
    var countries: List<T>
)


