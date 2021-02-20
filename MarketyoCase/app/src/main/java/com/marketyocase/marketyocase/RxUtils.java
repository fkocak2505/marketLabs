package com.marketyocase.marketyocase;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Response;

public class RxUtils {

    private RxUtils() {
    }

    public static <T> Observable<T> androidDefaults(Observable<T> observable) {
        return observable
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T>Single<Response<T>> androidDef(Single<Response<T>> single){
        return single
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
