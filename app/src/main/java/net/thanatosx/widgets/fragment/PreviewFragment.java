package net.thanatosx.widgets.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import net.thanatosx.previewer.ImagePreviewView;
import net.thanatosx.widgets.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 演示图片预览
 *
 * fix: 图片预览与ViewPager左右滑动的冲突
 * Created by thanatos on 16/7/25.
 */
public class PreviewFragment extends Fragment{

    @Bind(R.id.image_previewer) ImagePreviewView mViewPreviewer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (ab != null){
            ab.setSubtitle("previewer");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preview, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Glide.with(getContext())
                .load(R.mipmap.pic_00)
                .into(mViewPreviewer);
    }
}
