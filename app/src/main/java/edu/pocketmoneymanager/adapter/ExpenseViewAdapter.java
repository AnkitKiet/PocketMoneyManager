package edu.pocketmoneymanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import edu.pocketmoneymanager.R;
import edu.pocketmoneymanager.model.ExpenseModel;

/**
 * Created by Ankit on 04/12/17.
 */

public class ExpenseViewAdapter extends RecyclerView.Adapter<ExpenseViewAdapter.RecyclerViewHolder> {

    private List<ExpenseModel> borrowModelList;
    private Context context;

    public ExpenseViewAdapter(Context context, List<ExpenseModel> borrowModelList) {
        this.borrowModelList = borrowModelList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        ExpenseModel borrowModel = borrowModelList.get(position);
        holder.moneyTextView.setText(String.valueOf(borrowModel.getMoney()));
        holder.detailsTextView.setText(borrowModel.getDetails());
        holder.dateTextView.setText(borrowModel.getTimestamp().toLocaleString().substring(0, 11));
        holder.itemView.setTag(borrowModel);
        if (borrowModel.getAdd().equals("true")) {
            holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        }else{
            holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.red));

        }
        // holder.itemView.setOnLongClickListener(longClickListener);
    }

    @Override
    public int getItemCount() {
        return borrowModelList.size();
    }

    public void addItems(List<ExpenseModel> borrowModelList) {
        this.borrowModelList = borrowModelList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView detailsTextView;
        private TextView moneyTextView;
        private TextView dateTextView;
        private LinearLayout linearLayout;

        RecyclerViewHolder(View view) {
            super(view);
            linearLayout = (LinearLayout) view.findViewById(R.id.ll);
            moneyTextView = (TextView) view.findViewById(R.id.txtMoney);
            detailsTextView = (TextView) view.findViewById(R.id.txtDetails);
            dateTextView = (TextView) view.findViewById(R.id.txtDate);
        }
    }
}