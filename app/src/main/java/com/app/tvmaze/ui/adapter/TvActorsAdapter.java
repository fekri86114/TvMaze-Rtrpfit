package com.app.tvmaze.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.tvmaze.databinding.ActorsListRowBinding;
import com.app.tvmaze.model.Person;
import com.app.tvmaze.model.TvMazeModelItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TvActorsAdapter extends RecyclerView.Adapter<TvActorsAdapter.TvActorrVieWholder> {
	private final List<TvMazeModelItem> tvMazeModelItemList;

	public TvActorsAdapter(List<TvMazeModelItem> tvMazeModelItemList) {
		this.tvMazeModelItemList = tvMazeModelItemList;
	}

	@NonNull
	@Override
	public TvActorrVieWholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return new TvActorrVieWholder(ActorsListRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
	}

	@Override
	public void onBindViewHolder(@NonNull TvActorrVieWholder holder, int position) {
		TvMazeModelItem item = tvMazeModelItemList.get(position);
		Picasso.get().load(item.getPerson().getImage().getMedium()).centerCrop().into(holder.binding.imageviewActors);
		holder.binding.textviewActorsName.setText(item.getPerson().getName());
		holder.binding.textviewActorsGender.setText(item.getPerson().getGender());
		holder.binding.textviewActorsBirthday.setText(item.getPerson().getBirthday() + "");
		holder.binding.textviewActorsCountry.setText(item.getPerson().getCountry().getName());

	}

	@Override
	public int getItemCount() {
		return tvMazeModelItemList.size();
	}

	static class TvActorrVieWholder extends RecyclerView.ViewHolder {
		private final ActorsListRowBinding binding;


		public TvActorrVieWholder(ActorsListRowBinding binding) {
			super(binding.getRoot());
			this.binding = binding;

		}

	}
}