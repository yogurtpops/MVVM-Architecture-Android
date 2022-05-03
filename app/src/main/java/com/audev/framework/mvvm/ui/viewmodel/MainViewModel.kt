package com.audev.framework.mvvm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.audev.framework.mvvm.data.DataRepository
import com.audev.framework.mvvm.data.Result
import com.audev.framework.mvvm.data.remote.model.User
import com.audev.framework.mvvm.utils.Resource
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {

    private val users = MutableLiveData<Resource<List<User>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        users.postValue(Resource.loading(null))
//        compositeDisposable.add(
//            mainRepository.getUsers()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ userList ->
//                    users.postValue(Resource.success(userList))
//                }, { throwable ->
//                    users.postValue(Resource.error("Something Went Wrong", null))
//                })
//        )

        viewModelScope.launch {
            repository.getUsers().let { result ->
                when (result) {
                    is Result.Success -> {
                        users.postValue(Resource.success(result.data))
                    }
                    is Result.Error -> {
                        users.postValue(Resource.error("Something Went Wrong", null))
                    }
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getUsers(): LiveData<Resource<List<User>>> {
        return users
    }

}