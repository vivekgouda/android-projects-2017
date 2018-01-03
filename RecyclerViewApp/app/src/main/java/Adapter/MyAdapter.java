package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.gouda.vivek.recyclerviewapp.DetailsActivity;
import com.gouda.vivek.recyclerviewapp.R;

import java.util.List;

import Model.ListItem;

/**
 * Created by vivek on 1/9/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<ListItem> listItem;

    public MyAdapter(Context context, List listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

        ListItem item = listItem.get(position);

        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.rating.setText(item.getRating());
    }

    @Override
    public int getItemCount() {

        return listItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView name;
        public TextView description;
        public TextView rating;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            rating = (TextView) itemView.findViewById(R.id.rating);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();

            ListItem item = listItem.get(position);

            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("name",item.getName());
            intent.putExtra("description",item.getDescription());
            intent.putExtra("rating",item.getRating());

            context.startActivity(intent);

            Toast.makeText(context,item.getName(), Toast.LENGTH_SHORT).show();

        }
    }
}
