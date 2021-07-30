package com.billy.android.loadingstatusview.wrapfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.billy.android.loadingstatusview.R;

/**
 * demo: wrap fragment
 * @author billy.qi
 * @since 19/3/21 17:33
 */
public class WrapFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrap_fragment);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_container, new WrapRootViewFragment2());
        transaction.commit();
    }
}
