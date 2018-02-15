package com.exmample.android.musicplayerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;

public class SamplePaymentActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonPay;
    private EditText editTextAmount;
    private final int PAYPAL_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_activty);
        buttonPay = (Button) findViewById(R.id.buttonPay);
        buttonPay.setOnClickListener(this);
        editTextAmount = (EditText) findViewById(R.id.editTextAmount);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonPay :
                payNow();
                break;
        }
    }

    private void payNow(){
        int payment = Integer.parseInt(editTextAmount.getText().toString().trim());
        PayPalConfiguration config = new PayPalConfiguration()
                .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
                .clientId(PayPalConfig.PAYPAL_CLIENT_ID);
        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);
        Intent intent1 = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
        startActivityForResult(intent1, PAYPAL_REQUEST_CODE);
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }
}
