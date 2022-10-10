package com.example.hw2_robertpaud

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidplot.xy.BarRenderer
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet

class BarFragment : Fragment(R.layout.fragment_bar) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bar, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val barChart = view.findViewById<BarChart>(R.id.barChart)
        val barSpace = 0.01f
        val groupSpace = 0.3f

        fun setBarChartData() {
            val yaxis = arrayOf(3.1f,4.6f,5.3f,7f)
            val yaxis2 = arrayOf(2.3f,5.8f,2.6f,6.5f)
            val yaxis3 = arrayOf(4.0f,2.2f,3.8f,4.4f)

            val barentry = ArrayList<BarEntry>()
            val barentry2 = ArrayList<BarEntry>()
            val barentry3 = ArrayList<BarEntry>()

            for(i in 0..yaxis.size-1)
            {
                barentry.add(BarEntry(i.toFloat(),yaxis[i]))
            }
            for(i in 0..yaxis2.size-1)
            {
                barentry2.add(BarEntry(i.toFloat(),yaxis2[i]))
            }
            for(i in 0..yaxis3.size-1)
            {
                barentry3.add(BarEntry(i.toFloat(),yaxis3[i]))
            }

            val bardataset = BarDataSet(barentry, "First")
            bardataset.color = resources.getColor(R.color.teal_200)

            val bardataset2 = BarDataSet(barentry2, "Second")
            bardataset2.color = resources.getColor(R.color.purple_500)

            val bardataset3 = BarDataSet(barentry3, "Third")
            bardataset3.color = resources.getColor(R.color.red)

            val finaldataset = ArrayList<BarDataSet>()
            finaldataset.add(bardataset)
            finaldataset.add(bardataset2)
            finaldataset.add(bardataset3)

            val data = BarData(finaldataset as List<IBarDataSet>?)
            barChart.data = data
            data.barWidth = 0.15f
            barChart.setBackgroundColor(resources.getColor(R.color.white))
            barChart.xAxis.axisMinimum = 0f
            barChart.animateXY(2000,2000)
            barChart.groupBars(0f, groupSpace, barSpace)
        }
        setBarChartData()
    }


}