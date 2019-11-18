package com.example.mvptest_2;

public interface MainContract {

    public interface MainView {
        void showProgress();
        void hideProgress();
        void setQuote(String str);
    }

    public interface MainPresenter {
        void onButtonClick();
        void onDestroy();
    }

    public interface GetQuoteInteractor {
        interface OnFinishedListener {
            void onFinished(String str);
        }

        void getNextQuote(OnFinishedListener listener);
    }
}
