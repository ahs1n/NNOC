package edu.aku.hassannaqvi.uen_scans_bl.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FoodFreqContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_scans_bl.core.MainApp;
import edu.aku.hassannaqvi.uen_scans_bl.databinding.ActivitySectionD2Binding;
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util;

public class SectionD2Activity extends AppCompatActivity {

    ActivitySectionD2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d2);
        bi.setCallback(this);

        setupListeners();

    }

    private void setupListeners() {

        bi.d205.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.d20597.getId()) {
                bi.d205sub.clearCheck();
                bi.fldGrpCVd205sub.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVd205sub.setVisibility(View.VISIBLE);
            }
        });

        bi.d206.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.d20697.getId()) {
                bi.d206sub.clearCheck();
                bi.fldGrpCVd206sub.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVd206sub.setVisibility(View.VISIBLE);
            }
        });

        bi.d209.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == bi.d20997.getId()) {
                bi.d209sub.clearCheck();
                bi.fldGrpCVd209sub.setVisibility(View.GONE);
            } else {
                bi.fldGrpCVd209sub.setVisibility(View.VISIBLE);
            }
        });
    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionD3Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void BtnEnd() {
        Util.openEndActivity(this);
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFoodFreqColumn(FoodFreqContract.SingleFoodFreq.COLUMN_SD2, MainApp.foodFreq.getsD2());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("d201",
                bi.d201a.isChecked() ? "1" :
                        bi.d201b.isChecked() ? "2" :
                                bi.d201c.isChecked() ? "3" :
                                        bi.d201d.isChecked() ? "4" :
                                                bi.d201e.isChecked() ? "5" :
                                                        bi.d201f.isChecked() ? "6" :
                                                                bi.d201g.isChecked() ? "98" :
                                                                        "0");

        json.put("d202",
                bi.d202a.isChecked() ? "1" :
                        bi.d202b.isChecked() ? "2" :
                                bi.d202c.isChecked() ? "3" :
                                        bi.d202d.isChecked() ? "4" :
                                                bi.d202e.isChecked() ? "5" :
                                                        bi.d202f.isChecked() ? "6" :
                                                                bi.d202g.isChecked() ? "7" :
                                                                        bi.d202h.isChecked() ? "8" :
                                                                                "0");

        json.put("d203",
                bi.d203a.isChecked() ? "1" :
                        bi.d203b.isChecked() ? "2" :
                                bi.d203c.isChecked() ? "3" :
                                        bi.d203d.isChecked() ? "4" :
                                                bi.d203e.isChecked() ? "5" :
                                                        bi.d203f.isChecked() ? "6" :
                                                                bi.d203g.isChecked() ? "7" :
                                                                        bi.d203h.isChecked() ? "8" :
                                                                                "0");

        json.put("d204",
                bi.d204a.isChecked() ? "1" :
                        bi.d204b.isChecked() ? "2" :
                                bi.d204c.isChecked() ? "3" :
                                        bi.d204d.isChecked() ? "4" :
                                                bi.d204e.isChecked() ? "5" :
                                                        bi.d204f.isChecked() ? "6" :
                                                                bi.d204g.isChecked() ? "7" :
                                                                        bi.d204h.isChecked() ? "8" :
                                                                                "0");

        json.put("d205",
                bi.d205a.isChecked() ? "1" :
                        bi.d205b.isChecked() ? "2" :
                                bi.d20597.isChecked() ? "97" :
                                        "0");

        json.put("d205sub",
                bi.d205suba.isChecked() ? "1" :
                        bi.d205subb.isChecked() ? "2" :
                                bi.d205subc.isChecked() ? "3" :
                                        bi.d205subd.isChecked() ? "4" :
                                                bi.d205sube.isChecked() ? "5" :
                                                        bi.d205subf.isChecked() ? "6" :
                                                                bi.d205subg.isChecked() ? "7" :
                                                                        "0");

        json.put("d206",
                bi.d206a.isChecked() ? "1" :
                        bi.d206b.isChecked() ? "2" :
                                bi.d206c.isChecked() ? "3" :
                                        bi.d206d.isChecked() ? "4" :
                                                bi.d20696.isChecked() ? "96" :
                                                        bi.d20697.isChecked() ? "97" :
                                                                "0");
        json.put("d20696x", bi.d20696x.getText().toString());

        json.put("d206sub",
                bi.d206suba.isChecked() ? "1" :
                        bi.d206subb.isChecked() ? "2" :
                                bi.d206subc.isChecked() ? "3" :
                                        bi.d206subd.isChecked() ? "4" :
                                                bi.d206sube.isChecked() ? "5" :
                                                        bi.d206subf.isChecked() ? "6" :
                                                                bi.d206subg.isChecked() ? "7" :
                                                                        "0");

        json.put("d207",
                bi.d207a.isChecked() ? "1" :
                        bi.d207b.isChecked() ? "2" :
                                bi.d207c.isChecked() ? "3" :
                                        bi.d207d.isChecked() ? "4" :
                                                bi.d207e.isChecked() ? "5" :
                                                        bi.d207f.isChecked() ? "6" :
                                                                bi.d207g.isChecked() ? "7" :
                                                                        "0");

        json.put("d208",
                bi.d208a.isChecked() ? "1" :
                        bi.d208b.isChecked() ? "2" :
                                bi.d208c.isChecked() ? "3" :
                                        bi.d208d.isChecked() ? "4" :
                                                bi.d208e.isChecked() ? "5" :
                                                        bi.d208f.isChecked() ? "6" :
                                                                bi.d208g.isChecked() ? "7" :
                                                                        "0");

        json.put("d209",
                bi.d209a.isChecked() ? "1" :
                        bi.d209b.isChecked() ? "2" :
                                bi.d20997.isChecked() ? "97" :
                                        "0");

        json.put("d209sub",
                bi.d209suba.isChecked() ? "1" :
                        bi.d209subb.isChecked() ? "2" :
                                bi.d209subc.isChecked() ? "3" :
                                        bi.d209subd.isChecked() ? "4" :
                                                bi.d209sube.isChecked() ? "5" :
                                                        bi.d209subf.isChecked() ? "6" :
                                                                bi.d209subg.isChecked() ? "7" :
                                                                        "0");

        json.put("d210",
                bi.d210a.isChecked() ? "1" :
                        bi.d210b.isChecked() ? "2" :
                                bi.d210c.isChecked() ? "3" :
                                        bi.d210d.isChecked() ? "4" :
                                                bi.d210e.isChecked() ? "5" :
                                                        bi.d210f.isChecked() ? "6" :
                                                                bi.d210g.isChecked() ? "98" :
                                                                        "0");

        MainApp.foodFreq.setsD2(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionD2);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


}
