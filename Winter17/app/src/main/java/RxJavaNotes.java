/**
 * Created by michaelsanchez on 12/21/17.
 */

public class RxJavaNotes {

    /*

        Chapter 2:
        What is RxJava ? -> RxJava is about reacting to results. It can be an item that you
        were waiting for or also and even error too. RxJava is a framework that knows what to do
        when you get any of these things. It does it in an easy way to use. Things like waiting for
        an arrival of an item before transforming it become very easy with RxJava.

        RxJavas primitives ? ->
        Observable -> A source of Data.
        Subscription -> An Activated handle to the Observable that receives data.
        Schedulers -> A mean to define where (which thread) the data is processed.

        What is an Observable ? ->
            How do you create an Observable ? ->
                Simplest way -> by using .just()
                    this allows us to place non RxItems to an RxItem
            What happens when you call the .just() ? -> this means that the observable got created
            but does not mean that the data will be emitted. It will not start emitting
            data until there is a subscription call using the .subscribe()

            How do you use the .subscribe() ? ->
                simply calling the .subscribe()

            Cold observables vs Hot observables ? ->
                Cold -> data will not be emitted by the Observable until there is a subscriber.
                this means that anything before the .subscriber() method will not be emitted until
                we place a subscriber
                Hot -> the observable will begin processing(emitting) items internally as soon as it
                is created.

        What are Disposables ? -> A tool that can control the life cycle of an observable.
        It only has two methods, dispose() and isDisposed().
            Dispose() is used to destroy the subscription of the observable.
            isDisposed() is used to check if the subscription is still being used.
        Disposed observables cannot be re-enabled.
        You can also dispose many things together by using the CompositeDecomposable(), this is done
        when you want to decompose many observables, this is usually done when you are done with an
        activity.

        Schedulers are set by simply calling the subscribeOn() method.

        How do items travel through the Observable ? ->

        What is Backpressure and how we can use it with Flowable ? ->

        What is Backpressure -> when you dont specify how we want to handle items that cannot be processed.
        What is Flowable -> allows you to process items that emitted faster from the source than some of the
        following steps can handle.

     */
}
