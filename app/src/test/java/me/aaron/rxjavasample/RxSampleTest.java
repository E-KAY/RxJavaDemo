package me.aaron.rxjavasample;

import org.junit.Test;

import rx.observers.TestSubscriber;

/**
 * Created by Chenll on 2016/8/23 0023.
 */
public class RxSampleTest extends BaseTest {

    private RxSample mTest;

    @Override
    public void setup() {
        super.setup();

        mTest = new RxSample();
    }

    @Test
    public void testOnNext() throws Exception {
        TestSubscriber<String> expected = new TestSubscriber<>();

        mTest.onNext().subscribe(expected);

        expected.assertValues("1", "2");
        expected.assertCompleted();
    }

    @Test
    public void testJust() {
        TestSubscriber<String> expected = new TestSubscriber<>();

        mTest.just().subscribe(expected);

        expected.assertValues("Hello");
        expected.assertCompleted();
    }

    @Test
    public void testFrom() {
        TestSubscriber<String> expected = new TestSubscriber<>();

        mTest.from().subscribe(expected);

        expected.assertValues("1", "2", "3");
        expected.assertCompleted();
    }

    @Test
    public void testFilter() {
        TestSubscriber<String> expected = new TestSubscriber<>();

        mTest.filter().subscribe(expected);

        expected.assertValues("2", "2");
        expected.assertCompleted();
    }

    @Test
    public void testMap() {
        TestSubscriber<Integer> expected = new TestSubscriber<>();

        mTest.map().subscribe(expected);

        expected.assertValue(1);
        expected.onCompleted();
    }

    @Test
    public void testFlatMap() {
        TestSubscriber<String> expected = new TestSubscriber<>();

        mTest.flatMap().subscribe(expected);

        expected.assertValues("291212 token login");
        expected.onCompleted();
    }

    @Test
    public void testLift() {
        TestSubscriber<String> expected = new TestSubscriber<>();

        mTest.lift().subscribe(expected);

        expected.assertValues("291212");
        expected.onCompleted();
    }

    @Test
    public void testMerge() {
        TestSubscriber<Long> expected = new TestSubscriber<>();

        mTest.merge().subscribe(expected);

        expected.awaitTerminalEvent();
        expected.assertValues(0L, 0L, 5L, 10L, 10L, 20L, 15L, 30L, 20L, 40L);
        expected.onCompleted();
    }

    @Test
    public void testTake() {
        TestSubscriber<String> expected = new TestSubscriber<>();

        mTest.take().subscribe(expected);

        expected.assertValues("1", "2", "3");
        expected.onCompleted();
    }

    @Test
    public void testToList() {
        TestSubscriber<String> expected = new TestSubscriber<>();

        mTest.toList().subscribe(expected);

        expected.awaitTerminalEvent();
        expected.assertValues("12345");
        expected.onCompleted();
    }

}