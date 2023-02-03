package com.example.mentor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MeetAdapter extends RecyclerView.Adapter<MeetAdapter.Holder> {

    private List<MeetModel> list;
    private RecyclerView recyclerView;
    private Context context;
    private String LogTag = MeetAdapter.class.getSimpleName();

    public MeetAdapter(List<MeetModel> list, RecyclerView recyclerView, Context context) {
        this.list = list;
        this.recyclerView = recyclerView;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.meet_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.topic.setText(list.get(position).getTopic());
        holder.description.setText(list.get(position).getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                URL server;
                try{
                    server =new URL("https://meet.jit.si");
                    JitsiMeetConferenceOptions defaultOptions=
                            new JitsiMeetConferenceOptions.Builder()
                                    .setServerURL(server)
                                    .setFeatureFlag("welcomepage.enabled", false).build();
                    JitsiMeet.setDefaultConferenceOptions(defaultOptions);

                }catch (MalformedURLException e){
                    e.printStackTrace();
                }
                        JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                                .setRoom("xyzki8edk")
                                .setFeatureFlag("welcomepage.enabled", false).build();
                        JitsiMeetActivity.launch(context,options);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class Holder extends RecyclerView.ViewHolder {

        TextView topic;
        TextView description;

        public Holder(@NonNull View itemView) {
            super(itemView);

            topic = itemView.findViewById(R.id.meet_topic);
            description = itemView.findViewById(R.id.description);

        }


    }


}