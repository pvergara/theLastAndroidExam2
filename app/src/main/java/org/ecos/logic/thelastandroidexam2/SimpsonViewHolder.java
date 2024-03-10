package org.ecos.logic.thelastandroidexam2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SimpsonViewHolder extends RecyclerView.ViewHolder {

    private final TextView name;

    private final TextView longName;
    private final TextView age;
    private final TextView description;
    private final TextView nationality;
    private final TextView gender;
    private final ImageView simpsonPhoto;
    private SimpsonAdapter simpsonAdapter;

    public SimpsonViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnLongClickListener(v -> {
            SimpsonViewHolder.this.simpsonAdapter.setSelectedPosition(getAdapterPosition());
            return true;
        });
        name = itemView.findViewById(R.id.name_text_view);
        longName = itemView.findViewById(R.id.long_name_text_view);
        age = itemView.findViewById(R.id.age_text_view);
        description = itemView.findViewById(R.id.description_text_view);
        nationality = itemView.findViewById(R.id.nationality_text_view);
        gender = itemView.findViewById(R.id.gender_text_view);
        simpsonPhoto = itemView.findViewById(R.id.simpson_image_view);
    }


    public TextView getName() {
        return name;
    }

    public TextView getLongName() {
        return longName;
    }

    public TextView getAge() {
        return age;
    }

    public TextView getDescription() {
        return description;
    }

    public TextView getNationality() {
        return nationality;
    }

    public TextView getGender() {
        return gender;
    }

    public ImageView getSimpsonPhoto() {
        return simpsonPhoto;
    }

    public void setAdapter(SimpsonAdapter simpsonAdapter) {

        this.simpsonAdapter = simpsonAdapter;
    }
}
