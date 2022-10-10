package com.example.hw2_robertpaud

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidplot.xy.*
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import java.util.*
import kotlin.collections.ArrayList

class LineFragment : Fragment(R.layout.fragment_line) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_line, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lineChart = view.findViewById<LineChart>(R.id.lineChart)

        fun setLineChartData() {
            val lineentry = ArrayList<Entry>()
            lineentry.add(Entry(1f, 5f))
            lineentry.add(Entry(2f, 1f))
            lineentry.add(Entry(3f, 3f))
            lineentry.add(Entry(4f, 2f))

            val lineentry2 = ArrayList<Entry>()
            lineentry2.add(Entry(1f, 1f))
            lineentry2.add(Entry(2f, 3f))
            lineentry2.add(Entry(3f, 2f))
            lineentry2.add(Entry(4f, 4f))

            val lineentry3 = ArrayList<Entry>()
            lineentry3.add(Entry(1f, 2f))
            lineentry3.add(Entry(2f, 5f))
            lineentry3.add(Entry(3f, 1f))
            lineentry3.add(Entry(4f, 6f))

            val linedataset = LineDataSet(lineentry, "First")
            linedataset.color = resources.getColor(R.color.teal_200)

            val linedataset2 = LineDataSet(lineentry2, "Second")
            linedataset2.color = resources.getColor(R.color.purple_500)

            val linedataset3 = LineDataSet(lineentry3, "Third")
            linedataset3.color = resources.getColor(R.color.red)

            val finaldataset = ArrayList<LineDataSet>()
            finaldataset.add(linedataset)
            finaldataset.add(linedataset2)
            finaldataset.add(linedataset3)

            val data = LineData(finaldataset as List<ILineDataSet>?)
            lineChart.data = data
            lineChart.setBackgroundColor(resources.getColor(R.color.white))
            lineChart.animateXY(2000,2000)
        }
        setLineChartData()
    }
}
