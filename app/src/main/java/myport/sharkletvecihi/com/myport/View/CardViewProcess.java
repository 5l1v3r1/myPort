package myport.sharkletvecihi.com.myport.View;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import myport.sharkletvecihi.com.myport.Activities.MainActivity;
import myport.sharkletvecihi.com.myport.R;

public class CardViewProcess extends LinearLayout
{
    private CheckBox checkBoxProcess;
    private TextView textViewProcess;
    private Button buttonExpand;
    private CardViewProcess next = null;
    private  boolean out = false;

    public static final String MyPREFERENCES = "ProccessSettings" ;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int count_step = 0;

    public CardViewProcess(Context context)
    {

        super(context);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_operational_process, null);
        this.addView(view);

        sharedPreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        count_step = sharedPreferences.getInt("count_step", -1);
        if(count_step == -1)
        {
            editor.putInt("count_step", 0);
            editor.putString("next_step_name", "Travel to Airport");
        }

        textViewProcess = (TextView) findViewById(R.id.txtview_process);
        checkBoxProcess = (CheckBox) findViewById(R.id.chkbox_process);
        buttonExpand = (Button) findViewById(R.id.btn_expand);
        buttonExpand.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                open();
            }
        });
        checkBoxProcess.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(next != null && isChecked)
                {
                    next.getCheckBoxProcess().setEnabled(true);
                    next.getButtonExpand().setEnabled(true);
                    count_step++;
                    editor.putInt("count_step", count_step);
                    editor.putString("next_step_name", next.getOperation());
                    editor.commit();
                }

                if(next != null && !isChecked)
                {
                    next.getCheckBoxProcess().setEnabled(false);
                    next.getButtonExpand().setEnabled(false);
                    count_step--;
                    editor.putInt("count_step", count_step);
                    editor.putString("next_step_name", getOperation());
                    editor.commit();
                }
            }
        });
    }

    public void setText(String text)
    {
        textViewProcess.setText(text);
    }

    public void setChecked(boolean is)
    {
        checkBoxProcess.setChecked(true);
    }

    public void setNextView(CardViewProcess cardViewProcess)
    {
        this.next = cardViewProcess;
    }

    public String getOperation()
    {
        return textViewProcess.getText().toString();
    }

    public CheckBox getCheckBoxProcess()
    {
        return checkBoxProcess;
    }

    public Button getButtonExpand()
    {
        return buttonExpand;
    }

    public void setOut(boolean out)
    {
        this.out = out;
    }

    public void open()
    {

    }
}
