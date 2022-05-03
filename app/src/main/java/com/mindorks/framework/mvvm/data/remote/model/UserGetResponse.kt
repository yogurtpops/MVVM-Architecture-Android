package com.mindorks.framework.mvvm.data.remote.model

import io.reactivex.Single

data class UserGetResponse(

//    @SerialiazedName("users")
    var users : Single<List<User>>
)
