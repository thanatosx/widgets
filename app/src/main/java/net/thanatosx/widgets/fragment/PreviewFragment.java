package net.thanatosx.widgets.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import net.thanatosx.previewer.ImagePreviewView;
import net.thanatosx.widgets.R;

/**
 * 演示图片预览
 *
 * fix: 图片预览与ViewPager左右滑动的冲突
 * Created by thanatos on 16/7/25.
 */
public class PreviewFragment extends Fragment{

    private ImagePreviewView mViewPreviewer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_preview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewPreviewer = (ImagePreviewView) view.findViewById(R.id.image_previewer);

        Glide.with(getContext())
                .load(R.mipmap.picture_00)
                .into(mViewPreviewer);
    }
}
