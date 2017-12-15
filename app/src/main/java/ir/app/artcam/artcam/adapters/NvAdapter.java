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
        holder.tv_Parent.setSelected(false);
        holder.expandableLayout.collapse(false);
        holder.nv_expand_icon.setImageResource(R.drawable.ic_chevron_left_black_24dp);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ExpandableLayout.OnExpansionUpdateListener {

        @BindView(R.id.tv_fasl1)
        TextView tv_fasl1;
        @BindView(R.id.tv_fasl2)
        TextView tv_fasl2;
        @BindView(R.id.tv_fasl3)
        TextView tv_fasl3;
        @BindView(R.id.tv_fasl4)
        TextView tv_fasl4;
        @BindView(R.id.tv_fasl5)
        TextView tv_fasl5;
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
            tv_fasl1.setOnClickListener(this);
            tv_fasl2.setOnClickListener(this);
            tv_fasl3.setOnClickListener(this);
            tv_fasl4.setOnClickListener(this);
            tv_fasl5.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.tv_fasl1:
                    nvAdapterClickCallBAck.onPartClicked(1);
                    break;
                case R.id.tv_fasl2:
                    nvAdapterClickCallBAck.onPartClicked(2);
                    break;
                case R.id.tv_fasl3:
                    nvAdapterClickCallBAck.onPartClicked(3);
                    break;
                case R.id.tv_fasl4:
                    nvAdapterClickCallBAck.onPartClicked(4);
                    break;
                case R.id.tv_fasl5:
                    nvAdapterClickCallBAck.onPartClicked(5);
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

