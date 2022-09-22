package com.example.common_lib.okhttp

interface IGetDataListener<T> {
    fun onSuccess(dataobj: T)
    fun onFailure(reasonOBJ: Any)
}
