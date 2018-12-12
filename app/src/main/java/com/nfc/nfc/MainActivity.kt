package com.nfc.nfc

import android.content.Intent
import android.nfc.NfcAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.nfc.nfc.databinding.ActivityMainBinding
import com.pro100svitlo.creditCardNfcReader.CardNfcAsyncTask
import com.pro100svitlo.creditCardNfcReader.utils.CardNfcUtils


class MainActivity : AppCompatActivity(), CardNfcAsyncTask.CardNfcInterface {

    private lateinit var binding: ActivityMainBinding
    private var nfcAdapter: NfcAdapter? = null
    private lateinit var cardNfcUtils: CardNfcUtils
    private var intentFromOnCreate: Boolean = false
    private var cardNfcAsyncTask: CardNfcAsyncTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        nfcAdapter = NfcAdapter.getDefaultAdapter(this)

        if (nfcAdapter == null){
            //do something if there are no nfc module on device
            Log.i("MainActivity", "No NFC Module on Device")
        } else {
            //do something if there are nfc module on device

            cardNfcUtils = CardNfcUtils(this);
            //next few lines here needed in case you will scan credit card when app is closed
            intentFromOnCreate = true
            onNewIntent(intent)
        }


    }

    override fun onResume() {
        super.onResume()

        intentFromOnCreate = false

        if (nfcAdapter?.isEnabled == false) {
            Log.i("MainActivity", "NFC is disabled, please enable it in settings")
        } else if (nfcAdapter != null){
            cardNfcUtils.enableDispatch()
        }

    }

    override fun onPause() {
        super.onPause()

        if (nfcAdapter != null){
            cardNfcUtils.disableDispatch()
        }

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        if (nfcAdapter?.isEnabled == true) {
            cardNfcAsyncTask = CardNfcAsyncTask.Builder(this, intent, intentFromOnCreate)
            .build()
        }

    }

    override fun startNfcReadCard() {
        //notify user that scannig start
        Log.i("MainActivity", "startNfcReadCard")
    }

    override fun cardIsReadyToRead() {
        val card = cardNfcAsyncTask?.cardNumber
        val expiredDate = cardNfcAsyncTask?.cardExpireDate
        val cardType = cardNfcAsyncTask?.cardType

        Log.i("MainActivity", card)
        Log.i("MainActivity", expiredDate)
        Log.i("MainActivity", cardType)

    }

    override fun doNotMoveCardSoFast() {
        //notify user do not move the card
        Log.i("MainActivity", "doNotMoveCardSoFast")
    }

    override fun unknownEmvCard() {
        //notify user that current card has unnown nfc tag
        Log.i("MainActivity", "unknownEmvCard")
    }

    override fun cardWithLockedNfc() {
        //notify user that current card has locked nfc tag
        Log.i("MainActivity", "cardWithLockedNfc")
    }

    override fun finishNfcReadCard() {
        //notify user that scannig finished
        Log.i("MainActivity", "finishNfcReadCard")
    }
}
