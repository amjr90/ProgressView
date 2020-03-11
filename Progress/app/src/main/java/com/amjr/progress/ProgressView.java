package com.amjr.progress;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ProgressView {

    public View view;
    public ViewGroup container;
    private static volatile ProgressView instance;

    private ProgressView() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static ProgressView getInstance() {
        if (instance == null) {
            //if there is no instance available... create new one
            synchronized (ProgressView.class) {
                if (instance == null) instance = new ProgressView();
            }
        }

        return instance;
    }

    public void Show(Activity activity, final ICallback callback) {

        view = LayoutInflater.from(activity).inflate(R.layout.progress, (ViewGroup) activity.getWindow().getDecorView(), true);
        container = (ViewGroup) activity.getWindow().getDecorView();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.run();
            }
        }, 500);
    }

    public void Dismiss() {
        if (view != null) {
            container.removeView(container.findViewById(R.id.progressView));
            view = null;
            container = null;
        }
    }

    public interface ICallback {
        void run();
    }
}

