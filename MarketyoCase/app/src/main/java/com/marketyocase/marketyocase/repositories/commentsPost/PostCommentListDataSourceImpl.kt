package com.marketyocase.marketyocase.repositories.commentsPost

import com.marketyocase.marketyocase.IRequestListener
import com.marketyocase.marketyocase.model.commentsPost.Response4CommentsPost
import com.marketyocase.marketyocase.model.retrofit.MarketyoApisService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class PostCommentListDataSourceImpl(private val compositeDisposable: CompositeDisposable) {

    private val marketyoApiService = MarketyoApisService()

    //==============================================================================================
    /**
     * Request With Retrofit PostComment with postId parameters
     */
    //==============================================================================================
    fun getPostComment(
        postId: Int,
        iRequestListener: IRequestListener<MutableList<Response4CommentsPost>>
    ) {

        val request: Single<Response<MutableList<Response4CommentsPost>>> =
            marketyoApiService.getCommentsPost(postId)

        compositeDisposable.add(
            request.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->

                    when (response.isSuccessful) {
                        true -> {
                            iRequestListener.onSuccess(response)
                        }
                        else -> {
                            iRequestListener.onUnSuccess(response)
                        }
                    }
                }, { throwable ->
                    iRequestListener.onFail(throwable)
                })
        )

    }

}