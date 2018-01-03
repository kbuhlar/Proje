package e.kaan.proje;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class Ayarlar extends AppCompatActivity {

    int redValue;
    int greenValue;
    int blueValue;
    ToggleButton tb = (ToggleButton)findViewById(R.id.tb);
    TextView tv1 =(TextView)findViewById(R.id.tv1);
    Switch switchhh = (Switch)findViewById(R.id.switchh);
    CheckBox checkbox = (CheckBox)findViewById(R.id.cb);
    RadioGroup rg = (RadioGroup)findViewById(R.id.rg);
    RadioButton rb =(RadioButton)findViewById(R.id.rb1);
    RadioButton rb2 =(RadioButton)findViewById(R.id.rb2);
    SeekBar sbR;
    SeekBar sbG;
    SeekBar sbB;
    TextView tv2 = (TextView)findViewById(R.id.tv2);
    LinearLayout layout = (LinearLayout)findViewById(R.id.layout);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayarlar);

        sbR=(SeekBar)findViewById(R.id.seekbarR);
        sbG = (SeekBar)findViewById(R.id.seekbarG);
        sbB =(SeekBar)findViewById(R.id.seekbarB);
        redValue  = sbR.getProgress();
        greenValue  = sbG.getProgress();
        blueValue  = sbB.getProgress();

        sbR.setMax(255);
        sbG.setMax(255);
        sbB.setMax(255);

        sbR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {

                redValue = progress;
                layout.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
                final SharedPreferences ayarlar = getSharedPreferences("arkaplanrengi",MODE_PRIVATE);
                int arkaplan = ayarlar.getInt("arkaplan",redValue);
                SharedPreferences.Editor editor = ayarlar.edit();
                editor.putInt("arkaplan",sbR.getProgress());
                editor.commit();
                Ayarlar.this.finish();
            }
        });

        sbG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {

                greenValue = progress;
                layout.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
                final SharedPreferences ayarlar = getSharedPreferences("arkaplanrengi",MODE_PRIVATE);
                int arkaplan = ayarlar.getInt("arkaplan",greenValue);
                SharedPreferences.Editor editor = ayarlar.edit();
                editor.putInt("arkaplan",sbB.getProgress());
                editor.commit();
                Ayarlar.this.finish();
            }
        });

        sbB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {

                blueValue = progress;
                layout.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));
                final SharedPreferences ayarlar = getSharedPreferences("arkaplanrengi",MODE_PRIVATE);
                int arkaplan = ayarlar.getInt("arkaplan",blueValue);
                SharedPreferences.Editor editor = ayarlar.edit();
                editor.putInt("arkaplan",sbB.getProgress());
                editor.commit();
                Ayarlar.this.finish();
            }
        });

    }

}
