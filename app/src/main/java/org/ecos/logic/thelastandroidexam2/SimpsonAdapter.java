package org.ecos.logic.thelastandroidexam2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SimpsonAdapter extends RecyclerView.Adapter<SimpsonViewHolder> {

    List<Personaje> simpsons;

    public SimpsonAdapter(List<Personaje> theSimpsons) {
        simpsons = theSimpsons;
    }

    int selectedPos=RecyclerView.NO_POSITION;
    public int getSelectedPos () {
        return selectedPos;
    }
    public void setSelectedPosition(int newPosition) {
        if (newPosition == this.selectedPos){
            this.selectedPos=RecyclerView.NO_POSITION;
            notifyItemChanged(newPosition);
        } else {
            if (this.selectedPos >=0 ) {
                notifyItemChanged(this.selectedPos);
            }
            this.selectedPos = newPosition;
            notifyItemChanged(newPosition);
        }
    }

    @NonNull
    @Override
    public SimpsonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell,parent,false);
        return new SimpsonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpsonViewHolder holder, int position) {
        Personaje simpson = simpsons.get(position);

        holder.getName().setText(simpson.getNombre());
        holder.getLongName().setText(simpson.getNombreLargo());
        holder.getAge().setText(simpson.getEdad()+"");
        holder.getNationality().setText(simpson.getNacionalidad());
        holder.getGender().setText(simpson.getGenero());
        holder.getDescription().setText(simpson.getDesc());
        holder.getSimpsonPhoto().setImageResource(simpson.getImagen()   );
        holder.setAdapter(this);
        if (selectedPos == position) {
            holder.itemView.setBackgroundResource(R.color.seleccionado);
        } else {
            holder.itemView.setBackgroundResource(R.color.colorcelda);
        }


    }

    @Override
    public int getItemCount() {
        return simpsons.size();
    }
}
