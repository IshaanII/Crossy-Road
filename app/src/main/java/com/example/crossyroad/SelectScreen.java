package com.example.crossyroad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SelectScreen extends AppCompatActivity {
    private Button easyButton;
    private Button mediumButton;
    private Button hardButton;
    private Button character1Button;
    private Button character2Button;
    private Button character3Button;
    private EditText nameInput;
    private Button submitButton;
    private int difficulty = -1;
    private int character = -1;

    public static boolean nameChecker(String name) {
        return name != null && name.trim().length() > 0;
    }

    public static boolean difficultyChecker(int difficulty) {
        return difficulty >= 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_screen);

        easyButton = findViewById(R.id.easyButton);
        mediumButton = findViewById(R.id.mediumButton);
        hardButton = findViewById(R.id.hardButton);
        character1Button = findViewById(R.id.characterAButton);
        character2Button = findViewById(R.id.characterBButton);
        character3Button = findViewById(R.id.characterCButton);
        nameInput = findViewById(R.id.usernameEditText);
        submitButton = findViewById(R.id.submit);

        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (difficulty < -1) {
                    easyButton.setBackgroundColor(getColor(R.color.black));
                } else {
                    mediumButton.setBackgroundColor(getColor(R.color.purple_500));
                    hardButton.setBackgroundColor(getColor(R.color.purple_500));
                    easyButton.setBackgroundColor(getColor(R.color.black));
                }
                difficulty = 0;
            }
        });

        mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (difficulty < -1) {
                    mediumButton.setBackgroundColor(getColor(R.color.black));
                } else {
                    easyButton.setBackgroundColor(getColor(R.color.purple_500));
                    hardButton.setBackgroundColor(getColor(R.color.purple_500));
                    mediumButton.setBackgroundColor(getColor(R.color.black));
                }
                difficulty = 1;
            }
        });

        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (difficulty < -1) {
                    hardButton.setBackgroundColor(getColor(R.color.black));
                } else {
                    mediumButton.setBackgroundColor(getColor(R.color.purple_500));
                    easyButton.setBackgroundColor(getColor(R.color.purple_500));
                    hardButton.setBackgroundColor(getColor(R.color.black));
                }
                difficulty = 2;
            }
        });

        character1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (character < -1) {
                    character1Button.setBackgroundColor(getColor(R.color.black));
                } else {
                    character2Button.setBackgroundColor(getColor(R.color.purple_500));
                    character3Button.setBackgroundColor(getColor(R.color.purple_500));
                    character1Button.setBackgroundColor(getColor(R.color.black));
                }
                character = 0;
            }
        });

        character2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (character < -1) {
                    character2Button.setBackgroundColor(getColor(R.color.black));
                } else {
                    character1Button.setBackgroundColor(getColor(R.color.purple_500));
                    character3Button.setBackgroundColor(getColor(R.color.purple_500));
                    character2Button.setBackgroundColor(getColor(R.color.black));
                }
                character = 1;
            }
        });

        character3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (character < -1) {
                    character3Button.setBackgroundColor(getColor(R.color.black));
                } else {
                    character1Button.setBackgroundColor(getColor(R.color.purple_500));
                    character2Button.setBackgroundColor(getColor(R.color.purple_500));
                    character3Button.setBackgroundColor(getColor(R.color.black));
                }
                character = 2;
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nameChecker(nameInput.getText().toString())) {
                    System.out.println(nameInput.getText());
                    System.out.println(difficulty);
                    System.out.println(character);
                    Toast.makeText(SelectScreen.this,
                            "Please enter a valid name input!", Toast.LENGTH_SHORT).show();
                } else if (!difficultyChecker(difficulty)) {
                    Toast.makeText(SelectScreen.this,
                            "Please select a valid difficulty!", Toast.LENGTH_SHORT).show();
                } else if (character < 0) {
                    Toast.makeText(SelectScreen.this,
                            "Please select a character!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent gameIntent = new Intent(SelectScreen.this, GameScreen.class);
                    gameIntent.putExtra("username", nameInput.getText().toString());
                    gameIntent.putExtra("difficulty", difficulty);
                    gameIntent.putExtra("character", character);
                    startActivity(gameIntent);
                    }
                }
        });


    }

}