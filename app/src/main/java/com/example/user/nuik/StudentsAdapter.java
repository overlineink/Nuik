package com.example.user.nuik;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder> {
    private Context mCtx;
    private List<Students> stdList;
    public StudentsAdapter(Context mCtx, List<Students> stddtList) {
        this.mCtx = mCtx;
        this.stdList = stddtList;
    }
    @NonNull
    @Override
    public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentsViewHolder(
                LayoutInflater.from(mCtx).inflate(R.layout.layout_students  , parent, false)
        );
    }
    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, int position) {
        Students students = stdList.get(position);

        holder.textViewNum.setText(students.getStudentNum());
        holder.textViewName.setText(students.getStudenttName());
        holder.textViewPre.setText(students.getStudentPrenom());
        holder.textViewparcc.setText(students.getStudentPar());
        holder.textViewsp.setText(students.getStudentSp());
        holder.textViewann.setText(students.getStudentNiveau());
        holder.textViewgrp.setText(students.getStudentGroup());

    }

    @Override
    public int getItemCount() {
        return stdList.size();
    }
    class StudentsViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewNum, textViewparcc ,textViewPre ,textViewsp, textViewann,  textViewgrp;

        public StudentsViewHolder(View itemView) {
            super(itemView);

            textViewNum = itemView.findViewById(R.id.textview_num);
            textViewName = itemView.findViewById(R.id.textview_name);
            textViewparcc = itemView.findViewById(R.id.textview_parcc);

        }
    }

}
