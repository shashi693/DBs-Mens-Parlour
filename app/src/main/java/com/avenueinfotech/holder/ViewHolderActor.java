package com.sukenkar.db.holder;

import android.widget.TextView;

/**
 * Created by suken on 16-12-2016.
 */

public class ViewHolderActor {
    public TextView tvActorName;

    public void setTvActorName(Actor actor){
        tvActorName.setText(actor.getMember_name());
    }
}
