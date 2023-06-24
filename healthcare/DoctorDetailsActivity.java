package cdu.zch.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    // 枚举每个页面医生的信息，各有五个信息
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : PGone", "Hospital Address : lixiaolu", "Exp : 5yrs", "Mobile No:1008611", "600"},
                    {"Doctor Name : 吴亦凡", "Hospital Address : 监狱.", "Exp : 15yrs", "Mobile No:11012011", "988"},
                    {"Doctor Name : 李易峰", "Hospital Address : 风月场所", "Exp : 8yrs", "Mobile No:8898989898", "3008"},
                    {"Doctor Name : 范冰冰", "Hospital Address : 税务局", "Exp : 6yrs", "Mobile Mo:98980000", "500"},
                    {"Doctor Name : 老八", "Hospital Address :厕所", "Exp : 7yrs", "Mobile No:7798989898", "808"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : 小八嘎", "Hospital Address : 日本", "Exp : 5yrsS", "Mobile No:9898989898", "600"},
                    {"Doctor Name : 小西巴", "Hospital Address : 韩国", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Mame :小魔仙", "Hospital Address : 魔仙堡", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Mame : 小样肖恩", "Hospital Address : 羊村", "Exp : 6yrs", "Mobile No:989800000", "500"},
                    {"Doctor Name : 小沈阳", "Hospital Address : 沈阳", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : ak", "Hospital Address : 日照", "Exp : 4yrs", "Mobile No:9898989898", "280"},
                    {"Doctor Name : m4a1", "Hospital Address : 日照", "Exp : 5yrs", "Mobile No:7898989898", "300"},
                    {"Doctor Name : sgr", "Hospital Address :日照", "Exp : 7yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Mame : Make ", "Hospital Address : 日照", "Exp : 6yns", "Mobile No:989800000", "500"},
                    {"Doctor Name : Jone ", "Hospital Address : 日照", "Exp : 7yrs", "Mobile No:7798989898", "60"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Amal Gawade", "Hospital Address : 青岛", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Prasad Paa.", "Hospital Address : 北京", "Exp : 15yrs", "Mobile No:7898989898", "980"},
                    {"Doctor Name : Nilesh Kale", "Hospital Address : 南京", "Exp : 8yrs", "Mobile No:88989:9898", "300"},
                    {"Doctor Name : Deepak Deshpande", "Hospital Address : 上海", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Ashok Singh", "Hospital Address :济宁", "Exp : 7yrst", "Mobile No:7798989898", "300"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Nilesh Bonate", "Hospital Address : Pimpri", "Exp : 5yns", "Mobile No:9898989898", "1600"},
                    {"Doctor MName : Pamkai Paarc", "Hospital Address : Migdi", "Exp : 15yrs", "Mobile No:7898989898", "1900"},
                    {"Doctor Name : Sapnil LeLe", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:898989898", "1300"},
                    {"Doctor Name : Deepak Kumar", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:989800800", "1500"},
                    {"Doctor Name : Ankul Panda", "Hospital Address : Katnaj", "Exp : 7yrs", "Mobile No:7798989898", "1800"}
            };


    TextView tv;
    Button btn;
    String[][] doctor_details = {};

    ArrayList list;
    SimpleAdapter sa;
    HashMap<String, String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.titleViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians") == 0) {
            doctor_details = doctor_details1;
        } else if (title.compareTo("Dietician") == 0) {
            doctor_details = doctor_details2;
        } else if (title.compareTo("Dentist") == 0) {
            doctor_details = doctor_details3;
        } else if (title.compareTo("Surgeon") == 0) {
            doctor_details = doctor_details4;
        } else if (title.compareTo("Cardiologists") == 0) {
            doctor_details = doctor_details5;
        }

        // 返回上一个页面
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:" + doctor_details[i][4] + "元");
            list.add(item);
        }
        sa = new SimpleAdapter(this,
                list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView listView = findViewById(R.id.listViewDD);
        listView.setAdapter(sa);

        // 点击某一个行跳转到某个医生的详情页面
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[position][0]);
                it.putExtra("text3", doctor_details[position][1]);
                it.putExtra("text4", doctor_details[position][3]);
                it.putExtra("text5", doctor_details[position][4]);
                startActivity(it);
            }
        });
    }
}