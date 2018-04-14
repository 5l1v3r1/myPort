package myport.sharkletvecihi.com.myport.View;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import myport.sharkletvecihi.com.myport.R;

public class CardViewProcess extends ConstraintLayout
{
    private CheckBox checkBoxProcess;
    private TextView textViewProcess;
    private Button buttonExpand;
    private CardViewProcess next = null;

    public CardViewProcess(Context context)
    {
        super(context);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_operational_process, this);
        this.addView(view);

        textViewProcess = (TextView) findViewById(R.id.txtview_process);
        checkBoxProcess = (CheckBox) findViewById(R.id.chkbox_process);
        buttonExpand = (Button) findViewById(R.id.btn_expand);
        buttonExpand.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(checkBoxProcess.isChecked())
                {
                    if(next != null)
                        next.setEnabled(true);
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


}
