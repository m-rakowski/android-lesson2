package course.android.android_lesson2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<View> allButtons;
    private TextView helloWorldTextView;

    private TextView welcomeMessage;
    private EditText firstName;
    private EditText lastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloWorldTextView = (TextView) findViewById(R.id.helloWorld);
        welcomeMessage = (TextView) findViewById(R.id.welcomeMessage);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);

        initButtons();

        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcomeMessage.setText(firstName.getText()+ " "+lastName.getText());
            }
        });


    }

    private void initButtons() {

        allButtons = ((LinearLayout) findViewById(R.id.buttonContainer)).getTouchables();

        for (View view : allButtons) {
            Button button = (Button) view;
            final CharSequence buttonText = button.getText();
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String text = "Wciśnięto " + buttonText;
                    helloWorldTextView.setText(text);
                }
            });
        }
    }
}
