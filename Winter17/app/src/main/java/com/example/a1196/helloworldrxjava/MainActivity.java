package com.example.a1196.helloworldrxjava;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;


import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Function;

public class MainActivity extends Activity {

    @BindView(R.id.hello_world)
    TextView mHelloText;
    @BindView(R.id.stock_updates_view)
    RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private StockDataAdapter mStockDataAdapter;



    public void demo() {

        Observable.just("1")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String e) {
                        Log.d("APP", "Hello " + e);
                    }
                });

        Observable.just("1")
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s + "mapped";
                    }
                })
                .flatMap(new Function<String, Observable<String>>() {
                    @Override
                    public Observable<String> apply(String s) {
                        return Observable.just("flat-" + s);
                    }
                })
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        Log.d("APP", "on next " + s);
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String e) {
                        Log.d("APP", "Hello " + e);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        Log.d("APP", "Error!");
                    }
                });

        Observable.just("1")
                .map(s -> s + "mapped")
                .flatMap(s -> Observable.just("flat-" + s))
                .doOnNext(s -> Log.d("APP", "on next " + s))
                .subscribe(e -> Log.d("APP", "Hello " + e),
                        throwable -> Log.d("APP", "Error!"));

        Observable.just("1")
                .subscribe(e -> Log.d("APP", "Hello " + e));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        demo();

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mStockDataAdapter = new StockDataAdapter();
        mRecyclerView.setAdapter(mStockDataAdapter);

        Observable.just("Please use this app responsibly!")
                .subscribe(s -> mHelloText.setText(s));

        Observable.just(
                new StockUpdate("GOOGLE", 12.43, new Date()),
                new StockUpdate("APPL", 645.1, new Date()),
                new StockUpdate("TWTR", 1.43, new Date())
        )
                .subscribe(stockUpdate -> {
                    Log.d("APP", "New update " + stockUpdate.getStockSymbol());
                    mStockDataAdapter.add(stockUpdate);
                });
    }
}

/*
    Retrolambdas replace to boiler plate code that the observable in react uses.
    this makes the code much more cleaner and understandable once you know how
    lambdas work.
 */
