package com.marketyocase.marketyocase

import androidx.annotation.CallSuper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marketyocase.marketyocase.model.retrofit.MarketyoApisService
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class BaseVM : ViewModel() {

    val marketyoApiService = MarketyoApisService()

    private var disposables: CompositeDisposable? = null

    val loadingHUD = MutableLiveData<Boolean>()

    protected fun addDisposable(disposable: Disposable) {
        compositeDisposables?.add(disposable)
    }

    private val compositeDisposables: CompositeDisposable?
        get() {
            if (disposables == null) {
                disposables = CompositeDisposable()
            }
            return disposables
        }

    @CallSuper
    override fun onCleared() {
        super.onCleared()
        if (disposables != null) {
            disposables!!.dispose()
            disposables = null
        }
    }
}