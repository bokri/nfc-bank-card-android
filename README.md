# NFC Bank Card Android

This project is an Android application sample to help developers to read data from credit card: card number, expired date, card type.<br>
In this application, I'm using this library : https://github.com/pro100svitlo/Credit-Card-NFC-Reader <br>

<i>Works only with cards that has paypass or paywave technology!</i>

---

### Proguard
If you are using Proguard, please add this line to your proguard-rules.pro file
```
-keep class com.noveogroup.android.log.** { *; }
```


### License
The MIT License (MIT)

Copyright (c) 2018 NFC Bank Card Android

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
