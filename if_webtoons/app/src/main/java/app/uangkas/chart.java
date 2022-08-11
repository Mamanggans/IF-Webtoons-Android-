package app.uangkas;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class chart extends AppCompatActivity {

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pie_layout);
        pieChart = (PieChart) findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);


        ArrayList<PieEntry> month = new ArrayList<>();

        month.add(new PieEntry(2000f,"Garudayana 1000"));
        month.add(new PieEntry(3000f,"DMNS 8000"));
        month.add(new PieEntry(4000f,"SxF 4000"));
        month.add(new PieEntry(5000f,"One-Piece 5000"));
        month.add(new PieEntry(7000f,"Komi-san 7000"));

        Description description = new Description();
        description.setText("data diatas adalah jumlah 5 comic terpopuler di ifwebtoons dan " +
                "data yang di tampilkan adalah dalam persen");
        description.setTextSize(12);
        pieChart.setDescription(description);

        pieChart.animateY( 1000, Easing.EaseInOutCubic);

        PieDataSet dataset = new PieDataSet(month, "month");
        dataset.setSliceSpace(3f);
        dataset.setSelectionShift(5f);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData((dataset));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLUE);
        pieChart.setData(data);
    }
}
