package cdu.zch.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    // 枚举药品信息
    private String[][] packages =
            {
                    {"阿司匹林", "", "", "", "50"},
                    {"胖大海", "", "", "", "305"},
                    {"头孢", "", "", "", "448"},
                    {"青霉素", "", "", "", "539"},
                    {"999感冒灵", "", "", "", "30"},
                    {"百草枯", "", "", "", "50"},
                    {"灭草剂", "", "", "", "40"},
                    {"南京板鸭味道发烧药品", "", "", "", "30"},
                    {"西红柿炒鸡蛋味嗓子药", "", "", "", "130"},
            };

    private String[] package_details = {
            "缓解轻度或中度疼痛，如牙痛、头痛、神经痛、肌肉酸痛及痛经\n" +
                    "用于咽疾、用于肺热、肺燥咳嗽、用于大便干结\n" +
                    "头孢克洛是β-内酰胺类抗生素，头孢菌素类药",
            "第二代头孢菌素，主要适用于敏感菌所致的急性咽炎、急性扁桃体",
            "中耳炎、支气管炎、肺炎等呼吸道感染、皮肤软组织感染和尿路感染\n" +
                    "能破坏细菌的细胞壁并在细菌细胞的繁殖期起杀菌作用\n" +
                    "青霉素是很常用的抗菌药品",
            "治疗感冒\n" +
                    "延年益寿，吃了快乐至极，飞升成仙\n" +
                    "它是一种有灵性的药物",
            "其中含有的多肽合小分子具有极其震撼的力量可以让本来呼吸停止的人更加难以恢复呼吸很不错的一个药物希望各位都去试试加油奥里给",
            "极致的快乐需要你们尽情体验\n" +
                    "首先这款产品对所有高的东西都很敏感可以降高",
            "可以解馋消炎消暑消化各种毛病让你没病有病开心快乐每一天\n" +
                    "给你一个快乐的世界让你变成大螃蟹架在火上烤成猪脑花",
            "这个就更厉害了很牛逼的那种厉害激爽的快乐激爽的回应快乐加油奥里给\n" +
                    "促进关节的活动性让你健步如飞",
            "帮助减少由于慢性失血或铁摄入不足导致的缺铁状况"
    };
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);

        // 去购物车界面
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });
        // 返回Home
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost: " + packages[i][4] + "元");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        lst.setAdapter(sa);

        // 药品详情页面
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l) {
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                it.putExtra("text1" , packages[i][0]);
                it.putExtra("text2" , package_details[i]);
                it.putExtra("text3" , packages[i][4]);
                startActivity(it);
            }
        });
    }
}