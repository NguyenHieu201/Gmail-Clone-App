package com.artsystem.gmailapplocal.maillist;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.artsystem.gmailapplocal.R;
import com.artsystem.gmailapplocal.data.Constant;
import com.bumptech.glide.Glide;

public class MailAdapter extends ListAdapter<MailItem, MailAdapter.MailBaseViewHolder> {


    public MailAdapter(@NonNull DiffUtil.ItemCallback<MailItem> diffCallback) {
            super(diffCallback);
        }


    @NonNull
    @Override
    public MailBaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case Constant.MAIL_ITEM_TYPE:
                return new MailViewHolder (LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_mail,parent,false));
            default:  return new MailViewHolder (LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_mail,parent,false));
        }


    }

    @Override
    public void onBindViewHolder(@NonNull MailBaseViewHolder holder, int position) {

        holder.bindData(getItem(position));

    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }


    // Base View Holder:
    public  abstract class MailBaseViewHolder extends RecyclerView.ViewHolder{

        abstract void bindData(MailItem item);

        public MailBaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    // mail item viewholder
    public class MailViewHolder extends MailBaseViewHolder{

        TextView tvTitle,tvDesc,tvContent,tvDate;
        ImageView imgUser,imgFav;



        public MailViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.item_mail_title);
            tvContent = itemView.findViewById(R.id.item_mail_content);
            tvDesc = itemView.findViewById(R.id.item_mail_description);
            tvDate = itemView.findViewById(R.id.item_mail_date);
            imgUser = itemView.findViewById(R.id.item_mail_img);
            imgFav = itemView.findViewById(R.id.item_mail_fav);


        }


        @Override
        void bindData(MailItem item) {
            setSelected(item.getSimpleItem().isRead());
            setFav(item.getSimpleItem().isFav());
            tvTitle.setText(item.getSimpleItem().getTitle());
            tvDesc.setText(item.getSimpleItem().getDescription());
            tvContent.setText(item.getSimpleItem().getContent());
            Glide.with(imgUser.getContext()).load(item.getSimpleItem().getImgUrl()).circleCrop().into(imgUser);

        }


        void setSelected(boolean isRead) {

            if (isRead) {

                tvTitle.setTypeface(Typeface.DEFAULT);
                tvDesc.setTypeface(Typeface.DEFAULT);
                tvDate.setTypeface(Typeface.DEFAULT);

            }

            else {
                tvTitle.setTypeface(Typeface.DEFAULT_BOLD);
                tvDesc.setTypeface(Typeface.DEFAULT_BOLD);
                tvDate.setTypeface(Typeface.DEFAULT_BOLD);
            }

        }
        private void setFav(boolean fav) {
            if (fav) {
                imgFav.setImageResource(R.drawable.ic_baseline_star_24);
                imgFav.setColorFilter(imgFav.getContext().getResources().getColor(R.color.yellow));
            }
            else
            {
                imgFav.setImageResource(R.drawable.ic_baseline_star_border_24);
                imgFav.setColorFilter(imgFav.getContext().getResources().getColor(R.color.light_text_sec_color));

            }

        }

    }



}
