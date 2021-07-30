package com.billy.android.loadingstatusview.wrapfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.billy.android.loadingstatusview.BaseActivity;
import com.billy.android.loadingstatusview.R;

/**
 * demo for wrap fragment
 *
 * You can wrap a BaseFragment like {@link BaseActivity}
 *
 * @author billy.qi
 * @since 19/3/21 17:23
 */
public class WrapRootViewFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.layout_test_pager, null, false);


        ViewPager vp = (ViewPager)root.findViewById(R.id.vp);
        vp.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return new WrapRootViewFragmentChild();
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
            }
        });

        return root;

//        holder = Gloading.getDefault().wrap(imageView).withRetry(new Runnable() {
//            @Override
//            public void run() {
//                //change picture url to a correct one
//                loadImage(getRandomImage());
//            }
//        });
//        //demo load failed with an error image url
//        loadImage(Util.getErrorImage());
//        return holder.getWrapper();
    }



    private void loadImage(String picUrl) {
//        holder.showLoading();
//        Glide.with(this)
//                .load(picUrl)
//                .listener(new RequestListener<Drawable>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                        holder.showLoadFailed();
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                        holder.showLoadSuccess();
//                        return false;
//                    }
//                })
//                .into(imageView);
    }

}
