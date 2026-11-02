package com.neowarriors.admobbridge;

import android.app.Activity;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

/**
 * Native AdMob helper. The host Android app must import this library,
 * declare its AdMob App ID in the merged manifest, and call initialize().
 * A WebToApp JavaScript bridge must be implemented by the host separately.
 */
public final class AdMobBridge {
    private AdMobBridge() {}

    public static final String TEST_BANNER_ID =
            "ca-app-pub-3940256099942544/9214589741";
    public static final String TEST_INTERSTITIAL_ID =
            "ca-app-pub-3940256099942544/1033173712";

    public static void initialize(Activity activity) {
        MobileAds.initialize(activity, status -> {});
    }

    public static AdView createBanner(Activity activity, String adUnitId) {
        AdView view = new AdView(activity);
        view.setAdUnitId(adUnitId);
        view.setAdSize(AdSize.BANNER);
        view.loadAd(new AdRequest.Builder().build());
        return view;
    }

    public static void showBanner(
            Activity activity, ViewGroup container, String adUnitId) {
        activity.runOnUiThread(() -> {
            container.removeAllViews();
            container.addView(
                    createBanner(activity, adUnitId),
                    new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
        });
    }

    public static void loadInterstitial(
            Activity activity, String adUnitId, InterstitialCallback callback) {
        InterstitialAd.load(
                activity,
                adUnitId,
                new AdRequest.Builder().build(),
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(InterstitialAd ad) {
                        callback.onLoaded(ad);
                    }

                    @Override
                    public void onAdFailedToLoad(LoadAdError error) {
                        callback.onFailed(error.getMessage());
                    }
                });
    }

    public interface InterstitialCallback {
        void onLoaded(InterstitialAd ad);
        void onFailed(String message);
    }
}
