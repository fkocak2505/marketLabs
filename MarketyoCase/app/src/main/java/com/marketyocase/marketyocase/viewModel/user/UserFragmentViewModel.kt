package com.marketyocase.marketyocase.viewModel.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marketyocase.marketyocase.BaseVM
import com.marketyocase.marketyocase.IRequestListener
import com.marketyocase.marketyocase.RxUtils
import com.marketyocase.marketyocase.model.retrofit.MarketyoApisService
import com.marketyocase.marketyocase.model.user.Response4Users
import com.marketyocase.marketyocase.repositories.user.UserListDataSourceImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class UserFragmentViewModel : BaseVM() {

    //private val disposable = CompositeDisposable()
    //private val userListDataSourceImpl = UserListDataSourceImpl(disposable)

    //private val marketyoApiService = MarketyoApisService()

    val userList = MutableLiveData<MutableList<Response4Users>>()
    val userListError = MutableLiveData<Boolean>()
    //val loading = MutableLiveData<Boolean>()

    //==============================================================================================
    /**
     * Trigger User List When Fragment Start..
     */
    //==============================================================================================
    fun refresh() {
        getUserList()
    }

    //==============================================================================================
    /**
     * UserList View Model method
     */
    //==============================================================================================
    private fun getUserList() {
        loadingHUD.value = true

        addDisposable(
            RxUtils.androidDef(
                marketyoApiService.getUserList()
            ).subscribe({ responseData ->
                when(responseData.isSuccessful){
                    true -> {
                        userList.value = responseData.body()!!
                        userListError.value = false
                        loadingHUD.value = false
                    }
                    false -> {
                        userListError.value = true
                        loadingHUD.value = false
                    }
                }
            }, { error ->
                userListError.value = true
                loadingHUD.value = false
            })
        )

        /*loading.value = true
        val request: Single<Response<MutableList<Response4Users>>> =
            marketyoApiService.getUserList()

        disposable.add(
            request.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->

                    when(response.isSuccessful){
                        true -> {
                            userList.value = response.body()!!
                            userListError.value = false
                            loading.value = false
                        }
                        false -> {
                            userListError.value = true
                            loading.value = false
                        }
                    }


                }, { throwable ->
                    userListError.value = true
                    loading.value = false
                })
        )*/


        /*userListDataSourceImpl.getUserList(object : IRequestListener<MutableList<Response4Users>> {
            override fun onSuccess(response: Response<MutableList<Response4Users>>) {
                userList.value = response.body()!!
                userListError.value = false
                loading.value = false
            }

            override fun onUnSuccess(response: Response<MutableList<Response4Users>>) {
                userListError.value = true
                loading.value = false
            }

            override fun onFail(t: Throwable?) {
                userListError.value = true
                loading.value = false
            }
        })*/
    }

}