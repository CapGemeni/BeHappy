package com.bbva.intranet.behappy.modules.animometro;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.ActivityEstadisticaBinding;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;
import java.util.List;

public class EstadisticaActivity extends AppCompatActivity implements OnChartValueSelectedListener {

    ActivityEstadisticaBinding binding;
    protected String[] mParties = new String[] {
            "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "",
            "", ""
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_estadistica);

        setSupportActionBar(binding.viewToolbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.label_er_estadisticas);

        /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            init();
        }
        */
        
        init2();
    }

    private void init2() {
        binding.chart.setUsePercentValues(true);
        binding.chart.getDescription().setEnabled(false);
        binding.chart.setExtraOffsets(5, 10, 5, 5);

        binding.chart.setDragDecelerationFrictionCoef(0.95f);

        binding.chart.setDrawHoleEnabled(true);
        binding.chart.setHoleColor(Color.WHITE);

        binding.chart.setTransparentCircleColor(Color.WHITE);
        binding.chart.setTransparentCircleAlpha(110);

        binding.chart.setHoleRadius(85f);
        binding.chart.setTransparentCircleRadius(61f);

        //binding.chart.setDrawCenterText(true);

        binding.chart.setRotationAngle(0);
        // enable rotation of the chart by touch
        binding.chart.setRotationEnabled(true);
        binding.chart.setHighlightPerTapEnabled(true);

        // binding.chart.setUnit(" €");
        // binding.chart.setDrawUnitsInChart(true);

        // add a selection listener
        binding.chart.setOnChartValueSelectedListener(this);

        setData(5, 100);

        binding.chart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // binding.chart.spin(2000, 0, 360);

        Legend l = binding.chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // entry label styling
        binding.chart.setEntryLabelColor(Color.WHITE);
        binding.chart.setEntryLabelTextSize(12f);
    }

    private void setData(int count, float range) {

        float mult = range;

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < count ; i++) {
            entries.add(new PieEntry((float) ((Math.random() * mult) + mult / 5),
                    mParties[i % mParties.length],
                    getResources().getDrawable(R.drawable.icon_happy)));
        }

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setDrawValues(false);
        dataSet.setDrawIcons(true);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 25));
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        binding.chart.setData(data);

        // undo all highlights
        binding.chart.highlightValues(null);

        binding.chart.invalidate();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void init() {
        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(18.5f, ""));
        entries.add(new PieEntry(26.7f, ""));
        entries.add(new PieEntry(24.0f, ""));
        entries.add(new PieEntry(30.8f, ""));

        PieDataSet set = new PieDataSet(entries, "");
        set.setColors(new int[] { R.color.green, R.color.yellow, R.color.red, R.color.blue }, this);
        PieData data = new PieData(set);
        binding.chart.setData(data);

        binding.chart.invalidate(); // refresh
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
