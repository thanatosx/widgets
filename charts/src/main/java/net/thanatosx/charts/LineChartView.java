package net.thanatosx.charts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * 折线图
 * Created by thanatos on 16/8/9.
 */
public class LineChartView extends View{

    private String mXText;
    private String mYText;
    private boolean isShowHorizontalLine;
    private boolean isShowVerticalLine;
    private int mGridColor;
    private int mCoordinateLineColor;
    private int mCoordinateLineWidth;
    private int mVerticalSpace;
    private int mHorizontalSpace;
    private int mLineColor;
    private int mLineWidth;



    public LineChartView(Context context) {
        this(context, null);
        int i = 0;
        i= i >> 2;
    }

    public LineChartView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LineChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LineChartView, 0, 0);

        mXText = a.getString(R.styleable.LineChartView_lcvXText);
        mYText = a.getString(R.styleable.LineChartView_lcvYText);
        isShowHorizontalLine = a.getBoolean(R.styleable.LineChartView_isShowHorizontalLine, false);
        isShowVerticalLine = a.getBoolean(R.styleable.LineChartView_isShowVerticalLine, false);
        mGridColor = a.getColor(R.styleable.LineChartView_gridColor, 0XFFECECEC);
        mCoordinateLineColor = a.getColor(R.styleable.LineChartView_coordinateLineColor, 0XFF000000);
        mCoordinateLineWidth = a.getDimensionPixelSize(R.styleable.LineChartView_coordinateLineWidth, 1);
        mVerticalSpace = a.getDimensionPixelSize(R.styleable.LineChartView_verticalSpace, 10);
        mHorizontalSpace = a.getDimensionPixelSize(R.styleable.LineChartView_horizontalSpace, 10);
        mLineColor = a.getColor(R.styleable.LineChartView_lcvLineColor, 0XFF0000BB);
        mLineWidth = a.getDimensionPixelSize(R.styleable.LineChartView_lcvLineWidth, 1);

        a.recycle();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
