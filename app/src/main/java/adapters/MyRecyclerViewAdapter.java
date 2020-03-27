package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.application.databindingexample.BR;
import com.application.databindingexample.R;
import com.application.databindingexample.databinding.ItemRowBinding;
import java.util.ArrayList;
import interfaces.CustomClickListener;
import model.Person;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> implements CustomClickListener {

    private ArrayList<Person> dataModelList;
    private Context context;

    public MyRecyclerViewAdapter(ArrayList<Person> dataModelList, Context ctx) {
        this.dataModelList = dataModelList;
        context = ctx;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                               int viewType) {
        ItemRowBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_row, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person dataModel = dataModelList.get(position);
       // holder.bind(dataModel);
        holder.itemRowBinding.setModel(dataModel);
        holder.itemRowBinding.setItemClickListener(this);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    @Override
    public void cardClicked(Person p) {
        Toast.makeText(context, "You clicked " + p.getName(),
                Toast.LENGTH_SHORT).show();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemRowBinding itemRowBinding;

        ViewHolder(ItemRowBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        void bind(Object obj) {
            itemRowBinding.setVariable(BR.model, obj);
            itemRowBinding.executePendingBindings();
        }
    }

}
