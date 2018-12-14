package com.sandu.linearitemdecoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class LinearItemDecoration extends RecyclerView.ItemDecoration {

    private int dividerHeight;
    private Paint colorPaint = new Paint();
    public static final int HORIZONTAL = 0x01;  //水平
    public static final int VERTICAL = 0x02;  //垂直
    private int orientation = VERTICAL;
    private int include;

    public static final int VERTICAL_INCLUDE_NULL = 0x001;
    public static final int VERTICAL_INCLUDE_TOP = 0x002;
    public static final int VERTICAL_INCLUDE_BOTTOM = 0x003;
    public static final int VERTICAL_INCLUDE_TOP_BOTTOM = 0x004;

    public LinearItemDecoration(int dividerHeight, int color){
        this.dividerHeight = dividerHeight;
        colorPaint.setColor(color);
        this.include = VERTICAL_INCLUDE_BOTTOM;
    }

    public LinearItemDecoration(int dividerHeight, int color, int include){
        this.dividerHeight = dividerHeight;
        colorPaint.setColor(color);
        this.include = include;
    }

    public LinearItemDecoration setOrientation(int orientation){
        this.orientation = orientation;
        return this;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        if(orientation == HORIZONTAL){

        }else if(orientation == VERTICAL){
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();
            int count = parent.getChildCount();
            for(int i = 0; i < count; i++){
                View view = parent.getChildAt(i);
                int top = 0, bottom = 0;
                switch (include){
                    case VERTICAL_INCLUDE_NULL:  //不包含顶、底部
                        if(i != count - 1){
                            top = view.getBottom();
                            bottom = view.getBottom() + dividerHeight;
                            c.drawRect(left, top, right, bottom, colorPaint);
                        }
                        break;
                    case VERTICAL_INCLUDE_TOP:  //包含顶
                        top = view.getTop() - dividerHeight;
                        bottom = view.getTop();
                        c.drawRect(left, top, right, bottom, colorPaint);
                        break;
                    case VERTICAL_INCLUDE_BOTTOM:  //包含底部
                        top = view.getBottom();
                        bottom = view.getBottom() + dividerHeight;
                        c.drawRect(left, top, right, bottom, colorPaint);
                        break;
                    case VERTICAL_INCLUDE_TOP_BOTTOM:  //包含顶、底部
                        if(i == 0){
                            top = view.getTop() - dividerHeight;
                            bottom = view.getTop();
                            c.drawRect(left, top, right, bottom, colorPaint);
                        }
                        top = view.getBottom();
                        bottom = view.getBottom() + dividerHeight;
                        c.drawRect(left, top, right, bottom, colorPaint);

                        break;
                    default:
                        break;
                }


            }
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int count = parent.getAdapter().getItemCount();
        if(orientation == HORIZONTAL){

        }else if(orientation == VERTICAL) {
            switch (include) {
                case VERTICAL_INCLUDE_NULL:  //不包含顶、底部
                    if(parent.getChildAdapterPosition(view) != count - 1){
                        outRect.bottom = dividerHeight;
                    }
                    break;
                case VERTICAL_INCLUDE_TOP:  //包含顶
                    outRect.top = dividerHeight;
                    break;
                case VERTICAL_INCLUDE_BOTTOM:  //包含底部
                    outRect.bottom = dividerHeight;
                    break;
                case VERTICAL_INCLUDE_TOP_BOTTOM:  //包含顶、底部
                    if(parent.getChildAdapterPosition(view) == 0){
                        outRect.top = dividerHeight;
                    }
                    outRect.bottom = dividerHeight;
                    break;
                default:
                    break;
            }
        }
    }

}
