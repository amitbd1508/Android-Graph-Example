package me.amitghosh.gruph;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

//http://www.android-graphview.org/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);


        GraphView graph2 = (GraphView) findViewById(R.id.graph2);
        BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, -1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph2.addSeries(series2);

// styling
        series2.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        series2.setSpacing(50);

// draw values on top
        series2.setDrawValuesOnTop(true);
        series2.setValuesOnTopColor(Color.RED);




        GraphView pointgruph = (GraphView) findViewById(R.id.pointgraph);

        PointsGraphSeries<DataPoint> pointgruphseries = new PointsGraphSeries<>(new DataPoint[] {
                new DataPoint(0, -2),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });

        pointgruph.addSeries(pointgruphseries);
        pointgruphseries.setShape(PointsGraphSeries.Shape.POINT);

        PointsGraphSeries<DataPoint> pointgruphseries2 = new PointsGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, -1),
                new DataPoint(1, 4),
                new DataPoint(2, 2),
                new DataPoint(3, 1),
                new DataPoint(4, 5)
        });
        pointgruph.addSeries(pointgruphseries2);
        pointgruphseries2.setShape(PointsGraphSeries.Shape.RECTANGLE);
        pointgruphseries2.setColor(Color.RED);

        PointsGraphSeries<DataPoint> pointgruphseries3 = new PointsGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 3),
                new DataPoint(2, 1),
                new DataPoint(3, 0),
                new DataPoint(4, 4)
        });
        pointgruph.addSeries(pointgruphseries3);
        pointgruphseries3.setShape(PointsGraphSeries.Shape.TRIANGLE);
        pointgruphseries3.setColor(Color.YELLOW);

        PointsGraphSeries<DataPoint> pointgruphseries4 = new PointsGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 2),
                new DataPoint(2, 0),
                new DataPoint(3, -1),
                new DataPoint(4, 3)
        });
        pointgruph.addSeries(pointgruphseries4);
        pointgruphseries4.setColor(Color.GREEN);
        pointgruphseries4.setCustomShape(new PointsGraphSeries.CustomShape() {
            @Override
            public void draw(Canvas canvas, Paint paint, float x, float y, DataPointInterface dataPoint) {
                paint.setStrokeWidth(10);
                canvas.drawLine(x-20, y-20, x+20, y+20, paint);
                canvas.drawLine(x+20, y-20, x-20, y+20, paint);
            }
        });

        GraphView mix = (GraphView) findViewById(R.id.mix);
        mix.addSeries(series2);
        mix.addSeries(series);



        //scrolable
        DataPoint[] points = new DataPoint[500];
        for (int i = 0; i < points.length; i++) {
            points[i] = new DataPoint(i, Math.sin(i*0.5) * 20*(Math.random()*10+1));
        }
        LineGraphSeries<DataPoint> scrolableseries = new LineGraphSeries<>(points);

        GraphView scrolablegraph = (GraphView) findViewById(R.id.scrolablegraph);
        // set manual X bounds
        scrolablegraph.getViewport().setYAxisBoundsManual(true);
        scrolablegraph.getViewport().setMinY(-150);
        scrolablegraph.getViewport().setMaxY(150);

        scrolablegraph.getViewport().setXAxisBoundsManual(true);
        scrolablegraph.getViewport().setMinX(4);
        scrolablegraph.getViewport().setMaxX(100);

        // enable scaling and scrolling
        scrolablegraph.getViewport().setScalable(true);
        scrolablegraph.getViewport().setScalableY(true);

        scrolablegraph.addSeries(scrolableseries);
    }



}
