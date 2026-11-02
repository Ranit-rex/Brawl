# Neo Warriors – AdMob Android SDK source

## Important
Yeh **Android library ka source project** hai. Yeh ready-made APK ya compiled `.aar` nahi hai.
Sirf is ZIP ko GitHub Pages website (`index.html`) ke saath rakhne se AdMob APK mein enable nahi hoga.
WebToApp ko Android library / Gradle module import ya `.aar` integration support karna zaroori hai.

## ZIP ko kaise use karein
1. ZIP ko extract karein.
2. Extracted `neowarriors-admob-sdk-fixed` folder ke andar ki files GitHub repository mein upload karein.
3. `README.md` padhein aur WebToApp support se confirm karein ki woh Gradle project ya compiled AAR mein se kya accept karta hai.
4. Apna AdMob App ID kisi public GitHub file mein mat daalein.

## Build
Android Studio + Android SDK + Gradle environment mein:
`gradle :admobbridge:assembleRelease`

Build output:
`admobbridge/build/outputs/aar/admobbridge-release.aar`

Is environment mein project compile/test nahi hua hai. WebToApp compatibility confirm nahi hai.
