package com.bawei.guolei.guolei20171221;

/**
 * Created by Lenovo on 2017/12/21.
 */

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by Lenovo on 2017/11/21.
 */
public class PlusView extends LinearLayout {

    private Button revserser;
    private Button add;
    private EditText editText;
    private int mCount=1;


    public PlusView(Context context) {
        super(context);
    }
    public PlusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view= LayoutInflater.from(context).inflate(R.layout.plus_layout,null);
        revserser = view.findViewById(R.id.revserse);
        add = view.findViewById(R.id.add);
        editText = view.findViewById(R.id.content);
        revserser.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {


                    String content=editText.getText().toString().trim();
                    int count=Integer.valueOf(content);
                    if (count>1){
                        mCount=count-1;
                        editText.setText(mCount+"");
                        if (listener!=null){
                            listener.click(mCount);
                        }
                    }
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }

            }
        });
        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String content=editText.getText().toString().trim();
                    int count=Integer.valueOf(content)+1;
                    mCount=count;
                    editText.setText(count+"");
                    if (listener!=null){
                        listener.click(count);
                    }

                }catch (NumberFormatException e){
                    e.printStackTrace();
                }


            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        addView(view);


    }

    public PlusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setEditText(int num){
        if (editText!=null){
            editText.setText(num+"");
        }

    }
    public ClickListener listener;
    public void setListener(ClickListener listener){
        this.listener=listener;

    }

    public interface ClickListener{
        public void click(int count);
    }



}
