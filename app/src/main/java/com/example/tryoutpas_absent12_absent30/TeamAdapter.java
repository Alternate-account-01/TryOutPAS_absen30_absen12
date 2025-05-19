package com.example.tryoutpas_absent12_absent30;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private List<Team> teams;

    private Context context;

    public TeamAdapter(Context context, List<Team> teams) {
        this.context = context;
        this.teams = teams;
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TeamViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.teamName.setText(team.getStrTeam());
        Glide.with(context)
                .load(team.getStrTeamBadge())
                .into(holder.teamBadge);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }


    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView teamName;
        ImageView teamBadge;

        public TeamViewHolder(View itemView) {
            super(itemView);

            // Find the views in the item layout (team_itemlayout.xml)
            teamName = itemView.findViewById(R.id.tvTeamName);
            teamBadge = itemView.findViewById(R.id.ivTeamBadge);
        }
    }
}
