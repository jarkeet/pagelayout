package com.billy.android.loadingstatusview.wrapfragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.billy.android.loading.Gloading;
import com.billy.android.loadingstatusview.BaseActivity;
import com.billy.android.loadingstatusview.R;
import com.billy.android.loadingstatusview.pagelayout.PageLayout;
import com.billy.android.loadingstatusview.util.Util;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * demo for wrap fragment
 *
 * You can wrap a BaseFragment like {@link BaseActivity}
 *
 * @author billy.qi
 * @since 19/3/21 17:23
 */
public class WrapRootViewFragmentChild extends Fragment {
    private Gloading.Holder holder;
    private ImageView imageView;
    PageLayout pageLayout;

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//
//        View root = inflater.inflate(R.layout.layout_test_pager_child, null, false);
//
//        imageView = (ImageView) root.findViewById(R.id.iv);
//
//
//        holder = Gloading.getDefault().wrap(root).withRetry(new Runnable() {
//            @Override
//            public void run() {
//                //change picture url to a correct one
//                loadImage(getRandomImage());
//            }
//        });
//        //demo load failed with an error image url
//        loadImage(getErrorImage());
//
//        return holder.getWrapper();
////
////
////        return root;
//
////
//    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.layout_test_pager_child, null, false);

        imageView = (ImageView) root.findViewById(R.id.iv);

        pageLayout = new PageLayout.Builder(getActivity())
//                .initPage(getActivity().findViewById(R.id.fl_test))
                .initPage(root)
                .setOnRetryListener(new PageLayout.OnRetryClickListener() {
                    @Override
                    public void onRetry() {
                        loadImage(Util.getRandomImage());
                    }
                })
                .create();


        return pageLayout;
    }

    @Override
    public void onActivityCreated(@Nullable  Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        pageLayout.mContent.setVisibility(View.VISIBLE);

        getView().requestLayout();

        pageLayout.post(new Runnable() {
            @Override
            public void run() {
                Log.d("post", "pageLayout: " + pageLayout.getWidth());
                Log.d("post", "pageLayout: " + pageLayout.getWidth());
                Log.d("post", "mContent: " + pageLayout.mContent.getWidth());
                Log.d("post", "mContent: " + pageLayout.mContent.getHeight());
                Log.d("post", "viewpager: " + ((ViewGroup)pageLayout.getParent()).toString());
                Log.d("post", "viewpager: " + ((ViewGroup)pageLayout.getParent()).getWidth());
                Log.d("post", "viewpager: " + ((ViewGroup)pageLayout.getParent()).getHeight());
                pageLayout.requestLayout();
            }
        });

        //demo load failed with an error image url
        loadImage(Util.getErrorImage());
    }

    //    private void loadImage(String picUrl) {
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
//    }

    private void loadImage(String picUrl) {
        pageLayout.showLoading();
        Glide.with(this)
                .load(picUrl)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        pageLayout.showError();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        pageLayout.hide();
                        return false;
                    }
                })
                .into(imageView);
    }

}
