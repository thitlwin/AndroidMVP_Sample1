package com.example.mvptest_2;

public class MainPresenterImpl implements
        MainContract.MainPresenter, MainContract.GetQuoteInteractor.OnFinishedListener {

    MainContract.MainView mainView;
    MainContract.GetQuoteInteractor getQuoteInteractor;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetQuoteInteractor getQuoteInteractor) {
        this.mainView = mainView;
        this.getQuoteInteractor = getQuoteInteractor;
    }

    @Override
    public void onFinished(String str) {
        if (mainView != null){
            mainView.setQuote(str);
            mainView.hideProgress();
        }
    }

    @Override
    public void onButtonClick() {
        if (mainView != null) {
            mainView.showProgress();
        }
        getQuoteInteractor.getNextQuote(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }
}
