package africa.lejournal.audiolistproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private List<AudioModel> audioModelList;
    private Context context;

    public ListAdapter(List<AudioModel> audioModelList, Context context) {
        this.audioModelList = audioModelList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return audioModelList!=null?audioModelList.size():0;
    }

    @Override
    public Object getItem(int position) {
        return audioModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        TextView audioName=(TextView)convertView.findViewById(R.id.audio);
        audioName.setText(audioModelList.get(position).getName());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(v.getContext(),AudioModelPlayer.class).putExtra("actionBarTitle",audioModelList.get(position).getName()));
            }
        });
        return convertView;
    }
}
