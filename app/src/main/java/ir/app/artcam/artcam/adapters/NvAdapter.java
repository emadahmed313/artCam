package ir.app.artcam.artcam.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.app.artcam.artcam.R;

public class NvAdapter extends RecyclerView.Adapter<NvAdapter.ViewHolder> {

    private static final int UNSELECTED = -1;

    private int selectedItem = UNSELECTED;

    private String PUB = "نمایش دهندگان";
    private String ADV = "تبلیغ دهندگان";

    private NvAdapterClickCallBAck nvAdapterClickCallBAck;

    private ArrayList<String> list;

    private RecyclerView recyclerView;

    public NvAdapter(NvAdapterClickCallBAck nvAdapterClickCallBAck, ArrayList<String> list, RecyclerView recyclerView) {
        this.nvAdapterClickCallBAck = nvAdapterClickCallBAck;
        this.list = list;
        this.recyclerView = recyclerView;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nv_recycler_item, parent, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        holder.tv_Parent.setText(list.get(position));
        holder.tv_child_dash.setText("داشبورد");
        holder.tv_Parent.setSelected(false);
        holder.expandableLayout.collapse(false);
        holder.nv_expand_icon.setImageResource(R.drawable.ic_chevron_left_black_24dp);
        if (list.get(position).equals(PUB)) {
            holder.tv_child_media.setText("رسانه های من");
        } else {
            holder.tv_child_media.setText("تبلیغات من");

        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ExpandableLayout.OnExpansionUpdateListener {

        @BindView(R.id.tv_child_dash)
        TextView tv_child_dash;
        @BindView(R.id.tv_child_media)
        TextView tv_child_media;
        @BindView(R.id.parent_textView)
        TextView tv_Parent;
        @BindView(R.id.expandable_layout)
        ExpandableLayout expandableLayout;
        @BindView(R.id.nv_expand_icon)
        ImageView nv_expand_icon;
        @BindView(R.id.expand_button)
        RelativeLayout relativeLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            expandableLayout.setInterpolator(new OvershootInterpolator());
            expandableLayout.setOnExpansionUpdateListener(this);
            relativeLayout.setOnClickListener(this);
            tv_child_media.setOnClickListener(this);
            tv_child_dash.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.tv_child_dash:

                    nvAdapterClickCallBAck.onDashClicked(getAdapterPosition());
                    break;

                case R.id.tv_child_media:

                    nvAdapterClickCallBAck.onMediaClicked(getAdapterPosition());
                    break;

                case R.id.expand_button:

                    NvAdapter.ViewHolder holder = (ViewHolder) recyclerView.findViewHolderForAdapterPosition(selectedItem);

                    if (holder != null) {
                        holder.tv_Parent.setSelected(false);
                        holder.expandableLayout.collapse();
                        holder.nv_expand_icon.setImageResource(R.drawable.ic_chevron_left_black_24dp);
                    }

                    if (getAdapterPosition() == selectedItem) {

                        selectedItem = UNSELECTED;

                    } else {

                        tv_Parent.setSelected(true);
                        expandableLayout.expand();
                        selectedItem = getAdapterPosition();
                        nv_expand_icon.setImageResource(R.drawable.ic_expand_more_black_24dp);
                    }
                    break;

                default:

                    break;
            }
        }

        @Override
        public void onExpansionUpdate(float expansionFraction, int state) {

            recyclerView.smoothScrollToPosition(getAdapterPosition());
        }
    }
}

