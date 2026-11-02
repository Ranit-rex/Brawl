# Neo Warriors AdMob Bridge (Android library source)

Starter Android library project for a native Google Mobile Ads bridge.

**Not a ready-made APK or compiled AAR.** WebToApp must explicitly support importing a Gradle Android library or AAR, merging its manifest, and invoking native methods. Uploading these files to a website repository alone does not integrate the SDK into an APK.

## Requirements
- Android Gradle Plugin 8.7.3
- Android SDK platform 35
- Java 17
- WebToApp support for native Android library/AAR integration

## Build
From this directory, with Gradle installed:
`gradle :admobbridge:assembleRelease`

Expected AAR:
`admobbridge/build/outputs/aar/admobbridge-release.aar`

The project has not been compiled or tested in this environment. Confirm WebToApp's accepted integration format before relying on it.

## Host app integration
The final host app manifest needs this metadata inside `<application>`:
`com.google.android.gms.ads.APPLICATION_ID`

The host app must call `AdMobBridge.initialize(activity)` once. The host must also implement any WebView-to-native bridge needed for webpage controls to request ads.

Use Google's test ad-unit IDs during development. Never click your own ads. Follow Google's consent and publisher policies. A parent/guardian should handle monetization and payment setup where required.
