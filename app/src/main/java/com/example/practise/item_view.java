



package com.example.practise;

        import android.content.Context;
        import android.content.res.TypedArray;
        import android.graphics.Color;
        import android.util.AttributeSet;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;

/**
 * @author wh445306
 * @version 1.0
 * @Description ItemView
 * @Date 2023-03-14 1:23
 */

public class item_view extends LinearLayout {
    private Boolean isBottom;
    private Boolean isItemText;
    private ImageView itemIcon;
    private TextView leftTitle;
    private TextView textDuration;
    private TextView itemText;
    private View itemLine;


    public item_view(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(getContext()).inflate(R.layout.activity_item_view, this); //加载布局
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ItemView);//解析布局

        isBottom = ta.getBoolean(R.styleable.ItemView_show_bottom_line, true); //底部分割线是否显示
        isItemText = ta.getBoolean(R.styleable.ItemView_show_right_text, true);//右边描述文字是否显示

        itemIcon = findViewById(R.id.item_icon);   //左边图标
        leftTitle = findViewById(R.id.item_title); //左边标题文字
        itemText = findViewById(R.id.item_text);   //右边描述文字或数值
        itemLine = findViewById(R.id.item_line);   //底部分割线
        //   获取持续时间的view
        textDuration = findViewById(R.id.text_duration);
        textDuration.setText(ta.getText(R.styleable.ItemView_right_text_duration));
        itemIcon.setImageDrawable(ta.getDrawable(R.styleable.ItemView_left_icon)); //图标赋值
        leftTitle.setText(ta.getText(R.styleable.ItemView_left_title));
        itemText.setText(ta.getText(R.styleable.ItemView_right_text));
        itemText.setTextColor(ta.getColor(R.styleable.ItemView_right_text_color, Color.BLACK));
        itemText.setVisibility(isItemText ? VISIBLE : INVISIBLE);
        itemLine.setVisibility(isBottom ? VISIBLE : INVISIBLE);

        //回收属性对象
        ta.recycle();

    }

}