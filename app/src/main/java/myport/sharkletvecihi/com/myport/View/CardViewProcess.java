package myport.sharkletvecihi.com.myport.View;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import myport.sharkletvecihi.com.myport.R;

public class CardViewProcess extends LinearLayout
{
    private CheckBox checkBoxProcess;
    private TextView textViewProcess;
    private Button buttonExpand;
    private CardViewProcess next = null;

    public CardViewProcess(Context context)
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
                }

                if(next != null && !isChecked)
                {
                    next.getCheckBoxProcess().setEnabled(false);
                    next.getButtonExpand().setEnabled(false);
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
        checkBoxProcess.setChecked(is);
    }

    public void setNextView(CardViewProcess cardViewProcess)
    {
        this.next = cardViewProcess;
    }

    public CheckBox getCheckBoxProcess()
    {
        return checkBoxProcess;
    }

    public Button getButtonExpand()
    {
        return buttonExpand;
    }
}
