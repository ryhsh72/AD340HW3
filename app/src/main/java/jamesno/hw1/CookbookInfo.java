package jamesno.hw1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CookbookInfo extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;

    // 2D data array
    String[][] cookbooks =
            {
                    {"THE FRENCH LAUNDRY", "THOMAS KELLER"},
                    {"WD-40", "WYLIE DUFRESNE"},
                    {"MOMOFUKU", "DAVID CHANG"},
                    {"FLOUR", "JOANNE CHANG"},
                    {"ON FOOD AND COOKING", "HAROLD MCGEE"},
                    {"ELEVEN MADISON PARK", "DANIEL HUMM"},
                    {"IVAN RAMEN", "IVAN ORKIN"},
                    {"GRAMERCY TAVERN", "MICHAEL ANTHONY"},
                    {"LUCQUES", "SUZANNE GOIN"},
                    {"PRUNE", "GABRIELLE HAMILTON"},
                    {"DANIEL", "DANIEL BOULUD"},
                    {"VONG", "JEAN GEORGES VONGERITCHEN"},
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        context = getApplicationContext();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        recylerViewLayoutManager = new LinearLayoutManager(context);

        // use a linear layout manager
        recylerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recylerViewLayoutManager);

        recyclerViewAdapter = new CustomAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTitle;
            public TextView mDetail;

            public ViewHolder(View v) {
                super(v);
                mTitle = (TextView) v.findViewById(R.id.subject_1);
                mDetail = (TextView) v.findViewById(R.id.subject_2);
            }
        }

        @Override
        public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            // Inflate the view for this view holder
            View item = getLayoutInflater().inflate(R.layout.list_item2, parent,
                    false);

            // Call the view holder's constructor, and pass the view to it;
            // return that new view holder
            ViewHolder vh = new ViewHolder(item);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.mTitle.setText(cookbooks[position][0]);
            holder.mDetail.setText(cookbooks[position][1]);
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return cookbooks.length;
        }
    }
}