package com.example.aml.clearn

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.view.Menu
import android.view.MenuItem
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.ColorTemplate
import java.util.ArrayList

class Main3Activity : AppCompatActivity(), OnChartValueSelectedListener {
    override fun onNothingSelected() {

    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {

    }

    protected var mMonths = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec")

    protected var mParties = arrayOf("Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H", "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P", "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X", "Party Y", "Party Z")
    lateinit var mChart: PieChart
    private lateinit var tf: Typeface;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        mChart = findViewById(R.id.chart1)
        mChart.setUsePercentValues(true)
        mChart.getDescription().setEnabled(false)
        mChart.setExtraOffsets(5f, 10f, 5f, 5f)

        mChart.setDragDecelerationFrictionCoef(0.95f)

        tf = Typeface.createFromAsset(assets, "OpenSans-Regular.ttf")

        mChart.setCenterTextTypeface(Typeface.createFromAsset(assets, "OpenSans-Light.ttf"))
        mChart.setCenterText(generateCenterSpannableText())

        mChart.setExtraOffsets(20f, 0f, 20f, 0f)

        mChart.setDrawHoleEnabled(true)
        mChart.setHoleColor(Color.WHITE)

        mChart.setTransparentCircleColor(Color.WHITE)
        mChart.setTransparentCircleAlpha(110)

        mChart.setHoleRadius(58f)
        mChart.setTransparentCircleRadius(61f)

        mChart.setDrawCenterText(true)

        mChart.setRotationAngle(0f)
        // enable rotation of the chart by touch
        mChart.setRotationEnabled(true)
        mChart.setHighlightPerTapEnabled(true)

        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
        mChart.setOnChartValueSelectedListener(this)

        setData(4, 100f)

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad)
        // mChart.spin(2000, 0, 360);

        val l = mChart.getLegend()
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP)
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT)
        l.setOrientation(Legend.LegendOrientation.VERTICAL)
        l.setDrawInside(false)
        l.setEnabled(false)

    }

    private fun setData(count: Int, range: Float) {

        val entries = ArrayList<PieEntry>()

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (i in 0 until count) {
            entries.add(PieEntry((Math.random() * range).toFloat() + range / 5, mParties[i % mParties.size]))
        }

        val dataSet = PieDataSet(entries, "Election Results")
        dataSet.sliceSpace = 3f
        dataSet.selectionShift = 5f

        // add a lot of colors

        val colors = ArrayList<Int>()

        for (c in ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c)

        for (c in ColorTemplate.JOYFUL_COLORS)
            colors.add(c)

        for (c in ColorTemplate.COLORFUL_COLORS)
            colors.add(c)

        for (c in ColorTemplate.LIBERTY_COLORS)
            colors.add(c)

        for (c in ColorTemplate.PASTEL_COLORS)
            colors.add(c)

        colors.add(ColorTemplate.getHoloBlue())

        dataSet.colors = colors
        //dataSet.setSelectionShift(0f);


        dataSet.valueLinePart1OffsetPercentage = 80f
        dataSet.valueLinePart1Length = 0.2f
        dataSet.valueLinePart2Length = 0.4f
        //dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.yValuePosition = PieDataSet.ValuePosition.OUTSIDE_SLICE

        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.BLACK)
        data.setValueTypeface(tf)
        mChart.data = data

        // undo all highlights
        mChart.highlightValues(null)

        mChart.invalidate()
    }

    private fun generateCenterSpannableText(): SpannableString {

        val s = SpannableString("MPAndroidChart\ndeveloped by Philipp Jahoda")

        s.setSpan(RelativeSizeSpan(1.5f), 0, 14, 0)
        s.setSpan(StyleSpan(Typeface.NORMAL), 14, s.length - 15, 0)
        s.setSpan(ForegroundColorSpan(Color.GRAY), 14, s.length - 15, 0)
        s.setSpan(RelativeSizeSpan(.65f), 14, s.length - 15, 0)
        s.setSpan(StyleSpan(Typeface.ITALIC), s.length - 14, s.length, 0)
        s.setSpan(ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length - 14, s.length, 0)
        return s
    }

}
