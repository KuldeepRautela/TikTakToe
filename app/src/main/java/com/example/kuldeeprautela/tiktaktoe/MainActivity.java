package com.example.kuldeeprautela.tiktaktoe;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button img;
    String tag;
    int counter=0;
    GridLayout gridLayout;
    int array[][]=new int[3][3];
    public  void f1(View view){
        Log.d("it is running","");
        ColorDrawable color=(ColorDrawable) view.getBackground();
        if(color.getColor()==Color.CYAN){
        img=(Button) view;
        tag=img.getTag().toString();
        if(counter%2==0) {
            img.setBackgroundColor(Color.BLACK);
            array[tag.charAt(0)-48][tag.charAt(1)-48] = 1;
        }else{
            img.setBackgroundColor(Color.YELLOW);
            array[tag.charAt(0)-48][tag.charAt(1)-48] = 2;
        }
        counter++;
        int check=check(tag.charAt(0)-48,tag.charAt(1)-48);
        if(check!=0) {
            if(check==1)
            Toast.makeText(getApplicationContext(),"Black wins ", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(),"Yellow wins ", Toast.LENGTH_LONG).show();
            allClear();
        }else
            if(counter==9)
            {
                Toast.makeText(getApplicationContext(),"DRAW", Toast.LENGTH_LONG).show();

                allClear();
    }}}
    public int check(int row,int col){
        if(array[0][0]==array[1][1] && array[0][0]==array[2][2] || array[0][2]==array[1][1] && array[2][0]==array[1][1])
            return array[1][1];
        int temp=array[row][col],i;
        for (i=0;i<3;i++){
            if(temp!=array[row][i])
                break;
        }
        if(i==3)
            return temp;
        for (i=0;i<3;i++){
            if(temp!=array[i][col])
                break;
        }
        if(i==3)
            return temp;
        return 0;
    }
    public void allClear(){
        counter=0;
        for(int i=0;i<3;i++)
            for (int j=0;j<3;j++)
                array[i][j]=0;
        for(int i=0;i<gridLayout.getChildCount();i++) {
            Button button=(Button)  gridLayout.getChildAt(i);
              button.setBackgroundColor(Color.CYAN);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayout=(GridLayout) findViewById(R.id.grid);
        allClear();
    }
}
