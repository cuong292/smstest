package com.app.mysmslistener;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.RECEIVE_SMS},
                10);
        EventBus.getDefault().register(this);

        Observable<String> readJsonObs = Observable.create(emitter -> {
            try {
                URL google = new URL("https://github.com/ReactiveX/RxAndroid");
                BufferedReader in = new BufferedReader(new InputStreamReader(google.openStream()));
                String input;
                StringBuffer stringBuffer = new StringBuffer();
                while ((input = in.readLine()) != null) {
                    stringBuffer.append(input);
                }
                in.close();
                String htmlData = stringBuffer.toString();
                emitter.onNext(htmlData);
            } catch (Exception e) {
                emitter.onError(e);
            }
        });

        AppApi.getAppService()
                .getCoffee().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Coffee>>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull List<Coffee> coffees) {
                        Log.d("cuongnb", "get coffee success");
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        readJsonObs.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

            }

            @Override
            public void onNext(@io.reactivex.rxjava3.annotations.NonNull String jsonObject) {
                Log.d("cuongnb", "onNext: parse success");
            }

            @Override
            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


    }


    @Subscribe
    public void onFirstJobReceive(EventBusListener.FirstJobDone firstJobDone) {
        Log.d("cuongnb", "onFirstJobReceive: " + "first job done");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10) {
            // YES!!
            Log.i("cuongnb", "MY_PERMISSIONS_REQUEST_SMS_RECEIVE --> YES");
        } else {
            Log.d("cuongnb", "onRequestPermissionsResult: -> fails");
        }
    }
}