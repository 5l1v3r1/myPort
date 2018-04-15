package myport.sharkletvecihi.com.myport.View;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
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
    public static  boolean out = false;

    public static final String MyPREFERENCES = "ProccessSettings" ;

    public CardViewProcess(final Context context)
    {

        super(context);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_operational_process, null);
        this.addView(view);

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
                if(next != null && isChecked && !out)
                {
                    next.getCheckBoxProcess().setEnabled(true);
                    next.getButtonExpand().setEnabled(true);
                    MainActivity.count_step++;
                    MainActivity.next_op = next.getOperation();
                }

                if(next != null && !isChecked && !out)
                {
                    next.getCheckBoxProcess().setEnabled(false);
                    next.getButtonExpand().setEnabled(false);
                    MainActivity.count_step++;
                    MainActivity.next_op = next.getOperation();
                }

                if(out)
                {
                    out = false;
                    next.getCheckBoxProcess().setEnabled(true);
                    next.getButtonExpand().setEnabled(true);
                    MainActivity.next_op = next.getOperation();
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
