package com.gura.step03fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // activity_main.xml 에 정의된 TextView 의 참조값 필요하다면?
        TextView textView=(TextView) findViewById(R.id.textView);
        // activity_main.xml 에 정의된 Fragment 의 참조값이 필요하다면?
        FragmentManager fManager = getSupportFragmentManager();
        MyFragment f =(MyFragment)
                fManager.findFragmentById(R.id.myFragment);
    }


    //미니컨트롤러라고 생각하자  메인엑티비티클레스의 이너클레스로 만들어주자.(플레그먼트)
    public static class MyFragment extends Fragment implements View.OnClickListener{

        //리턴해주는 View 객체가 MyFragment 의 레이아웃이다(UI).
        @Nullable
        @Override // View 객체를 리턴하기위해 오버라이드를 한다.
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            // res/layout/fragent_my.xml 문서를 전개해서 View 객체를
            // 만든다.
            View v=inflater.inflate(R.layout.flagment_my, container); //xml문서를 뷰객체로 만들어준다.(inflater)

            //Button 의 참조값 얻어오기
            Button btn=(Button)v.findViewById(R.id.btn1);
            btn.setOnClickListener(this);

            // 만든 View 객체를 리턴해준다.
            return v;
        }

        @Override
        public void onClick(View v) { //getActivity는 플레그먼트의 메소드로써 나를 관리하고있는 참조값을 얻어올수 있다.
            Toast.makeText( getActivity(),"btn1 !",Toast.LENGTH_SHORT).show();
        }
    }
}
